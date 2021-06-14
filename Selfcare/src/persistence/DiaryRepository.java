package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Board;
import domain.Diary;

public class DiaryRepository {
	private static DiaryRepository instance;
	private static DataSource ds;
	public static DiaryRepository getInstacne() {
		if(instance==null) {
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
				return instance = new DiaryRepository();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;		
	}
	public void insert(Diary diary){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DIARY(CONTENT,REGDATE,MEMBER_ID) VALUES (?,now(),?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, diary.getContent());
			pstmt.setString(2, diary.getMem_Id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
	public void update(Diary diary){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE DIARY SET CONTENTS=? WHERE DIARY_ID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, diary.getContent());
			pstmt.setInt(2, diary.getDiary_Id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
	
	public void delete(Diary diary){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE DIARY SET isRemoved = 1 WHERE BOARD_ID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, diary.getDiary_Id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
	public Diary findDiaryById(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DIARY WHERE BOARD_ID="+id+"";
		Diary diary = new Diary();
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int idRe=rs.getInt("diary_id");
				String contents = rs.getString("content");
				String mem_id = rs.getString("member_id");
				LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
				diary = new Diary(idRe,contents,mem_id,regdate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		return diary;
	}
	
	public ArrayList<Diary> findDiaryByPage(int pageNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DIARY ORDER BY REGDATE DESC LIMIT ?,10";
		ArrayList<Diary> diaryList = new ArrayList<Diary>();
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, (pageNum-1)*10);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int idRe=rs.getInt("diary_id");
				String contents = rs.getString("content");
				String mem_id = rs.getString("member_id");
				LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
				Diary diary = new Diary(idRe,contents,mem_id,regdate);
				diaryList.add(diary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		return diaryList;
	}
		

}
