package member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ChangePwdServlet
 */
@WebServlet("/changePwd")
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member member = new Member();
		
		
		member.setMemberId(request.getParameter("userid"));
		String userpwd = request.getParameter("userpwd");
		
		String cryptoUserpwd = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));
			
			md.update(pwdValues);
			
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		member.setMemberPwd(cryptoUserpwd);
		
		int result = new MemberService().updateMemberpwd(member);
		
		if (result > 0) {
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("/petmily/views/member/login.jsp");
		} else {
			System.out.println("비밀번호 변경 실패.");
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
