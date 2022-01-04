package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.portfolio.PortfolioDAO;
import model.portfolio.PortfolioVO;

public class DeletePortfolioAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PortfolioVO vo = new PortfolioVO();
		PortfolioDAO dao = new PortfolioDAO();
		ActionInformation info = new ActionInformation();
		
		vo.setPortNum(Integer.parseInt(request.getParameter("portNum")));
		
		dao.portDelete(vo);
		
		info.setPath("board.do");
		info.setRedirect(false);
				
		return info;
	}

}
