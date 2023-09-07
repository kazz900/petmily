<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import="member.model.vo.Member" %>
    
    <% Member member = (Member)request.getAttribute("member");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>petmily</title>
<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<style type="text/css">
@font-face {
	font-family: 'Surround';
	src: url('/petmily/resources/font/surround.woff2') format('woff2');
	font-weight: normal;
	font-style: normal;
}
@font-face{
	font-family: 'forgedm';
	src: url('/petmily/resources/font/forged-Medium.ttf') format('truetype');
	font-weight: normal;
	font-style: normal;
}
@font-face{
	font-family: 'forgedl';
	src: url('/petmily/resources/font/forged-Light.ttf') format('truetype');
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
	text-align: center;
	margin: 0 auto;
	width: 340px;
	height: auto;
	border: 3px solid hsl(30.5, 77.6%, 29.8%);
	border-radius: 25px; display : flex;
	justify-content: center;
	background-color: #FFE4B5;
	display: flex;
}

[type=text] {
	text-align: center;
}
input[type=text]:focus {
	outline: none;
}
[name=dpinfo] {
	font-family: 'forgedl', sans-serif;
	font-size: 16px;
}
td input {
	font-family: 'forgedm', sans-serif;
	font-size: 16px;
	color: hsl(30.5, 77.6%, 29.8%);
	width: 250px;
	height: 30px;
	border-radius: 13px;
	background-color: #FFE4B5;
	border:none;
}

#mpwd, #mpwd2 {
	border: 2px solid #FFE4B5;
	background-color: beige;
}
#mpwd, #mpwd2:focus {
	outline: none;
}

#checkenroll {
	font-family: 'forgedl', sans-serif;
	font-size: 10pt;
	width: 300px;
	height: auto;
	border: none;
	margin: 0px;
	padding: 0px;
	white-space: pre-line;
	overflow: auto;
}

#myinformation {
	width: 300px;
	font-family: 'Surround', sans-serif;
	font-size: 18pt;
	color: hsl(30.46deg 58.9% 45.68%);
	background-color: #FFE4B5;
	border: none;
}
#chpwd {
	border: 2px solid hsl(30.5, 77.6%, 29.8%);
	background-color: beige;
}
#chpwd:hover {
	background-color: hsl(30.5, 77.6%, 29.8%);
	color: hsl(36deg 70.37% 68.61%);
}

</style>
<script type="text/javascript">
window.onload = function() {
	var mpwd = document.getElementById('mpwd');
	var mpwd2 = document.getElementById('mpwd2');
	var cpwd = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$])[a-zA-Z\d@!#$]{6,12}[a-zA-Z\d@!#$]$/;
	var notice = document.getElementById('checkenroll');
	var submit = document.getElementById('chpwd');
	notice.hidden = true;
	submit.hidden = true;
	
	mpwd.addEventListener('keyup',function() {
		if (!cpwd.test(mpwd.value)) {
			submit.hidden = true;
			notice.hidden = false;
			notice.textContent = '패스워드는 영어 대,소문자와 숫자를 포함하고,!@#$기호중 하나를 포함시켜 6~12글자로 사용해주세요.';
			notice.style.color = '#ae1a1e';
		} else {
			notice.textContent = '사용가능한 패스워드입니다';
			notice.style.color = 'hsl(118.43deg 64.18% 38.3%)';
		}
	if (cpwd.test(mpwd.value) && mpwd.value === mpwd2.value){
		submit.hidden = false;
	}
	});

mpwd2.addEventListener('keyup', function() {
			notice.hidden = false;
			submit.hidden = true;
if (mpwd.value === mpwd2.value && cpwd.test(mpwd.value)) {
	notice.textContent = '사용가능한 패스워드입니다.'; 
	notice.style.color = 'hsl(118.43deg 64.18% 38.3%)';
} else if (mpwd.value === mpwd2.value){
	if(!cpwd.test(mpwd.value)){
			submit.hidden = true;
	notice.textContent = '패스워드를 올바르게 입력해주세요.';
			notice.style.color = '#ae1a1e';
	}
} else {
	notice.textContent = '패스워드와 같은 값을 입력해주세요.';
			notice.style.color = '#ae1a1e';
}
if (cpwd.test(mpwd2.value) && mpwd.value === mpwd2.value){
	submit.hidden = false;
}
});	
};
</script>
</head>
<body>
<header>
<h1 align="left"><a href="/petmily/index.jsp">Petmily</a></h1>
</header>
<h2 align="center">패스워드 변경</h2>
<form action="/petmily/pwdupdate" method="post">
	<table>
		<tr><td><div style="width:auto; height:15px; border:2px;"></div></td></tr>
		<tr><td><input type="text" id="myinformation" value="내 회원정보" readonly></td></tr>
		<tr><td name="dpinfo">아이디 : <input type="text" id="mid" name="mid" value="<%= member.getMemberId() %>" readonly></td></tr>
		<tr><td><input type="password" id="mpwd" name="mpwd" placeholder="새로운 패스워드 입력"required></td></tr>
		<tr><td><input type="password" id="mpwd2" name="mpwd2" placeholder="패스워드 확인"required></td></tr>
		<tr><td name="dpinfo">이메일 : <input type="text" id="memail" name="memail" value="<%= member.getMemberEmail() %>" readonly></td></tr>
		<tr><td name="dpinfo">닉네임 : <input type="text" id="mnick" name="mnick" value="<%= member.getMemberNick() %>" readonly></td></tr>
		<tr><td><div id="checkenroll">패스워드는 영어 대,소문자와 숫자를 포함하고,!@#$기호중 하나를 포함시켜 6~12글자로 사용해주세요.</div></td></tr>
		<tr><td><div style="width:auto; height:15px; border:2px;"></div></td></tr>
		<tr><td><input type="submit" value="패스워드 변경" id="chpwd"></td></tr>
		<tr><td><div style="width:auto; height:15px; border:2px;"></div></td></tr>
	</table>
</form>
</body>
</html>