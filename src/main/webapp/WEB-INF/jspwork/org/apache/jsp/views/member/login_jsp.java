/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-09-04 11:39:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.math.BigInteger;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/member/../common/footer.jsp", Long.valueOf(1693554393356L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.security.SecureRandom");
    _jspx_imports_classes.add("java.net.URLEncoder");
    _jspx_imports_classes.add("java.math.BigInteger");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name =\"google-signin-client_id\" content=\"23928052687-euopa8m23l0j93plo1rfms4tvqrpkh8m.apps.googleusercontent.com\">\r\n");
      out.write("<title>Petmily</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/petmily/resources/js/common/jquery-3.7.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script src=\"https://developers.kakao.com/sdk/js/kakao.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  ");
 if (request.getAttribute("message") != null) { 
      out.write("\r\n");
      out.write("  ");
 if (request.getAttribute("message").equals("비밀번호 변경됨.")) { 
      out.write("\r\n");
      out.write("  	alert(\"비밀번호 변경 성공! 새로운 비밀번호로 로그인해주세요.\");\r\n");
      out.write("  ");
 } else {
      out.write("\r\n");
      out.write("    alert(\"");
      out.print(request.getAttribute("message"));
      out.write("\");\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("    location.href=\"/petmily/views/member/login.jsp\";	\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write(" ");
	//	네이버 로그인
    String clientId = "Y4aSWVB6n8GBIwdvF73u";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http:" + "//" + "localhost:8080/petmily/naver", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https:"+"//"+"nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("@font-face {\r\n");
      out.write("	font-family: 'Surround';\r\n");
      out.write("	src: url('/petmily/resources/font/surround.woff2') format('woff2');\r\n");
      out.write("	font-weight: normal;\r\n");
      out.write("	font-style: normal;\r\n");
      out.write("}\r\n");
      out.write("body {\r\n");
      out.write("      font-family: 'Surround', sans-serif;\r\n");
      out.write("      padding: 20px 50px;\r\n");
      out.write("font-size: 25px;\r\n");
      out.write("font-weight: 900;\r\n");
      out.write("color: hsl(30.5, 77.6%, 29.8%);\r\n");
      out.write("    }\r\n");
      out.write("body h1 a {\r\n");
      out.write("      font-family: 'Surround', sans-serif;\r\n");
      out.write("      padding: 20px 50px;\r\n");
      out.write("font-size: 35px;\r\n");
      out.write("font-weight: 900;\r\n");
      out.write("border: none;\r\n");
      out.write("color: hsl(30.46deg 58.9% 45.68%);\r\n");
      out.write("text-decoration: none;\r\n");
      out.write("    }\r\n");
      out.write("    body h2 {\r\n");
      out.write("      font-family: 'Surround', sans-serif;\r\n");
      out.write("      padding: 20px 50px;\r\n");
      out.write("color: hsl(30.5, 77.6%, 29.8%);\r\n");
      out.write("    }\r\n");
      out.write("    body h2 {\r\n");
      out.write("      font-family: 'Surround', sans-serif;\r\n");
      out.write("      padding: 20px 50px;\r\n");
      out.write("color: hsl(30.5, 77.6%, 29.8%);\r\n");
      out.write("    }\r\n");
      out.write("    form {\r\n");
      out.write("	text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */\r\n");
      out.write("	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */\r\n");
      out.write("	width: 350px; /* 폼의 너비 설정 */\r\n");
      out.write("	height: auto;\r\n");
      out.write("/* 	border: 1px solid black;  */\r\n");
      out.write("    }\r\n");
      out.write("/* td {\r\n");
      out.write("border: 1px solid red; \r\n");
      out.write("}  */\r\n");
      out.write(" td input[type=text]{\r\n");
      out.write("	width: 250px;\r\n");
      out.write("    height: 30px;\r\n");
      out.write("    border-radius: 7px;\r\n");
      out.write("    background-color: beige;\r\n");
      out.write("    font-family: 'Surround';\r\n");
      out.write("    border: solid;\r\n");
      out.write(" }\r\n");
      out.write(" td input[type=password]{\r\n");
      out.write("	width: 250px;\r\n");
      out.write("    height: 30px;\r\n");
      out.write("    border-radius: 7px;\r\n");
      out.write("    background-color: beige;\r\n");
      out.write("    font-family: 'Surround';\r\n");
      out.write("    border: solid;\r\n");
      out.write(" }\r\n");
      out.write("#logincheck {\r\n");
      out.write("    width: 80px;\r\n");
      out.write("    height: 80px;\r\n");
      out.write("    border-radius: 10px;\r\n");
      out.write("    color: hsl(30.5, 77.6%, 29.8%);\r\n");
      out.write("    background-color: hsl(36deg 70.37% 68.61%);\r\n");
      out.write("    font-family: 'Surround';\r\n");
      out.write("}\r\n");
      out.write("#findinfo {\r\n");
      out.write("text-align: center;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("    width: 165px;\r\n");
      out.write("    height: 30px;\r\n");
      out.write("    border-radius: 7px;\r\n");
      out.write("    color: hsl(30.5, 77.6%, 29.8%);\r\n");
      out.write("    background-color: hsl(36deg 70.37% 68.61%);\r\n");
      out.write("    font-family: 'Surround';\r\n");
      out.write("}\r\n");
      out.write("#enroll {\r\n");
      out.write("text-align: center;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("    width: 165px;\r\n");
      out.write("    height: 30px;\r\n");
      out.write("    border-radius: 7px;\r\n");
      out.write("    color: hsl(30.5, 77.6%, 29.8%);\r\n");
      out.write("    background-color: hsl(36deg 70.37% 68.61%);\r\n");
      out.write("    font-family: 'Surround';\r\n");
      out.write("}\r\n");
      out.write("td a {\r\n");
      out.write("left: 0px;\r\n");
      out.write("}\r\n");
      out.write(".social {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("}\r\n");
      out.write("      </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("<h1 align=\"left\"><a href=\"/petmily/index.jsp\">Petmily</a></h1>\r\n");
      out.write("</header>\r\n");
      out.write("<h2 align=\"center\">로그인</h2>\r\n");
      out.write("<form action=\"/petmily/login\">\r\n");
      out.write("	<table>\r\n");
      out.write("		<tr><td><input type=\"text\" id=\"memberid\" name=\"memberid\" placeholder=\"아이디 입력\" required> </td>\r\n");
      out.write("		<td rowspan=\"2\"><input type=\"submit\" value=\"로그인\" id=\"logincheck\"></td></tr>\r\n");
      out.write("		<tr><td><input type=\"password\" id=\"memberpwd\" name=\"memberpwd\" placeholder=\"패스워드 입력\"required></td></tr>\r\n");
      out.write("		<tr><td colspan=\"2\"><input type=\"button\" value=\"아이디/패스워드 찾기\" id=\"findinfo\" onclick=\"moveFindinfoPage();\">\r\n");
      out.write("		<input type=\"button\" value=\"회원가입\" id=\"enroll\" onclick=\"moveEnrollPage();\"></td></tr>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function moveFindinfoPage(){\r\n");
      out.write("	location.href=\"/petmily/views/member/findinfoPage.jsp\";\r\n");
      out.write("}\r\n");
      out.write("function moveEnrollPage(){\r\n");
      out.write("	location.href=\"/petmily/views/member/enrollPage.jsp\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<tr>\r\n");
      out.write("<td colspan=\"2\">\r\n");
      out.write("		<div class=\"social\">\r\n");
      out.write("			<div style=\"width:170px;\">\r\n");
      out.write("<a id=\"kakao-login-btn\" href=\"javascript:loginWithKakao()\">\r\n");
      out.write("  <img src=\"/petmily/resources/images/kakaologo.png\" width=\"60\" height=\"60\" alt=\"카카오 로그인 버튼\" /></a>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div style=\"width:170px;\">\r\n");
      out.write("<a href=\"");
      out.print(apiURL);
      out.write("\"><img width=\"60\" height=\"60\" src=\"/petmily/resources/images/naverlogo.png\"></a>\r\n");
      out.write("</div></div>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("  \r\n");
      out.write("	</table>\r\n");
      out.write("\r\n");
      out.write("<!-- 네이버로그인버튼 -->\r\n");
      out.write("<!-- 카카오로그인버튼 -->\r\n");
      out.write("<!-- 구글로그인 -->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write(" \r\n");
      out.write("<script>\r\n");
      out.write("Kakao.init('fa414bb9d343a627b76d4f12f380c22c');\r\n");
      out.write("\r\n");
      out.write("// 3. 데모버전으로 들어가서 카카오로그인 코드를 확인.\r\n");
      out.write("function loginWithKakao() {\r\n");
      out.write("    Kakao.Auth.login({\r\n");
      out.write("        success: function (authObj) {\r\n");
      out.write("            console.log(authObj); // access토큰 값\r\n");
      out.write("            Kakao.Auth.setAccessToken(authObj.access_token); // access토큰값 저장\r\n");
      out.write("            getInfo();\r\n");
      out.write("        },\r\n");
      out.write("        fail: function (err) {\r\n");
      out.write("            console.log(err);\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 4. 엑세스 토큰을 발급받고, 아래 함수를 호출시켜서 사용자 정보를 받아옴.\r\n");
      out.write("function getInfo() {\r\n");
      out.write("    Kakao.API.request({\r\n");
      out.write("        url: '/v2/user/me',\r\n");
      out.write("        success: function (res) {\r\n");
      out.write("            console.log(res);\r\n");
      out.write("            // 이메일, 닉네임 저장\r\n");
      out.write("            var email = res.kakao_account.email; \r\n");
      out.write("            var nickname = res.kakao_account.profile.nickname;\r\n");
      out.write("            var userInfo = {\r\n");
      out.write("                    email: email,\r\n");
      out.write("                    nickname: nickname\r\n");
      out.write("                };\r\n");
      out.write("\r\n");
      out.write("                // 서버로 정보 전송 후 메인페이지로 리다이렉트\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    type: 'POST',\r\n");
      out.write("                    url: '/petmily/kakao', \r\n");
      out.write("                    data: JSON.stringify(userInfo),\r\n");
      out.write("                    contentType: 'application/json',\r\n");
      out.write("                    success: function(response) {\r\n");
      out.write("                    console.log('Data sent successfully');\r\n");
      out.write("                    location.href=\"http://localhost:8080/petmily\"; \r\n");
      out.write("                    },\r\n");
      out.write("                    error: function(error) {\r\n");
      out.write("                    alert(\"정지처리된 회원입니다. 관리자에게 문의해주세요\");\r\n");
      out.write("                    location.href=\"/petmily/views/member/login.jsp\"; \r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("        },\r\n");
      out.write("        fail: function (error) {\r\n");
      out.write("            alert('카카오 로그인에 실패했습니다. 관리자에게 문의하세요.' + JSON.stringify(error));\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
