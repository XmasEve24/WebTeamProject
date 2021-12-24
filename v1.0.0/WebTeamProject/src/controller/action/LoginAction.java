package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;

public class LoginAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 로그인액션은 DB로부터 select를 통해서 그 사람의 정보가 존재하는지 확인하는 절차가 필요하다. 
		
		// 미완성 
		
		ActionInformation info = new ActionInformation();
		AdminDAO dao = new AdminDAO();
		
		
		info.setPath("login.jsp");
		info.setRedirect(false);
		
		return info;
	}
	
}
