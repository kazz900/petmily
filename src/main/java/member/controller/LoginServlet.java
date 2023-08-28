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
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberServlet1
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("memberid");
		String mpwd = request.getParameter("memberpwd");
		String cryptoUserpwd = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			// 패스워드 문자열을 암호문으로 바꾸려면, byte[]로 변환시켜야함
			byte[] pwdValues = mpwd.getBytes(Charset.forName("UTF-8"));
			// 암호문으로 변경하기
			md.update(pwdValues);
			// 암호화된 byte[] 을 String으로 변경시킴 : 암호문 상태가 됨
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			
			//확인하기
			//System.out.println("암호화된 패스워드 : " + cryptoUserpwd);
			//System.out.println("글자길이 : " + cryptoUserpwd.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3. 서비스 메소드로 값 전달 실행하고 결과 받아오기
		Member loginMember = new MemberService().commonLogin(mid, cryptoUserpwd);
		
		// 4. 받은 결과를 가지고 성공/실패 페이지 내보내기
		if(loginMember != null) {	// 값 있음, 로그인 성공시
				// 로그인 상태 확인용 세션 객체 생성함
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30*60);	
			//초단위 지정임 30분 지정	>	30분동안 활동 없을시 자동 파기(로그아웃)처리됨.
			
			//System.out.println("생성된 Session 객체의 id : " + session.getId());
			
			// 로그인한 회원의 정보를 세션객체에 저장한다.
			session.setAttribute("loginMember", loginMember);
			
			// 로그인 성공시 내보낼 페이지 지정
			response.sendRedirect("index.jsp");
			
		} else {	// 값 없음, 로그인 실패시
				// 클라이언트 브라우저로 내보낼 뷰 파일과 메세지 지정
				// 서블릿의 위치는 모두 root에서 실행되고 있다.			
				// 상대경로만 사용할 수 있다.
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");

			if(loginMember == null) {
				request.setAttribute("message", "아이디 혹은 패스워드를 다시 확인해주세요.");
			}
				// 요청한 클라이언트로 전송처리함
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
