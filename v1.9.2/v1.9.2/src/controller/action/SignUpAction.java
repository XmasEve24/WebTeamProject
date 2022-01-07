package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionInformation;
import model.member.MemberDAO;
import model.member.MemberVO;

public class SignUpAction implements Action {

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionInformation info = new ActionInformation();
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPw(request.getParameter("memberPw"));
		vo.setMemberEmail(request.getParameter("memberEmail"));
		vo.setMemberName(request.getParameter("memberName"));
		
		request.setCharacterEncoding("UTF-8");
		// ajax로 값을 받기 때문에 UTF-8로 인코딩해준다
		response.setCharacterEncoding("EUC-KR");

		String userId = request.getParameter("userId");
		// join.jsp에서 받아온 key값이 userId이고
		// value값은 유저가 실제로 적은 값, String userId에는 value값이 들어간다.
		PrintWriter out = response.getWriter();

		int idChcek = dao.checkId(vo);

		// 성공여부 확인 : 개발자용
		if (idChcek == 0) {
			System.out.println("이미 존재하는 아이디입니다.");
		} else if (idChcek == 1) {
			System.out.println("사용 가능한 아이디입니다.");
		}

		out.write(idChcek + ""); // --> ajax 결과값인 result가 됨
		// --> String으로 값을 내보낼 수 있도록 + "" 를 해준다
		if (dao.signUp(vo)) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", vo.getMemberId());
			session.setAttribute("memberName", vo.getMemberName());
			System.out.println("회원가입 성공");
			info.setPath("login.jsp");
			info.setRedirect(true);
		} else {
			System.out.println("회원가입 실패");
			info.setPath("signup.jsp");
			info.setRedirect(true);
		}

		return info;
	}

}
