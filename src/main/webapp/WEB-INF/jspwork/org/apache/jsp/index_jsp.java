/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-30 02:46:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/common/main.jsp", Long.valueOf(1693302158009L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>petmily</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/petmily/resources/js/common/jquery-3.7.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/petmily/resources/js/main/banner_scroll.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/petmily/resources/css/main/banner.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<section>\r\n");
      out.write('\r');
      out.write('\n');
 Member member = (Member)session.getAttribute("member"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/petmily/resources/js/main/main.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/petmily/resources/css/main/main.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<input type=\"checkbox\" id=\"menuicon\">\r\n");
      out.write("\r\n");
      out.write("	<header style=\"left: 0px;\">\r\n");
      out.write("		<div>\r\n");
      out.write("			<ul class=\"navi\">\r\n");
      out.write("				<!-- style=\"top: 50px; right: 77px;\" -->\r\n");
      out.write("				<li class=\"logo\"><a href=\"/petmily/index.jsp\">Petmily</a></li>\r\n");
      out.write("				<li>\r\n");
      out.write("					<form class='formSearch' style=\"margin-right: 80px;\">\r\n");
      out.write("						<div class='field'>\r\n");
      out.write("							<input class='inputSearch' id='inputSearch' name='inputSearch'\r\n");
      out.write("								required type='text'> <label for='inputSearch'>\r\n");
      out.write("								지역, 이름으로 검색 </label>\r\n");
      out.write("						</div>\r\n");
      out.write("					</form>\r\n");
      out.write("				</li>\r\n");
      out.write("				<li><a class=\"sub-link\" href=\"/petmily/mis?deptSeq=578\">내주변</a></li>\r\n");
      out.write("				<li><a class=\"sub-link\" href=\"/petmily/views/common/waiting.jsp\">커뮤니티</a></li>\r\n");
      out.write("				");
