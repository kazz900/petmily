/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-29 12:17:21 UTC

 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import department.model.vo.Department;
import member.model.vo.Member;

public final class info_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/info/../common/main.jsp", Long.valueOf(1693311377311L));
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

      out.write('\r');
      out.write('\n');
 Department dptmt = (Department)request.getAttribute("dptmt"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/petmily/resources/css/info/info.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/petmily/resources/js/common/jquery-3.7.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/petmily/resources/js/info/infotap.js\"></script>\r\n");
      out.write("<script src=\"https://developers.kakao.com/sdk/js/kakao.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=4ace05793ac4808782136fb0eaaad83b&libraries=services,clusterer\"></script>\r\n");
      out.write("</head>\r\n");

      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.\r\n");
      out.write("Kakao.init('4ace05793ac4808782136fb0eaaad83b');\r\n");
      out.write("\r\n");
      out.write("// SDK 초기화 여부를 판단합니다.\r\n");
      out.write("console.log(Kakao.isInitialized());\r\n");
      out.write("var link =  document.location.href;\r\n");
      out.write("function kakaoShare() {\r\n");
      out.write("  Kakao.Link.sendDefault({\r\n");
      out.write("    objectType: 'feed',\r\n");
      out.write("    content: {\r\n");
      out.write("      title: 'Petmily',\r\n");
      out.write("      description: '반려동물의 모든 것\\n ");
      out.print( dptmt.getDeptName() );
      out.write("',\r\n");
      out.write("      imageUrl: 'https://ifh.cc/g/NFnlJt.jpg',\r\n");
      out.write("      link: {\r\n");
      out.write("        mobileWebUrl: link,\r\n");
      out.write("        webUrl: link,\r\n");
      out.write("      },\r\n");
      out.write("    },\r\n");
      out.write("    buttons: [\r\n");
      out.write("      {\r\n");
      out.write("        title: '웹으로 보기',\r\n");
      out.write("        link: {\r\n");
      out.write("          mobileWebUrl: link,\r\n");
      out.write("          webUrl: link,\r\n");
      out.write("        },\r\n");
      out.write("      },\r\n");
      out.write("    ],\r\n");
      out.write("    // 카카오톡 미설치 시 카카오톡 설치 경로이동\r\n");
      out.write("    installTalk: true,\r\n");
      out.write("  })\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
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
      out.write("				<li><a class=\"sub-link\" href=\"/petmily/splist\" method=\"get\">커뮤니티</a></li>\r\n");
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
      out.write("<div id=\"info-content\" class=\"info-content\">\r\n");
      out.write("<div>\r\n");
      out.write("<!-- <img class=\"info-img\" src=\"/petmily/resources/images/mainbanner/882.jpg\"> -->\r\n");
      out.write("<img class=\"info-img\" src=\"https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;type=f184_184&amp;src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200216_260%2F15818269954319jfwa_JPEG%2F_9Yd8jwNtxtLyFcMAdHFV3Ur.jpeg.jpg\" alt=\"1004약국\">\r\n");
      out.write("<ul class=\"info-detail01\">\r\n");
      out.write("	<li class=\"info-detail-title\">");
      out.print( dptmt.getDeptName() );
      out.write("</li><br>\r\n");
      out.write("	<li class=\"info-detail-subtitle\">");
      out.print(dptmt.getDeptType());
      out.write("</li><br>\r\n");
      out.write("	<li class=\"infomenu-title\">주소</li>\r\n");
      out.write("	<li class=\"infomenu-sub\">");
      out.print( dptmt.getDeptAddress() );
      out.write("</li><br>\r\n");
      out.write("	<li class=\"infomenu-title\">전화번호</li>\r\n");
      out.write("	<li class=\"infomenu-sub\">");
      out.print( dptmt.getDeptPhone() );
      out.write("</li><br>\r\n");
      out.write("	<li class=\"infomenu-title\">홈페이지</li>\r\n");
      out.write("	<li class=\"infomenu-sub\">");
      out.print( dptmt.getDeptUrl() );
      out.write("</li><br><br>\r\n");
      out.write("	<li><a href=\"javascript:kakaoShare()\"><img  class=\"info-share\" src=\"/petmily/resources/images/share.png\" style=\"width: 35px;\"></a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"info-detail02\">\r\n");
      out.write("\r\n");
      out.write(" <ul class=\"tabs\">\r\n");

      out.write("            <li class=\"tab-link current\" data-tab=\"tab-1\">위 치</li>\r\n");
      out.write("            <li class=\"tab-link\" data-tab=\"tab-2\">상세내역</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("<hr style=\"opacity:0.5; margin-top:0px;\">\r\n");
      out.write("        <div id=\"tab-2\" class=\"tab-content\"><ul>\r\n");

      out.write("        	<li>＊영업 시간</li>\r\n");
      out.write("        	<li>&nbsp;&nbsp;&nbsp;");
      out.print( dptmt.getDeptTime() );
      out.write("</li><br>\r\n");
      out.write("        	<li>＊");
      out.print( dptmt.getDeptParking() );
      out.write("</li><br>\r\n");
      out.write("        	<li>＊입장 가능한 반려 동물 사이즈</li>\r\n");
      out.write("        	<li>&nbsp;&nbsp;&nbsp; ");
      out.print( dptmt.getDeptSizerestrict() );
      out.write("</li><br>\r\n");
      out.write("        	<li>＊제한 사항</li>\r\n");
      out.write("        	<li>&nbsp;&nbsp;&nbsp; ");
      out.print( dptmt.getDeptRestrict());
      out.write("</li><br>\r\n");
      out.write("        </ul></div>\r\n");

      out.write("        <div id=\"tab-1\" class=\"tab-content current\"><ul>\r\n");
      out.write("        		<li><div id=\"map2\" style=\"width:100%;height:350px;\"></div></li>\r\n");

      out.write("        	</ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");

      out.write("<script>\r\n");
      out.write("var lat = '");
      out.print( dptmt.getDeptLatitude() );
      out.write("';\r\n");
      out.write("var lon = '");
      out.print( dptmt.getDeptLongitude() );
      out.write("';\r\n");
      out.write("console.log(typeof(lat));\r\n");
      out.write("console.log(typeof(lon));//string\r\n");
      out.write("var json = JSON.parse(lat);\r\n");
      out.write("var json = JSON.parse(lon);\r\n");
      out.write("var mapContainer2 = document.getElementById('map2'), // 지도를 표시할 div \r\n");
      out.write("mapOption2 = {\r\n");
      out.write("    center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표\r\n");
      out.write("    level: 3 // 지도의 확대 레벨\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var map2 = new kakao.maps.Map(mapContainer2, mapOption2); // 지도를 생성합니다\r\n");
      out.write("\r\n");
      out.write("// 마커가 표시될 위치입니다 \r\n");
      out.write("var markerPosition = new kakao.maps.LatLng(lat, lon);\r\n");
      out.write("\r\n");
      out.write("// 마커를 생성합니다\r\n");
      out.write("var marker = new kakao.maps.Marker({\r\n");
      out.write("position: markerPosition\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("// 마커가 지도 위에 표시되도록 설정합니다\r\n");
      out.write("marker.setMap(map2);\r\n");
      out.write("</script>\r\n");

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
