<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="servicecenter.model.vo.Board, java.util.ArrayList"%>

<%
ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Tab-Menu</title>
<link rel="stylesheet" href="/pet/resources/css/addDept.css">
<script type="text/javascript"
	src="/pet/resources/js/jquery-3.7.0.min.js"></script>

<style type="text/css">
ul.tabs {
	width: 1000px;
	text-align: center;
	margin: 0px;
	padding: 0px;
	list-style: none;
}

ul.tabs li {
	background: none;
	color: #222;
	display: inline-block;
	padding: 10px 15px;
	cursor: pointer; 	
}

ul.tabs li.current {
	background: #ededed;
	color: #222;
}

.tab-content {
	display: none;
	padding: 15px 0;
	border-top: 3px solid #eee;
}

.tab-content.current {
	display: inherit;
}

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

li a {
	color: rgb(230, 100, 0);
	cursor: pointer;
	text-decoration: none;
	font-weight: bold;
}

#mainLogo a {
	text-decoration: none;
	color: rgb(230, 100, 0);
	font-size: 35px;
	margin: 30px 10px 10px 30px;
}

th {
	padding: 10px;
}

.slider {
	display: block;
	position: absolute;
	bottom: 0;
	left: 0;
	height: 15px;
	background: rgb(230, 100, 0); /* 슬라이더의 색상 */
	transition: all 0.3s;
}
</style>

<script type="text/javascript">
	$(function() {

		$('ul.tabs li').click(function() {
			var tab_id = $(this).attr('data-tab');

			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#" + tab_id).addClass('current');
		})

		$('ul.tabs li').click(
				function() {
					var tab_id = $(this).attr('data-tab');

					$('ul.tabs li').removeClass('current');
					$('.tab-content').removeClass('current');

					$(this).addClass('current');
					$("#" + tab_id).addClass('current');

					var tab_index = $(this).index();
					var tab_width = $(this).outerWidth();
					var slider = $('.slider');

					slider.css('transform', 'translateX('
							+ (tab_index * tab_width) + 'px)');
				});

	})
</script>

</head>
<body>

	<h2 id="mainLogo">
		<a href="/pet/index.jsp">Petmily</a>
	</h2>
	<br>

<div class="container" align="center">
  <ul class="tabs">
    <li class="tab-link" data-tab="tab-1"><a>나의 문의내역</a></li>
    <li class="tab-link current" data-tab="tab-2"><a>건의사항 작성</a></li>
    <li class="tab-link" data-tab="tab-3"><a>업체 등록요청</a></li>
    <li class="tab-link" data-tab="tab-4"><a>업체 삭제요청</a></li>
	<li class="slider"></li>
  </ul>
 
<%--   <div id="tab-1" class="tab-content current">
  <%@ include file="../common/menubar.jsp" %>
  	<table id="outer" align="center" cellspacing="5" cellpadding="0">
<!-- 		<tr>
			
		</tr> -->
		<tr>
			<th style="width: 100px;">No.</th>
			<th style="width: 200px;">Title</th>
			<th style="width: 310px;">Content</th>
			<th style="width: 110px;">Date</th>
		</tr>
		<%
		for (Board b : list) {
		%>
		<tr>
			<td style="font-size:14px;"><%=b.getBrdNo()%></td>
			<td style="padding-right: 15px; font-size:14px;"><%=b.getBrdTitle()%></td>
			<td style="padding-left: 15px; font-size:14px;"><%=b.getBrdContent()%></td>
			<td style="font-size:14px;"><%=b.getBrdDate()%></td>
		</tr>
		<%
		}
		%>
	</table>
  </div> --%>
  
  
  
  <div id="tab-2" class="tab-content current">

  <form action="/pet/addsuggest" method="get">
	<table width="500" align="center" cellspacing="5">

		<tr>
			<th width="150">글 제목</th>
			<td><input type="text" name="title" size="31" maxlength="50"
				placeholder="제목을 입력해주세요." required></td>
		</tr>

		<tr>
			<th width="150">내용</th>
			<td><textarea name="content" rows="5" cols="30"></textarea></td>
		</tr>

		<th colspan="2"><input type="submit" value="확인"
			id="submitBtn"></th>

	</table>
