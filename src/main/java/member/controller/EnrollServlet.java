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

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollServlet
 */
@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원가입 처리용 컨트롤러
		request.setCharacterEncoding("UTF-8");
		Member member = new Member();
		member.setMemberId(request.getParameter("mid"));
		String mPwd = request.getParameter("mpwd"); // 암호화처리를 위해 변수에 저장시킴
		member.setMemberNick(request.getParameter("mnick"));
		member.setMemberEmail(request.getParameter("memail"));
		String cryptoUserpwd = null;
		try { // 입력받은 패스워드 암호화처리
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			// 패스워드 문자열을 암호문으로 바꾸려면, byte[]로 변환시켜야함
			byte[] pwdValues = mPwd.getBytes(Charset.forName("UTF-8"));
			// 암호문으로 변경하기
			md.update(pwdValues);
			// 암호화된 byte[] 을 String으로 변경시킴 : 암호문 상태가 됨
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			// 확인하기

		} catch (Exception e) {
			e.printStackTrace();
		}

		member.setMemberPwd(cryptoUserpwd);

		int result = new MemberService().insertMember(member);

		if (result > 0) {
			request.setAttribute("message", "회원가입 성공. 로그인해주세요.");
		}
		RequestDispatcher view = request.getRequestDispatcher("views/member/login.jsp");
		view.forward(request, response);
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
