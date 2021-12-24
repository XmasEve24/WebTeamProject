package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_memberJoin="insert into member(memberNum, memberName, memberId, memberPw, memberEmail) values(?,?,?,?)";
	String sql_login="select * from member where memberId=? and memberPw=?";
	
	JNDI JNDIUtil = new JNDI();
	
	public boolean memberJoin(MemberVO vo) {
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_memberJoin);
			pstmt.setString(1, vo.getMemberName());
			pstmt.setString(2, vo.getMemberId());
			pstmt.setString(3, vo.getMemberPw());
			pstmt.setString(4, vo.getMemberEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("MemberDAO memberJoin method error");
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	
	public boolean login(MemberVO vo) {
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_login);
			pstmt.setString(1, vo.getMemberId());
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("memberPw").equals(vo.getMemberPw())) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO login method error");
			e.printStackTrace();
			return false;
		} 
		return false;
	}
	
}
