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
 * Servlet implementation class MemberEnrollServlet
 */
@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member member = new Member();
		member.setMemberId(request.getParameter("mid"));
		String mPwd = request.getParameter("mpwd");	//암호화처리를 위해 변수에 저장시킴
		member.setMemberNick(request.getParameter("mnick"));
		member.setMemberEmail(request.getParameter("memail"));
		
		String cryptoUserpwd = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			// 패스워드 문자열을 암호문으로 바꾸려면, byte[]로 변환시켜야함
			byte[] pwdValues = mPwd.getBytes(Charset.forName("UTF-8"));
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
		
		member.setMemberPwd(cryptoUserpwd);
		
		int result = new MemberService().insertMember(member);
		
		//4. 받은 결과로 내보낼 뷰 선택 처리 
		if(result > 0) {
			//수정 성공시 마이 페이지 뷰가 출력되게 한다면, myinfo 서블릿을 구동시킴
			//서블릿에서 다른 서블릿을 실행시킬 수 있음
			response.sendRedirect("/first/myinfor?userid=" + member.getMemberId());//쿼리스트링안에 절대 공백이 포함되어서는 안됨
			//해당부분 코딩시 리다이렉트하는 서블릿 주소 변경해야함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
			//수정 성공시 메인페이지가 출력되게 한다면 
			//response.sendRedirect("/first/index.jsp");
			
		}else {
			//회원가입 실패시 error.jsp 로 에러메세지를 보냄
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			//상대경로만 사용할 수 있음
			
			//지정한 뷰로 내보낼 정보나 객체가 있으면 request 에 기록 저장함
			//request.setAttribute(String name, Object value);
			request.setAttribute("message", member.getMemberId() + "회원가입 실패");
			
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
