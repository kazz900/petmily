package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberFindServlet
 */
@WebServlet("/idfind")
public class IdFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdFindServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원정보 아이디 조회용 컨트롤러
		request.setCharacterEncoding("UTF-8");
		String memail = request.getParameter("memail");
		Member member = new MemberService().findMemberid(memail);

		RequestDispatcher view = null;
		if (member.getMemberId() != null) {
			request.setAttribute("member", member);
			request.setAttribute("message", "성공메세지보냄");
		} else {
			request.setAttribute("message", memail + "로 가입된 회원정보 없음");
		}
		view = request.getRequestDispatcher("views/member/findinfoPage.jsp");
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
