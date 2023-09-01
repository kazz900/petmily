<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model. vo. Member" %>
<%
 Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 h1 {
 
  font-size: 30px; 
  color:green;
 }
 
 ul {
 list-style-type:none;
 }
 
 li {
  float: left;
  margin-left: 100px;
 
 }
 .clear{
  clear:both;
 }
 
 h3{
  color: blue;
  font-size: 30px;
  margin-top: 50px;
  margin-left: 90px;
 
 }
 
 table {
  
  margin-top: 70px;
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

th {
  background-color: #f2f2f2;
}
 
 
</style>

</head>
<body>
<h1 align="center">회원 정보 조회 및 수정 페이지</h1>
<br>

 <h3>Change Info</h3>
	
	
	
<table id="outer" align="center" width="500" cellspacing="5" cellpadding="0">
	<tr><th colspan="2">등록된 회원정보는 아래와 같습니다.<br> 
	수정할 내용이 있으면 변경하고 수정하기 버튼을 누르세요.</th></tr>
	<tr><th width="140">아이디</th>
	<td><input type="text" name="userid" value="추후 데이터가 들어갈 예정임" readonly>
	<tr><th width="140">이메일</th>
	<td><input type="text" name="emaim" value="추후 데이터가 들어갈 예정임" >
	</td></tr>	
	
	
	
   
  
</body>
</html>