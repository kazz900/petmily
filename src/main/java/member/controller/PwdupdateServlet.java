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
 * Servlet implementation class MemberpwdchangeServlet
 */
@WebServlet("/pwdupdate")
public class PwdupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PwdupdateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원정보가 DB에 있을때 새로운 패스워드를 입력받아 암호화한 뒤 DB 업데이트를 위한 컨트롤러
		Member member = new Member();
		RequestDispatcher view = null;
		member.setMemberId(request.getParameter("mid"));
		String newPwd = request.getParameter("mpwd");
		member.setMemberEmail(request.getParameter("memail"));

		String cryptoUserpwd = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] pwdValues = newPwd.getBytes(Charset.forName("UTF-8"));
			md.update(pwdValues);
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
		} catch (Exception e) {
			e.printStackTrace();
		}

		member.setMemberPwd(cryptoUserpwd);
		int result = new MemberService().updatePwd(member);
		if (result > 0) {
			request.setAttribute("message", "비밀번호 변경됨.");
		} else {
			request.setAttribute("message", "Error! 비밀번호 변경 실패.");
		}

		view = request.getRequestDispatcher("views/member/login.jsp");
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
