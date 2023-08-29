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

<div class="banner-container" style="height: 750px; margin-top:85px">
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
<div class="block">
<ul style="position:absolute; left: 20%; padding-left: 0px; display:inline">
<span style="margin-right:50px;"><a href="#"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/veterinary.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">병원</li></ul></a></span>
<span style="margin-right:50px;"><a href="#"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/miyong.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">미용</li></ul></a></span>
<span style="margin-right:50px;"><a href="#"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/shop.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">용품</li></ul></a></span>
<span style="margin-right:50px;"><a href="#"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/witac.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">위탁</li></ul></a></span>
<span style="margin-right:50px;"><a href="#" ><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/hosp.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">카페, 식당</li></ul></a></span>
<span style="margin-right:50px;"><a href="#"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/hotel.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">호텔</li></ul></a></span>
<span style="margin-right:50px;"><a href="#"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/muhwa.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">문화</li></ul></a></span>
<span style="margin-right:50px;"><a href="#"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/dead.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">장묘</li></ul></a></span>
</ul>


</div>

</body>
</html>