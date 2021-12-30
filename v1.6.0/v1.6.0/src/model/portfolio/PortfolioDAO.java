package model.portfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class PortfolioDAO {
	
	// 전체 포트폴리오를 볼 수 있는 메서드 selectAll
	// 하나의 포트폴리오를 볼 수 있는 메서드 selectOne
	// 포트폴리오 수정을 위한 update 
	// 포트폴리오 삭제를 위한 delete
	// 포트폴리오 작성을 위한 insert 
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_portInsert="insert into portfolio(adminNum, adminName,portTitle, portContent, portTime) values (?,?,?,?,NOW())";
	String sql_portDelete="delete from portfolio where portNum=?";	
	String sql_portSelectAll="select * from portfolio order by portNum desc";
	
	String sql_portSelectOne="select * from portfolio where portNum = ?";
	String sql_replySelect="select * from reply where portNum = ? order by replyNum desc";
	
	String sql_replyInsert="insert into reply(portNum, replyContent, memberName, replyTime) values(?,?,?,NOW())";
	String sql_replyDelete="delete from reply where replyNum=?";	
	
	JNDI JNDIUtil = new JNDI();
	
	public boolean portInsert(PortfolioVO vo) {
		
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_portInsert);
			pstmt.setInt(1, vo.getAdminNum());
			pstmt.setString(2, vo.getAdminName());
			pstmt.setString(3, vo.getPortTitle());
			pstmt.setString(4, vo.getPortContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PortfolioDAO contactInsert method error");
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	public boolean portDelete(PortfolioVO vo) {
		   conn=JNDIUtil.connect();
		   try {
			pstmt=conn.prepareStatement(sql_portDelete);
			pstmt.setInt(1, vo.getPortNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PortfolioDAO portDelete()에서 문제발생!");
			e.printStackTrace();
			return false;
		}
		   return true;
	   }
	
	public ArrayList<PortfolioVO> portSelectAll(){ 
	    ArrayList<PortfolioVO> portData =new ArrayList<PortfolioVO>();
	    conn=JNDIUtil.connect();
	    try {
	       pstmt=conn.prepareStatement(sql_portSelectAll);     
	       rs=pstmt.executeQuery();
	       while(rs.next()) {
	               
	          PortfolioVO pvo = new PortfolioVO();          
	        
	          pvo.setAdminNum(rs.getInt("adminNum"));
	          pvo.setAdminName(rs.getString("adminName"));
	          pvo.setPortContent(rs.getString("portContent"));
	          pvo.setPortNum(rs.getInt("portNum"));          
	          // datetime 타입은 timestamp로 받아야 함 
	          pvo.setPortTime(rs.getTimestamp("portTime"));
	          pvo.setPortTitle(rs.getString("portTitle"));
	       
	          portData.add(pvo);
	       }
	    } catch (SQLException e) {
	       System.out.println("PortDAO portSelectAll()에서 문제발생!");
	       e.printStackTrace();
	    }  
	    return portData;
	 }	
	
	public ArrayList<PortReplySet> portSelectOne(PortfolioVO vo){
		
		ArrayList<PortReplySet> PortReplySet = new ArrayList<PortReplySet>();
		try {
	         pstmt=conn.prepareStatement(sql_portSelectOne);
	         pstmt.setInt(1, vo.getPortNum());
	         rs=pstmt.executeQuery();
	         if(rs.next()) {
	            PortReplySet prSet = new PortReplySet();   	     
	            PortfolioVO portVO = new PortfolioVO();
	            ArrayList<ReplyVO> replyData =new ArrayList<ReplyVO>();
	            
	            portVO.setAdminNum(rs.getInt("adminNum"));
	            portVO.setAdminName(rs.getString("adminName"));
	            portVO.setPortContent(rs.getString("portContent"));
	            portVO.setPortNum(rs.getInt("portNum"));
	            portVO.setPortTime(rs.getTimestamp("portTime"));
	            portVO.setPortTitle(rs.getString("portTitle"));
	            	            	   
	            pstmt=conn.prepareStatement(sql_replySelect);
	            pstmt.setInt(1, rs.getInt("portNum"));
	            ResultSet rs2=pstmt.executeQuery();
	            while(rs2.next()) {
	               ReplyVO replyVO=new ReplyVO();
	               
	               replyVO.setMemberName(rs2.getString("memberName"));	           
	               replyVO.setPortNum(rs2.getInt("portNum"));
	               replyVO.setReplyContent(rs2.getString("replyContent"));
	               replyVO.setReplyNum(rs2.getInt("replyNum"));
	               replyVO.setReplyTime(rs2.getTimestamp("replyTime"));
	               
	               replyData.add(replyVO);
	            }
	            
	            prSet.setPort(portVO);
	            prSet.setReply(replyData);
	            
	            PortReplySet.add(prSet);
	         }
	      } catch (SQLException e) {
	         System.out.println("DAO portselectOne()에서 문제발생!");
	         e.printStackTrace();
	      }  	
		return PortReplySet;
	}
	
	public boolean replyInsert(ReplyVO vo) {
	      conn=JNDIUtil.connect();
	      try {
	    	  /*String sql_replyInsert="insert into reply(portNum, replyContent, memberNum, memberName, replyTime) values(?,?,?,?,NOW())";*/
	         pstmt=conn.prepareStatement(sql_replyInsert);
	         pstmt.setInt(1, vo.getPortNum());
	         pstmt.setString(2, vo.getReplyContent());
	         
	         pstmt.setString(3, vo.getMemberName());	       
	         pstmt.executeUpdate();
	      } catch (SQLException e) {
	         System.out.println("PortfolioDAO replyInsert()에서 문제발생!");
	         e.printStackTrace();
	         return false;
	      } 
	      return true;
	   }
	
	public boolean replyDelete(ReplyVO vo) {
  conn=JNDIUtil.connect();
  try {
     pstmt=conn.prepareStatement(sql_replyDelete);
     pstmt.setInt(1, vo.getReplyNum());
     pstmt.executeUpdate();
  } catch (SQLException e) {
  	System.out.println("PortfolioDAO replyDelete()에서 문제발생!");
	    e.printStackTrace();
	    return false;
  } 
	    return true;
	}
	
}
