package model.portfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;
import model.contact.ContactVO;

public class PortfolioDAO {
	
	// �쟾泥� �룷�듃�뤃由ъ삤瑜� 蹂� �닔 �엳�뒗 硫붿꽌�뱶 selectAll
	// �븯�굹�쓽 �룷�듃�뤃由ъ삤瑜� 蹂� �닔 �엳�뒗 硫붿꽌�뱶 selectOne
	// �룷�듃�뤃由ъ삤 �닔�젙�쓣 �쐞�븳 update 
	// �룷�듃�뤃由ъ삤 �궘�젣瑜� �쐞�븳 delete
	// �룷�듃�뤃由ъ삤 �옉�꽦�쓣 �쐞�븳 insert 
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_portInsert="insert into portfolio values((select nvl(max(portNum),0)+1 from portfolio),?,?,?,sysdate)";
//	String sql_portInsert="insert into portfolio(adminNum, portTitle, portContent, portTime) values (?,?,?,NOW())";
		
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
