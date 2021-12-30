package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import controller.action.AdminLoginAction;
import controller.action.ContactInsertAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.MemberLoginAction;
import controller.action.SignUpAction;

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
			System.out.println("메인");
		}
		else if(command.equals("/login.do")) {		
			// 관리자로그인과 회원로그인을 구별하기 위한 boolean타입 flag 설정			
			AdminLoginAction LoginDistinction = new AdminLoginAction();
			
			try {
				info = LoginDistinction.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(LoginDistinction.isFlag() == false) {
				// 관리자 로그인으로 실패시, 회원로그인으로 진행한다. 
				info = null;
				actionSet = new MemberLoginAction();
				System.out.println("회원 로그인");
			}
			else {
				actionSet = new AdminLoginAction();
				System.out.println("관리자 로그인");
			}		
		} 
		else if(command.equals("/logout.do")) {		
			actionSet = new LogoutAction();
			System.out.println("로그아웃");
		} 
		else if(command.equals("/signup.do")) {		
			actionSet = new SignUpAction();
			System.out.println("회원가입");
		} 
		else if(command.equals("/contact_insert.do")) {		
			actionSet = new ContactInsertAction();
			System.out.println("문의 넣기");
		} 
		
		//TODO
	
		
		try {
			info = actionSet.execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in try catch");
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
