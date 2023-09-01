<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>

<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript"
	src="/petmily/resources/js/info/infotap.js"></script>

<style type="text/css">

.info-content{
	width: 900px;
    margin: 98px auto 0 auto;
    word-wrap: break-word;
}

.info-share{
	position:relative;
	left: 95%;
}

.info-detail02{
	margin-top:120px;
	font-family: OhsquareAir;
	src: url('/petmily/resources/font/OhsquareAir.woff2') format('woff2');
	font-size: 18px;
	color: black;
}

ul.tabs{
	margin: 0px;
	padding: 0px;
	list-style: none;
}
ul.tabs li{
	background: none;
	color: #222;
	display: inline-block;
	padding: 10px 15px;
	cursor: pointer;
}

ul.tabs li.current{
	/* background: #ededed; */
	color: #222;
	border-bottom: 3px solid hsl(30.46deg 58.9% 45.68%);
}

.tab-content{
	display: none;
	/* background: #ededed; */
	padding: 15px;
	
}

.tab-content.current{
	display: inherit;
}

.tabs {
	text-align:center;
}


input[type=text] {
	width:280px;
	height:30px;
}

input[type=email] {
	width:280px;
	height:30px;
}

input[type=time] {
	height:30px;
	width:132px;
}

/* input[type=submit] {
	margin-top:15px;
	width:200px;
	height:35px;
	border-radius:30px;
} */

input[type=tel] {
	width:280px;
	height:30px;
}

select[name=type] {
	width:280px;
	height:30px;
}

form table tr textarea {
	width:280px;
}

form {
	margin-top:0px;
}

.yes {
	height:30px;
}



div.wrapper {
	border: 2px solid #cfcfcf;
	text-align:center;
	background-color:#fafafa;
	box-shadow:2px 2px 5px 2px #cfcfcf;
}

div.wrapper form {
	text-align:center;
}

</style>

<script type="text/javascript">
function loadImage(input){
	const imgElement = document.getElementById("profile");
	if (input.files && input.files[0]) {
		const reader = new FileReader();
		reader.onload = function(e){
			imgElement.setAttribute("src", e.target.result);
		}
		
		reader.readAsDataURL(input.files[0]);
	}
}

function changePwd(){
	location.href="/petmily/views/myPage/changePwd.jsp";
}
</script>

</head>
<body>
<%@ include file="../common/main.jsp"%>

<div class="info-content">
		<div class="info-detail02">

			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">나의 정보</li>
				<li class="tab-link" data-tab="tab-2">프로필 사진</li>
				<li class="tab-link" data-tab="tab-3">업체 등록요청</li>
				<li class="tab-link" data-tab="tab-4">업체 삭제요청</li>
			</ul>

			<hr style="opacity: 0.5; margin: 0px;">



<div id="tab-1" class="tab-content current">
	<div class="wrapper">
	<div style="text-align:center;">
		<p style="margin-bottom:2px;">고객님께서 가입하신 펫밀리 계정정보입니다.</p>
		<p style="font-size:15px; margin-top:3px;">닉네임만 변경 가능합니다.</p>
	</div>
		<form action="/petmily/myinfo" method="get">
			<table id="outer" align="center" width="500" cellspacing="5"
				cellpadding="0">
				
				<tr>
					<th width="140">아이디</th>
					<td><input type="text" name="userid" value="<%=member.getMemberId()%>"
						readonly>
				<tr>
					<th width="140">이메일</th>
					<td><input type="email" name="email" value="<%=member.getMemberEmail()%>">
					</td>
				</tr>
				
				<tr>
					<th width="140">(*)닉네임</th>
					<td><input type="text" name="nickname" value="<%=member.getMemberNick()%>">
					</td>
				</tr>
			</table>
			<div style="text-align:center; margin-top:10px;">
			
				<input type="button" value="비밀번호 변경" onclick="changePwd();" 
				style="margin-bottom:15px; width:150px; height:30px; 
				border-radius:5px; border:1px solid black;
				box-shadow:1px 1px 0px 1px #cfcfcf;">
				&nbsp; 
				<input type="submit" value="변경하기" 
				style="margin-bottom:15px; width:150px; height:30px; 
				border-radius:5px; border:1px solid black;
				box-shadow:1px 1px 0px 1px #cfcfcf;">
			
			</div>
		</form>
	</div>
</div>



<div id="tab-2" class="tab-content">
	<div class="wrapper">
		<h1><a href="/petmily/loadPetPic">프로필 변경하기</a></h1>
	</div>
</div>



			<div id="tab-3" class="tab-content">

			</div>



			<div id="tab-4" class="tab-content">
				
			</div>
		</div>
	</div>



</body>
</html>