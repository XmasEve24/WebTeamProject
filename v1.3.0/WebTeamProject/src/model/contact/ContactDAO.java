package model.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;
import model.member.MemberVO;

public class ContactDAO {
	
	// 회원의 Contact를 위한 insert
	// 관리자가 Contact를 보기 위한 selectAll 
	
	// + 추가? 관리자가 하나의 Contact를 보기 위한 selectOne 
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_contactInsert="insert into contact(contactType, portNum, memberName, contactContent, memberEmail) values(?,?,?,?,?)";
	String sql_selectAll="select * from contact order by contactNum desc";
	
	JNDI JNDIUtil = new JNDI();
	
	public boolean contactInsert(ContactVO vo) {
		
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_contactInsert);
			pstmt.setString(1, vo.getContactType());
			pstmt.setInt(2, vo.getPortNum());
			pstmt.setString(3, vo.getMemberName());
			pstmt.setString(4, vo.getContactContent());
			pstmt.setString(5, vo.getMemberEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ContactDAO contactInsert method error");
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	
	public ArrayList<ContactVO> selectAll(ContactVO vo) {
		ArrayList<ContactVO> contactData = new ArrayList<ContactVO>();
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectAll);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				ContactVO co = new ContactVO();
				co.setContactContent(rs.getString("contactContent"));
				co.setContactType(rs.getString("contactType"));
				co.setMemberEmail(rs.getString("memberEmail"));
				co.setMemberName(rs.getString("memberName"));
				
				co.setPortNum(rs.getInt("portNum"));
				// 만약 portNum을 입력받지 않는 경우라면, 프론트쪽에서 0으로 넘겨주자 
				
				contactData.add(co);
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO memberJoin method error");
			e.printStackTrace();
		} 
		return contactData;
	}
	
	

}
