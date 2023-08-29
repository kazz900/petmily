<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
    <%
    	Member m = (Member)session.getAttribute("member");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>

<style type="text/css">
div.inner-container {
	text-align: center;
}

input[type=submit] {
	margin-top: 15px;
	width: 200px;
	height: 35px;
	border-radius: 30px;
}

input[type=text] {
	width: 280px;
	height: 30px;
}

input[type=password] {
	width: 280px;
	height: 30px;
}
</style>

</head>
<body>

<div class="outer-container">
	<div class="inner-container">
		<h4>소중한 회원정보 관리를 위해 아이디와 비밀번호를 재확인합니다.</h4><br>
		
		<form action="" method="post">
			<label>아이디 : </label><input type="text" name="userid" id="userid" placeholder="<%=m.getMemberId()%>"><br>
			<label>비밀번호 : </label><input type="password" name="userpwd" id="userpwd" placeholder="비밀번호"><br>
			
			<input type="submit" value="확인">
		</form>
	</div>
	<a href="/petmily"></a>
</div>

</body>
</html>