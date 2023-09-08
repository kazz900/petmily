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
	font-size: 25px;
	font-weight: 900;
	color: hsl(30.5, 77.6%, 29.8%);
}

body h1 a { /*좌상단 Petmily 문구*/
	font-family: 'Surround', sans-serif;
	padding: 20px 50px;
	font-size: 35px;
	font-weight: 900;
	border: none;
	color: hsl(30.46deg 58.9% 45.68%);
	text-decoration: none;
}

form { /*회원가입정보 입력공간*/
	text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */
	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */
	width: 350px; /* 폼의 너비 설정 */
	height: auto;
	background-color: #FFE4B5;
	border: 2px solid hsl(30.5, 77.6%, 29.8%);
	border-radius: 15px;
	justify-content: center;
}

td input:not(#checkpassword) { /*패스워드 입력칸을 제외한 입력칸*/
	width: 250px;
	height: 30px;
	border-radius: 7px;
	background-color: beige;
	font-family: 'forgedl', sans-serif;
	font-size: 16px;
	color: hsl(30.5, 77.6%, 29.8%);
	border: 1px solid #c90;
}

td input:focus { /*입력칸 포커스되어도 테두리 강조 x*/
	outline: none;
}

td input#dupcheck { /*아이디 중복확인 버튼*/
	font-family: 'Surround', sans-serif;
	width: 80px;
	height: 34px;
	border-radius: 7px;
	color: hsl(30.5, 77.6%, 29.8%);
	background-color: hsl(36deg 70.37% 68.61%);
	border: 2px solid hsl(30.5, 77.6%, 29.8%);
}

td input#dupcheck:hover { /*중복확인 버튼 마우스 오버되면 색 변화*/
	background-color: hsl(30.5, 77.6%, 29.8%);
	color: hsl(36deg 70.37% 68.61%);
}

td input#dupcheck2 { /*이메일 중복확인 버튼*/
	font-family: 'Surround', sans-serif;
	width: 80px;
	height: 34px;
	border-radius: 7px;
	color: hsl(30.5, 77.6%, 29.8%);
	background-color: hsl(36deg 70.37% 68.61%);
	border: 2px solid hsl(30.5, 77.6%, 29.8%);
}

td input#dupcheck2:hover { /*중복확인 버튼 마우스 오버되면 색 변화*/
	background-color: hsl(30.5, 77.6%, 29.8%);
	color: hsl(36deg 70.37% 68.61%);
}

hr {
	width: 100%;
}

input[type=submit] { /*회원가입 버튼*/
	font-family: 'Surround', sans-serif;
	width: 340px;
	height: 34px;
	border-radius: 7px;
	margin-right: 3px;
	color: hsl(30.5, 77.6%, 29.8%);
	background-color: hsl(36deg 70.37% 68.61%);
}

input[type=password] { /*패스워드 입력칸*/
	width: 400px;
	height: 30px;
	border-radius: 7px;
	background-color: hsl(36deg 70.37% 68.61%);
	/* display: flex;
justify-content: space-between; */
}

