<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	width: 1050px;
	height: 100%;
	border: 1px solid black;
}

div#top {
	width: 100%;
	height: 100px;
	border: 1px solid black;
	margin-bottm: 3px;
}

div#bottom {
	width: 100%;
	margin: 10px auto;
}

div#map {
	width: 523px;
	height: 67%;
	border: 1px solid black;
	float: left;
}

div#info {
	width: 523px;
	height: 67%;
	border: 1px solid black;
	float: right;
}
</style>
</head>
<body>

	<%@ include file="../common/main.jsp"%>

	<div id="main" class="block">
		<div id="top">
			<h1>dd</h1>
		</div>
		<div id="map">
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=47b2dcffee9e1b18c1d5105786e522b7"></script>
			<script>
				var container = document.getElementById('map');
				var options = {
					center : new kakao.maps.LatLng(33.450701, 126.570667),
					level : 3
				};

				var map = new kakao.maps.Map(container, options);
			</script>
		</div>
		<div id="info"></div>
	</div>
</body>
</html>