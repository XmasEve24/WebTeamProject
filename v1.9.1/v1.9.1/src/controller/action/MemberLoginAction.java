package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionInformation;
import model.member.MemberDAO;
import model.member.MemberVO;

public class MemberLoginAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		  ActionInformation info = new ActionInformation();
		  MemberDAO dao=new MemberDAO();
	      MemberVO vo=new MemberVO();
	      vo.setMemberId(request.getParameter("Id"));
	      vo.setMemberPw(request.getParameter("Pw"));
	      
	      if(dao.memberLogin(vo)) {
	         HttpSession session=request.getSession();
	         session.setAttribute("memberId", vo.getMemberId());
		     session.setAttribute("memberName", vo.getMemberName());
		     session.setAttribute("memberEmail", vo.getMemberEmail());
			 info.setPath("main.do");
		     info.setRedirect(false);	    
	      }
	      else {
	    	System.out.println("회원 로그인 실패");
			info.setPath("login.jsp");
			info.setRedirect(true);
	      }	      
	      return info;
	}
}
