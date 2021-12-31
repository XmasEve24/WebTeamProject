package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.portfolio.PortfolioDAO;
import model.portfolio.PortfolioVO;

public class PortfolioInsertAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PortfolioDAO dao = new PortfolioDAO();
		PortfolioVO vo = new PortfolioVO();
		ActionInformation info = new ActionInformation();
		
		System.out.println("adminNum = "+Integer.parseInt(request.getParameter("adminNum")));
		
		vo.setAdminName(request.getParameter("adminName"));
		vo.setAdminNum(Integer.parseInt(request.getParameter("adminNum")));
		vo.setPortContent(request.getParameter("portContent"));
		vo.setPortTitle(request.getParameter("portTitle"));
			
		 if(dao.portInsert(vo)) {	     
		     System.out.println("포트폴리오 업로드 성공");
			 info.setPath("main.do");
		     info.setRedirect(false);	    
	     }
	     else {
	    	System.out.println("업로드 실패");
	    	info.setPath("write.jsp");
		    info.setRedirect(true);	   
	     }	          
	     return info;
		
	}

}
