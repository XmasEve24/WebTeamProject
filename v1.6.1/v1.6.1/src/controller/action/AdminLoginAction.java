package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionInformation;
import model.admin.AdminDAO;
import model.admin.AdminVO;

public class AdminLoginAction implements Action{
	
	private boolean flag;

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 로그인액션은 DB로부터 select를 통해서 그 사람의 정보가 존재하는지 확인하는 절차가 필요하다. 	
		ActionInformation info = new ActionInformation();
		AdminDAO dao = new AdminDAO();
		AdminVO vo = new AdminVO();
		
		vo.setAdminId(request.getParameter("Id"));
		vo.setAdminPw(request.getParameter("Pw"));
		
		if(dao.adminLogin(vo)) {
			HttpSession session=request.getSession();
	        session.setAttribute("adminId", vo.getAdminId());
	        session.setAttribute("adminNum", vo.getAdminNum());
	        session.setAttribute("adminName", vo.getAdminName());
			info.setPath("main.do");
			info.setRedirect(false);
			setFlag(true);
		}
		else {
			System.out.println("관리자 로그인 실패");
			info.setPath("login.jsp");
			info.setRedirect(true);
			
			
			setFlag(false); // 로그인 실패 시 flag == false 
		}
			
		return info;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
