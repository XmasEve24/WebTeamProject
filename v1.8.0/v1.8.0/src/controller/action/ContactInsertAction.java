package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionInformation;
import model.contact.ContactDAO;
import model.contact.ContactVO;

public class ContactInsertAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionInformation info = new ActionInformation();
		 ContactDAO dao=new ContactDAO();
	     ContactVO vo = new ContactVO();
	     
	     vo.setContactContent(request.getParameter("contactContent"));
	     vo.setContactType(request.getParameter("contactType"));
	     vo.setMemberEmail(request.getParameter("memberEmail"));
	     vo.setMemberName(request.getParameter("memberName"));
	     
	     if(request.getParameter("portNum") == null) {
	    	 vo.setPortNum(0);
	     }
	     else {
	     vo.setPortNum(Integer.parseInt(request.getParameter("portNum")));
	     }
	     if(dao.contactInsert(vo)) {	     
		     System.out.println("문의 넣기 성공");
			 info.setPath("main.do");
		     info.setRedirect(false);	    
	     }
	     else {
	    	System.out.println("문의 실패");
	    	info.setPath("contact.jsp");
		    info.setRedirect(true);	   
	     }	          
	     return info;
	}

}
