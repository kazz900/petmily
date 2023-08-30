<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>petmily</title>
<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="/petmily/resources/js/main/banner_scroll.js"></script>
<style>
.adminmenu{
	bacgroundcolor: #ccc;
	align: center;
}
</style>
<link rel="stylesheet" href="/petmily/resources/css/main/banner.css">
</head>
<body>
<section>
<%@ include file="../../views/common/main.jsp" %>
</section>
<hr>
<div>
<ul class="adminmenu">
	<hr>
	<li><a class="sub-link" href="/petmily/mis?deptSeq=578">업체 등록</a></li>
	<li><a class="sub-link" href="/petmily/views/member/login.jsp">업체 삭제</a></li>
	<li><a class="sub-link" href="/petmily/views/member/login.jsp">회원 등급 변경</a></li>
	<li><a class="sub-link" href="/petmily/views/member/login.jsp">일반 게시글 삭제</a></li>
	<li><a class="sub-link" href="/petmily/views/member/login.jsp">거래 게시글 삭제</a></li>
	<hr>
</ul>

</div>

<div class="list-button">
  <span class="list-button-item active"></span> 
  <span class="list-button-item"></span> 
  <span class="list-button-item"></span> 
  <span class="list-button-item"></span> 
</div>

</body>
</html>