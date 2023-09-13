<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
  <% String message = (String) request.getAttribute("message"); %>
  <% if (message != null && message.equals("성공메세지보냄")) { %>
    <!-- 메세지 값이 "성공메세지보냄"인 경우 -->
    <% Member m = (Member) request.getAttribute("member"); %>
    	alert("가입하신 아이디는 [<%= m.getMemberId() %>] 입니다.");
  <% } else if (message != null) { %>
    <!-- 메세지 값이 "성공메세지보냄"이 아닌 경우 -->
    alert("<%= message %>");
  <% } %>
</script>
<style type="text/css">
@font-face { /*폰트추가*/
	font-family: 'Surround';
	src: url('/petmily/resources/font/surround.woff2') format('woff2');
	font-weight: normal;
	font-style: normal;
}
@font-face { /*폰트추가*/
	font-family: 'forgedm';
	src: url('/petmily/resources/font/forged-Medium.ttf') format('truetype');
	font-weight: normal;
	font-style: normal;
}
@font-face { /*폰트추가*/
	font-family: 'forgedl';
	src: url('/petmily/resources/font/forged-Light.ttf') format('truetype');
	font-weight: normal;
	font-style: normal;
}

body {
	font-family: 'Surround', sans-serif;
	padding: 20px 50px;
	font-size: 20px;
	font-weight: 900;
	color: hsl(30.5, 77.6%, 29.8%);
}

body h1 a {	/*좌상단 Petmily 문구*/
	font-family: 'Surround', sans-serif;
	padding: 20px 50px;
	font-size: 35px;
	font-weight: 900;
	border: none;
	color: hsl(30.46deg 58.9% 45.68%);
	text-decoration: none;
}

body h2 {
	font-family: 'Surround', sans-serif;
	padding: 20px 50px;
	color: hsl(30.5, 77.6%, 29.8%);
	font-size: 40px;
}

form {
	text-align: center;
	margin: 0 auto;
	width: 350px;
	height: auto;
	background-color: #FFE4B5;
	border-radius: 25px;
	display: flex;
	justify-content: center;
	align-items: center;
	border: 2px solid hsl(30.5, 77.6%, 29.8%);
}

.find-all {
	display: flex;
	justify-content: center;
	align-items: center;
	hieght: 100%;
	margin-top: 30px;
	padding-top: 100px;
}

.find {
	display: inline-block;
	display: flex;
	justify-content: center;
}

ul {
	list-style-type: none;
	width: 300px;
	height: 200px;
}

input[type="submit"] {
	font-family: 'Surround', sans-serif;
	font-size: 16px;
	height: 39px;
	width: 230px;
	margin-top: 28px;
	border-radius: 13px;
	border: none;
	background-color: #DEB887;
	color: hsl(30.5, 77.6%, 29.8%);
}

input[type="submit"]:hover {
	background-color: hsl(30.5, 77.6%, 29.8%);
	color: hsl(36deg 70.37% 68.61%);
}

input[type=text] {
	font-family: 'forgedl', sans-serif;
	font-size: 13px;
	width: 222px;
	height: 33px;
	border-radius: 13px;
	background-color: beige;
	border: 1px solid #FFE4B5;
	margin-top: 28px;
}

input[type="text"]:focus {
	outline: none;
}
</style>
</head>
<body>
	<header>
		<h1 align="left">
			<a href="/petmily/index.jsp">Petmily</a>
		</h1>
	</header>
	<h2 align="center">아이디/패스워드 찾기</h2>
	<div class="find-all">
		<div class="find">
			<form action="/petmily/idfind" method="post">
				<ul style="padding: 0px;">
					<li style="margin-top: 17px;">아이디 찾기</li>

					<li><input type="text" name="memail"
						placeholder="회원가입시 입력한 Email 입력" required></li>
					<li><input type="submit" value="아이디 조회"
						style="margin-top: 7px;"></li>

				</ul>
			</form>
		</div>
		<div style="margin: 50px;"></div>
		<div class="find">
			<form action="/petmily/pwdfind" method="post">
				<ul style="padding: 0px;">
					<li style="margin-top: 17px;">비밀번호 찾기</li>
					<li><input type="text" name="pmid" placeholder="아이디 입력"
						required style="margin-top: 15px;"></li>
					<li><input type="text" name="pmemail"
						placeholder="회원가입시 입력한 Email 입력" required style="margin-top: 5px;"></li>
					<li><input type="submit" value="비밀번호 찾기"
						style="margin-top: 7px;"></li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>