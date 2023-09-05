package member.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String nickname = request.getParameter("nickname");
		String memail = request.getParameter("email");
		String message = "성공적으로 변경되었습니다.";
		int result = new MemberService().updateMemberInfo(userid, nickname);
		
		if (result > 0) {
			
			Member member = new MemberService().snsLogin(memail);
			
			HttpSession session = request.getSession();
//			session.invalidate();
			
			session.setMaxInactiveInterval(30 * 60);
			session.setAttribute("member", member);
			
			response.sendRedirect("/petmily/mypet?memberSeq=" + member.getMemberSeq() + "&message=" + URLEncoder.encode(message, "UTF-8"));
		} else {
			System.out.println("ChangeNicknameServlet 실패");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
