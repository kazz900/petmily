/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-29 06:03:36 UTC
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
    _jspx_dependants.put("/views/member/../common/footer.jsp", Long.valueOf(1693281650000L));
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Petmily</title>\n");
      out.write("<script type=\"text/javascript\" src=\"https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js\" charset=\"utf-8\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"/petmily/resources/js/common/jquery-3.7.0.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("  ");
 if (request.getAttribute("message") != null) { 
      out.write("\n");
      out.write("    alert(\"");
      out.print(request.getAttribute("message"));
      out.write("\");\n");
      out.write("    location.href=\"/petmily/views/member/login.jsp\";	//로그인 실패시 \n");
      out.write("  ");
 } 
      out.write("\n");
      out.write("</script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("@font-face {\n");
      out.write("	font-family: 'Surround';\n");
      out.write("	src: url('/petmily/resources/font/surround.woff2') format('woff2');\n");
      out.write("	font-weight: normal;\n");
      out.write("	font-style: normal;\n");
      out.write("}\n");
      out.write("body {\n");
      out.write("      font-family: 'Surround', sans-serif;\n");
      out.write("      padding: 20px 50px;\n");
      out.write("font-size: 25px;\n");
      out.write("font-weight: 900;\n");
      out.write("color: hsl(30.5, 77.6%, 29.8%);\n");
      out.write("	background-color:  hsl(30.7, 86.9%, 70%);\n");
      out.write("    }\n");
      out.write("body h1 {\n");
      out.write("      font-family: 'Surround', sans-serif;\n");
      out.write("      padding: 20px 50px;\n");
      out.write("font-size: 35px;\n");
      out.write("font-weight: 900;\n");
      out.write("color: hsl(30.46deg 58.9% 45.68%);\n");
      out.write("    }\n");
      out.write("    form {\n");
      out.write("	text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */\n");
      out.write("	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */\n");
      out.write("	width: 350px; /* 폼의 너비 설정 */\n");
      out.write("	height: auto;\n");
      out.write("/* 	border: 1px solid black;  */\n");
      out.write("    }\n");
      out.write("/* td {\n");
      out.write("border: 1px solid red; \n");
      out.write("}  */\n");
      out.write(" td input[type=text]{\n");
      out.write(" width: 250px;\n");
      out.write(" height: 30px;\n");
      out.write(" border-radius: 3px;\n");
      out.write(" background-color: #c5c5c5;\n");
      out.write(" }\n");
      out.write(" td input[type=password]{\n");
      out.write(" width: 250px;\n");
      out.write(" height: 30px;\n");
      out.write(" border-radius: 3px;\n");
      out.write(" background-color: #c5c5c5;\n");
      out.write(" }\n");
      out.write("#logincheck {\n");
      out.write("width:80px;\n");
      out.write("height:80px;\n");
      out.write(" border-radius: 3px;\n");
      out.write(" background-color: #39f;\n");
      out.write("}\n");
      out.write("#findinfo {\n");
      out.write("text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */\n");
      out.write("	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */\n");
      out.write("	width: 165px; /* 폼의 너비 설정 */\n");
      out.write("	height: 30px;\n");
      out.write("	 border-radius: 3px;\n");
      out.write(" background-color: #39f;\n");
      out.write("}\n");
      out.write("#enroll {\n");
      out.write("text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */\n");
      out.write("	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */\n");
      out.write("	width: 165px; /* 폼의 너비 설정 */\n");
      out.write("	height: 30px;\n");
      out.write("	 border-radius: 3px;\n");
      out.write(" background-color: #39f;\n");
      out.write("}\n");
      out.write("      </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<header>\n");
      out.write("<h1 align=\"left\">Petmily</h1> <!-- 추후 include처리 -->\n");
      out.write("</header>\n");
      out.write("<h2 align=\"center\">로그인</h2> <!-- 추후 include처리 -->\n");
      out.write("<form action=\"/petmily/login\">\n");
      out.write("	<table>\n");
      out.write("		<tr><td><input type=\"text\" id=\"memberid\" name=\"memberid\" placeholder=\"아이디 입력\" required> </td>\n");
      out.write("		<td rowspan=\"2\"><input type=\"submit\" value=\"로그인\" id=\"logincheck\"></td></tr>\n");
      out.write("		<tr><td><input type=\"password\" id=\"memberpwd\" name=\"memberpwd\" placeholder=\"패스워드 입력\"required></td></tr>\n");
      out.write("		<tr><td colspan=\"2\"><input type=\"button\" value=\"ID/PA 조회\" id=\"findinfo\" onclick=\"moveFindinfoPage();\">\n");
      out.write("		<input type=\"button\" value=\"회원가입\" id=\"enroll\" onclick=\"moveEnrollPage();\"></td></tr>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function moveFindinfoPage(){\n");
      out.write("	location.href=\"/petmily/views/member/findinfoPage.jsp\";\n");
      out.write("}\n");
      out.write("function moveEnrollPage(){\n");
      out.write("	location.href=\"/petmily/views/member/enrollPage.jsp\";\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("	</table>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write(" ");

    String clientId = "Y4aSWVB6n8GBIwdvF73u";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http:" + "//" + "localhost:8080/petmily/naver", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https:"+"//"+"nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 
      out.write("\n");
      out.write(" <div align=\"center\">\n");
      out.write("  <a href=\"");
      out.print(apiURL);
      out.write("\"><img width=\"200\" height=\"60\" src=\"http://static.nid.naver.com/oauth/small_g_in.PNG\"></a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("</body>\n");
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
