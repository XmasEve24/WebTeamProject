package model.portfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class PortfolioDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql_portInsert="insert into portfolio values((select nvl(max(portNum),0)+1 from portfolio),?,?,?,?,sysdate)";
//	String sql_portInsert="insert into portfolio(adminNum, adminName,portTitle, portContent, portTime) values (?,?,?,?,NOW())";
	String sql_portDelete="delete from portfolio where portNum=?";	
	String sql_portSelectAll="select * from portfolio order by portNum desc";
	
	String sql_portSelectOne="select * from portfolio where portNum = ?";
	String sql_replySelect="select * from reply where portNum = ? order by replyNum desc";
	
//	String sql_replyInsert="insert into reply(portNum, replyContent, memberName, replyTime) values(?,?,?,NOW())";
	String sql_replyInsert="insert into reply values((select nvl(max(replyNum),0)+1 from reply),?,?,?,sysdate)";
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
			System.out.println("PortfolioDAO portDelete() method error");
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
	          pvo.setPortTime(rs.getTimestamp("portTime"));
	          pvo.setPortTitle(rs.getString("portTitle"));
	       
	          portData.add(pvo);
	       }
	    } catch (SQLException e) {
	       System.out.println("PortDAO portSelectAll() method error!");
	       e.printStackTrace();
	    }  
	    return portData;
	 }	
	
	public PortReplySet portSelectOne(PortfolioVO vo){
		//System.out.println("로깅0");
		PortReplySet set = new PortReplySet();
		conn=JNDIUtil.connect();
		try {
			//System.out.println("try문에서의 portNum: "+vo.getPortNum());
	         pstmt=conn.prepareStatement(sql_portSelectOne);
	         pstmt.setInt(1, vo.getPortNum());
	         rs=pstmt.executeQuery();
	        // System.out.println("로깅1");
	         while(rs.next()) {	          
	        	//System.out.println("로깅2");
	            PortfolioVO portVO = new PortfolioVO();
	            ArrayList<ReplyVO> replyData = new ArrayList<ReplyVO>();
	            
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
	            	 //System.out.println("로깅3");
	               ReplyVO replyVO=new ReplyVO();
	               
	               replyVO.setMemberName(rs2.getString("memberName"));	           
	               replyVO.setPortNum(rs2.getInt("portNum"));
	               replyVO.setReplyContent(rs2.getString("replyContent"));
	               replyVO.setReplyNum(rs2.getInt("replyNum"));
	               replyVO.setReplyTime(rs2.getTimestamp("replyTime"));
	               
	               replyData.add(replyVO);
	            }
	            
	            set.setPort(portVO);	            
	            set.setReply(replyData);
	            
	         }
	      } catch (SQLException e) {
	         System.out.println("DAO portselectOne() method error");
	         e.printStackTrace();
	      }  	
//		System.out.println("DAO 정상작동");
		return set;
	}
	
	public boolean replyInsert(ReplyVO vo) {
	      conn=JNDIUtil.connect();
	      try {
	    	  
	         pstmt=conn.prepareStatement(sql_replyInsert);
	         pstmt.setInt(1, vo.getPortNum());
	         pstmt.setString(2, vo.getReplyContent());         
	         pstmt.setString(3, vo.getMemberName());	       
	         pstmt.executeUpdate();
	      } catch (SQLException e) {
	         System.out.println("PortfolioDAO replyInsert() method error");
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
  	System.out.println("PortfolioDAO replyDelete() method error!");
	    e.printStackTrace();
	    return false;
  } 
	    return true;
	}
	
}
