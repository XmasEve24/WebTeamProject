package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionInformation;
import model.member.MemberDAO;
import model.member.MemberVO;

public class SignUpAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 ActionInformation info = new ActionInformation();
		 MemberDAO dao=new MemberDAO();
	     MemberVO vo=new MemberVO();
	     
	     vo.setMemberId(request.getParameter("memberId"));
	     vo.setMemberPw(request.getParameter("memberPw"));
	     vo.setMemberEmail(request.getParameter("memberEmail"));
	     vo.setMemberName(request.getParameter("memberName"));
	      
	     if(dao.signUp(vo)) {
	         HttpSession session=request.getSession();
	         session.setAttribute("memberId", vo.getMemberId());
		     session.setAttribute("memberName", vo.getMemberName());
		     System.out.println("�쉶�썝媛��엯 �꽦怨�");
			 info.setPath("login.jsp");
		     info.setRedirect(true);	    
	     }
	     else {
	    	System.out.println("�쉶�썝媛��엯 �떎�뙣");
			info.setPath("signup.jsp");
			info.setRedirect(true);
	     }	      
		
	     
	     return info;
	}

}
