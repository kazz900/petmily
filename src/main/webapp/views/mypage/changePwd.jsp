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
	height:33.px;
	border: 2px solid #cfcfcf;
	text-align:center;
	background-color:#fafafa;
	box-shadow:2px 2px 5px 2px #cfcfcf;
	font-family: OhsquareAir;
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
@media(min-width: 1050px){
.block{
	width: 1050px;
    margin: 98px auto 0 auto;
    word-wrap: break-word;
}
}

input[type=submit]#submit {
	margin-top:5px;
	margin-bottom:15px; 
	width:250px; 
	height:35px; 
	border-radius:5px; 
	border:0px solid rgba(200,124,25,0.1);
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	

	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,0.7) 0%, rgba(218,131,0,0.7) 100%);
}

input[type=submit]#submit:hover {
	background: transparent;
	background: rgba(230,154,55,0.8);
}

input[type=button]#prev {
	margin-top:5px;
	margin-bottom:15px; 
	width:250px; 
	height:35px; 
	border-radius:5px; 
	border:0px solid rgba(200,124,25,0.1);
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	
	
	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,0.7) 0%, rgba(218,131,0,0.7) 100%);
}

input[type=button]#prev:hover {
	background: transparent;
	background: rgba(230,154,55,0.8);
}

</style>
<script type="text/javascript">
$(function(){
	var pwdValue1 = document.getElementById("userpwd1");
	var pwdValue2 = document.getElementById("userpwd2");
	
	var reg = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$])[a-zA-Z\d@!#$]{6,15}[a-zA-Z\d@!#$]$/;
	
	var notice = document.getElementById("notice");
	var notice2 = document.getElementById("notice2");
	var submitBtn = document.getElementById("submit");

	notice.hidden = true;
	notice2.hidden = true;
	submitBtn.disabled = true;
	submitBtn.style.background = "#dfdfdf";

	pwdValue1.addEventListener("keyup", function(){
		if (!reg.test(pwdValue1.value)) {
			notice.hidden = false;
			submitBtn.disabled = true;
		} else {
			notice.hidden = true;
			submitBtn.disabled = true;
			if(pwdValue1.value == pwdValue2.value){
				submitBtn.disabled = false;
			}
		}
	});
	
	pwdValue2.addEventListener("keyup", function(){
		if (!reg.test(pwdValue2.value)) {
			notice.hidden = false;
			notice2.hidden = false;
			submitBtn.disabled = true;
			if (pwdValue1.value == pwdValue2.value){
				notice2.hidden = true;
			}
		} else {
			notice.hidden = true;
			if(pwdValue1.value == pwdValue2.value){
				submitBtn.disabled = false;
				notice2.hidden = true;
				submitBtn.style.removeProperty('background');
			} else {
				notice2.hidden = false;
			}
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


<div class="block" style="display:flex; justify-content:center;">
	<div class="wrapper" style="margin-top:100px;">
	<div style="text-align:center;">
		<p style="margin-bottom:10px; font-size:24px; font-weight:bold;">비밀번호 변경 페이지</p>
		
		<form action="/petmily/pwdupdate" method="post" onsubmit="return validate();">
		<p style="font-size:14px;" id="notice">
			비밀번호는 영어 대/소문자, 특수문자, 숫자를 포함하여 최소 6자리 이상으로 설정해주세요.
		</p>
		
		<p style="font-size:14px;" id="notice2">
			비밀번호가 일치하지 않습니다.<br>확인 후 다시 입력해주세요.
		</p>
		
		<input type="hidden" name="memail" value="<%=member.getMemberEmail()%>">
		
			<table id="outer" align="center" width="500" cellspacing="5"
				cellpadding="0">
				<tr>
					<th width="140">아이디</th>
					<td><input type="text" name="mid" value="<%=member.getMemberId()%>"
						readonly>
				<tr>
					<th width="140">비밀번호</th>
					<td><input type="password" name="mpwd" id="userpwd1" required>
					</td>
				</tr>

				<tr>
					<th width="140">비밀번호 확인</th>
					<td><input type="password" id="userpwd2" required>
					</td>
				</tr>
			</table>
			<div style="text-align:center; margin-top:10px;">
			
				<input type="button" value="이전으로" id="prev"
				style="margin-bottom:15px; width:150px; height:30px; 
				border-radius:5px;
				box-shadow:1px 1px 0px 1px #cfcfcf;" onclick="history.go(-1)">
				&nbsp; 
				<input type="submit" value="변경하기" id="submit"
				style="margin-bottom:15px; width:150px; height:30px; 
				border-radius:5px;
				box-shadow:1px 1px 0px 1px #cfcfcf;">
			
			</div>
		</form>

</div>
</div>
</body>
</html>