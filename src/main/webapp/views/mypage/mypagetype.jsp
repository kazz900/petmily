<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/petmily/resources/js/main/main.js"></script>
<link rel="stylesheet" href="/petmily/resources/css/main/main.css">
</head>
<body>
	<h1 id="add">My petmily 추가</h1>
 <hr>
    <tr><th width="120">펫 이름을 입력해주세요 </th>
	<td><input type="text" >
	</td></tr>
	
	<p>펫 종류를 선택해주세요 </p>
		<td><input type="radio" id="dog" name="pet" value="dog">고양이</td>
	    <td><input type="radio" id="cat" name="pet" value="cat">강아지</td>
		<td><input type="radio" id="etc" name="pet" value="etc">모든 동물</td>
	
	
	<p>펫 체중을 선택해주세요 </p>
    	<td><input type="radio" id="small" name="pet" value="small"> 소형(10kg 미만) </td>
    	<td><input type="radio" id="midium"" name="pet" value="midium">중형(10kg 이상 25kg 미만)</td>
    	<td><input type="radio" id="larger" name="pet" value="large"> 대형(25kg 이상)</td>
  <hr>
  
   		<input class="additial" type="submit" value="추가하기"> &nbsp;
		<input id="cancel" type="reset" value="취소하기"> &nbsp;
		<a href="javascript:history.go(-1);">이전페이지로 이동</a>
    

</body>
</html>