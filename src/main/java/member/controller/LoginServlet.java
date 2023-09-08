package member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberServlet1
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 일반회원 로그인처리용 컨트롤러
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("memberid");
		String mpwd = request.getParameter("memberpwd");
		String cryptoUserpwd = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] pwdValues = mpwd.getBytes(Charset.forName("UTF-8"));
			md.update(pwdValues);
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Member member = new MemberService().commonLogin(mid, cryptoUserpwd);
		if (member.getMemberGrade() != null) { // 값 있음, 로그인 성공시
			if (Integer.parseInt(member.getMemberGrade()) != 2) {// 정지당한 회원이 아닌경우
				// 로그인 상태 확인용 세션 객체 생성함
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(30 * 60);
				session.setAttribute("member", member);
				response.sendRedirect("index.jsp");
			} else {	// 정지당한 회원의 경우
				RequestDispatcher view = request.getRequestDispatcher("views/member/login.jsp");
				request.setAttribute("message", "정지처리된 회원입니다. 관리자에게 문의해주세요.");
				view.forward(request, response);
			}
		} else {	//회원정보를 잘못 입력한 경우
			RequestDispatcher view = request.getRequestDispatcher("views/member/login.jsp");
			request.setAttribute("message", "아이디 혹은 패스워드를 다시 확인해주세요.");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
