package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.portfolio.PortfolioDAO;
import model.portfolio.ReplyVO;

public class WriteCommentAction implements Action {

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/* pstmt.setInt(1, vo.getPortNum());
         pstmt.setString(2, vo.getReplyContent());         
         pstmt.setString(3, vo.getMemberName()); */
		ReplyVO vo = new ReplyVO();
		PortfolioDAO dao = new PortfolioDAO();
		ActionInformation info = new ActionInformation();
		
		int portNum = Integer.parseInt(request.getParameter("portNum"));	
		vo.setMemberName(request.getParameter("memberName"));
		vo.setPortNum(Integer.parseInt(request.getParameter("portNum")));
		vo.setReplyContent(request.getParameter("replyContent"));
		
		System.out.println(portNum+vo.getMemberName()+vo.getPortNum()+vo.getReplyContent());
		
		dao.replyInsert(vo);
		
		info.setPath("portfolioOne.do?bid="+portNum);
		info.setRedirect(false);
		
		return info;
	}
	
	

}
