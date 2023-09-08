package member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class KakaoServlet
 */
@WebServlet("/kakao")
public class KakaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KakaoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 카카오아이디 로그인 및 회원가입 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		Member member = new Member();
		MemberService mservice = new MemberService();
		JSONParser parsing = new JSONParser();
		JSONObject jsonObj = new JSONObject();
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String checkKakaoemail = "kakao";
		String Kname = null;
		String Kemail = null;
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String responseBody = sb.toString();
		try {
			Object obj = parsing.parse(responseBody);
			jsonObj = (JSONObject) obj;
			JSONObject resObj = (JSONObject) jsonObj;

			Kname = (String) resObj.get("nickname");
			Kemail = checkKakaoemail + (String) resObj.get("email");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		member = mservice.snsLogin(Kemail);
		
		if (member == null) {
			Member newMember = new Member();
			String generatedId = "k@";
			String snspwdIsNull = null;
			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			StringBuilder token = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				char randomChar = characters.charAt(random.nextInt(characters.length()));
				token.append(randomChar);
			}
			generatedId += token.toString();

			newMember.setMemberId(generatedId);
			newMember.setMemberPwd(snspwdIsNull);
			newMember.setMemberNick(Kname);
			newMember.setMemberEmail(Kemail);

			int result = mservice.insertMember(newMember);

			if (result > 0) {
				member = mservice.snsLogin(Kemail);
			}
		}
		if (Integer.parseInt(member.getMemberGrade()) != 2) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30 * 60); // 30분동안 활동 없을시 자동 파기(로그아웃)처리됨.
			session.setAttribute("member", member);
			request.setAttribute("message", "정상적인 로그인입니다.");
			response.sendRedirect("index.jsp");
		} else {
			boolean condition = true; // 조건을 원하는 대로 설정
			if (condition) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}
		}
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
