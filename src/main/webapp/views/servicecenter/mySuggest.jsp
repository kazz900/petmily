<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Petmily</title>
<style type="text/css">

input[type=text]{
	width:450px;
}

form table tr textarea {
	width:450px;
}


</style>
<!-- <link rel="stylesheet" href="/petmily/resources/css/dCommon/mySuggest.css"> -->
<script type="text/javascript"
	src="/pet/resources/js/jquery-3.7.0.min.js"></script>

</head>
<body>
<%@ include file="dCommon/menubar.jsp" %>
<form action="/petmily/addsuggest" method="get">
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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
</body>
</html>