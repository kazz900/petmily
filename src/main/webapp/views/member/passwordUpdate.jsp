<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import="member.model.vo.Member" %>
    
    <% Member member = (Member)request.getAttribute("findMember");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>petmily</title>
</head>
<body>
<h1>New Password</h1>
<%= member.getMemberId() %>
</body>
</html>