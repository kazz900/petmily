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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memail = request.getParameter("memail");
		
		Member findMember = new MemberService().findMemberid(memail);
		
		String returnValue = null;	//ajax로 보낼 문자 저장용
		
		if(findMember != null) {
			returnValue = findMember.getMemberId();
					//ajax 통신은 네트워크 입출력임 : 별도의 스트림을 열어서 사용함
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append(returnValue);
		out.flush();
		out.close();		
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
