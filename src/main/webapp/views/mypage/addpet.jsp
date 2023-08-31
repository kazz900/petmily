<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pet 추가</title>

<link rel="stylesheet"
	href="/petmily/resources/css/mypage/myp.css">

<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript"
	src="/petmily/resources/js/info/infotap.js"></script>




</head>


<body>
<%@ include file="../common/main.jsp" %>

 <h1 id="add">My petmily 추가</h1>
 <form action="/petmily/peten" method="get" id="form">
					<input type="hidden" name="commitment" value="N">
					<table width="500" align="center" cellspacing="5">

						<tr>
							<th width="150">펫밀리 이름</th>
							<td><input type="text" name="petname" size="31" maxlength="50"
								placeholder="펫밀리 이름을 입력해주세요." required></td>
						</tr>
						
						
						
						<tr class="yes">
							<th width="300">펫밀리 종류</th>
							<td>
								<table>
									<tr>
										<td><input type="radio" name="pettype" value="0">고양이 </td>
										<td><input type="radio" name="pettype" value="1">강아지</td>
										<td><input type="radio" name="pettype" value="2">모든 동물</td>
										
									</tr>
								</table>
							</td>
						</tr>
						
						<tr class="yes">
							<th width="300">펫밀리 사이즈 </th>
							<td>
								<table>
									<tr>
										<td><input type="radio" name="petsize" value="small">소형(10kg 미만) </td>
										<td><input type="radio" name="petsize" value="regular">중형(10kg 이상 25kg 미만)</td>
										<td><input type="radio" name="petsize" value="big">대형(25kg 이상)</td>
											<input type="hidden" name="memberSeq" value="<%= member.getMemberSeq() %>">										
									</tr>
								</table>
							</td>
						</tr>

						
						
						<th colspan="2"><input type="submit" value="펫 등록하기"
							id="submitBtn"></th>


					</table>
				</form>
			</div>
 
</body>
</html>