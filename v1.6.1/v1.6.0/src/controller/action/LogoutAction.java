package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionInformation;

public class LogoutAction implements Action{

	   @Override
	   public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      HttpSession session=request.getSession();
	      session.invalidate(); 
	      
	      ActionInformation info=new ActionInformation();
	      info.setPath("main.jsp");
	      info.setRedirect(true);
	      return info;
	   }
	}