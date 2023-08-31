<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<style type="text/css">

div.wrapper {
	width:600px;
	height:300px;
	margin-top:250px;
/* 	position:relative; */
	border: 2px solid #cfcfcf;
	font-family: OhsquareAir;
	text-align:center;
	left:40%;
}

input[type=password] {
	width:280px;
	height:30px;
	margin-bottom:10px;
}

input[type=text] {
	width:280px;
	height:30px;
	margin-bottom:10px;
}

</style>
<script type="text/javascript">
$(function(){
	var pwdValue1 = document.getElementById("userpwd1");
	var pwdValue2 = document.getElementById("userpwd2");
	
	var reg = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$])[a-zA-Z\d@!#$]{6,15}[a-zA-Z\d@!#$]$/;
	
	var notice = document.getElementById("notice");
	notice.hidden = true;
	
	pwdValue1.addEventListener("keyup", function(){
		if (!reg.test(pwdValue1.value)) {
			notice.hidden = false;
		} else {
			notice.hidden = true;
		}
	});
})

function toMyPage(){
	location.href="/petmily/views/myPage/changeMyinfo.jsp";
}

</script>
</head>
<body>
<%@ include file="../common/main.jsp"%>
<div class="wrapper">

<form action="/petmily/changePwd" method="post" onsubmit="return validate();">
	<h3>비밀번호 변경하기</h3>
	<p style="font-size:14px;" id="notice">비밀번호는 영어 대/소문자, 특수문자, 숫자를 포함하여 최소 6자리 이상으로 설정해주세요.</p>
	아이디 : <input type="text" name="userid" value="<%=member.getMemberId()%>" readonly><br>
	비밀번호 : <input type="password" name="userpwd" id="userpwd1" required><br>
	비밀번호 확인 : <input type="password" id="userpwd2" required><br>
	
	<input type="submit" value="변경하기"> &nbsp; <input type="reset" value="취소하기" onclick="toMyPage();">
</form>

</div>
</body>
</html>