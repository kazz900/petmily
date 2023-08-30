<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<% Member member = (Member)session.getAttribute("member"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<script type="text/javascript" src="/petmily/resources/js/main/main.js"></script>
<link rel="stylesheet" href="/petmily/resources/css/main/main.css">
</head>
<body>
	<input type="checkbox" id="menuicon">

	<header style="left: 0px;">
		<div>
			<ul class="navi">
				<!-- style="top: 50px; right: 77px;" -->
				<li class="logo"><a href="/petmily/index.jsp">Petmily</a></li>
				<li>
               <form action="/petmily/selectdepartment" method="get" class='formSearch' style="margin-right: 80px;">
                  <div class='field'>
                     <input class='inputSearch' id='inputSearch' name='inputSearch'
                        required type='text'><label for='inputSearch'>
                        지역, 이름으로 검색 </label>
                  </div>
               </form>
				</li>
				<li><a class="sub-link" href="/petmily/mis?deptSeq=578">내주변</a></li>
				<li><a class="sub-link" href="/petmily/splist" method="get">커뮤니티</a></li>
				<%if(member == null){ %>
				<li><a class="sub-link" href="/petmily/views/member/login.jsp">로그인</a></li>
				<% }else{ %>
				
				<li
					style="display: inline-block; font-size: 15px; width: 90px; height: 20px; position: absolute; top: 25px; margin-left: 20px;"><%= member.getMemberNick() %>님</li>
				<li
					style="display: inline-block; font-size: 15px; width: 90px; height: 20px;"><a
					href="/petmily/logout"
					style="padding-top: 0px; padding-left: 0px; padding-right: 0px; padding-bottom: 0px; margin-left: 45px; position: relative; top: 12px;">logout</a></li>
				<% } %>
			</ul>
			<label for="menuicon" class="menubtn"> <span></span> <span></span>
				<span></span>
			</label>
		</div>
	</header>
	<div class="menu-container">
		<div class="sidebar">
			<span class="area_desc" style="margin-top: 25%">
				<ul>
					<% if(member == null){ %>
					<li class="sidebarmenutitle">더보기</li>
					
					<li><a href="/petmily/suggest" class="sidebarmenu">고객센터</a></li>
					<% }else{ %>
					<li class="sidebarmenutitle">더보기</li>
					<li><a href="#" class="sidebarmenu">마이페이지</a></li>
					<li><a href="/petmily/suggest" class="sidebarmenu">고객센터</a></li>
					<% } %>
				</ul>
			</span><br>

		</div>
	</div>
	</header>

</body>
</html>