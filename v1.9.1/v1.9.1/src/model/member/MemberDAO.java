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
	
	String sql_signUp="insert into member values((select nvl(max(memberNum),0)+1 from member),?,?,?,?)";
	String sql_login="select * from member where memberId=?";
	
//	String sql_signUp="insert into member(memberName, memberId, memberPw, memberEmail) values(?,?,?,?)";
//	String sql_login="select * from member where memberId=?";
	
	JNDI JNDIUtil = new JNDI();
	
	public boolean signUp(MemberVO vo) {
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_signUp);
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
	
	public boolean memberLogin(MemberVO vo) {
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_login);
			pstmt.setString(1, vo.getMemberId());
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo.setMemberEmail(rs.getString("memberEmail"));
				vo.setMemberName(rs.getString("memberName"));
				vo.setMemberId(rs.getString("memberId"));
				if(rs.getString("memberPw").equals(vo.getMemberPw())) {
					vo.setMemberPw(rs.getString("memberPw"));
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO memberLogin method error");
			e.printStackTrace();
			return false;
		} 
		return false;
	}
	
	
}
