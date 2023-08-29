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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입시 아이디와 이메일을 입력받아 회원정보가 db에 있는지 조회하는 컨트롤러
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String memail = request.getParameter("memail");
		
		Member findMember = new MemberService().findMemberpwd(mid, memail);

		if(findMember != null) {
			// 값 있으면 
			request.setAttribute("findMember", findMember);
			request.getRequestDispatcher("/petmily/views/member/passwordUpdate.jsp").forward(request, response);
			//response.sendRedirect("/petmily/views/member/passwordUpdate.jsp");	
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", memail + "로 가입된 회원정보 없음");
			
			//뷰를 포워딩함
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
