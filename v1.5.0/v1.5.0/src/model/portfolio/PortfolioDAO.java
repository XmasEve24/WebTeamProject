package model.portfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;
import model.contact.ContactVO;

public class PortfolioDAO {
	
	// 전체 포트폴리오를 볼 수 있는 메서드 selectAll
	// 하나의 포트폴리오를 볼 수 있는 메서드 selectOne
	// 포트폴리오 수정을 위한 update 
	// 포트폴리오 삭제를 위한 delete
	// 포트폴리오 작성을 위한 insert 
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_portInsert="insert into portfolio(adminNum, portTitle, portContent, portTime) values (?,?,?,NOW())";
		
	JNDI JNDIUtil = new JNDI();
	
	public boolean portInsert(PortfolioVO vo) {
		
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_portInsert);
			pstmt.setInt(1, vo.getAdminNum());
			pstmt.setString(2, vo.getPortTitle());
			pstmt.setString(3, vo.getPortContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PortfolioDAO contactInsert method error");
			e.printStackTrace();
			return false;
		} 
		return true;
	}

}
