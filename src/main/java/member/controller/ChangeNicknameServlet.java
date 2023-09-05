package member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ChangeNicknameServlet
 */
@WebServlet("/myinfo")
public class ChangeNicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeNicknameServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 한글 넘어오면 인코딩처리

		String userid = request.getParameter("userid");
		String nickname = request.getParameter("nickname");
		String memail = request.getParameter("email");

		int result = new MemberService().updateMemberInfo(userid, nickname);

		if (result > 0) {//
			Member member = new MemberService().snsLogin(memail);
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30 * 60);
			session.setAttribute("member", member);

			response.sendRedirect("/petmily/views/servicecenter/dCommon/updateSucceed.jsp");
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
