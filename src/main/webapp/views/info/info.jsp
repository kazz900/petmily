<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="department.model.vo.Department"%>
<% Department dptmt = (Department)request.getAttribute("dptmt"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<link rel="stylesheet" href="/petmily/resources/css/info/info.css">
<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="/petmily/resources/js/info/infotap.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4ace05793ac4808782136fb0eaaad83b&libraries=services,clusterer"></script>
</head>
<script type="text/javascript">
//SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
Kakao.init('4ace05793ac4808782136fb0eaaad83b');

// SDK 초기화 여부를 판단합니다.
console.log(Kakao.isInitialized());
var link =  document.location.href;
function kakaoShare() {
  Kakao.Link.sendDefault({
    objectType: 'feed',
    content: {
      title: 'Petmily',
      description: '반려동물의 모든 것\n <%= dptmt.getDeptName() %>',
      imageUrl: 'https://ifh.cc/g/NFnlJt.jpg',
      link: {
        mobileWebUrl: link,
        webUrl: link,
      },
    },
    buttons: [
      {
        title: '웹으로 보기',
        link: {
          mobileWebUrl: link,
          webUrl: link,
        },
      },
    ],
    // 카카오톡 미설치 시 카카오톡 설치 경로이동
    installTalk: true,
  })
}
</script>
</head>
<body>
<section>
<%@ include file="../common/main.jsp" %>
</section>
<div id="info-content" class="info-content">
<div>
<img class="info-img" src="/petmily/resources/images/mainbanner/882.jpg">
<!-- <img class="info-img" src="https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;type=f184_184&amp;src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20200216_260%2F15818269954319jfwa_JPEG%2F_9Yd8jwNtxtLyFcMAdHFV3Ur.jpeg.jpg" alt="1004약국"> -->
<ul class="info-detail01">
	<li class="info-detail-title"><%= dptmt.getDeptName() %></li><br>
	<li class="info-detail-subtitle"><%=dptmt.getDeptType()%></li><br>
	<li class="infomenu-title">주소</li>
	<li class="infomenu-sub"><%= dptmt.getDeptAddress() %></li><br>
	<li class="infomenu-title">전화번호</li>
	<li class="infomenu-sub"><%= dptmt.getDeptPhone() %></li><br>
	<li class="infomenu-title">홈페이지</li>
	<li class="infomenu-sub"><%= dptmt.getDeptUrl() %></li><br><br>
	<li><a href="javascript:kakaoShare()"><img  class="info-share" src="/petmily/resources/images/share.png" style="width: 35px;"></a></li>
</ul>
</div>

<div class="info-detail02">

 <ul class="tabs">
            <li class="tab-link current" data-tab="tab-1">위 치</li>
            <li class="tab-link" data-tab="tab-2">상세내역</li>
        </ul>
<hr style="opacity:0.5; margin-top:0px;">
        <div id="tab-2" class="tab-content"><ul>
        	<li>＊영업 시간</li>
        	<li>&nbsp;&nbsp;&nbsp;<%= dptmt.getDeptTime() %></li><br>
        	<li>＊<%= dptmt.getDeptParking() %></li><br>
        	<li>＊입장 가능한 반려 동물 사이즈</li>
        	<li>&nbsp;&nbsp;&nbsp; <%= dptmt.getDeptSizerestrict() %></li><br>
        	<li>＊제한 사항</li>
        	<li>&nbsp;&nbsp;&nbsp; <%= dptmt.getDeptRestrict()%></li><br>
        </ul></div>
        <div id="tab-1" class="tab-content current"><ul>
        		<li><div id="map2" style="width:100%;height:350px;"></div></li>
        	</ul>
        </div>
    </div>
</div>
<script>
var lat = '<%= dptmt.getDeptLatitude() %>';
var lon = '<%= dptmt.getDeptLongitude() %>';
console.log(typeof(lat));
console.log(typeof(lon));//string
var json = JSON.parse(lat);
var json = JSON.parse(lon);
var mapContainer2 = document.getElementById('map2'), // 지도를 표시할 div 
mapOption2 = {
    center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};

var map2 = new kakao.maps.Map(mapContainer2, mapOption2); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition = new kakao.maps.LatLng(lat, lon);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map2);
</script>
</body>
</html>