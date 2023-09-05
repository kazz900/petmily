package member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ChangePwdServlet
 */
@WebServlet("/changePwd")
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePwdServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Member member = new Member();

		member.setMemberId(request.getParameter("userid"));
		String userpwd = request.getParameter("userpwd");
		String cryptoUserpwd = null;
		try { // 입력받은 변경할 패스워드 암호화처리
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));
			md.update(pwdValues);
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
		} catch (Exception e) {
			e.printStackTrace();
		}
		member.setMemberPwd(cryptoUserpwd);
		int result = new MemberService().updateMemberpwd(member);
		if (result > 0) { // 패스워드 변경완료시 로그아웃처리하고 로그인페이지로 보냄
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/petmily/views/member/login.jsp");
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
