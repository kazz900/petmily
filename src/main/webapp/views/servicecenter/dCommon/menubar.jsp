<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<link rel="stylesheet" href="/pet/resources/css/index.css">
<script type="text/javascript"
	src="/pet/resources/js/jquery-3.7.0.min.js"></script>
<style type="text/css">

ul {
  font-size: 0;
  position: relative;
  padding: 0;
  width: 800px;
  margin: 0px auto;
  user-select: none;
}

li {
  display: inline-block;
  width: 200px;
  height: 60px;
/*   background: #39CCCC; */
  font-size: 16px;
  text-align: center;
  line-height: 60px;
  color: black;
  text-transform: uppercase;
  position: relative;
  overflow: hidden;
  cursor: pointer;

}

a:-webkit-any-link {
    color:rgb(230, 100, 0);
    cursor: pointer;
    text-decoration: none;
}

.slider {
  display: block;
  position: absolute;
  bottom: 0;
  left: 0;
  height: 4px;
  background: rgb(230, 100, 0);
  transition: all 0.3s;
}

#mainLogo a {
	text-decoration:none;
	color:rgb(230, 100, 0);
	font-size:35px;
	margin:30px 10px 10px 30px;
}

#servCenter {
	margin: 0px 0px 0px 75px;
	color:rgb(230, 100, 0);
}

.wrapper {
	position:absolute;
	top:50%;
	left:50%;
	width:450px;
	height:160px;
	margin-left:-180px;
	margin-top:-80px;
	transform:translate(0%, -80%);
}

th {
	padding:10px;
}

</style>
<script type="text/javascript">
$(function() {
	$("ul li").click(function(e) {
		if ($(this).hasClass('slider')) {
			return;
		}
	var whatTab = $(this).index();

	var howFar = 200 * whatTab;

	$(".slider").css({
		left : howFar + "px"
	});

	$(".ripple").remove();

	var posX = $(this).offset().left, posY = $(this)
			.offset().top, buttonWidth = $(this)
			.width(), buttonHeight = $(this).height();

	$(this).prepend("<span class='ripple'></span>");

	if (buttonWidth >= buttonHeight) {
		buttonHeight = buttonWidth;
	} else {
		buttonWidth = buttonHeight;
	}

	var x = e.pageX - posX - buttonWidth / 2;
	var y = e.pageY - posY - buttonHeight / 2;

	$(".ripple").css({
		width : buttonWidth,
		height : buttonHeight,
		top : y + 'px',
		left : x + 'px'
	}).addClass("rippleEffect");
});
	
	
});
</script>

</head>
<body>

	<h2 id="mainLogo">
		<a href="/petmily/index.jsp">Petmily</a>
	</h2>
	<br>
	<h3 id="servCenter">고객센터</h3>
	<ul>
		<li><a href="/petmily/suggest">나의 문의내역</a></li>
		<li><a href="/petmily/views/servicecenter/mySuggest.jsp">건의사항 작성</a></li>
		<li><a href="/petmily/views/servicecenter/addDept.jsp">업체 등록요청</a></li>
		<li><a href="/petmily/views/servicecenter/delDept.jsp">업체 삭제요청</a></li>
		<li class="slider"></li>
	</ul>
	<br>

</body>
</html>