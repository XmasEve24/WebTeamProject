package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.portfolio.PortfolioDAO;
import model.portfolio.ReplyVO;

public class DeleteReplyAction implements Action {

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReplyVO vo = new ReplyVO();
		PortfolioDAO dao = new PortfolioDAO();
		ActionInformation info = new ActionInformation();
		
		System.out.println(Integer.parseInt(request.getParameter("portNum")));
		
		int portNum = Integer.parseInt(request.getParameter("replyNum"));
		vo.setReplyNum(Integer.parseInt(request.getParameter("replyNum")));
		
		dao.replyDelete(vo);	
		
		info.setPath("portfolioOne.do?bid="+portNum);
		info.setRedirect(false);
		
		return info;
	}

}
