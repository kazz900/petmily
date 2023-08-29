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
body h1 {
	font-family: 'Surround', sans-serif;
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
	border-radius: 3px;
	background-color: #c5c5c5;
	/* display: flex;
justify-content: space-between; */
}

td input#dupcheck {
	width: 80px;
	height: 34px;
	border-radius: 3px;
	background-color: #39f;
}

td input#dupcheck2 {
	width: 80px;
	height: 34px;
	border-radius: 3px;
	background-color: #39f;
}

hr {
	width: 100%;
}

input[type=submit] {
	width: 340px;
	height: 34px;
	border-radius: 3px;
	margin-right: 3px;
	background-color: #39f;
}
/*      ::placeholder {
      color: red; /* 힌트 텍스트의 색상을 빨간색으로 설정 */
font-style
:
 
italic
; /* 힌트 텍스트의 글꼴을 기울임체로 설정 */
 
    
}
* /
 input[type=password] {
	width: 400px;
	height: 30px;
	border-radius: 3px;
	background-color: #c5c5c5;
	/* display: flex;
justify-content: space-between; */
}

#checkenroll {
	font-size: 7pt;
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
	var notice = document.getElementById('checkenroll');
	var mnick = document.getElementById('mnick');
	var memail = document.getElementById('memail');
	   notice.hidden = true;
	mid.addEventListener('keyup', function() {
		var val = /^(?=.*[a-zA-Z0-9])[A-Za-z0-9]{8,12}$/;
		if(!val.test(mid.value)){
		notice.hidden = false;
		notice.style.color = '#ff6633';
		} else {
		notice.hidden = true;			
		}
	});
	
	mpwd.addEventListener('keyup', function() {
		var val = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$])[a-zA-Z\d@!#$]{6,12}[a-zA-Z\d@!#$]$/;
		if(!val.test(mpwd.value)){
		notice.hidden = false;
		notice.textContent = '패스워드는 영어 대,소문자와 숫자를 포함하고,!@#$기호중 하나를 포함시켜 6~12글자로 사용해주세요.';
		notice.style.color = '#ff6633';
		} else {
		notice.hidden = true;			
		}
	});
	
	mpwd2.addEventListener('keyup', function() {
			   notice.hidden = false;
		   if(mpwd.value === mpwd2.value){
			   /* notice.textContent = '유효한 패스워드입니다.'; */
			   notice.hidden = true;
			   } else {
			  notice.textContent = '패스워드와 같은 값을 입력해주세요.';
			  notice.style.color = '#ff6633';
		      mpwd2.focus();
		    }
	});
	mnick.addEventListener('keyup', function() {
		var val = /^[A-Za-z0-9가-힣ㄱ-ㅎㅏ-ㅣ]{0,8}$/;
		if(!val.test(mnick.value)){
		notice.hidden = false;
		notice.textContent = '닉네임은 8자 이하로 작성해주세요.';
		notice.style.color = '#ff6633';
		} else {
		notice.hidden = true;			
		}
	});
	memail.addEventListener('keyup', function() {
		var val = /^[A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Za-z0-9]{2,}$/;
		if(!val.test(memail.value)){
		notice.hidden = false;
		notice.textContent = '이메일은 test@enroll.com 형태로 작성해주세요.';
		notice.style.color = '#ff6633';
		} else {
		notice.hidden = true;			
		}
	});	
}
</script>
</head>
<body>
	<h1 align="center">Petmily</h1>
	<!-- 추후 include처리 -->
	<h2 align="center">회원가입</h2>
	<!-- 추후 include처리 -->
	<form action="/petmily/enroll">
		<table>
			<tr>
				<td><input type="text" id="mid" name="mid"
					placeholder="사용할 아이디 입력" required></td>
				<td><input type="button" value="중복확인" id="dupcheck" onclick="#"></td>
			</tr>
			<tr>
				<td><input type="password" id="mpwd" name="mpwd"
					placeholder="사용할 패스워드 입력" required></td>
			</tr>
			<tr>
				<td><input type="password" id="mpwd2" placeholder="패스워드 확인"
					required></td>
			</tr>
			<tr>
				<td><input type="text" id="mnick" name="mnick"
					placeholder="사용할 닉네임 입력" required>
				<!--  &nbsp;  &nbsp;  -->
			<tr>
				<td><input type="email" id="memail" name="memail"
					placeholder="Email" required>
				<!--  &nbsp;  &nbsp;  --></td>
				<td><input type="button" value="중복확인" id="dupcheck2"
					onclick="#"></td>
			</tr>
			<tr>
				<td><div id="checkenroll" >아이디는 영어 대소문자와 숫자를 포함해서 8~12글자로 작성해주세요.</div></td>
			</tr>
		</table>
		<input type="submit" value="가입하기"> &nbsp;
	</form>
	<br>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>