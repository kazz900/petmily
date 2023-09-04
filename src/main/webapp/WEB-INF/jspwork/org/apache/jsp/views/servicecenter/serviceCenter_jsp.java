/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-09-04 06:11:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.servicecenter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import servicecenter.model.vo.Board;
import member.model.vo.Member;
import java.util.ArrayList;
import member.model.vo.Member;

public final class serviceCenter_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/servicecenter/../common/main.jsp", Long.valueOf(1693807730000L));
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
    _jspx_imports_classes.add("servicecenter.model.vo.Board");
    _jspx_imports_classes.add("java.util.ArrayList");
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

	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	Board board = (Board)request.getAttribute("board");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Petmily</title>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"/petmily/resources/css/servicecenter/serviceCenter.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("	src=\"/petmily/resources/js/common/jquery-3.7.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("	src=\"/petmily/resources/js/info/infotap.js\"></script>\r\n");
      out.write("	\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
if (request.getAttribute("message") != null) { 
      out.write("\r\n");
      out.write("	alert(\"건의사항이 수정되었습니다.\");\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write('\r');
      out.write('\n');
 Member member = (Member)session.getAttribute("member"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Petmily</title>\r\n");
      out.write("<style type=\"text/css\"> \r\n");
      out.write(".dropdown {\r\n");
      out.write("  display: none;\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  top: 100%;\r\n");
      out.write("  left: 0;\r\n");
      out.write("  background-color: #fff;\r\n");
      out.write("  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);\r\n");
      out.write("  list-style: none;\r\n");
      out.write("  padding: 0;\r\n");
      out.write("  z-index: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown > li {\r\n");
      out.write("  padding: 10px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/petmily/resources/js/main/main.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("function toggleDropdown() {\r\n");
      out.write("	  var dropdown = document.getElementById(\"dropdown\");\r\n");
      out.write("	  dropdown.style.display = dropdown.style.display === \"block\" ? \"none\" : \"block\";\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
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
      out.write("               <form action=\"/petmily/selectdepartment\" method=\"get\" class='formSearch' style=\"margin-right: 80px;\">\r\n");
      out.write("                  <div class='field'>\r\n");
      out.write("                     <input class='inputSearch' id='inputSearch' name='inputSearch'\r\n");
      out.write("                        required type='text'><label for='inputSearch'>\r\n");
      out.write("                        지역, 이름으로 검색 </label>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </form>\r\n");
      out.write("				</li>\r\n");
      out.write("        \r\n");
      out.write("				<li class=\"sub-link\" onclick=\"toggleDropdown()\"><a href=\"#\">내주변</a>\r\n");
      out.write("				<ul class=\"dropdown\" id=\"dropdown\">\r\n");
      out.write("				<li><a href=\"/petmily/selectdepttype?selecttype=1&typename=의료\" style=\"color : hsl(30.46deg 58.9% 45.68%)\">의료</a></li>\r\n");
      out.write("				<li><a href=\"/petmily/selectdepttype?selecttype=2&typename=미용\" style=\"color : hsl(30.46deg 58.9% 45.68%)\">미용</a></li>\r\n");
      out.write("				<li><a href=\"/petmily/selectdepttype?selecttype=3&typename=용품\" style=\"color : hsl(30.46deg 58.9% 45.68%)\">용품</a></li>\r\n");
      out.write("				<li><a href=\"/petmily/selectdepttype?selecttype=4&typename=위탁\" style=\"color : hsl(30.46deg 58.9% 45.68%)\">위탁</a></li>\r\n");
      out.write("				<li><a href=\"/petmily/selectdepttype?selecttype=6&typename=카페/식당\" style=\"color : hsl(30.46deg 58.9% 45.68%)\">카페/식당</a></li>\r\n");
      out.write("				<li><a href=\"/petmily/selectdepttype?selecttype=7&typename=호텔\" style=\"color : hsl(30.46deg 58.9% 45.68%)\">호텔</a></li>\r\n");
      out.write("				<li><a href=\"/petmily/selectdepttype?selecttype=8&typename=문화\" style=\"color : hsl(30.46deg 58.9% 45.68%)\">문화</a></li>\r\n");
      out.write("				<li><a href=\"/petmily/selectdepttype?selecttype=5&typename=장묘\" style=\"color : hsl(30.46deg 58.9% 45.68%)\">장묘</a></li>			\r\n");
      out.write("				</ul>\r\n");
      out.write("				</li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("				");
if(member != null){ 
      out.write("\r\n");
      out.write("				<li><a class=\"sub-link\" href=\"/petmily/plist?memberseq=");
      out.print( member.getMemberSeq() );
      out.write("\" method=\"post\">커뮤니티</a></li>\r\n");
      out.write("				");
 } 
      out.write("\r\n");
      out.write("				\r\n");
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
 if(member == null) { 
      out.write("\r\n");
      out.write("					<li class=\"sidebarmenutitle\">더보기</li>\r\n");
      out.write("					\r\n");
      out.write("					<li><a href=\"/petmily/suggest\" class=\"sidebarmenu\">고객센터</a></li>\r\n");
      out.write("					");
 }else if(member.getMemberGrade().equals("1")){ 
      out.write("\r\n");
      out.write("					<li class=\"sidebarmenutitle\">더보기</li>\r\n");
      out.write("\r\n");
      out.write("					<li><a href=\"/petmily/mypet?memberSeq=");
      out.print(member.getMemberSeq());
      out.write("\" class=\"sidebarmenu\">마이페이지</a></li>\r\n");
      out.write("					<li><a href=\"/petmily/suggest?mseq=");
      out.print(member.getMemberSeq());
      out.write("\" class=\"sidebarmenu\">고객센터</a></li>\r\n");
      out.write("					");
      out.write("\r\n");
      out.write("					");
 }else if(member.getMemberGrade().equals("0")){ 
      out.write("\r\n");
      out.write("					<li class=\"sidebarmenutitle\">더보기</li>\r\n");
      out.write("					<li><a href=\"#\" class=\"sidebarmenu\">마이페이지</a></li>\r\n");
      out.write("					<li><a href=\"/petmily/adminmain\" class=\"sidebarmenu\">업체등록</a></li>\r\n");
      out.write("					<li><a href=\"/petmily/srtd\" class=\"sidebarmenu\">업체삭제</a></li>\r\n");
      out.write("					<li><a href=\"/petmily/memli\" class=\"sidebarmenu\">회원등급변경</a></li>\r\n");
      out.write("					<li><a href=\"#\" class=\"sidebarmenu\">일반게시판관리</a></li>\r\n");
      out.write("					<li><a href=\"#\" class=\"sidebarmenu\">거래게시판관리</a></li>\r\n");
      out.write("					<li><a href=\"/petmily/suggestAdmin?mseq=");
      out.print(member.getMemberSeq());
      out.write(", mGrade=");
      out.print(member.getMemberGrade());
      out.write("\" class=\"sidebarmenu\">관리자 고객센터</a></li>\r\n");
      out.write("					");
 }else if(member.getMemberGrade().equals("2")){ 
      out.write("\r\n");
      out.write("					\r\n");
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
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"info-content\">\r\n");
      out.write("		<div class=\"info-detail02\">\r\n");
      out.write("\r\n");
      out.write("			<ul class=\"tabs\">\r\n");
      out.write("				<li class=\"tab-link current\" data-tab=\"tab-1\">나의 문의내역</li>\r\n");
      out.write("				<li class=\"tab-link\" data-tab=\"tab-2\">건의사항 작성</li>\r\n");
      out.write("				<li class=\"tab-link\" data-tab=\"tab-3\">업체 등록요청</li>\r\n");
      out.write("				<li class=\"tab-link\" data-tab=\"tab-4\">업체 삭제요청</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("\r\n");
      out.write("			<hr style=\"opacity: 0.5; margin: 0px;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<div id=\"tab-1\" class=\"tab-content current\">\r\n");
      out.write("				");
 if (list != null) { 
      out.write("\r\n");
      out.write("				<table id=\"outer\" align=\"center\" cellspacing=\"5\" cellpadding=\"0\">\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th style=\"width: 80px;\">번호</th>\r\n");
      out.write("						<th style=\"width: 200px;\">제목</th>\r\n");
      out.write("						<th style=\"width: 310px;\">글 내용</th>\r\n");
      out.write("						<th>현황</th>\r\n");
      out.write("						<th style=\"width: 110px;\">작성일자</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("\r\n");
      out.write("					\r\n");
      out.write("					");
 for (Board b : list) { 
      out.write("\r\n");
      out.write("					<tr style=\"border-top: 1px solid black; border-bottom: 1px solid black;\">\r\n");
      out.write("						<td style=\"font-size: 14px;\">");
      out.print(b.getBrdNo());
      out.write("</td>\r\n");
      out.write("						<td style=\"padding-right: 15px; font-size: 14px;\">");
      out.print(b.getBrdTitle());
      out.write("</td>\r\n");
      out.write("						\r\n");
      out.write("						<td style=\"padding-left: 15px; font-size: 14px;\">\r\n");
      out.write("						");
 if (b.getBrdReply() != null) { 
      out.write("\r\n");
      out.write("						&nbsp; &nbsp; (답변완료)\r\n");
      out.write("						");
 } 
      out.write("\r\n");
      out.write("						<a href=\"/petmily/bdetail?bnum=");
      out.print(b.getBrdNo());
      out.write("\">\r\n");
      out.write("						");
      out.print(b.getBrdContent());
      out.write("</a></td>\r\n");
      out.write("						\r\n");
      out.write("						<td style=\"font-size:12px;\">\r\n");
      out.write("						");
 if (b.getBrdResult().equals("N")) { 
      out.write("\r\n");
      out.write("						접수\r\n");
      out.write("						");
 } else if (b.getBrdResult().equals("Y")) { 
      out.write("\r\n");
      out.write("						답변완료\r\n");
      out.write("						");
 } 
      out.write("\r\n");
      out.write("						</td>\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("						<td style=\"font-size: 10px;\">");
      out.print(b.getBrdDate());
      out.write("</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("				</table>\r\n");
      out.write("					");
 } else { 
      out.write("\r\n");
      out.write("					    <h1>아직 문의사항이 없습니다.</h1>\r\n");
      out.write("					");
 } 
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<div id=\"tab-2\" class=\"tab-content\">\r\n");
      out.write("				<form action=\"/petmily/addsuggest\" method=\"get\">\r\n");
      out.write("					<input type=\"hidden\" name=\"result\" value=\"N\">\r\n");
      out.write("					<input type=\"hidden\" name=\"mNo\" value=\"");
      out.print(member.getMemberSeq());
      out.write("\">\r\n");
      out.write("					\r\n");
      out.write("					<table width=\"500\" align=\"center\" cellspacing=\"5\">\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">글 제목</th>\r\n");
      out.write("							<td><input type=\"text\" name=\"title\" size=\"31\" maxlength=\"50\"\r\n");
      out.write("								placeholder=\"제목을 입력해주세요.\" required></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">내용</th>\r\n");
      out.write("							<td><textarea name=\"content\" rows=\"5\" cols=\"30\" style=\"height:351px;\"></textarea></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<th colspan=\"2\"><input type=\"submit\" value=\"확인\"\r\n");
      out.write("							id=\"submitBtn\"></th>\r\n");
      out.write("\r\n");
      out.write("					</table>\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div id=\"tab-3\" class=\"tab-content\">\r\n");
      out.write("				<form action=\"/petmily/adddept\" method=\"get\" id=\"form\">\r\n");
      out.write("					<input type=\"hidden\" name=\"loginOk\" value=\"N\">\r\n");
      out.write("					<input type=\"hidden\" name=\"deleteOk\" value=\"N\">\r\n");
      out.write("					<table width=\"500\" align=\"center\" cellspacing=\"5\">\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">시설명</th>\r\n");
      out.write("							<td><input type=\"text\" name=\"name\" size=\"31\" maxlength=\"50\"\r\n");
      out.write("								placeholder=\"시설명을 입력해주세요.\" required></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">시설분류</th>\r\n");
      out.write("							<td><select name=\"type\" style=\"width: 288px; height: 36px;\">\r\n");
      out.write("									<option selected>시설의 분류를 선택해주세요.</option>\r\n");
      out.write("									<option value=\"1\">동물병원</option>\r\n");
      out.write("									<option value=\"2\">미용시설</option>\r\n");
      out.write("									<option value=\"1/2\">의료/미용</option>\r\n");
      out.write("									<option value=\"3\">반려동물용품점</option>\r\n");
      out.write("									<option value=\"4\">위탁관리시설</option>\r\n");
      out.write("									<option value=\"5\">장묘시설</option>\r\n");
      out.write("									<option value=\"6\">식당/카페</option>\r\n");
      out.write("									<option value=\"7\">호텔/펜션</option>\r\n");
      out.write("									<option value=\"8\">문화시설</option>\r\n");
      out.write("							</select></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">주소</th>\r\n");
      out.write("							<td><input type=\"text\" name=\"address\" size=\"31\"\r\n");
      out.write("								maxlength=\"25\" placeholder=\"주소를 입력해주세요.\" required></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">전화번호</th>\r\n");
      out.write("							<td><input type=\"tel\" name=\"phone\" size=\"31\" maxlength=\"50\"\r\n");
      out.write("								placeholder=\"전화번호를 입력해주세요.\"></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">운영시간</th>\r\n");
      out.write("							<td><input type=\"time\" name=\"open\" value=\"time\" size=\"31\"\r\n");
      out.write("								maxlength=\"50\" style=\"width: 128px;\"> ~ <input\r\n");
      out.write("								type=\"time\" name=\"close\" value=\"time\" size=\"31\" maxlength=\"50\"\r\n");
      out.write("								style=\"width: 129px;\"></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr class=\"yes\">\r\n");
      out.write("							<th width=\"150\">동물크기제한</th>\r\n");
      out.write("							<td>\r\n");
      out.write("								<table>\r\n");
      out.write("									<tr>\r\n");
      out.write("										<td><input type=\"radio\" name=\"animalSize\" value=\"1\">소형</td>\r\n");
      out.write("										<td><input type=\"radio\" name=\"animalSize\" value=\"2\">중형</td>\r\n");
      out.write("										<td><input type=\"radio\" name=\"animalSize\" value=\"3\">대형</td>\r\n");
      out.write("										<td><input type=\"radio\" name=\"animalSize\" value=\"0\"\r\n");
      out.write("											checked>제한없음</td>\r\n");
      out.write("									</tr>\r\n");
      out.write("								</table>\r\n");
      out.write("							</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr class=\"yes\">\r\n");
      out.write("							<th width=\"150\">주차여부</th>\r\n");
      out.write("							<td><input type=\"radio\" name=\"parking\" value=\"1\"\r\n");
      out.write("								style=\"margin-left: 78px;\"> 가능 <input type=\"radio\"\r\n");
      out.write("								name=\"parking\" value=\"0\"> 불가능</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr class=\"yes\">\r\n");
      out.write("							<th width=\"150\">입장료여부</th>\r\n");
      out.write("							<td><input type=\"radio\" name=\"entFee\" value=\"1\"\r\n");
      out.write("								style=\"margin-left: 78px;\"> 있음 <input type=\"radio\"\r\n");
      out.write("								name=\"entFee\" value=\"0\"> 없음</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">애견동반추가요금</th>\r\n");
      out.write("							<td><input type=\"radio\" name=\"petFee\" value=\"1\"\r\n");
      out.write("								style=\"margin-left: 78px;\"> 있음 <input type=\"radio\"\r\n");
      out.write("								name=\"petFee\" value=\"0\"> 없음</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">추가제한사항</th>\r\n");
      out.write("							<td><textarea rows=\"3\" cols=\"30\" name=\"restrict\"></textarea></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<th colspan=\"2\"><input type=\"submit\" value=\"등록요청하기\"\r\n");
      out.write("							id=\"submitBtn\" class=\"w-btn-neon2\"></th>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("					</table>\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<div id=\"tab-4\" class=\"tab-content\">\r\n");
      out.write("				<form action=\"/petmily/deldept\" method=\"get\">\r\n");
      out.write("				<input type=\"hidden\" name=\"deleteOk\" value=\"Y\">\r\n");
      out.write("					<table width=\"500\" align=\"center\" cellspacing=\"5\">\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">시설명</th>\r\n");
      out.write("							<td><input type=\"text\" name=\"name\" size=\"31\" maxlength=\"15\"\r\n");
      out.write("								placeholder=\"시설명을 입력해주세요.\" required></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th width=\"150\">주소</th>\r\n");
      out.write("							<td><input type=\"text\" name=\"address\" size=\"31\"\r\n");
      out.write("								maxlength=\"25\" placeholder=\"주소를 입력해주세요.\" required></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("\r\n");
      out.write("						<th colspan=\"2\"><input type=\"submit\" value=\"삭제요청하기\"\r\n");
      out.write("							id=\"submitBtn\"></th>\r\n");
      out.write("\r\n");
      out.write("					</table>\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
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
