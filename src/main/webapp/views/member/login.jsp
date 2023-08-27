<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<!-- <script type="text/javascript">
	const naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "Y4aSWVB6n8GBIwdvF73u",
				callbackUrl: "http:"+"//"+"localhost:8080/petmily/",
				loginButton: {color: "green", type:2 , height: 80}
			});
	
    naverLogin.init();
    naverLogin.getLoginStatus(function (status) {
      if (status) {
          const nickName=naverLogin.user.getName();

          if(Name===null||Name===undefined){
            alert("별명이 필요합니다. 정보제공을 동의해주세요.");
            naverLogin.reprompt();
            return ;  
         }else{
          setLoginStatus();
         }
    }
    });
    console.log(naverLogin);

    function setLoginStatus(){

      const message_area=document.getElementById('message');
      message_area.innerHTML=`
      <h3> Login 성공 </h3>
      <div>user Name : ${naverLogin.user.name}</div>
      `;

      const button_area=document.getElementById('button_area');
      button_area.innerHTML="<button id='btn_logout'>로그아웃</button>";

      const logout=document.getElementById('btn_logout');
      logout.addEventListener('click',(e)=>{
        naverLogin.logout();
    location.replace("http:"+"//"+"localhost:8080/petmily/");
      })
    }
</script> -->
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
	background-color:  hsl(30.7, 86.9%, 70%);
    }
body h1 {
      font-family: 'Surround', sans-serif;
      padding: 20px 50px;
font-size: 35px;
font-weight: 900;
color: hsl(30.46deg 58.9% 45.68%);
    }
    form {
	text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */
	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */
	width: 350px; /* 폼의 너비 설정 */
	height: auto;
/* 	border: 1px solid black;  */
    }
/* td {
border: 1px solid red; 
}  */
 td input[type=text]{
 width: 250px;
 height: 30px;
 border-radius: 3px;
 background-color: #c5c5c5;
 }
 td input[type=password]{
 width: 250px;
 height: 30px;
 border-radius: 3px;
 background-color: #c5c5c5;
 }
#logincheck {
width:80px;
height:80px;
 border-radius: 3px;
 background-color: #39f;
}
#findinfo {
text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */
	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */
	width: 165px; /* 폼의 너비 설정 */
	height: 30px;
	 border-radius: 3px;
 background-color: #39f;
}
#enroll {
text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */
	margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */
	width: 165px; /* 폼의 너비 설정 */
	height: 30px;
	 border-radius: 3px;
 background-color: #39f;
}
      </style>
</head>
<body>
<header>
<h1 align="left">Petmily</h1> <!-- 추후 include처리 -->
</header>
<h2 align="center">로그인</h2> <!-- 추후 include처리 -->
<form action="">
	<table>
		<tr><td><input type="text" id="userid" name="userid" placeholder="아이디 입력" required> </td>
		<td rowspan="2"><input type="button" value="로그인" id="logincheck" onclick="#"></td></tr>
		<tr><td><input type="password" id="userpwd" name="userpwd" placeholder="패스워드 입력"required></td></tr>
		<tr><td colspan="2"><input type="button" value="ID/PA 조회" id="findinfo" onclick="moveFindinfoPage();">
		<input type="button" value="회원가입" id="enroll" onclick="moveEnrollPage();"></td></tr>
<script type="text/javascript">
function moveFindinfoPage(){
	location.href="/petmily/views/member/findinfoPage.jsp";
}
function moveEnrollPage(){
	location.href="/petmily/views/member/enrollPage.jsp";
}
</script>
	</table>
</form>

<br>
 <div id="naver_id_login" align="center"></div>
//네이버 로그인 버튼 노출 영역


네이버아디디로로그인 초기화 Script
<script type="text/javascript">
	var naver_id_login = new naver_id_login("Y4aSWVB6n8GBIwdvF73u", "http://localhost:8080/petmily/views/member/callback.jsp");
	var state = naver_id_login.getUniqState();
	naver_id_login.setButton("green", 2, 80);
	naver_id_login.setDomain("http://localhost:8080/petmily/views/member/login.jsp");
	naver_id_login.setState(state);
	naver_id_login.init_naver_id_login();
</script>
//네이버아디디로로그인 초기화 Script


네이버아디디로로그인 Callback페이지 처리 Script
<script type="text/javascript">
	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	function naverSignInCallback() {
		// naver_id_login.getProfileData('프로필항목명');
		// 프로필 항목은 개발가이드를 참고하시기 바랍니다.
		alert(naver_id_login.getProfileData('email'));
		alert(naver_id_login.getProfileData('name'));
	}


	// 네이버 사용자 프로필 조회
	naver_id_login.get_naver_userprofile("naverSignInCallback();");
</script>
<%-- <%
    String clientId = "Y4aSWVB6n8GBIwdvF73u";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http:" + "//" + "localhost:8080/petmily/views/member/callback.jsp", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https:"+"//"+"nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
 <div align="center">
  <a href="<%=apiURL%>"><img width="200" height="60" src="http://static.nid.naver.com/oauth/small_g_in.PNG"></a>
</div> --%>
<br>
<%-- <%@ include file="../common/footer.jsp" %> --%>
</body>
</html>