package persistence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO task(content,clear,regdate,member_id) VALUE (?,?,now(),?)";
		try {
			conn=ds.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, task.getContents());
			pstmt.setInt(2, 0);
			pstmt.setString(3, task.getMem_Id());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
