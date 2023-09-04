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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("memberid");
		String mpwd = request.getParameter("memberpwd");
		String cryptoUserpwd = null;

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");

			// 패스워드 문자열을 암호문으로 바꾸려면, byte[]로 변환시켜야함
			byte[] pwdValues = mpwd.getBytes(Charset.forName("UTF-8"));
			// 암호문으로 변경하기
			md.update(pwdValues);
			// 암호화된 byte[] 을 String으로 변경시킴 : 암호문 상태가 됨
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			System.out.println(mid);
			System.out.println(cryptoUserpwd);
			// 확인하기
			// System.out.println("암호화된 패스워드 : " + cryptoUserpwd);
			// System.out.println("글자길이 : " + cryptoUserpwd.length());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3. 서비스 메소드로 값 전달 실행하고 결과 받아오기
		Member member = new MemberService().commonLogin(mid, cryptoUserpwd);

		// System.out.println(loginMember + " is mem");

		// 4. 받은 결과를 가지고 성공/실패 페이지 내보내기
		if (member.getMemberGrade() != null) { // 값 있음, 로그인 성공시
			if (Integer.parseInt(member.getMemberGrade()) != 2) {// 회원이 밴당한 회원이 아닌경우
				// 로그인 상태 확인용 세션 객체 생성함
				HttpSession session = request.getSession();
				// 초단위 지정임 30분 지정 > 30분동안 활동 없을시 자동 파기(로그아웃)처리됨.
				session.setMaxInactiveInterval(30 * 60);
				// 로그인한 회원의 정보를 세션객체에 저장
				session.setAttribute("member", member);
				// 로그인 성공시 내보낼 페이지 지정
				response.sendRedirect("index.jsp");
			} else {
				String message = "정지처리된 회원입니다. 관리자에게 문의해주세요.";
				response.getWriter().write("{\"message\":\"" + message + "\"}");
			}
		} else {
			String message = "아이디 혹은 패스워드를 다시 확인해주세요.";
			response.getWriter().write("{\"message\":\"" + message + "\"}");
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
