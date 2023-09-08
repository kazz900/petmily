<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id"
	content="23928052687-euopa8m23l0j93plo1rfms4tvqrpkh8m.apps.googleusercontent.com">
<title>Petmily</title>
<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
  <%if (request.getAttribute("message") != null) {%>
  <%if (request.getAttribute("message").equals("비밀번호 변경됨.")) {%>
     alert("비밀번호 변경 성공! 새로운 비밀번호로 로그인해주세요.");
  <%} else {%>
    alert("<%=request.getAttribute("message")%>
	");
<%}%>
	location.href = "/petmily/views/member/login.jsp";
<%}%>
	
</script>
<%
//   네이버 로그인
String clientId = "Y4aSWVB6n8GBIwdvF73u";//애플리케이션 클라이언트 아이디값";
String redirectURI = URLEncoder.encode("http:" + "//" + "localhost:8080/petmily/naver", "UTF-8");
SecureRandom random = new SecureRandom();
String state = new BigInteger(130, random).toString();
String apiURL = "https:" + "//" + "nid.naver.com/oauth2.0/authorize?response_type=code";
apiURL += "&client_id=" + clientId;
apiURL += "&redirect_uri=" + redirectURI;
apiURL += "&state=" + state;
session.setAttribute("state", state);
%>
<style type="text/css">
@font-face {
	font-family: 'Surround';
	src: url('/petmily/resources/font/surround.woff2') format('woff2');
	font-weight: normal;
	font-style: normal;
} /*폰트추가*/
@font-face {
	font-family: 'forgedm';
	src: url('/petmily/resources/font/forged-Medium.ttf') format('truetype');
	font-weight: normal;
	font-style: normal;
} /*폰트추가*/
@font-face {
	font-family: 'forgedl';
	src: url('/petmily/resources/font/forged-Light.ttf') format('truetype');
	font-weight: normal;
	font-style: normal;
} /*폰트추가*/
body {
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

body h2 { /*로그인 문구*/
	font-family: 'Surround', sans-serif;
	padding: 20px 50px;
	color: hsl(30.5, 77.6%, 29.8%);
}

form { /*기능폼 전체*/
	text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */
	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */
	width: 350px; /* 폼의 너비 설정 */
	height: auto;
}

td input[type=text] { /*아이디입력칸*/
	font-family: 'forgedl', sans-serif;
	width: 250px;
	height: 30px;
	border-radius: 7px;
	background-color: beige;
	border: 1px solid #c90;
}

td input[type=text]:focus {
	outline: none;
}

td input[type=password] { /*패스워드입력칸*/
	font-family: 'forgedl', sans-serif;
	width: 250px;
	height: 30px;
	border-radius: 7px;
	background-color: beige;
	border: 1px solid #c90;
}

td input[type=password]:focus {
	outline: none;
}

#logincheck { /*로그인 버튼*/
	font-family: 'Surround';
	width: 80px;
	height: 80px;
	border-radius: 10px;
	color: hsl(30.5, 77.6%, 29.8%);
	background-color: hsl(36deg 70.37% 68.61%);
}

#findinfo { /*아이디패스워드조회 버튼*/
	font-family: 'Surround';
	text-align: center;
	margin: 0 auto;
	width: 165px;
	height: 30px;
	border-radius: 7px;
	color: hsl(30.5, 77.6%, 29.8%);
	background-color: hsl(36deg 70.37% 68.61%);
}

#enroll { /*회원가입 버튼*/
	font-family: 'Surround';
	text-align: center;
	margin: 0 auto;
	width: 165px;
	height: 30px;
	border-radius: 7px;
	color: hsl(30.5, 77.6%, 29.8%);
	background-color: hsl(36deg 70.37% 68.61%);
}

td a {
	left: 0px;
}

.social { /*소셜로그인버튼 정렬용*/
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<header>
		<h1 align="left">
			<a href="/petmily/index.jsp">Petmily</a>
		</h1>
	</header>
	<h2 align="center">로그인</h2>
	<form action="/petmily/login">
		<table>
			<tr>
				<td><input type="text" id="memberid" name="memberid"
					placeholder="아이디 입력" required></td>
				<td rowspan="2"><input type="submit" value="로그인"
					id="logincheck"></td>
			</tr>
			<tr>
				<td><input type="password" id="memberpwd" name="memberpwd"
					placeholder="패스워드 입력" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="아이디/패스워드 찾기"
					id="findinfo" onclick="moveFindinfoPage();"> <input
					type="button" value="회원가입" id="enroll" onclick="moveEnrollPage();"></td>
			</tr>

			<tr>
				<td colspan="2">
					<div class="social">
						<!-- 카카오로그인버튼 -->
						<div style="width: 170px;">
							<a id="kakao-login-btn" href="javascript:loginWithKakao()"> <img
								src="/petmily/resources/images/kakaologo.png" width="60"
								height="60" alt="카카오 로그인 버튼" /></a>
						</div>
						<!-- 네이버로그인버튼 -->
						<div style="width: 170px;">
							<a href="<%=apiURL%>"><img width="60" height="60"
								src="/petmily/resources/images/naverlogo.png"></a>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
				function moveFindinfoPage() {
					location.href = "/petmily/views/member/findinfoPage.jsp";
				}
				function moveEnrollPage() {
					location.href = "/petmily/views/member/enrollPage.jsp";
				}
			</script>
	<script>
		Kakao.init('fa414bb9d343a627b76d4f12f380c22c');
		// 데모버전으로 들어가서 카카오로그인 코드를 확인.
		function loginWithKakao() {
			Kakao.Auth.login({
				success : function(authObj) {
					Kakao.Auth.setAccessToken(authObj.access_token); // access토큰값 저장
					getInfo();
				},
				fail : function(err) {
					console.log(err);
				}
			});
		}
		// 엑세스 토큰을 발급받고, 아래 함수를 호출시켜서 사용자 정보를 받아옴.
		function getInfo() {
			Kakao.API.request({
				url : '/v2/user/me',
				success : function(res) {
					// 이메일, 닉네임 저장
					var email = res.kakao_account.email;
					var nickname = res.kakao_account.profile.nickname;
					var userInfo = {
						email : email,
						nickname : nickname
					};
					// 서버로 정보 전송 후 메인페이지로 리다이렉트
					$.ajax({
						type : 'POST',
						url : '/petmily/kakao',
						data : JSON.stringify(userInfo),
						contentType : 'application/json',
						success : function(response) {
							console.log('Data sent successfully');
							location.href = "http://localhost:8080/petmily";
						},
						error : function(error) {
							alert("정지처리된 회원입니다. 관리자에게 문의해주세요");
							location.href = "/petmily/views/member/login.jsp";
						}
					});
				},
				fail : function(error) {
					alert('카카오 로그인에 실패했습니다. 관리자에게 문의하세요.'
							+ JSON.stringify(error));
				}
			});
		}
	</script>
</body>
</html>