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
	
	
	/*	
		1. 첫번째 비밀번호가 정규식에 맞지 않는 경우
		2. 첫번째 비밀번호는 정규식에 맞지만 두번째가 불일치하는 경우
		3. 
	*/
	var notice2 = document.getElementById("notice2");
	notice2.hidden = true;
	
	pwdValue2.addEventListener("keyup", function(){
		if (pwdValue2.value != pwdValue1.value) {
			notice2.hidden = false;
		} else {
			notice2.hidden = true;
		}
	})
	
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
	</div>
		<form action="/petmily/changePwd" method="post" onsubmit="return validate();">
		<p style="font-size:14px;" id="notice">비밀번호는 영어 대/소문자, 특수문자, 숫자를 포함하여 최소 6자리 이상으로 설정해주세요.</p>
		<p style="font-size:14px;" id="notice2">비밀번호가 일치하지 않습니다.<br>확인 후 다시 입력해주세요.</p>
			<table id="outer" align="center" width="500" cellspacing="5"
				cellpadding="0">
				
				
				
				<tr>
					<th width="140">아이디</th>
					<td><input type="text" name="userid" value="<%=member.getMemberId()%>"
						readonly>
				<tr>
					<th width="140">비밀번호</th>
					<td><input type="password" name="userpwd" id="userpwd1" required>
					</td>
				</tr>
				
				<tr>
					<th width="140">비밀번호 확인</th>
					<td><input type="password" id="userpwd2" required>
					</td>
				</tr>
			</table>
			<div style="text-align:center; margin-top:10px;">
			
				<input type="reset" value="취소하기" 
				style="margin-bottom:15px; width:150px; height:30px; 
				border-radius:5px; border:1px solid black;
				box-shadow:1px 1px 0px 1px #cfcfcf;">
				&nbsp; 
				<input type="submit" value="변경하기" id="submit"
				style="margin-bottom:15px; width:150px; height:30px; 
				border-radius:5px; border:1px solid black;
				box-shadow:1px 1px 0px 1px #cfcfcf;">
			
			</div>
		</form>

</div>
</div>
</body>
</html>