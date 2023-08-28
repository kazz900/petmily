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
 * Servlet implementation class MemberpwdchangeServlet
 */
@WebServlet("/pwdupdate")
public class PwdupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdupdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원정보가 db에 있을때 새로운 패스워드를 입력받아 암호화한 뒤 DB 업데이트를 위한 컨트롤러
		Member member = new Member();
		
		member.setMemberId(request.getParameter("mid"));
		String newPwd = request.getParameter("newpwd");
		member.setMemberEmail(request.getParameter("memail"));

		String cryptoUserpwd = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			// 패스워드 문자열을 암호문으로 바꾸려면, byte[]로 변환시켜야함
			byte[] pwdValues = newPwd.getBytes(Charset.forName("UTF-8"));
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
		int result = new MemberService().updatePwd(member);
		if(result > 0) {
			//변경 성공시 변경완료 페이지로 이동
			response.sendRedirect("/first/views/member/changePwdComp.html");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "비밀번호 변경 에러.");			
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
