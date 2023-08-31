<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="servicecenter.model.vo.Board, member.model.vo.Member, java.util.ArrayList"%>

<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<link rel="stylesheet"
	href="/petmily/resources/css/servicecenter/serviceCenter.css">

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
				<li class="tab-link current" data-tab="tab-1">나의 문의내역</li>
				<li class="tab-link" data-tab="tab-2">건의사항 작성</li>
				<li class="tab-link" data-tab="tab-3">업체 등록요청</li>
				<li class="tab-link" data-tab="tab-4">업체 삭제요청</li>
			</ul>

			<hr style="opacity: 0.5; margin: 0px;">



			<div id="tab-1" class="tab-content current">
				<table id="outer" align="center" cellspacing="5" cellpadding="0">
					<tr>
						<th style="width: 80px;">No.</th>
						<th style="width: 200px;">Title</th>
						<th style="width: 310px;">Content</th>
						<th>Progress</th>
						<th style="width: 110px;">Date</th>
					</tr>
					<%
					if (list != null) {
					%>
					<%
					for (Board b : list) {
					%>
					<tr style="border-top: 1px solid black; border-bottom: 1px solid black;">
						<td style="font-size: 14px;"><%=b.getBrdNo()%></td>
						<td style="padding-right: 15px; font-size: 14px;"><%=b.getBrdTitle()%></td>
						
						<td style="padding-left: 15px; font-size: 14px;">
						<a href="/petmily/bdetail?bnum=<%=b.getBrdNo()%>">
						<%=b.getBrdContent()%></a></td>
						
						<td style="font-size:12px;"><%=b.getBrdResult()%></td>
						<td style="font-size: 10px;"><%=b.getBrdDate()%></td>
					</tr>
					<%
					}
					%>

					<%
					} else {
					%>
					<tr>
						<td style="font-size: 14px;"></td>
						<td style="padding-right: 15px; font-size: 14px;"></td>
						<td style="padding-left: 15px; font-size: 14px;"></td>
						<td style="font-size: 14px;"></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>



			<div id="tab-2" class="tab-content">
				<form action="/petmily/addsuggest" method="get">
					<input type="hidden" name="result" value="접수">
					<input type="hidden" name="mNo" value="<%=member.getMemberSeq()%>">
					
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
				<form action="/petmily/adddept" method="get" id="form">
					<input type="hidden" name="loginOk" value="N">
					<input type="hidden" name="deleteOk" value="N">
					<table width="500" align="center" cellspacing="5">

						<tr>
							<th width="150">시설명</th>
							<td><input type="text" name="name" size="31" maxlength="50"
								placeholder="시설명을 입력해주세요." required></td>
						</tr>

						<tr>
							<th width="150">시설분류</th>
							<td><select name="type" style="width: 288px; height: 36px;">
									<option selected>시설의 분류를 선택해주세요.</option>
									<option value="1">동물병원</option>
									<option value="2">미용시설</option>
									<option value="1/2">의료/미용</option>
									<option value="3">반려동물용품점</option>
									<option value="4">위탁관리시설</option>
									<option value="5">장묘시설</option>
									<option value="6">식당/카페</option>
									<option value="7">호텔/펜션</option>
									<option value="8">문화시설</option>
							</select></td>
						</tr>

						<tr>
							<th width="150">주소</th>
							<td><input type="text" name="address" size="31"
								maxlength="25" placeholder="주소를 입력해주세요." required></td>
						</tr>


						<tr>
							<th width="150">전화번호</th>
							<td><input type="tel" name="phone" size="31" maxlength="50"
								placeholder="전화번호를 입력해주세요."></td>
						</tr>

						<tr>
							<th width="150">운영시간</th>
							<td><input type="time" name="open" value="time" size="31"
								maxlength="50" style="width: 128px;"> ~ <input
								type="time" name="close" value="time" size="31" maxlength="50"
								style="width: 129px;"></td>
						</tr>

						<tr class="yes">
							<th width="150">동물크기제한</th>
							<td>
								<table>
									<tr>
										<td><input type="radio" name="animalSize" value="1">소형</td>
										<td><input type="radio" name="animalSize" value="2">중형</td>
										<td><input type="radio" name="animalSize" value="3">대형</td>
										<td><input type="radio" name="animalSize" value="0"
											checked>제한없음</td>
									</tr>
								</table>
							</td>
						</tr>

						<tr class="yes">
							<th width="150">주차여부</th>
							<td><input type="radio" name="parking" value="1"
								style="margin-left: 78px;"> 가능 <input type="radio"
								name="parking" value="0"> 불가능</td>
						</tr>

						<tr class="yes">
							<th width="150">입장료여부</th>
							<td><input type="radio" name="entFee" value="1"
								style="margin-left: 78px;"> 있음 <input type="radio"
								name="entFee" value="0"> 없음</td>
						</tr>

						<tr>
							<th width="150">애견동반추가요금</th>
							<td><input type="radio" name="petFee" value="1"
								style="margin-left: 78px;"> 있음 <input type="radio"
								name="petFee" value="0"> 없음</td>
						</tr>

						<tr>
							<th width="150">추가제한사항</th>
							<td><textarea rows="3" cols="30" name="restrict"></textarea></td>
						</tr>

						<th colspan="2"><input type="submit" value="등록요청하기"
							id="submitBtn" class="w-btn-neon2"></th>


					</table>
				</form>
			</div>



			<div id="tab-4" class="tab-content">
				<form action="/petmily/deldept" method="get">
				<input type="hidden" name="deleteOk" value="Y">
					<table width="500" align="center" cellspacing="5">

						<tr>
							<th width="150">시설명</th>
							<td><input type="text" name="name" size="31" maxlength="15"
								placeholder="시설명을 입력해주세요." required></td>
						</tr>

						<tr>
							<th width="150">주소</th>
							<td><input type="text" name="address" size="31"
								maxlength="25" placeholder="주소를 입력해주세요." required></td>
						</tr>

						<th colspan="2"><input type="submit" value="삭제요청하기"
							id="submitBtn"></th>

					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>