#checkenroll { /*유효성검사이후 문구 출력공간*/
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
</style>
<script type="text/javascript">
	//중복체크 실행시에만 회원가입 가능하도록 함
	var idc = 0;
	var emc = 0;
	//회원가입 페이지 입력값 가져오기
	window.onload = function() {
		var mid = document.getElementById('mid');
		var mpwd = document.getElementById('mpwd');
		var mpwd2 = document.getElementById('mpwd2');
		var notice = document.getElementById('checkenroll');
		var mnick = document.getElementById('mnick');
		var memail = document.getElementById('memail');
		//유효성검사를 위한 조건식 지정
		var cid = /^(?=.*[a-zA-Z0-9])[A-Za-z0-9]{8,12}$/;
		var cpwd = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$])[a-zA-Z\d@!#$]{6,12}[a-zA-Z\d@!#$]$/;
		var cnick = /^[A-Za-z0-9가-힣ㄱ-ㅎㅏ-ㅣ]{0,8}$/;
		var cemail = /^[A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Za-z0-9]{2,}$/;
		//키 입력시 유효성검사하는 이벤트 추가
		notice.hidden = true;
		mid.addEventListener('keyup', function() {
			idc = 0;
			if (!cid.test(mid.value)) {
				notice.hidden = false;
				notice.textContent = '아이디는 영어 대소문자와 숫자를 포함해서 8~12글자로 작성해주세요.';
				notice.style.color = '#ff6633';
			} else {
				notice.hidden = true;
			}
			if (mid.value.length === 0) {
				notice.hidden = true;
			}
		});

		mpwd.addEventListener(
						'keyup',
						function() {
							if (!cpwd.test(mpwd.value)) {
								notice.hidden = false;
								notice.textContent = '패스워드는 영어 대,소문자와 숫자를 포함하고,!@#$기호중 하나를 포함시켜 6~12글자로 사용해주세요.';
								notice.style.color = '#ff5151';
							} else {
								notice.hidden = true;
							}
							if (mpwd.value.length === 0) {
								notice.hidden = true;
							}
						});

		mpwd2.addEventListener('keyup', function() {
			notice.hidden = false;
			if (mpwd.value === mpwd2.value) {
				/* notice.textContent = '유효한 패스워드입니다.'; */
				notice.hidden = true;
			} else {
				notice.textContent = '패스워드와 같은 값을 입력해주세요.';
				notice.style.color = '#ff5151';
				mpwd2.focus();
			}
			if (mpwd2.value.length === 0) {
				notice.hidden = true;
			}
		});

		mnick.addEventListener('keyup', function() {
			if (!cnick.test(mnick.value)) {
				notice.hidden = false;
				notice.textContent = '닉네임은 8자 이내로 작성해주세요.';
				notice.style.color = '#ff5151';
			} else {
				notice.hidden = true;
			}
		});

		memail.addEventListener('keyup', function() {
			emc = 0;
			if (!cemail.test(memail.value)) {
				notice.hidden = false;
				notice.textContent = '이메일은 test@enroll.com 형태로 작성해주세요.';
				notice.style.color = '#ff5151';
			} else {
				notice.hidden = true;
			}
			if (memail.value.length === 0) {
				notice.hidden = true;
			}
		});

	};
	//회원가입시 유효성 체크용 함수
	function validateCheck() {
		var mid = document.getElementById('mid');
		var mpwd = document.getElementById('mpwd');
		var mpwd2 = document.getElementById('mpwd2');
		var notice = document.getElementById('checkenroll');
		var mnick = document.getElementById('mnick');
		var memail = document.getElementById('memail');
		//유효성검사를 위한 조건식 지정
		var cid = /^(?=.*[a-zA-Z0-9])[A-Za-z0-9]{8,12}$/;
		var cpwd = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$])[a-zA-Z\d@!#$]{6,12}[a-zA-Z\d@!#$]$/;
		var cnick = /^[A-Za-z0-9가-힣ㄱ-ㅎㅏ-ㅣ]{0,8}$/;
		var cemail = /^[A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Za-z0-9]{2,}$/;

		if (!cid.test(mid.value)) {
			alert("아이디는 영어 대소문자와 숫자를 포함해서 8~12글자로 작성해주세요.");
			mid.focus();
			return false;
		}
		if (!cpwd.test(mpwd.value)) {
			alert("패스워드는 영어 대,소문자와 숫자를 포함하고,!@#$기호중 하나를 포함시켜 6~12글자로 사용해주세요.");
			mpwd.value = "";
			mpwd2.value = "";
			mpwd.focus();
			return false;
		}
		if (!cnick.test(mnick.value)) {
			alert("닉네임은 8자 이하로 작성해주세요.");
			mnick.value = "";
			return false;
		}
		if (!cemail.test(memail.value)) {
			alert("이메일은 test@enroll.com 형태로 작성해주세요.");
			memail.focus();
			return false;
		}
		if (idc === 0) {
			alert("아이디 중복확인 해주세요!");
			return false;
		}
		if (emc === 0) {
			alert("이메일 중복확인 해주세요!");
			return false;
		}
		if (idc === 1 && emc === 1) {
			return true;
		}

	}
	//아이디 중복검사용 Ajax 사용 함수
	function dupcheckId() {
		var mid = $('#mid').val();
		if (mid === "" || mid == null || mid.length === 0) {
			alert("아이디를 입력해주세요.");
			return false;
		}

		$.ajax({
			type : "POST",
			url : "/petmily/dupid",
			data : {
				mid : mid
			},
			success : function(response) {
				alert(response);
				var isDuplicate = (response === "중복된 아이디입니다.");
				setSignupButtonState(isDuplicate);
				if (isDuplicate) {
					idc = 0;
				} else {
					idc = 1;
				}
			},
			error : function() {
				alert("오류가 발생했습니다. 다시 시도해주세요.");
			}
		});
	}
	//이메일 중복검사용 Ajax 사용 힘수
	function dupcheckemail() {
		var memail = $('#memail').val();
		if (memail === "" || memail == null || memail.length === 0) {
			alert("이메일을 입력해주세요.");
			return false;
		}

		$.ajax({
			type : "POST",
			url : "/petmily/dupemail",
			data : {
				memail : memail
			},
			success : function(response) {
				alert(response);
				var isDuplicate = (response === "이미 가입된 이메일입니다.");
				setSignupButtonState(isDuplicate);
				if (isDuplicate) {
					emc = 0;
				} else {
					emc = 1;
				}
			},
			error : function() {
				alert("오류가 발생했습니다. 다시 시도해주세요.");
			}
		});

	}
	// 아이디와 이메일 중복검사 이후 회원가입 버튼 처리
	function setSignupButtonState(isDuplicate) {
		var signupButton = document.getElementById('submit');
		if (isDuplicate) {
			signupButton.disabled = true; // 중복이면 버튼 비활성화
		} else if (idc == 1 && emc == 1) {
			signupButton.disabled = false; // 중복이 아니면 버튼 활성화
		}
	}
</script>
</head>
<body>
	<h1 align="left">
		<a href="/petmily/index.jsp">Petmily</a>
	</h1>
	<!-- 추후 include처리 -->
	<h2 align="center">회원가입</h2>
	<!-- 추후 include처리 -->
	<form action="/petmily/enroll" id="myForm"
		onsubmit="return validateCheck();">
		<table>
			<tr>
				<td><div style="width: auto; height: 5px; border: 2px;"></div></td>
			</tr>
			<tr>
				<td><input type="text" id="mid" name="mid"
					placeholder="사용할 아이디 입력" required></td>
				<td><input type="button" value="중복확인" id="dupcheck"
					onclick="return dupcheckId();"></td>
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
					placeholder="사용할 닉네임 입력" required> <!--  &nbsp;  &nbsp;  -->
			<tr>
				<td><input type="email" id="memail" name="memail"
					placeholder="Email" required> <!--  &nbsp;  &nbsp;  --></td>
				<td><input type="button" value="중복확인" id="dupcheck2"
					onclick="dupcheckemail();"></td>
			</tr>
			<tr>
				<td colspan="2"><div id="checkenroll">아이디는 영어 대소문자와 숫자를
						포함해서 8~12글자로 작성해주세요.</div></td>
			</tr>
		</table>
		<input type="submit" id="submit" value="가입하기"> &nbsp;
	</form>

</body>
</html>