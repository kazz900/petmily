<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" sizes="32x32" href="/petmily/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="/petmily/favicon-16x16.png">
<link rel="manifest" href="/petmily/site.webmanifest">
<title>petmily</title>
<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="/petmily/resources/js/main/banner_scroll.js"></script>
<link rel="stylesheet" href="/petmily/resources/css/main/banner.css">
</head>
<body>
<section>
<%@ include file="views/common/main.jsp" %>
</section>
<div style="display: flex;
    justify-content: center;
    
    height: 670px;">
<div class="banner-container" style="height: 500px; margin-top:85px">
  <div class="banner">
    <div data-index=1><img src="/petmily/resources/images/mainbanner/882.jpg"></div>
    <div data-index=2><img src="/petmily/resources/images/mainbanner/miho.jpg"></div>
    <div data-index=3><img src="https://henlopaw.com/banner/00_main/slide/pc/HD.jpg"></div>
    <div data-index=4><img src="/petmily/resources/images/mainbanner/885.jpg"></div>
  </div>
</div>
<div class="list-button" style="margin-bottom: 28px; margin-top: 540px;">
  <span class="list-button-item active"></span> 
  <span class="list-button-item"></span> 
  <span class="list-button-item"></span> 
  <span class="list-button-item"></span> 
</div>
</div>
<div class="block">
<ul style="display: flex;
    justify-content: center;
    align-items: center;">
<span style="margin-right:50px;"><a href="/petmily/selectdepttype?selecttype=1&typename=의료"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/veterinary.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">의료</li></ul></a></span>
<span style="margin-right:50px;"><a href="/petmily/selectdepttype?selecttype=2&typename=미용"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/miyong.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">미용</li></ul></a></span>
<span style="margin-right:50px;"><a href="/petmily/selectdepttype?selecttype=3&typename=용품"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/shop.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">용품</li></ul></a></span>
<span style="margin-right:50px;"><a href="/petmily/selectdepttype?selecttype=4&typename=위탁"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/witac.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">위탁</li></ul></a></span>
<span style="margin-right:50px;"><a href="/petmily/selectdepttype?selecttype=6&typename=카페/식당" ><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/hosp.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">카페, 식당</li></ul></a></span>
<span style="margin-right:50px;"><a href="/petmily/selectdepttype?selecttype=7&typename=호텔"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/hotel.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">호텔</li></ul></a></span>
<span style="margin-right:50px;"><a href="/petmily/selectdepttype?selecttype=8&typename=문화"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/muhwa.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">문화</li></ul></a></span>
<span style="margin-right:50px;"><a href="/petmily/selectdepttype?selecttype=5&typename=장묘"><ul style="display:inline-block"><li><img src="/petmily/resources/images/mainicon/dead.png" style="height:100px; width:100px;"></li><li class="main-icon" style="text-align: center">장묘</li></ul></a></span>
</ul>


</div>

</body>
</html>