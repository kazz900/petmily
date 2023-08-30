<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, department.model.vo.Department, com.google.gson.Gson"%>
<%
ArrayList<Department> list = (ArrayList<Department>) request.getAttribute("list");
String searhInfo = (String) request.getAttribute("search");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<script type="text/javascript"
	src="/petmily/resources/js/main/banner_scroll.js"></script>
<style type="text/css">
@media ( min-width : 1050px) {
	.block {
		width: 1050px;
		margin: 98px auto 0 auto;
		word-wrap: break-word;
	}
}

html, body {
	height: 100%;
}

div#main {
	width: 100%;
	height: 100%;
}

div#top {
	width: 100%;
	height: 150px;
	margin-bottm: 3px;
}

div#bottom {
	width: 100%;
	height: 80%;
}

div#map {
	width: 70%;
	height: 100%;
	float: left;
}

div#info {
	width: 30%;
	height: 100%;
	float: right;
	overflow: auto;
}

h1#searchvalue {
	
}

img#searchImg {
	width: 200px;
	height: 80px;
}
</style>
</head>
<body>

	<%@ include file="../common/main.jsp"%>

	<div id="main" class="block">
		<div id="top">
			<h1 id="searchvalue">
				검색 정보 :
				<%=searhInfo%></h1>
			<h3>
				내위치 : 위도 = <span id="lat"></span>, 경도 = <span id="lng"></span>
			</h3>


			<script type="text/javascript">
				var lat = 0;
				var lng = 0;

				//실행시 권한 요청을 수락하여야 함.
				navigator.geolocation.getCurrentPosition(function(position) {
					lat = position.coords.latitude;
					lng = position.coords.longitude;

					document.getElementById("lat").innerHTML = lat;
					document.getElementById("lng").innerHTML = lng;
				});
			</script>
			<hr>
		</div>
		<div id="bottom">
			<div id="map">
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=47b2dcffee9e1b18c1d5105786e522b7"></script>
				<script>
					var dept = <%=new Gson().toJson(list)%>;
					console.log(dept);

					if (
				<%=list.size()%>
					> 0) {
						lat = dept[0].deptLatitude;
						lng = dept[0].deptLongitude;
					} else {

						lat = 33.451475;
						lng = 126.570528;
					}

					var container = document.getElementById('map');
					var options = {
						center : new kakao.maps.LatLng(lat, lng),
						level : 3
					};

					var imageSrc = null;

					var map = new kakao.maps.Map(container, options);
					for (var i = 0; i < dept.length; i++) {
						var type = dept[i].deptType;
						if (type == 1) {
							imageSrc = "/petmily/resources/images/marker/hospital.png";
						} else if (type == 2) {
							imageSrc = "/petmily/resources/images/marker/miyong.png";
						} else if (type == 3) {
							imageSrc = "/petmily/resources/images/marker/yongpom.png";
						} else if (type == 4) {
							imageSrc = "/petmily/resources/images/marker/wetak.png";
						} else if (type == 5) {
							imageSrc = "/petmily/resources/images/marker/die.png";
						} else if (type == 6) {
							imageSrc = "/petmily/resources/images/marker/food.png";
						} else if (type == 7) {
							imageSrc = "/petmily/resources/images/marker/hotel.png";
						} else if (type == 8) {
							imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
						}

						var imageSize = new kakao.maps.Size(34, 45);

						// 마커 이미지를 생성합니다    
						var markerImage = new kakao.maps.MarkerImage(imageSrc,
								imageSize);

						var marker = new kakao.maps.Marker(
								{
									map : map,
									position : new kakao.maps.LatLng(
											dept[i].deptLatitude,
											dept[i].deptLongitude),
									title : dept[i].deptName,
									image : markerImage
								});

						var content = '<div style="padding:10px;">' + '<h4>'
								+ dept[i].deptName + '</h4>' + '</div>';
								
						
						var infowindow = new kakao.maps.InfoWindow({
					    	position : new kakao.maps.LatLng(
									dept[i].deptLatitude,
									dept[i].deptLongitude), 
					    	content : content
					    });

						marker.setMap(map);
					}
					
					 infowindow.open(map,marker);
					
				</script>
			</div>
			<div id="info">
				<h2>
					검색 결과 :
					<%=list.size()%>
					개
				</h2>
				<hr>
				<%
				for (Department dept : list) {
				%>
				<div id="searchInfo">
					<img id="searchImg"
						src="/petmily/resources/images/mainbanner/885.jpg" align="left">
					<h3>
						<a href="/petmily/mis?deptSeq=<%=dept.getDeptSeq()%>"><%=dept.getDeptName()%></a>
					</h3>
					<h4><%=dept.getDeptAddress()%></h4>
				</div>
				<hr>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>