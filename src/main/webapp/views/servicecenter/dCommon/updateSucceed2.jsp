<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<% Member member = (Member)session.getAttribute("member"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<style type="text/css">
body {
	display:flex;
	justify-content:center;
	align-items:center;
	height:100vh;
	margin:0;
	flex-direction:column;
	font-family: OhsquareAir;
}
@font-face {
	font-family: 'OhsquareAir';
	src: url('/petmily/resources/font/OhsquareAir.woff2') format('woff2');
	font-weight: normal;
	font-style: normal;
}
button {
	width:280px;
	height:30px;
	display:block;
	margin-top:0;
	text-decoration:none;
}

button:hover {
	/* background-color:#00f261; */
	background: radial-gradient(#00f261, #99ff55);
}

a {
	text-decoration:none;
}
</style>
</head>
<body>
<img src="/petmily/resources/images/servicecenter/check_mark.png" style="width:100px; height:auto;">
<h1 style="margin-bottom:5px; font-size:36px;">감사합니다!</h1>
<h3 style="margin-top:5px; font-size:28px;">성공적으로 변경되었습니다!</h3>
<a href="/petmily/suggest?mseq=<%=member.getMemberSeq()%>"><button style="margin-bottom:15px; width:200px; height:40px; 
	border-radius:5px; border:1px solid black;
	box-shadow:1px 1px 0px 1px #cfcfcf;">확인</button></a>
</body>
</html>