if(member == null){ 
      out.write("\r\n");
      out.write("				<li><a class=\"sub-link\" href=\"/petmily/views/member/login.jsp\">로그인</a></li>\r\n");
      out.write("				");
 }else{ 
      out.write("\r\n");
      out.write("				\r\n");
      out.write("				<li\r\n");
      out.write("					style=\"display: inline-block; font-size: 15px; width: 90px; height: 20px; position: absolute; top: 25px; margin-left: 20px;\">");
      out.print( member.getMemberNick() );
      out.write("님</li>\r\n");
      out.write("				<li\r\n");
      out.write("					style=\"display: inline-block; font-size: 15px; width: 90px; height: 20px;\"><a\r\n");
      out.write("					href=\"/petmily/logout\"\r\n");
      out.write("					style=\"padding-top: 0px; padding-left: 0px; padding-right: 0px; padding-bottom: 0px; margin-left: 45px; position: relative; top: 12px;\">logout</a></li>\r\n");
      out.write("				");
 } 
      out.write("\r\n");
      out.write("			</ul>\r\n");
      out.write("			<label for=\"menuicon\" class=\"menubtn\"> <span></span> <span></span>\r\n");
      out.write("				<span></span>\r\n");
      out.write("			</label>\r\n");
      out.write("		</div>\r\n");
      out.write("	</header>\r\n");
      out.write("	<div class=\"menu-container\">\r\n");
      out.write("		<div class=\"sidebar\">\r\n");
      out.write("			<span class=\"area_desc\" style=\"margin-top: 25%\">\r\n");
      out.write("				<ul>\r\n");
      out.write("					");
 if(member == null){ 
      out.write("\r\n");
      out.write("					<li class=\"sidebarmenutitle\">더보기</li>\r\n");
      out.write("					\r\n");
      out.write("					<li><a href=\"/petmily/suggest\" class=\"sidebarmenu\">고객센터</a></li>\r\n");
      out.write("					");
 }else{ 
      out.write("\r\n");
      out.write("					<li class=\"sidebarmenutitle\">더보기</li>\r\n");
      out.write("					<li><a href=\"#\" class=\"sidebarmenu\">마이페이지</a></li>\r\n");
      out.write("					<li><a href=\"/petmily/suggest\" class=\"sidebarmenu\">고객센터</a></li>\r\n");
      out.write("					");
 } 
      out.write("\r\n");
      out.write("				</ul>\r\n");
      out.write("			</span><br>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	</header>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<div class=\"banner-container\" style=\"height: 750px; margin-top:85px\">\r\n");
      out.write("  <div class=\"banner\">\r\n");
      out.write("    <div data-index=1><img src=\"/petmily/resources/images/mainbanner/882.jpg\"></div>\r\n");
      out.write("    <div data-index=2><img src=\"/petmily/resources/images/mainbanner/883.jpg\"></div>\r\n");
      out.write("    <div data-index=3><img src=\"/petmily/resources/images/mainbanner/884.jpg\"></div>\r\n");
      out.write("    <div data-index=4><img src=\"/petmily/resources/images/mainbanner/885.jpg\"></div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"list-button\">\r\n");
      out.write("  <span class=\"list-button-item active\"></span> \r\n");
      out.write("  <span class=\"list-button-item\"></span> \r\n");
      out.write("  <span class=\"list-button-item\"></span> \r\n");
      out.write("  <span class=\"list-button-item\"></span> \r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"block\">\r\n");
      out.write("<ul style=\"position:absolute; left: 20%; padding-left: 0px; display:inline\">\r\n");
      out.write("<span style=\"margin-right:50px;\"><a href=\"#\"><ul style=\"display:inline-block\"><li><img src=\"/petmily/resources/images/mainicon/veterinary.png\" style=\"height:100px; width:100px;\"></li><li class=\"main-icon\" style=\"text-align: center\">병원</li></ul></a></span>\r\n");
      out.write("<span style=\"margin-right:50px;\"><a href=\"#\"><ul style=\"display:inline-block\"><li><img src=\"/petmily/resources/images/mainicon/miyong.png\" style=\"height:100px; width:100px;\"></li><li class=\"main-icon\" style=\"text-align: center\">미용</li></ul></a></span>\r\n");
      out.write("<span style=\"margin-right:50px;\"><a href=\"#\"><ul style=\"display:inline-block\"><li><img src=\"/petmily/resources/images/mainicon/shop.png\" style=\"height:100px; width:100px;\"></li><li class=\"main-icon\" style=\"text-align: center\">용품</li></ul></a></span>\r\n");
      out.write("<span style=\"margin-right:50px;\"><a href=\"#\"><ul style=\"display:inline-block\"><li><img src=\"/petmily/resources/images/mainicon/witac.png\" style=\"height:100px; width:100px;\"></li><li class=\"main-icon\" style=\"text-align: center\">위탁</li></ul></a></span>\r\n");
      out.write("<span style=\"margin-right:50px;\"><a href=\"#\" ><ul style=\"display:inline-block\"><li><img src=\"/petmily/resources/images/mainicon/hosp.png\" style=\"height:100px; width:100px;\"></li><li class=\"main-icon\" style=\"text-align: center\">카페, 식당</li></ul></a></span>\r\n");
      out.write("<span style=\"margin-right:50px;\"><a href=\"#\"><ul style=\"display:inline-block\"><li><img src=\"/petmily/resources/images/mainicon/hotel.png\" style=\"height:100px; width:100px;\"></li><li class=\"main-icon\" style=\"text-align: center\">호텔</li></ul></a></span>\r\n");
      out.write("<span style=\"margin-right:50px;\"><a href=\"#\"><ul style=\"display:inline-block\"><li><img src=\"/petmily/resources/images/mainicon/muhwa.png\" style=\"height:100px; width:100px;\"></li><li class=\"main-icon\" style=\"text-align: center\">문화</li></ul></a></span>\r\n");
      out.write("<span style=\"margin-right:50px;\"><a href=\"#\"><ul style=\"display:inline-block\"><li><img src=\"/petmily/resources/images/mainicon/dead.png\" style=\"height:100px; width:100px;\"></li><li class=\"main-icon\" style=\"text-align: center\">장묘</li></ul></a></span>\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
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
