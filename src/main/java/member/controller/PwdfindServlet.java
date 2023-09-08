package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberpwdsearchServlet
 */
@WebServlet("/pwdfind")
public class PwdfindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PwdfindServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 패스워드 조회시 아이디와 이메일을 입력받아 회원정보 DB에 조회하는 컨트롤러
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("pmid");
		String memail = request.getParameter("pmemail");
		Member member = new MemberService().findMemberpwd(mid, memail);
		RequestDispatcher view = null;

		if (member.getMemberGrade() != null) {
			// 회원정보 있으면
			request.setAttribute("member", member);
			view = request.getRequestDispatcher("views/member/passwordUpdate.jsp");
		} else {
			request.setAttribute("message", "해당 정보로 가입된 회원 없음.");
			view = request.getRequestDispatcher("views/member/findinfoPage.jsp");
		}
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
