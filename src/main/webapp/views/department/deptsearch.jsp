<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.ArrayList, department.model.vo.Department, com.google.gson.Gson"%>
<%
ArrayList<Department> list = (ArrayList<Department>) request.getAttribute("list");
String searchInfo = (String) request.getAttribute("search");
String type = (String)request.getAttribute("type");
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
	height: 920px;
}

div#main {
	width: 90%;
	height: 100%;
}

div#top {
	width: 100%;
	height: 100px;
}

div#searchname {
	width: 50%;
	height: 100%;
	float: left;
}

div#searchcheck {
	width: 50%;
	height: 100%;
	float: right;
}

div#bottom {
	width: 100%;
	height: 80%;
}

div#map {
	width: 70%;
	height: 100%;
	float: left;
	z-index:0;
}

div#info {
	width: 30%;
	height: 100%;
	float: right;
	overflow: auto;
}

.markerDeptName {
	display: block;
	text-align: center;
	width: 100%;
}

img#searchImg {
	width: 200px;
	height: 80px;
	algin: left;
}

.checkbox-container {
	display: inline-block;
    margin-right: 10px; /* 체크박스 간격 조절을 위해 마진 추가 */
}
        
</style>					
<script type="text/javascript">
	var lat = 0;
	var lng = 0;
	//실행시 권한 요청을 수락하여야 함.
	navigator.geolocation.getCurrentPosition(function(position) {
		lat = position.coords.latitude;
		lng = position.coords.longitude;

	});
