<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,pet.model.vo.Pet"%>
<%

ArrayList<Pet> list = (ArrayList<Pet>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<link rel="stylesheet" href="/petmily/resources/css/mypage/myp.css">

<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript"
	src="/petmily/resources/js/info/infotap.js"></script>

</head>
<%@ include file="../common/main.jsp"%>

<body>
	<div class="info-content">
		<div class="info-detail02">

			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">나의 펫정보</li>
				<li class="tab-link" data-tab="tab-2">나의 게시물 목록</li>
				<li class="tab-link" data-tab="tab-3">나의 정보</li>
			</ul>

			<hr style="opacity: 0.5; margin: 0px;">



			<div id="tab-1" class="tab-content current">
				<p class="welcome">
					<%= member.getMemberNick() %>님 환영합니다!
				</p>

				<h3>나의 펫밀리</h3>
				<a href="views/mypage/addpet.jsp">펫 밀리 추가하러 가기</a>


				<legend>My petmily</legend>

				<div class="my_pet_tab">
					<div class="my_pet_table">
						<table id="outer" align="center" width="100" cellspacing="5"
							cellpadding="0">

							<tr>
								<th>펫 이름</th>
								<th>펫 종류</th>
								<th>펫 사이즈</th>
								<th>수정하기</th>
								<th>삭제하기</th>
							</tr>
							
							
                            
                            
							<% for(Pet p : list){ %>
							<tr>
								<td><%= p.getPetName() %></td>
								<td><%= p.getPetType() %></td>
								<td><%= p.getPetSize() %></td>
								<td><button onclick="javascript:location.href='/petmily/moveup?memberseq=<%= p.getMemberSeq() %>&petseq=<%= p.getPetSeq() %>';">수정</button></td>
								<td><button onclick="editPet('<%= p.getPetName() %>')">삭제</button></td>
							</tr>
							<% } %>

						</table>
					</div>

					&nbsp;
				</div>
				
				





				<!-- <table align="left" border="1" cellspacing="0" cellpadding="3">
		 		
		 
					<tr>
		
						
					</tr>
		
	
		
					<tr>
			
			
					</tr>
		
				</table> -->



			</div>
			<!-- tab-1 end -->



			<div id="tab-2" class="tab-content"></div>



			<div id="tab-3" class="tab-content">

				<h1 align="center">회원 정보 조회 및 수정 페이지</h1>
				<br>

				<h3>Change Info</h3>



				<table id="outer" align="center" width="500" cellspacing="5"
					cellpadding="0">
					<tr>
						<th colspan="2">등록된 회원정보는 아래와 같습니다.<br> 수정할 내용이 있으면 변경하고
							수정하기 버튼을 누르세요.
						</th>
					</tr>
					<tr>
						<th width="140">아이디</th>
						<td><input type="text" name="userid" value="추후 데이터가 들어갈 예정임"
							readonly>
					<tr>
						<th width="140">이메일</th>
						<td><input type="text" name="emaim" value="추후 데이터가 들어갈 예정임">
						</td>
					</tr>




					</div>






					</div>
					</div>
</body>
</html>