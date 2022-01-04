package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.portfolio.PortReplySet;
import model.portfolio.PortfolioDAO;
import model.portfolio.PortfolioVO;

public class PortfolioSelectOneAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PortfolioDAO dao = new PortfolioDAO();
		PortfolioVO vo = new PortfolioVO();
		ActionInformation info = new ActionInformation();
		
		vo.setPortNum(Integer.parseInt(request.getParameter("portNum")));
		
		System.out.println("Action"+vo.getPortNum());
		
		PortReplySet portSelectOne = dao.portSelectOne(vo);	
		// 여기서 nullpointerException 발생
		
		System.out.println("Action 로깅");
		
		request.setAttribute("portSelectOne", portSelectOne);
		
		info.setPath("portfolio.jsp");
	    info.setRedirect(false);	
	    
		return info;
	}

}
