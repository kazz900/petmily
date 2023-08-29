package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1056959982559128200L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	로그아웃 컨트롤러
		
		//request 에 등록되어있는 세션 객체의 ID를 이용해서 세션 객체를 조회한다.
		HttpSession session = request.getSession(false);
		//false : ID 와 일치하는 세션객체가 있으면 가져오고, 없으면 Null을 리턴한다.
		
		//해당 세션 객체가 존재하면, 세션 객체를 없앤다.
		if(session != null) {
			session.invalidate();
			//index.jsp 페이지로 이동한다.
			response.sendRedirect("index.jsp");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}