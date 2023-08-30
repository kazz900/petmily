<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<style type="text/css">
@font-face {
	font-family: 'Surround';
	src: url('/petmily/resources/font/surround.woff2') format('woff2');
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

body h1 a {
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
	text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */
	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */
	width: 350px; /* 폼의 너비 설정 */
	height: auto;
	background-color: #FFE4B5;
	border-radius: 25px;
	display: flex;
	justify-content: center;
	align-items: center;
	border: solid;
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
	height: 33px;
	width: 222px;
	margin-top: 28px;
	border-radius: 13px;
	font-family: 'Surround', sans-serif;
	font-size: 16px;
}

input[type="text"]:focus {
	outline: 3px solid #DAA520;
}
</style>
</head>
<body>
	<header>
		<h1 align="left">
			<a href="/petmily/index.jsp">Petmily</a>
		</h1>
	</header>
	<h2 align="center">
		ID/PASSWORD 조회
		</h1>
		<div class="find-all">
			<div class="find">
				<form action="/petmily/idfind">
					<ul style="padding: 0px;">
						<li style="margin-top: 17px; color: black;">아이디 찾기</li>

						<li><input type="text" placeholder="회원가입시 입력한 Email 입력"
							required
							style="height: 33px; width: 222px; margin-top: 28px; border-radius: 13px; font-family: 'Surround', sans-serif; font-size: 16px; border: solid 3px black;"></li>
						<li><input type="submit" value="아이디 조회"
							style="margin-top: 7px; height: 39px; border: none; background-color: #DEB887; font-family: 'Surround', sans-serif; font-size: 16px;"></li>

					</ul>
				</form>
			</div>
			<div style="margin: 50px;"></div>
			<div class="find">
				<form action="/petmily/pwdfind">
					<ul style="padding: 0px;">
						<li style="margin-top: 17px; color: black;">비밀번호 찾기</li>
						<li><input type="text" placeholder="아이디 입력" required
							style="height: 33px; width: 222px; margin-top: 15px; border-radius: 13px; font-family: 'Surround', sans-serif; font-size: 16px; border: solid 3px;"></li>
						<li><input type="text" placeholder="회원가입시 입력한 Email 입력"
							required
							style="height: 33px; width: 222px; margin-top: 5px; border-radius: 13px; font-family: 'Surround', sans-serif; font-size: 16px; border: solid 3px;"></li>
						<li><input type="submit" value="비밀번호 찾기"
							style="margin-top: 7px; height: 39px; border: none; background-color: #DEB887; font-family: 'Surround', sans-serif; font-size: 16px; width: 230px; border-radius: 13px;"></li>
					</ul>
				</form>
			</div>
		</div>
</body>
</html>