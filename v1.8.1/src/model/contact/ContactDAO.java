package model.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;
import model.member.MemberVO;

public class ContactDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_contactInsert="insert into contact values((select nvl(max(contactNum),0)+1 from contact),?,?,?,?,?)";
	String sql_selectAll="select * from contact";
	
//	String sql_contactInsert="insert into contact(contactType, portNum, memberName, contactContent, memberEmail) values(?,?,?,?,?)";
//	String sql_selectAll="select * from contact order by contactNum desc";
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
	
	public ArrayList<ContactVO> selectAll() {
		ArrayList<ContactVO> contactData = new ArrayList<ContactVO>();
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectAll);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				ContactVO co = new ContactVO();
				co.setContactNum(rs.getInt("contactNum"));
				co.setContactContent(rs.getString("contactContent"));
				co.setContactType(rs.getString("contactType"));
				co.setMemberEmail(rs.getString("memberEmail"));
				co.setMemberName(rs.getString("memberName"));
				co.setPortNum(rs.getInt("portNum"));
				
				contactData.add(co);
				
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO memberJoin method error");
			e.printStackTrace();
		} 
		return contactData;
	}
	
	

}
