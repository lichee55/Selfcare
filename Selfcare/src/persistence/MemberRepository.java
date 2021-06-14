package persistence;

import javax.sql.DataSource;

import domain.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MemberRepository {
	public static MemberRepository instance;
	public static DataSource ds;
	private MemberRepository() {}
	public static MemberRepository getInstance() {
		if(instance==null) {
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
				return instance = new MemberRepository();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	public void save(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER(member_id,name,password) values(?,?,?)";
		try {
			conn = ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,member.getMem_Id());
			pstmt.setString(2,member.getName());
			pstmt.setString(3,member.getPassword());
			
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
	
	public boolean logIn(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginResult = false;
		String sql = "SELECT password FROM MEMBER WHERE MEM_ID = \'" +member.getMem_Id() + "\'";
		try {
			conn = ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(member.getPassword())){
					loginResult = true;
				}
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
		return loginResult;
	}
	public Member getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member=new Member();
		boolean loginResult = false;
		String sql = "SELECT * FROM MEMBER WHERE MEM_ID = \'" +id + "\'";
		try {
			conn = ds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setMem_Id(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
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
		return member;
	}
}

