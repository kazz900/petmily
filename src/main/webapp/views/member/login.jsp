<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name ="google-signin-client_id" content="23928052687-euopa8m23l0j93plo1rfms4tvqrpkh8m.apps.googleusercontent.com">
<title>Petmily</title>
<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.3.0/kakao.min.js" integrity="sha384-70k0rrouSYPWJt7q9rSTKpiTfX6USlMYjZUtr1Du+9o4cGvhPAWxngdtVZDdErlh" crossorigin="anonymous"></script>
<script type="text/javascript">
  <% if (request.getAttribute("message") != null) { %>
    alert("<%=request.getAttribute("message")%>");
    location.href="/petmily/views/member/login.jsp";	//로그인 실패시 
  <% } %>
</script>
 <%	//	네이버 로그인
    String clientId = "Y4aSWVB6n8GBIwdvF73u";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http:" + "//" + "localhost:8080/petmily/naver", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https:"+"//"+"nid.naver.com/oauth2.0/authorize?response_type=code";
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
    body h2 {
      font-family: 'Surround', sans-serif;
      padding: 20px 50px;
color: hsl(30.5, 77.6%, 29.8%);
    }
    body h2 {
      font-family: 'Surround', sans-serif;
      padding: 20px 50px;
color: hsl(30.5, 77.6%, 29.8%);
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
    border-radius: 7px;
    background-color: beige;
    font-family: 'Surround';
    border: solid;
 }
 td input[type=password]{
	width: 250px;
    height: 30px;
    border-radius: 7px;
    background-color: beige;
    font-family: 'Surround';
    border: solid;
 }
#logincheck {
    width: 80px;
    height: 80px;
    border-radius: 10px;
    color: hsl(30.5, 77.6%, 29.8%);
    background-color: hsl(36deg 70.37% 68.61%);
    font-family: 'Surround';
}
#findinfo {
text-align: center;
    margin: 0 auto;
    width: 165px;
    height: 30px;
    border-radius: 7px;
    color: hsl(30.5, 77.6%, 29.8%);
    background-color: hsl(36deg 70.37% 68.61%);
    font-family: 'Surround';
}
#enroll {
text-align: center;
    margin: 0 auto;
    width: 165px;
    height: 30px;
    border-radius: 7px;
    color: hsl(30.5, 77.6%, 29.8%);
    background-color: hsl(36deg 70.37% 68.61%);
    font-family: 'Surround';
}
      </style>
</head>
<body>
<header>
<h1 align="left"><a href="/petmily/index.jsp">Petmily</a></h1>
</header>
<h2 align="center">로그인</h2>
<form action="/petmily/login">
	<table>
		<tr><td><input type="text" id="memberid" name="memberid" placeholder="아이디 입력" required> </td>
		<td rowspan="2"><input type="submit" value="로그인" id="logincheck"></td></tr>
		<tr><td><input type="password" id="memberpwd" name="memberpwd" placeholder="패스워드 입력"required></td></tr>
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

<div>
<!-- 네이버로그인 -->

 <div  style="width: 120px; position: absolute; left: 530px; border:1px solid black;">
  <a href="<%=apiURL%>"><img width="110" height="40" src="http://static.nid.naver.com/oauth/small_g_in.PNG"></a>
</div>
<!-- 카카오로그인 -->

<!-- 구글로그인 -->

</div>

 

<br>
<%@ include file="../common/footer.jsp" %>
</body>
</html>