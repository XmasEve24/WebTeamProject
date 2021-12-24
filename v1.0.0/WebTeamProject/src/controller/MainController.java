package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import controller.action.LoginAction;
import controller.action.MainAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String command = uri.substring(cp.length());
		System.out.println(command);
		
		Action actionSet = null;
		ActionInformation info = new ActionInformation();
				
		if(command.equals("/main.do")) {		
			actionSet = new MainAction();
		}
		else if(command.equals("/login.do")) {		
			actionSet = new LoginAction();
		} 
		
		//TODO
	
		
		try {
			info = actionSet.execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(info != null) {
			if(info.isRedirect()) {
				response.sendRedirect(info.getPath());
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(info.getPath());
				dispatcher.forward(request, response);
			}
		}
		
		
	
	}

}
