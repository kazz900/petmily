<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
Member member = (Member) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<style type="text/css">
.dropdown {
	display: none;
	position: absolute;
	top: 100%;
	left: 0;
	background-color: #fff;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	list-style: none;
	padding: 0;
	z-index: 1;
}

.dropdown>li {
	padding: 10px;
}

hr#dropdowonhr {
	border-color: rgba(0, 0, 0, 0.1);
	width: 75%; 
	margin-top:0;
	margin-bottom:0;
}

a#drowpdowna {
	color: hsl(30.46deg 58.9% 45.68%);
}


</style>
<script type="text/javascript" src="/petmily/resources/js/main/main.js"></script>
<script>
	function toggleDropdown() {
		var dropdown = document.getElementById("dropdown");
		dropdown.style.display = dropdown.style.display === "block" ? "none"
				: "block";
	}
</script>
<link rel="stylesheet" href="/petmily/resources/css/main/main.css">
</head>
<body>
	<input type="checkbox" id="menuicon">

	<header style="left: 0px; z-index: 2;">
		<div>
			<ul class="navi">
				<!-- style="top: 50px; right: 77px;" -->
				<li class="logo"><a href="/petmily/index.jsp">Petmily</a></li>
				<li>
					<form action="/petmily/selectdepartment" method="get"
						class='formSearch' style="margin-right: 80px;">
						<div class='field'>
							<input class='inputSearch' id='inputSearch' name='inputSearch'
								required type='text'><label for='inputSearch'>
								지역, 이름으로 검색 </label>
						</div>
					</form>
				</li>


				<li class="sub-link" onclick="toggleDropdown()"
					style="margin-left: 150px;"><a href="#">내주변</a>
					<ul class="dropdown" id="dropdown">
						<li><a id="drowpdowna"
							href="/petmily/selectdepttype?selecttype=1&typename=의료">의료</a></li>
						<hr id="dropdowonhr">
						<li><a id="drowpdowna"
							href="/petmily/selectdepttype?selecttype=2&typename=미용">미용</a></li>
						<hr id="dropdowonhr">
						<li><a id="drowpdowna"
							href="/petmily/selectdepttype?selecttype=3&typename=용품">용품</a></li>
						<hr id="dropdowonhr">
						<li><a id="drowpdowna"
							href="/petmily/selectdepttype?selecttype=4&typename=위탁">위탁</a></li>
						<hr id="dropdowonhr">
						<li><a id="drowpdowna"
							href="/petmily/selectdepttype?selecttype=6&typename=카페/식당">카페/식당</a></li>
						<hr id="dropdowonhr">
						<li><a id="drowpdowna"
							href="/petmily/selectdepttype?selecttype=7&typename=호텔">호텔</a></li>
						<hr id="dropdowonhr">
						<li><a id="drowpdowna"
							href="/petmily/selectdepttype?selecttype=8&typename=문화">문화</a></li>
						<hr id="dropdowonhr">
						<li><a id="drowpdowna"
							href="/petmily/selectdepttype?selecttype=5&typename=장묘">장묘</a></li>
					</ul></li>

				<li style="width: 15px;"></li>
				<%
				if (member == null) {
				%>

				<li><a class="sub-link" href="/petmily/views/member/login.jsp">로그인</a></li>
				<%
				} else {
				%>
				<li
					style="display: inline-block; font-size: 15px; width: 90px; height: 20px; position: absolute; top: 25px;"><%=member.getMemberNick()%>님</li>
				<li
					style="display: inline-block; font-size: 15px; width: 90px; height: 20px;"><a
					href="/petmily/logout"
					style="padding-top: 0px; padding-left: 0px; padding-right: 0px; padding-bottom: 0px; position: relative; top: 12px;">logout</a></li>

			</ul>
			<label for="menuicon" class="menubtn"> <span></span> <span></span>
				<span></span>
			</label>
			<%
			}
			%>
		</div>
	</header>
	<div class="menu-container">
		<div class="sidebar">
			<span class="area_desc" style="margin-top: 25%">
				<ul>
					<%
					if (member == null) {
					%>
					<li class="sidebarmenutitle">더보기</li>
					<script>
						
					</script>

					<li><a href="/petmily/suggest" class="sidebarmenu">고객센터</a></li>
					<%
					} else if (member.getMemberGrade().equals("1")) {
					%>
					<li class="sidebarmenutitle">더보기</li>
					<li><a
						href="/petmily/mypet?memberSeq=<%=member.getMemberSeq()%>"
						class="sidebarmenu">마이페이지</a></li>
					<li><a
						href="/petmily/plist?memberseq=<%=member.getMemberSeq()%>"
						method="post" class="sidebarmenu">커뮤니티</a></li>
					<li><a href="/petmily/suggest?mseq=<%=member.getMemberSeq()%>&page=1"
						class="sidebarmenu">고객센터</a></li>
					<%-- mseq를 들고가야됩니다. --%>
					<%
					} else if (member.getMemberGrade().equals("0")) {
					%>
					<li class="sidebarmenutitle">더보기</li>

					<li><a
						href="/petmily/mypet?memberSeq=<%=member.getMemberSeq()%>"
						class="sidebarmenu">마이페이지</a></li>

					<li><a
						href="/petmily/plist?memberseq=<%=member.getMemberSeq()%>"
						method="post" class="sidebarmenu">커뮤니티</a></li>
					<li><a href="/petmily/adminmain" class="sidebarmenu">업체등록</a></li>
					<li><a href="/petmily/srtd" class="sidebarmenu">업체삭제</a></li>
					<li><a href="/petmily/memli" class="sidebarmenu">회원등급변경</a></li>
					<li><a href="/petmily/adsp" class="sidebarmenu">일반게시판관리</a></li>
					<li><a href="/petmily/adtp" class="sidebarmenu">거래게시판관리</a></li>
					<li><a
						href="/petmily/suggestAdmin?mseq=<%=member.getMemberSeq()%>"
						class="sidebarmenu">고객센터</a></li>
					<%
					} else if (member.getMemberGrade().equals("2")) {
					%>

					<%
					}
					%>
				
			</span><br>

		</div>
	</div>
	</header>

</body>
</html>
