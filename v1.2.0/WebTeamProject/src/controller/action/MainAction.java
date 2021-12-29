package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.admin.AdminVO;

public class MainAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 정보를 보여주는 어떠한 화면이 아니기 때문에 데이터 이동이 없고 페이지 전환만 해주면 된다. 
		ActionInformation info = new ActionInformation();
		
		info.setPath("main.jsp");
		info.setRedirect(false);
		
		return info;
	}
	
}
