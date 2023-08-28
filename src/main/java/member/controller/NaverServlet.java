package member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class NaverServlet
 */
@WebServlet("/naver")
public class NaverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		Member member = new Member();
		MemberService mservice = new MemberService();
		JSONParser parsing = new JSONParser();
		JSONObject jsonObj = new JSONObject();
		String Nemail =null;
		String Nname = null;
		String clientId = "Y4aSWVB6n8GBIwdvF73u";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "oWbuQ2K3Ut";// 애플리케이션 클라이언트 시크릿값";
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String redirectURI = URLEncoder.encode("http:" + "//" + "localhost:8080/petmily/views/member/callback.jsp",
				"UTF-8");
		String apiURL;
		apiURL = "https:" + "//" + "nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		String access_token = "";
		//String refresh_token = "";
		StringBuffer res = new StringBuffer();

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				System.out.println(res.toString());

				Object obj = parsing.parse(res.toString());
				jsonObj = (JSONObject) obj;
//        	JSONObject jsonObj = (JSONObject)(new JSONParser().parse(res.toString()));

				access_token = (String) jsonObj.get("access_token");
				//refresh_token = (String) jsonObj.get("refresh_token");
			}
			if (access_token != null) { // access_token을 잘 받아왔다면
				try {
					String header = "Bearer " + access_token;
					String apiUrl = "https://openapi.naver.com/v1/nid/me";

					Map<String, String> requestHeaders = new HashMap<>();
					requestHeaders.put("Authorization", header);
					String responseBody = get(apiUrl, requestHeaders);
					System.out.println(responseBody);

					Object obj = parsing.parse(responseBody);
					jsonObj = (JSONObject) obj;
					JSONObject resObj = (JSONObject) jsonObj.get("response");
					System.out.println(resObj);

					Nemail = (String) resObj.get("email");
					Nname = (String) resObj.get("name");
					System.out.println("네이버 이메일은? " + Nemail);
					System.out.println("회원의 이름은? " + Nname);

					System.out.println("complete!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		member = mservice.snsLogin(Nemail);

		if(member == null) {	//회원정보 없을시 sns계정정보 임의생성용 토큰생성 메소드
			member = new Member();
			String generatedId = "n@";			
			String snspwdIsNull = null;
			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			StringBuilder token = new StringBuilder();
			Random random = new Random();		
			for (int i = 0; i < 10; i++) {
				char randomChar = characters.charAt(random.nextInt(characters.length()));
				token.append(randomChar);
			}			
			generatedId += token.toString();
			
			member.setMemberId(generatedId);
			member.setMemberPwd(snspwdIsNull);
			member.setMemberNick(Nname);
			member.setMemberEmail(Nemail);	
			
		int result = mservice.insertMember(member);
		
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPwd());
		System.out.println(member.getMemberNick());
		System.out.println(member.getMemberEmail());
		if(result > 0) {
			member = mservice.snsLogin(Nemail);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");

			request.setAttribute("message", member.getMemberEmail() + "회원가입 실패");
							
			view.forward(request, response);
			}
		}	//회원정보생성및 로그인, 멤버반환처리
		// 세션생성
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60);	
		//초단위 지정임 30분 지정	>	30분동안 활동 없을시 자동 파기(로그아웃)처리됨.

		session.setAttribute("member", member);
		
		response.sendRedirect("index.jsp");		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}
}