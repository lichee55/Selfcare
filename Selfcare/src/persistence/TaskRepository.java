package persistence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Member;
import domain.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Connection;

public class TaskRepository {
	private static TaskRepository instance;
	private static DataSource ds;

	private TaskRepository() {

	}

	public static TaskRepository getInstacne() {
		if (instance == null) {
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
				return instance = new TaskRepository();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}

	public void save(Task task) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO task(content,clear,regdate,member_id,isRemoved) VALUE (?,?,now(),?,0)";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, task.getContents());
			pstmt.setInt(2, 0);
			pstmt.setString(3, task.getMem_Id());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Task task) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE task SET content=?, clear=? WHERE task_id=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, task.getContents());
			pstmt.setInt(2, task.getClear());
			pstmt.setInt(3, task.getTask_Id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(Task task) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE task SET isRemoved=1 WHERE task_id=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, task.getTask_Id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Task> findTaskByDate(LocalDateTime time, Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Task> taskList = new ArrayList<Task>();
		LocalDateTime minusTwoDay = time.minusDays(3);
		LocalDateTime plusTwoDay = time.plusDays(3);
		String sql = "SELECT * FROM task WHERE member_id=? and taskdate>? and taskdate<?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMem_Id());
			pstmt.setTimestamp(2, Timestamp.valueOf(minusTwoDay));
			pstmt.setTimestamp(3, Timestamp.valueOf(plusTwoDay));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int task_id = rs.getInt("task_id");
				LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
				String contents = rs.getString("content");
				int clear = rs.getInt("clear");
				String mem_id = rs.getString("member_id");
				LocalDateTime taskdate = rs.getTimestamp("taskdate").toLocalDateTime();
				int isRemoved = rs.getInt("isRemoved");
				Task task = new Task(task_id, regdate, contents, clear, mem_id, taskdate, isRemoved);
				taskList.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return taskList;
	}
}
