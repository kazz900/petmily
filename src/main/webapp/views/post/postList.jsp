<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, standardpost.model.vo.StandardPost, java.sql.Date" %>
<% 

	ArrayList<StandardPost> list = (ArrayList<StandardPost>)request.getAttribute("list");
	int count = list.size();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community</title>
</head>
<body>

<%@ include file="../common/main.jsp" %>

<hr>
<br>
<br>
<br>
<br>
<br>

<div id="postListDiv">
	<table align="center" width="700"></table>
	<tr>
		<th>아이디</th>
		<th>내용</th>
		<th>작성일자</th>
	</tr>
	<br>
	<% for(StandardPost sp : list) { %>
		<tr>
			<td align="center"><%= sp.getMemberId() %></td>
			<td align="center"><%= sp.getPostContent() %></td>
			<td align="center"><%= sp.getPostDate() %></td>
		</tr>
		<br>
	<% } %>
</div>


</body>
</html>