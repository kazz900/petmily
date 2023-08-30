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
font-size: 17px;
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
form {
	text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */
	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */
	width: 350px; /* 폼의 너비 설정 */
	height: auto;
	border: 1px solid black;
}
	.find-all{
	display: flex;
  justify-content: center;
  align-items: center;
  hieght: 100%;
	}
	.find{
	display:inline-block;
	}
</style>
</head>
<body>
<header>
<h1 align="left">Petmily</h1> 
</header>
<h1 align="center">ID/PASSWORD 조회</h1>
<div class="find-all">
<div class="find">
<form action="/petmily/idfind">
<ul>
<li>아이디 찾기</li>
<li><input type="text" placeholder="회원가입시 입력한 Email 입력" required></li>
<li><input type="button" value="아이디 조회"></li>
</ul>
</form>
</div>
<div class="find">
<form action="/petmily/pwdfind">
<ul>
<li>비밀번호 찾기</li>
<li><input type="text" placeholder="회원가입시 입력한 Email 입력" required></li>
<li><input type="submit" value="비밀번호 찾기"></li>
</ul>
</form>
</div>
</div>
</body>
</html>