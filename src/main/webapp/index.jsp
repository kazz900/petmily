<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>petmily</title>
<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="/petmily/resources/js/main/banner_scroll.js"></script>
<link rel="stylesheet" href="/petmily/resources/css/main/banner.css">
</head>
<body>
<section>
<%@ include file="views/common/main.jsp" %>
</section>

<div class="banner-container" style="height: 750px">
  <div class="banner">
    <div data-index=1><img src="/petmily/resources/images/mainbanner/882.jpg"></div>
    <div data-index=2><img src="/petmily/resources/images/mainbanner/883.jpg"></div>
    <div data-index=3><img src="/petmily/resources/images/mainbanner/884.jpg"></div>
    <div data-index=4><img src="/petmily/resources/images/mainbanner/885.jpg"></div>
  </div>
</div>
<div class="list-button">
  <span class="list-button-item active"></span> 
  <span class="list-button-item"></span> 
  <span class="list-button-item"></span> 
  <span class="list-button-item"></span> 
</div>

</body>
</html>