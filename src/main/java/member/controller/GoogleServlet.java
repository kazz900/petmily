package member.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class GoogleServlet
 */
@WebServlet("/google")
public class GoogleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoogleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Member member = new Member();
		MemberService mservice = new MemberService();
		String id = request.getParameter("google_id_login_id");		
		String name = request.getParameter("google_id_login_name");	
		
		member = mservice.snsLogin(id);

		if(member == null) {	//회원정보 없을시 sns계정정보 임의생성용 토큰생성 메소드
			member = new Member();
			String generatedId = "g@";	
			
			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			StringBuilder token = new StringBuilder();
			Random random = new Random();		
			for (int i = 0; i < 10; i++) {
				char randomChar = characters.charAt(random.nextInt(characters.length()));
				token.append(randomChar);
			}
			
			generatedId += token.toString();
			
			member.setMemberId(generatedId);
			member.setMemberPwd(generatedId);
			member.setMemberNick(request.getParameter("google_id_login_name"));
			member.setMemberEmail(request.getParameter("google_id_login_id"));	
			
			int result = mservice.insertMember(member);
			
			//4. 받은 결과로 내보낼 뷰 선택 처리 
			if(result == 0) {
				//회원가입 실패시 error.jsp 로 에러메세지를 보냄
				RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");

				request.setAttribute("message", member.getMemberEmail() + "회원가입 실패");
								
				view.forward(request, response);
			}			
		}		
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60);	
		session.setAttribute("member", member);
		response.sendRedirect("index.jsp");			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
