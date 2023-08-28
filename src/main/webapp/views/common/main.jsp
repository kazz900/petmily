<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/petmily/resources/js/main/main.js"></script>
<link rel="stylesheet" href="/petmily/resources/css/main/main.css">
</head>
<body>
	<input type="checkbox" id="menuicon">
	
	<header>
		<div>
			<ul class="navi">
				<!-- style="top: 50px; right: 77px;" -->
				<li class="logo"><a href="/petmily/index.jsp">Petmily</a></li>
				<li>
					<form class='formSearch' style="margin-right: 80px;">
						<div class='field'>
							<input class='inputSearch' id='inputSearch' name='inputSearch'
								required type='text'> <label for='inputSearch'>
								지역, 이름으로 검색 </label>
						</div>
					</form>
				</li>
				<li><a class="sub-link" href="/petmily/views/info.jsp">내주변</a></li>
				<li><a class="sub-link" href="#">로그인</a></li>
			</ul>
			<label for="menuicon" class="menubtn"> <span></span> <span></span>
				<span></span>
			</label>
		</div>
	</header>
	<div class="menu-container">
		<div class="sidebar">
			<span class="area_desc" style="margin-top:25%">
			<ul>
			<li class="sidebarmenutitle">더보기</li>
			<li><a href="#" class="sidebarmenu">커뮤니티</a></li>
			<li><a href="/petmily/suggest" class="sidebarmenu">고객센터</a></li>
			</ul>
			</span><br>
			
		</div>
	</div>
	</header>

</body>
</html>