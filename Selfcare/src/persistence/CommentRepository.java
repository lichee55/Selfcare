package persistence;

import javax.sql.DataSource;

import domain.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CommentRepository {
	public static CommentRepository instance;
	public static DataSource ds;
	private CommentRepository() {}
	public static CommentRepository getInstance() {
		if(instance==null) {
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
				return instance = new CommentRepository();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public void save(Comment comment) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO COMMENT(comment_id,content,regdate,member_id,board_id) values(?,?,?,?,?)";
		try {
			conn=ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,comment.getComment_Id());
			pstmt.setString(2, comment.getContents());
			pstmt.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setString(4, comment.getMem_id());
			pstmt.setInt(5, comment.getBoard_Id());
			
			int n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void update(Comment comment) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET content=? " + "WHERE content_id=?,member_id=?";
		try {
			conn=ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, comment.getContents());
			pstmt.setInt(2, comment.getComment_Id());
			pstmt.setString(3,comment.getMem_id());
			int n= pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Comment comment) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "UPDATE COMMENT SET isRemoved = 1 " + "WHERE comment_id=?";
		try {
			conn=ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,comment.getComment_Id());
			int n = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Comment> findAll(Comment comment){
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "SELECT * FROM COMMENT WHERE board_id=?, isRemoved = 0";
		ArrayList<Comment> comments = new ArrayList<Comment>();
		try {
			conn=ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getBoard_Id());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int comment_id=rs.getInt("comment_id");
				String content=rs.getString("content");
				LocalDateTime regdate=rs.getTimestamp("regdate").toLocalDateTime();
				String member_id=rs.getString("member_id");
				int board_ids = rs.getInt("board_id");
				int isRemoved = 0;
				Comment coms = new Comment(comment_id,content,regdate,member_id,board_ids,isRemoved);
				comments.add(coms);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return comments;
	}
}
