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
<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<style type="text/css">
@media ( min-width : 1050px) {
	.block {
		width: 1050px;
		margin: 98px auto 0 auto;
		word-wrap: break-word;
	}
	
}

html, body {
	witdh: 1050px;
	height: 920px;
}

div#main {
	width: 60%;
	height: 100%;
	position: relative;
    z-index: 0;
}

div#top {
	width: 100%;
	height: 100px;
	text-align : center;
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


div#searchInfo {
	margin-left : 20px;
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

a#aid {
	font-family: 'Surround';
	font-size: 20px;
	color: hsl(36deg 70.37% 68.61%);
}

h1#mainsearch {
	font-family: 'Surround';
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
				<h1 id="mainsearch">
					검색 정보 : 	<%=searchInfo%>
					<hr>
				</h1>
			
		</div>
		<div id="bottom">
			<div id="map">				
			</div>
			<div id="info">
			</div>
		</div>
	</div>
</div>
	
	 <!-- <script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=47b2dcffee9e1b18c1d5105786e522b7&libraries=services"></script> -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=47b2dcffee9e1b18c1d5105786e522b7&libraries=clusterer"></script>
 	<script>
				
				const divElement = document.getElementById("info");	
				const div = document.createElement("div");
		        div.id = "searchInfo";
		        const hr = document.createElement("hr");
		        
				var dept =<%=new Gson().toJson(list)%>;

					if (<%=list.size()%> > 0) {
						lat = dept[0].deptLatitude;
						lng = dept[0].deptLongitude;
					}  

				
					//위치정보 동의가 있으면	 
					//0이 메인페이지에서 버튼 눌렀을때
					if(<%= type %> == "0") {																
						if (navigator.geolocation) {
							navigator.geolocation.getCurrentPosition(function(position) {
								
										lat = position.coords.latitude;
										lng = position.coords.longitude;
																			
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
													+ filteredDepts[i].deptName + '</a>'
											}); 
											
											div.innerHTML += '<a id="aid" href="/petmily/mis?deptSeq='
													+ filteredDepts[i].deptSeq + '"><h3>'
													+ filteredDepts[i].deptName + '</h3></a>';
											div.innerHTML += '<h4>' + filteredDepts[i].deptAddress
													+ '</h4><hr>';
													
											divElement.appendChild(div);
											
											// 클로저를 이용하여 인포윈도우에 표시할 정보를 제공
											(function(marker, deptName, deptSeq) {
											    kakao.maps.event.addListener(marker, 'click', function() {
											        var content = '<div class="markerDeptName"><a href="/petmily/mis?deptSeq=' + deptSeq + '">' + deptName + '</a></div>';
											        infowindow.setContent(content); // 가게 이름 설정
											        infowindow.open(map, marker);
											    });
											    
											})(marker, filteredDepts[i].deptName, filteredDepts[i].deptSeq);	
											
											kakao.maps.event.addListener(map, 'click', function() {
										        infowindow.close(map, marker);
										    });
											 
										}
							}, 
							function(error) {
					            if (error.code === error.PERMISSION_DENIED) {
					            	//권한이 없으면										
								        var map = new kakao.maps.Map(document.getElementById('bottom'), { // 지도를 표시할 div
							            center: new kakao.maps.LatLng(37.505675040057994, 127.047883157395), // 지도의 중심좌표 
							            level: 13 // 지도의 확대 레벨 
							        });
							
							
							        var clusterer = new kakao.maps.MarkerClusterer({
							            map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
							            averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
							            minLevel: 10 // 클러스터 할 최소 지도 레벨 
							        });							
							        
									var imageSrc = null;
						            var imageSize = new kakao.maps.Size(24, 35);
							        
							        if("<%= searchInfo %>" === "의료") {
							        	$.get("/petmily/resources/json/hospital.json", function (data) {
								            imageSrc = "/petmily/resources/images/marker/hospital.png";
								            
											var markerImage = new kakao.maps.MarkerImage(imageSrc,
													imageSize);
								            
								            var markers = $(data.positions).map(function (i, position) {
								                var maks = new kakao.maps.Marker({
								                    map: map,
								                    position: new kakao.maps.LatLng(position.deptLatitude, position.deptLongitude),
								                    image : markerImage
								                });
								
								                var infowindow = new kakao.maps.InfoWindow({
								                	content: '<a href="/petmily/mis?deptSeq='
														+ position.deptSeq + '">'
														+ position.deptName + '</a>',
													removable : true											
								                });	                          
								                
								               kakao.maps.event.addListener(maks, 'click', function() {								    							            	    
											        infowindow.open(map, maks);
											    }); 
								                
								                kakao.maps.event.addListener(map, 'click', function() {
											        infowindow.close();
											    });
								
								                return maks;							
								            });								
								            // 클러스터러에 마커들을 추가
								            clusterer.addMarkers(markers);
								
								        });
							        } else if("<%= searchInfo %>"  === "미용") {
							        	$.get("/petmily/resources/json/miyong.json", function (data) {
							        		
							        		 imageSrc = "/petmily/resources/images/marker/miyong.png";
									            
									         // 마커 이미지를 생성합니다    
												var markerImage = new kakao.maps.MarkerImage(imageSrc,
														imageSize);
								            // 데이터에서 좌표 값을 가지고 마커를 표시합니다
								            // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
								            var markers = $(data.positions).map(function (i, position) {
								                var maks = new kakao.maps.Marker({
								                    map: map,
								                    position: new kakao.maps.LatLng(position.deptLatitude, position.deptLongitude),
								              		image : markerImage
								                });
								
								                var infowindow = new kakao.maps.InfoWindow({
								                	content: '<a href="/petmily/mis?deptSeq='
														+ position.deptSeq + '">'
														+ position.deptName + '</a>',
													removable : true											
								                });	                          
								                
								               kakao.maps.event.addListener(maks, 'click', function() {								    							            	    
											        infowindow.open(map, maks);
											    }); 
								                
								                kakao.maps.event.addListener(map, 'click', function() {
											        infowindow.close();
											    });
								
								                return maks;
								
								            });
								
								            // 클러스터러에 마커들을 추가합니다
								            clusterer.addMarkers(markers);
								
								        });							        	
							        } else if("<%= searchInfo %>"  === "용품") {
							        	$.get("/petmily/resources/json/yongpom.json", function (data) {
							        		
							        		imageSrc = "/petmily/resources/images/marker/yongpom.png";
								            
									         // 마커 이미지를 생성합니다    
												var markerImage = new kakao.maps.MarkerImage(imageSrc,
														imageSize);
								            // 데이터에서 좌표 값을 가지고 마커를 표시합니다
								            // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
								            var markers = $(data.positions).map(function (i, position) {
								                var maks = new kakao.maps.Marker({
								                    map: map,
								                    position: new kakao.maps.LatLng(position.deptLatitude, position.deptLongitude),
								                    image : markerImage
								                });
								
								                var infowindow = new kakao.maps.InfoWindow({
								                	content: '<a href="/petmily/mis?deptSeq='
														+ position.deptSeq + '">'
														+ position.deptName + '</a>',
													removable : true											
								                });	                          
								                
								               kakao.maps.event.addListener(maks, 'click', function() {								    							            	    
											        infowindow.open(map, maks);
											    }); 
								                
								                kakao.maps.event.addListener(map, 'click', function() {
											        infowindow.close();
											    });
								
								                return maks;
								
								            });
								
								            // 클러스터러에 마커들을 추가합니다
								            clusterer.addMarkers(markers);
								
								        });							        	
							        } else if("<%= searchInfo %>"  === "위탁") {
							        	$.get("/petmily/resources/json/witak.json", function (data) {
							        		
							        		imageSrc = "/petmily/resources/images/marker/wetak.png";
								            
									         // 마커 이미지를 생성합니다    
												var markerImage = new kakao.maps.MarkerImage(imageSrc,
														imageSize);
							        		
								            // 데이터에서 좌표 값을 가지고 마커를 표시합니다
								            // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
								            var markers = $(data.positions).map(function (i, position) {
								                var maks = new kakao.maps.Marker({
								                    map: map,
								                    position: new kakao.maps.LatLng(position.deptLatitude, position.deptLongitude),
								                    image : markerImage
								                });
								
								                var infowindow = new kakao.maps.InfoWindow({
								                	content: '<a href="/petmily/mis?deptSeq='
														+ position.deptSeq + '">'
														+ position.deptName + '</a>',
													removable : true											
								                });	                          
								                
								               kakao.maps.event.addListener(maks, 'click', function() {								    							            	    
											        infowindow.open(map, maks);
											    }); 
								                
								                kakao.maps.event.addListener(map, 'click', function() {
											        infowindow.close();
											    });
								
								                return maks;
								
								            });
								
								            // 클러스터러에 마커들을 추가합니다
								            clusterer.addMarkers(markers);
								
								        });							        	
							        } else if("<%= searchInfo %>"  === "카페/식당") {
							        	$.get("/petmily/resources/json/food.json", function (data) {
							        		
							        		imageSrc = "/petmily/resources/images/marker/food.png";
								            
									         // 마커 이미지를 생성합니다    
												var markerImage = new kakao.maps.MarkerImage(imageSrc,
														imageSize);
							        		
								            // 데이터에서 좌표 값을 가지고 마커를 표시합니다
								            // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
								            var markers = $(data.positions).map(function (i, position) {
								                var maks = new kakao.maps.Marker({
								                    map: map,
								                    position: new kakao.maps.LatLng(position.deptLatitude, position.deptLongitude),
								                    image : markerImage
								                });
								
								                var infowindow = new kakao.maps.InfoWindow({
								                	content: '<a href="/petmily/mis?deptSeq='
														+ position.deptSeq + '">'
														+ position.deptName + '</a>',
													removable : true											
								                });	                          
								                
								               kakao.maps.event.addListener(maks, 'click', function() {								    							            	    
											        infowindow.open(map, maks);
											    }); 
								                
								                kakao.maps.event.addListener(map, 'click', function() {
											        infowindow.close();
											    });
								
								                return maks;
								
								            });
								
								            // 클러스터러에 마커들을 추가합니다
								            clusterer.addMarkers(markers);
								
								        });							        	
							        } else if("<%= searchInfo %>"  === "호텔") {
							        	$.get("/petmily/resources/json/hotel.json", function (data) {
							        		
							        		imageSrc = "/petmily/resources/images/marker/hotel.png";
								            
									         // 마커 이미지를 생성합니다    
												var markerImage = new kakao.maps.MarkerImage(imageSrc,
														imageSize);
									         
								            // 데이터에서 좌표 값을 가지고 마커를 표시합니다
								            // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
								            var markers = $(data.positions).map(function (i, position) {
								                var maks = new kakao.maps.Marker({
								                    map: map,
								                    position: new kakao.maps.LatLng(position.deptLatitude, position.deptLongitude),
								                    image : markerImage
								                });
								
								                var infowindow = new kakao.maps.InfoWindow({
								                	content: '<a href="/petmily/mis?deptSeq='
														+ position.deptSeq + '">'
														+ position.deptName + '</a>',
													removable : true											
								                });	                          
								                
								               kakao.maps.event.addListener(maks, 'click', function() {								    							            	    
											        infowindow.open(map, maks);
											    }); 
								                
								                kakao.maps.event.addListener(map, 'click', function() {
											        infowindow.close();
											    });
								
								                return maks;
								
								            });
								
								            // 클러스터러에 마커들을 추가합니다
								            clusterer.addMarkers(markers);
								
								        });							        	
							        } else if("<%= searchInfo %>"  === "문화") {
							        	$.get("/petmily/resources/json/culture.json", function (data) {
							        		
							        		imageSrc = "/petmily/resources/images/marker/culture.png";
								            
									         // 마커 이미지를 생성합니다    
												var markerImage = new kakao.maps.MarkerImage(imageSrc,
														imageSize);
								            // 데이터에서 좌표 값을 가지고 마커를 표시합니다
								            // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
								            var markers = $(data.positions).map(function (i, position) {
								                var maks = new kakao.maps.Marker({
								                    map: map,
								                    position: new kakao.maps.LatLng(position.deptLatitude, position.deptLongitude),
								                    image : markerImage
								                });
								
								                var infowindow = new kakao.maps.InfoWindow({
								                	content: '<a href="/petmily/mis?deptSeq='
														+ position.deptSeq + '">'
														+ position.deptName + '</a>',
													removable : true											
								                });	                          
								                
								               kakao.maps.event.addListener(maks, 'click', function() {								    							            	    
											        infowindow.open(map, maks);
											    }); 
								                
								                kakao.maps.event.addListener(map, 'click', function() {
											        infowindow.close();
											    });
								
								                return maks;
								
								            });
								
								            // 클러스터러에 마커들을 추가합니다
								            clusterer.addMarkers(markers);
								
								        });							        	
							        } else if("<%= searchInfo %>"  === "장묘") {
							        	$.get("/petmily/resources/json/die.json", function (data) {
							        		
							        		imageSrc = "/petmily/resources/images/marker/die.png";
								            
									         // 마커 이미지를 생성합니다    
												var markerImage = new kakao.maps.MarkerImage(imageSrc,
														imageSize);
								            // 데이터에서 좌표 값을 가지고 마커를 표시합니다
								            // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
								            var markers = $(data.positions).map(function (i, position) {
								                var maks = new kakao.maps.Marker({
								                    map: map,
								                    position: new kakao.maps.LatLng(position.deptLatitude, position.deptLongitude),
								                    image : markerImage
								                });
								
								                var infowindow = new kakao.maps.InfoWindow({
								                	content: '<a href="/petmily/mis?deptSeq='
														+ position.deptSeq + '">'
														+ position.deptName + '</a>',
													removable : true											
								                });	                          
								                
								               kakao.maps.event.addListener(maks, 'click', function() {								    							            	    
											        infowindow.open(map, maks);
											    }); 
								                
								                kakao.maps.event.addListener(map, 'click', function() {
											        infowindow.close();
											    });
								
								                return maks;
								
								            });
								
								            // 클러스터러에 마커들을 추가합니다
								            clusterer.addMarkers(markers);
								
								        });							        	
							        }
							        
									
					            ///절취선	
					            }
					        }
						);
					}	
 				} else {

 					var container = document.getElementById('map');
					var options = {
						center : new kakao.maps.LatLng(lat, lng),
						level : 10,
						marker : marker
					};

					var imageSrc = null;

					var map = new kakao.maps.Map(container, options);
					var infowindow = null; // infowindow 변수 미리 선언
					
					var myloc = null;
 					
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

						var imageSize = new kakao.maps.Size(24, 35);

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
						
									
						  
				div.innerHTML += '<a id="aid" href="/petmily/mis?deptSeq='
						+ dept[i].deptSeq + '"><h3>' + dept[i].deptName
						+ '</h3></a>';
				div.innerHTML += '<h4>' + dept[i].deptAddress + '</h4><hr>';
				divElement.appendChild(div);
							
				// 클로저를 이용하여 인포윈도우에 표시할 정보를 제공
				(function(marker, deptName, deptSeq) {
				    kakao.maps.event.addListener(marker, 'click', function() {
				        var content = '<div class="markerDeptName"><a href="/petmily/mis?deptSeq=' + deptSeq + '">' + deptName + '</a></div>';
				        infowindow.setContent(content); // 가게 이름 설정
				        infowindow.open(map, marker);
				    });
				})(marker, dept[i].deptName, deptSeq);			
				
				kakao.maps.event.addListener(map, 'click', function() {
			        infowindow.close(map, marker);
			    });
			}
		}	
		
	</script>
</body>
</html>