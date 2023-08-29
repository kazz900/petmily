<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<link rel="stylesheet" href="/petmily/resources/css/servicecenter/addDept.css">

</head>
<body>
<%@ include file="dCommon/menubar.jsp" %>

<form action="/petmily/adddept" method="get" id="form">
<input type="hidden" name="commitment" value="N">
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

</body>
</html>