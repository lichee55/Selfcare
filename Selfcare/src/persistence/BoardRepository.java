package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Board;

public class BoardRepository {
	private static BoardRepository instance;
	private static DataSource ds;
	public static BoardRepository getInstacne() {
		if(instance==null) {
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
				return instance = new BoardRepository();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;		
	}
	public void insert(Board board){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD(TITLE,MEMBER_ID,CONTENT,REGDATE,HIT,isRemoved) VALUES (?,?,?,now(),0,0)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getMem_id());
			pstmt.setString(3, board.getContents());
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
	public void update(Board board){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET TITLE=?,CONTENTS=? WHERE BOARD_ID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents());
			pstmt.setLong(3, board.getBoard_Id());
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
	
	public void delete(Board board){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET isRemoved = 1 WHERE BOARD_ID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, board.getBoard_Id());
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
	public Board findById(Long id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE BOARD_ID="+id+"";
		Board board = new Board();
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setLong(1, id);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int idRe=rs.getInt("id");
				String title = rs.getString("title");
				String mem_id = rs.getString("member_id");
				String contents = rs.getString("contents");
				LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
				String hit = rs.getString("hit");
				int isRe = rs.getInt("isRemoved");
				board = new Board(idRe,contents,regdate,title,mem_id,hit,isRe);
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
		return board;
	}
	
	public ArrayList<Board> findBoardByPage(int pageNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD ORDER BY REGDATE DESC LIMIT ?,10";
		ArrayList<Board> boards = new ArrayList<Board>();
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
				int idRe = rs.getInt("id");
				String title = rs.getString("title");
				String mem_id = rs.getString("writer");
				String contents = rs.getString("contents");
				LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
				String hit = rs.getString("hit");
				int isRe = rs.getInt("isRemoved");
				Board posts = new Board(idRe,contents,regdate,title,mem_id,hit,isRe);
				boards.add(posts);
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
		return boards;
	}
	public void updateHit(Long input) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET HIT=HIT+1 WHERE ID="+input+"";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
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

}
