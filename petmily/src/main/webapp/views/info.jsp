<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/petmily/resources/css/info/info.css">
<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="/petmily/resources/js/info/infotap.js"></script>
</head>
<body>
<section>
<%@ include file="common/main.jsp" %>
</section>
<div id="info-content" class="info-content">
<div>
<img class="info-img" src="/petmily/resources/images/mainbanner/882.jpg">
<ul class="info-detail01">
	<li class="info-detail-title">Petmily동물병원</li><br>
	<li class="info-detail-subtitle">병원시설</li><br>
	<li>주소 :서울시 서초구</li>
	<li>전화번호 :02-121-1212</li>
	<li>홈페이지 :https://www.petadrgagadfgasdfsadfsdafsgasdfsagaew119.com</li><br><br>
	<li><a><img  class="info-share" src="/petmily/resources/images/share.png" style="width: 35px;"></a></li>
</ul>
</div>

<div class="info-detail02">

 <ul class="tabs">
            <li class="tab-link current" data-tab="tab-1">상세내역</li>
            <li class="tab-link" data-tab="tab-2">위 치</li>
        </ul>
<hr style="opacity:0.5;">
        <div id="tab-1" class="tab-content current">tab1입니다.</p></div>
        <div id="tab-2" class="tab-content"><p>tab2입니다.</p></div>
    </div>

    <script>
</div>
</div>
</body>
</html>