<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Paging, member.model.vo.Member" %>    
<%
	Paging paging = (Paging)request.getAttribute("paging");

	int startPage = paging.getStartPage();
	int endPage = paging.getEndPage();
	int maxPage = paging.getMaxPage();
	int currentPage = paging.getCurrentPage();
	int limit = paging.getLimit();
	
	String urlMapping = paging.getUrlMapping();
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

</head>
<body>
<%-- 목록 페이징 처리 --%>

<div style="text-align:center;">
	<% if(currentPage <= 1){ %>
		＜＜ &nbsp;
	<% }else{ //currentPage > 1 %>
		<a href="/petmily/<%= urlMapping %>?page=1">＜＜ &nbsp;</a>
	<% } %>
	<%-- 이전 페이지 그룹으로 이동 --%>
	<% if(((currentPage - 10) < startPage || (currentPage - 10) > 1) && (currentPage - 10) > 0){  //이전그룹이 있다면 %>
		<a href="/petmily/<%= urlMapping %>?page=<%= startPage - 10 %>">＜&nbsp;</a> &nbsp;
	<% }else{ //이전그룹이 없다면 %>
		＜ &nbsp;
	<% } %>
	
	
	<%-- 현재 페이지가 속한 페이지그룹 숫자 출력 --%>
	<% for(int p = startPage; p <= endPage; p++){ 
			if (p == currentPage){
	%>
			<font color="brown" size="4"><b><%= p %></b></font>
	<%     }else{ %>
			<a href="/petmily/<%= urlMapping %>?page=<%= p %>" style="font-size:5px;">&nbsp;<%= p %>&nbsp;</a>
	<% }} %>
	
	
	<%-- 다음 페이지 그룹으로 이동 --%>
	<% if((currentPage + 10) > endPage && (currentPage + 10) < maxPage){  //다음그룹이 있다면 %>
		<a href="/petmily/<%= urlMapping %>?page=<%= startPage + 10 %>">&nbsp;＞</a> &nbsp;
	<% }else{ //다음그룹이 없다면 %>
		＞ &nbsp;
	<% } %>
	
	<% if(currentPage >= maxPage){ %>
		＞＞ &nbsp;
	<% }else{ //currentPage < maxPage  %>
		<a href="/petmily/<%= urlMapping %>?page=<%= maxPage %>">＞＞</a> &nbsp;
	<% } %>
</div>



</body>
</html>