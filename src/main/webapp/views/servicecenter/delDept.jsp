<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Petmily</title>
<link rel="stylesheet" href="/petmily/resources/css/servicecenter/delDept.css">
<script type="text/javascript"
	src="/pet/resources/js/jquery-3.7.0.min.js"></script>

</head>
<body>
<%@ include file="dCommon/menubar.jsp" %>
<form action="/petmily/deldept" method="get">
	<table width="500" align="center" cellspacing="5">

		<tr>
			<th width="150">시설명</th>
			<td><input type="text" name="name" size="31" maxlength="15"
				placeholder="시설명을 입력해주세요." required></td>
		</tr>

<!-- 		<tr>
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
		</tr> -->
		
		<tr>
			<th width="150">주소</th>
			<td><input type="text" name="address" size="31" maxlength="25"
				placeholder="주소를 입력해주세요." required></td>
		</tr>

		<th colspan="2"><input type="submit" value="삭제요청하기"
			id="submitBtn"></th>

	</table>
</form>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
</body>
</html>