</form>
  </div>
  
  
  
  <div id="tab-3" class="tab-content">
  <form action="/pet/adddept" method="get" id="form">
		<table width="500" align="center" cellspacing="5">

			<tr>
				<th width="150">시설명</th>
				<td><input type="text" name="name" size="31" maxlength="50"
					placeholder="시설명을 입력해주세요." required></td>
			</tr>

			<tr>
				<th width="150">시설분류</th>
				<td><select name="type">
						<option selected>시설의 분류를 선택해주세요.</option>
						<option value="1">동물병원</option>
						<option value="2">반려동물용품점</option>
						<option value="3">장묘시설</option>
						<option value="4">위탁관리시설</option>
						<option value="5">문화시설</option>
						<option value="6">카페</option>
				</select></td>
			</tr>

			<tr>
				<th width="150">주소</th>
				<td><input type="text" name="address" size="31" maxlength="25"
					placeholder="주소를 입력해주세요." required></td>
			</tr>


			<tr>
				<th width="150">전화번호</th>
				<td><input type="tel" name="phone" size="31" maxlength="50"
					placeholder="전화번호를 입력해주세요."></td>
			</tr>

			<tr>
				<th width="150">운영시간</th>
				<td><input type="time" name="open" value="time" size="31" maxlength="50">
				 ~ <input type="time" name="close" value="time" size="31"
					maxlength="50"></td>
			</tr>

			<tr>
				<th width="150">동물크기제한</th>
				<td>
					<table>
						<tr>
							<td><input type="radio" name="animalSize" value="small">소형</td>
							<td><input type="radio" name="animalSize" value="regular">중형</td>
							<td><input type="radio" name="animalSize" value="big">대형</td>
							<td><input type="radio" name="animalSize" value="noLimit"
								checked>제한없음</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<th width="150">주차여부</th>
				<td><input type="radio" name="parking" value="Y"
					style="margin-left: 78px;"> 가능 <input type="radio"
					name="parking" value="N"> 불가능</td>
			</tr>

			<tr>
				<th width="150">입장료여부</th>
				<td><input type="radio" name="entFee" value="Y"
					style="margin-left: 78px;"> 있음 <input type="radio"
					name="entFee" value="N"> 없음</td>
			</tr>

			<tr>
				<th width="150">애견동반추가요금</th>
				<td><input type="radio" name="petFee" value="Y"
					style="margin-left: 78px;"> 있음 <input type="radio"
					name="petFee" value="N"> 없음</td>
			</tr>

			<tr>
				<th width="150">추가제한사항</th>
				<td><textarea rows="3" cols="30" name="restrict"></textarea></td>
			</tr>

			<th colspan="2"><input type="submit" value="등록요청하기"
				id="submitBtn"></th>

		</table>
	</form>
  </div>



  <div id="tab-4" class="tab-content">
  <form action="/pet/deldept" method="get">
	<table width="500" align="center" cellspacing="5">

		<tr>
			<th width="150">시설명</th>
			<td><input type="text" name="name" size="31" maxlength="15"
				placeholder="시설명을 입력해주세요." required></td>
		</tr>

		<tr>
			<th width="150">시설분류</th>
			<td><select name="type">
					<option selected>시설의 분류를 선택해주세요.</option>
					<option value="1">동물병원</option>
					<option value="2">반려동물용품점</option>
					<option value="3">장묘시설</option>
					<option value="4">위탁관리시설</option>
					<option value="5">문화시설</option>
					<option value="6">카페</option>
			</select></td>
		</tr>

		<th colspan="2"><input type="submit" value="삭제요청하기"
			id="submitBtn"></th>

	</table>
</form>
  </div>
 
</div>

</body>
</html>