package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.portfolio.PortfolioDAO;
import model.portfolio.PortfolioVO;

public class PortfolioSelectAllAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PortfolioDAO dao = new PortfolioDAO();
		PortfolioVO vo = new PortfolioVO();
		ActionInformation info = new ActionInformation();
		
		ArrayList<PortfolioVO> portSelectAll = dao.portSelectAll();
		
		request.setAttribute("portSelectAll", portSelectAll);
		
		info.setPath("board.jsp");
	    info.setRedirect(false);	    
		
		return info;
	}
}
