/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-29 07:33:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import department.model.vo.Department;
import java.sql.Date;

public final class AdminMain2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/admin/../common/main.jsp", Long.valueOf(1693285867971L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("department.model.vo.Department");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("java.sql.Date");
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
      out.write("	\r\n");

ArrayList<Department> list = (ArrayList<Department>) request.getAttribute("list");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Petmily</title>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"/petmily/resources/css/admin/adminmain.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("	src=\"/petmily/resources/js/common/jquery-3.7.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("	src=\"/petmily/resources/js/info/infotap.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("	</script>\r\n");
      out.write("</head>\r\n");
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
      out.write("	\r\n");
      out.write("	<header>\r\n");
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
      out.write("				<li><a class=\"sub-link\" href=\"/petmily/views/member/login.jsp\">로그인</a></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			<label for=\"menuicon\" class=\"menubtn\"> <span></span> <span></span>\r\n");
      out.write("				<span></span>\r\n");
      out.write("			</label>\r\n");
      out.write("		</div>\r\n");
      out.write("	</header>\r\n");
      out.write("	<div class=\"menu-container\">\r\n");
      out.write("		<div class=\"sidebar\">\r\n");
      out.write("			<span class=\"area_desc\" style=\"margin-top:25%\">\r\n");
      out.write("			<ul>\r\n");
      out.write("			<li class=\"sidebarmenutitle\">더보기</li>\r\n");
      out.write("			<li><a href=\"#\" class=\"sidebarmenu\">커뮤니티</a></li>\r\n");
      out.write("			<li><a href=\"/petmily/suggest\" class=\"sidebarmenu\">고객센터</a></li>\r\n");
      out.write("			<li><a href=\"/petmily/adminmain\" class=\"sidebarmenu\">관리자</a></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			</span><br>\r\n");
      out.write("			\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	</header>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"info-content\">\r\n");
      out.write("		<div class=\"info-detail02\">\r\n");
      out.write("\r\n");
      out.write("			<ul class=\"tabs\">\r\n");
      out.write("				<li class=\"tab-link\" data-tab=\"tab-1\">업체등록</li>\r\n");
      out.write("				<li class=\"tab-link current\" data-tab=\"tab-2\">업체삭제</li>\r\n");
      out.write("				<li class=\"tab-link\" data-tab=\"tab-3\">회원 등급 변경</li>\r\n");
      out.write("				<li class=\"tab-link\" data-tab=\"tab-4\">일반게시판 관리</li>\r\n");
      out.write("				<li class=\"tab-link\" data-tab=\"tab-5\">거래게시판 관리</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("\r\n");
      out.write("			<hr style=\"opacity: 0.5; margin: 0px;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<div id=\"tab-1\" class=\"tab-content\">\r\n");
      out.write("				<table id=\"outer\" align=\"center\" border=\"1\" cellspacing=\"0\"\r\n");
      out.write("					cellpadding=\"3\">\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>등록번호</th>\r\n");
      out.write("						<th>시설종류</th>\r\n");
      out.write("						<th>시설명</th>\r\n");
      out.write("						<th>주소</th>\r\n");
      out.write("						<th>삽입</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");
 for(Department dept : list) { 
      out.write("\r\n");
      out.write("					<tr>\r\n");
      out.write("					<td>");
      out.print( dept.getDeptSeq() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( dept.getDeptType() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( dept.getDeptName() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( dept.getDeptAddress() );
      out.write("</td>\r\n");
      out.write("					<td><input type =\"button\" value=\"등록\" onclick=\"location.href='/petmily/deptins?deptSeq=");
      out.print( dept.getDeptSeq() );
      out.write("';\" return false;></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");
 } 
      out.write("\r\n");
      out.write("				</table>\r\n");
      out.write("				\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<div id=\"tab-2\" class=\"tab-content current\">\r\n");
      out.write("				<table id=\"outer\" align=\"center\" border=\"1\" cellspacing=\"0\"\r\n");
      out.write("					cellpadding=\"3\">\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>등록번호</th>\r\n");
      out.write("						<th>시설종류</th>\r\n");
      out.write("						<th>시설명</th>\r\n");
      out.write("						<th>주소</th>\r\n");
      out.write("						<th>삭제</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");
 for(Department dept : list) { 
      out.write("\r\n");
      out.write("					<tr>\r\n");
      out.write("					<td>");
      out.print( dept.getDeptSeq() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( dept.getDeptType() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( dept.getDeptName() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( dept.getDeptAddress() );
      out.write("</td>\r\n");
      out.write("					<td><input type =\"button\" value=\"삭제\" onclick=\"location.href='/petmily/deptter?deptSeq=");
      out.print( dept.getDeptSeq() );
      out.write("';\" return false;></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");
 } 
      out.write("\r\n");
      out.write("				</table>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			</table>\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	</div>\r\n");
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
