<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
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
font-size: 25px;
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

td input:not(#checkpassword) {
	width: 250px;
	height: 30px;
	border-radius: 7px;
    background-color: beige;
	/* display: flex;
justify-content: space-between; */
}

td input#dupcheck {
      font-family: 'Surround', sans-serif;
	width: 80px;
	height: 34px;
	border-radius: 7px;
	color: hsl(30.5, 77.6%, 29.8%);
    background-color: hsl(36deg 70.37% 68.61%);
}

td input#dupcheck2 {
      font-family: 'Surround', sans-serif;
	width: 80px;
	height: 34px;
	border-radius: 7px;
	color: hsl(30.5, 77.6%, 29.8%);
    background-color: hsl(36deg 70.37% 68.61%);
}

hr {
	width: 100%;
}

input[type=submit] {
      font-family: 'Surround', sans-serif;
	width: 340px;
	height: 34px;
	border-radius: 7px;
	margin-right: 3px;
	color: hsl(30.5, 77.6%, 29.8%);
    background-color: hsl(36deg 70.37% 68.61%);
}
/*      ::placeholder {
      color: red; /* 힌트 텍스트의 색상을 빨간색으로 설정 */
font-style
:
 
italic
; /* 힌트 텍스트의 글꼴을 기울임체로 설정 */
}*/
 input[type=password] {
	width: 400px;
	height: 30px;
	border-radius: 7px;
    background-color: hsl(36deg 70.37% 68.61%);
	/* display: flex;
justify-content: space-between; */
}

#checkenroll {
	font-size: 10pt;
	width: auto;
	height: auto;
	border: none;
	margin: 0px;
	padding: 0px;
	white-space: pre-line;
}
</style>
<script type="text/javascript">
window.onload = function(){
	var mid = document.getElementById('mid');
	var mpwd = document.getElementById('mpwd');
	var mpwd2 = document.getElementById('mpwd2');
	var notice = document.getElementById('checkpassword');
	var mnick = document.getElementById('mnick');
	var memail = document.getElementById('memail');
	
	console.log(notice);
	
}
</script>
</head>
<body>
<h1 align="center">Petmily</h1> <!-- 추후 include처리 -->
<h2 align="center">회원가입</h2> <!-- 추후 include처리 -->
<form action="/petmily/enroll">
<table>
<tr><td><input type="text" id="mid" name="mid" placeholder="사용할 아이디 입력" required> 
</td><td><input type="button" value="중복확인" id="dupcheck" onclick="#"></td></tr>
<tr><td><input type="password" id="mpwd" name="mpwd" placeholder="사용할 패스워드 입력"required></td></tr>
<tr><td><input type="password" id="mpwd2" placeholder="패스워드 확인"required></td></tr>
<tr><td><div id="checkpassword">패스워드는 영어 대소문자와 @, !, #, $중 하나의 기호를 포함하여 6~12자로 작성해주세요.</div></td></tr>
<tr><td><input type="text" id="mnick" name="mnick" placeholder="사용할 닉네임 입력" required><!--  &nbsp;  &nbsp;  -->
<tr><td><input type="email" id="memail" name="memail" placeholder="Email" required><!--  &nbsp;  &nbsp;  -->
</td><td><input type="button" value="중복확인" id="dupcheck2" onclick="#"></td></tr>
</table>
<input type="submit" value="가입하기"> &nbsp;
</form>
<br>
<%@ include file="../common/footer.jsp" %>
</body>
</html>