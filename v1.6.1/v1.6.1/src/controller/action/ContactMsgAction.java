package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.contact.ContactDAO;
import model.contact.ContactVO;

public class ContactMsgAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ContactDAO dao = new ContactDAO();
		ArrayList<ContactVO> contactData = new ArrayList<ContactVO>();
		ActionInformation info = new ActionInformation();
		
		contactData = dao.selectAll();
		
		request.setAttribute("contactData", contactData);
		info.setPath("contactMsg.jsp");
		info.setRedirect(false);
		
		return info;
	}

}