</script>
</head>
<body>

	<%@ include file="../common/main.jsp"%>

	<div id="main" class="block">
		<div id="top">
			<div id="searchname">
				<h1>
					검색 정보 : 	<%=searchInfo%>
				</h1>
			</div>
			<div id="searchcheck">
			    <!-- 체크박스 항목들 -->
			    <div class="checkbox-container">
			        <input type="checkbox" id="item1" name="items" value="아이템1">
			        <label for="item1">아이템 1</label>
			    </div>
			
			    <div class="checkbox-container">
			        <input type="checkbox" id="item2" name="items" value="아이템2">
			        <label for="item2">아이템 2</label>
			    </div>
			
			    <div class="checkbox-container">
			        <input type="checkbox" id="item3" name="items" value="아이템3">
			        <label for="item3">아이템 3</label>
			    </div>
		    </div>
			<hr>
		</div>
		<div id="bottom">
			<div id="map">				
			</div>
			<div id="info">
			</div>
		</div>
	</div>
	
	<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=47b2dcffee9e1b18c1d5105786e522b7"></script>
	<script>
				
				const divElement = document.getElementById("info");
				const div = document.createElement("div");
		        div.id = "searchInfo";
		        const hr = document.createElement("hr");
		        
				var dept =<%=new Gson().toJson(list)%>;
					console.log(dept);

					if (<%=list.size()%> > 0) {
						lat = dept[0].deptLatitude;
						lng = dept[0].deptLongitude;
					}  

					var container = document.getElementById('map');
					var options = {
						center : new kakao.maps.LatLng(lat, lng),
						level : 3,
						marker : marker
					};

					var imageSrc = null;

					var map = new kakao.maps.Map(container, options);
					var infowindow = null; // infowindow 변수 미리 선언
					
					var myloc = null;
				
					//위치정보 동의가 있으면	 
					//0이 메인페이지에서 버튼 처눌렀을때
					if(<%= type %> == "0") {																
						if (navigator.geolocation) {
							navigator.geolocation.getCurrentPosition(function(position) {
								
										lat = position.coords.latitude;
										lng = position.coords.longitude;
										
										var userMarker = new kakao.maps.Marker({
													map : map,
													position : new kakao.maps.LatLng(
															lat, lng),
													title : '내 위치',
													image : new kakao.maps.MarkerImage(
															"/petmily/resources/images/marker/myloc.png",
															new kakao.maps.Size(34,
																	45)
													)
												});

										// 내 위치를 중심으로 지도 표시
										map.setCenter(new kakao.maps.LatLng(lat, lng));
										makeMap();
							}, 
							function(error) {
					            if (error.code === error.PERMISSION_DENIED) {
					            	//권한이 없으면										
										var userMarker = new kakao.maps.Marker({
													map : map,
													position : new kakao.maps.LatLng(
															lat, lng),
													title : '현재 위치',
													image : new kakao.maps.MarkerImage(
															"/petmily/resources/images/marker/myloc.png",
															new kakao.maps.Size(34,
																	45)
													)
												});

										// 내 위치를 중심으로 지도 표시
										map.setCenter(new kakao.maps.LatLng(lat, lng));									
										makeMap();		
					            }
					        }
						);
					}	
 				} else {

 					
 					var infowindow = new kakao.maps.InfoWindow(); // 인포윈도우 객체 생성

 					
 					if (dept.length > 0) {
 						div.innerHTML = '<h2>' + "검색결과 : " + dept.length + "개"
 								+ '</h2><hr>';
 					} else {
 						div.innerHTML = '<h2>' + "검색결과 없음" + '</h2><hr>';
 						divElement.appendChild(div);
 					}
 					
 					
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
							imageSrc = "/petmily/resources/images/marker/culture.png";
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

						var deptSeq = dept[i].deptSeq;
						
						// 클로저를 이용하여 인포윈도우에 표시할 정보를 제공
						(function(marker, deptName, deptSeq) {
						    kakao.maps.event.addListener(marker, 'click', function() {
						        var content = '<div class="markerDeptName"><a href="/petmily/mis?deptSeq=' + deptSeq + '">' + deptName + '</a></div>';
						        infowindow.setContent(content); // 가게 이름 설정
						        infowindow.open(map, marker);
						    });
						})(marker, dept[i].deptName, deptSeq);						
						  
				div.innerHTML += '<a href="/petmily/mis?deptSeq='
						+ dept[i].deptSeq + '"><h3>' + dept[i].deptName
						+ '</h3></a>';
				div.innerHTML += '<h4>' + dept[i].deptAddress + '</h4><hr>';
				divElement.appendChild(div);
			}
		}

		//여기서부터 함수
		function makeMap() {

			var filteredDepts = dept.filter(function(deptItem) {
				var deptLat = deptItem.deptLatitude;
				var deptLng = deptItem.deptLongitude;

				var distance = Math.sqrt(Math.pow(lat - deptLat, 2)
						+ Math.pow(lng - deptLng, 2)) * 111;

				return distance <= 3;
			});

			if (filteredDepts.length > 0) {
				div.innerHTML = '<h2>' + "검색결과 : " + filteredDepts.length + "개"
						+ '</h2><hr>';
			} else {
				div.innerHTML = '<h2>' + "검색결과 없음" + '</h2><hr>';
				divElement.appendChild(div);
			}

			for (var i = 0; i < filteredDepts.length; i++) {
				var type = filteredDepts[i].deptType;
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
					imageSrc = "/petmily/resources/images/marker/culture.png";
				}

				var imageSize = new kakao.maps.Size(34, 45);

				// 마커 이미지를 생성합니다    
				var markerImage = new kakao.maps.MarkerImage(imageSrc,
						imageSize);

				var marker = new kakao.maps.Marker({
					map : map,
					position : new kakao.maps.LatLng(
							filteredDepts[i].deptLatitude,
							filteredDepts[i].deptLongitude),
					title : filteredDepts[i].deptName,
					image : markerImage
				});

				
				marker.setMap(map);
				
				var deptSeq = filteredDepts[i].deptSeq;
				
				 // 인포윈도우 객체 생성
				var infowindow = new kakao.maps.InfoWindow({
					content: '<a href="/petmily/mis?deptSeq='
						+ deptSeq + '">'
						+ filteredDepts[i].deptName + '</a>',
					removable: true
				}); 
				
				div.innerHTML += '<a href="/petmily/mis?deptSeq='
						+ filteredDepts[i].deptSeq + '"><h3>'
						+ filteredDepts[i].deptName + '</h3></a>';
				div.innerHTML += '<h4>' + filteredDepts[i].deptAddress
						+ '</h4><hr>';
						
				divElement.appendChild(div);
				
				(function(marker, infowindow) {
				    var clickHandler = function() {
				        // 마커 위에 인포윈도우를 표시합니다
				        infowindow.open(map, marker);  				       
				    };

				    kakao.maps.event.addListener(marker, 'click', clickHandler);
				   // kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
/* 				    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
 */				})(marker, infowindow);
				 
			}
		}
		
		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	/* 	function makeOverListener(map, marker, infowindow) {
		    return function() {
		        infowindow.open(map, marker);
		    };
		}
 */
		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		/* function makeOutListener(infowindow) {
		    return function() {
		        infowindow.close();
		    };
		} */
	</script>
</body>
</html>