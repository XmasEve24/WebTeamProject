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
import controller.action.ContactAction;
import controller.action.ContactInsertAction;
import controller.action.ContactMsgAction;
import controller.action.DeletePortfolioAction;
import controller.action.DeleteReplyAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.MemberLoginAction;
import controller.action.PortfolioInsertAction;
import controller.action.PortfolioSelectAllAction;
import controller.action.PortfolioSelectOneAction;
import controller.action.SignUpAction;
import controller.action.WriteCommentAction;

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
		else if(command.equals("/contactMsg.do")) {		
			actionSet = new ContactMsgAction();
			System.out.println("문의 보기");
		} 
		else if(command.equals("/portfolioWrite.do")) {		
			actionSet = new PortfolioInsertAction();
			System.out.println("포트폴리오 업로드하기");
		} 
		else if(command.equals("/board.do")) {		
			actionSet = new PortfolioSelectAllAction();
			System.out.println("포트폴리오 전체보기");
		} 
		else if(command.equals("/portfolioOne.do")) {		
			actionSet = new PortfolioSelectOneAction();
			System.out.println("포트폴리오 상세보기");
		} 
		else if(command.equals("/writeComment.do")) {		
			actionSet = new WriteCommentAction();
			System.out.println("댓글 달기");
		} 
		else if(command.equals("/contact.do")) {		
			actionSet = new ContactAction();
			System.out.println("포트폴리오 글 가져오기");
		} 
		else if(command.equals("/deletePortfolio.do")) {		
			actionSet = new DeletePortfolioAction();
			System.out.println("포트폴리오 글 삭제하기");
		} 
		else if(command.equals("/deleteReply.do")) {		
			actionSet = new DeleteReplyAction();
			System.out.println("댓글 삭제하기");
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
