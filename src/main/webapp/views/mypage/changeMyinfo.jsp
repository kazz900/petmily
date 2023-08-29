<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
    
<%
	Member member = (Member)session.getAttribute("member");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>

<style type="text/css">
div.inner-container {
	text-align:center;
}
</style>

</head>
<body>

<div class="outer-container">
	<div class="inner-container-first">
		<h1>나의 정보</h1>
		<p>고객님께서 가입하신 펫밀리 회원정보입니다.</p>
	</div>
	
	<div class="inner-container-second">
		<table id="outer" align="center" width="500" cellspacing="5"
		cellpadding="0">
			<tr>
				<th width="120">아이디</th>
				<td><%=member.getMemberId()%></td>
			</tr>
	
			<tr>
				<th>닉네임</th>
				<td><%=member.getMemberNick()%></td>
			</tr>
	
			<tr>
				<th>성별</th>
				<td><%=(member.getGender().equals("M") ? "남자" : "여자")%></td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>