<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<script type="text/javascript" src="/testq/resources/js/jquery-3.7.0.min.js"></script>
<style type="text/css">
body h1 {
      font-family: 'Surround', sans-serif;
    }
    form {
      text-align: center; /* form 요소 내부의 내용을 가운데 정렬 */
      margin: 0 auto; /* 가운데 정렬을 위한 외부 여백 조정 */
      width: 350px; /* 폼의 너비 설정 */
      height: auto;
      border: 1px solid black;
    }
 td input:not(#checkpassword) {
 width: 250px;
 height: 30px;
 border-radius: 3px;
 background-color: #c5c5c5;
/* display: flex;
justify-content: space-between; */
 }
 td input#dupcheck {
 width: 80px;
 height: 34px;
 border-radius: 3px;
   background-color: #39f;
 }
 td input#dupcheck2 {
 width: 80px;
 height: 34px;
 border-radius: 3px;
   background-color: #39f;
 }
 hr {
 width: 100%;
 }
 input[type=submit] {
  width: 340px;
 height: 34px;
 border-radius: 3px;
 margin-right: 3px;
 background-color: #39f;
 }
/*      ::placeholder {
      color: red; /* 힌트 텍스트의 색상을 빨간색으로 설정 */
      font-style: italic; /* 힌트 텍스트의 글꼴을 기울임체로 설정 */ 
    }*/
 input[type=password] {
 width: 400px;
 height: 30px;
 border-radius: 3px;
 background-color: #c5c5c5;
/* display: flex;
justify-content: space-between; */
 }
 #checkpassword {
 font-size: 7pt;
 color: #ff6633;
 width:auto;
 height:auto;
 border: none;
 margin: 0px;
 padding: 0px;
 white-space: pre-line;
 }
</style>
<script type="text/javascript"></script>
</head>
<body>
<h1 align="center">Petmily</h1> <!-- 추후 include처리 -->
<h2 align="center">회원가입</h2> <!-- 추후 include처리 -->
<form>
<table>
<tr><td><input type="text" id="userid" name="userid" placeholder="사용할 아이디 입력" required> 
</td><td><input type="button" value="중복확인" id="dupcheck" onclick="#"></td></tr>
<tr><td><input type="password" id="userpwd" name="userpwd" placeholder="사용할 패스워드 입력"required></td></tr>
<tr><td><input type="password" id="userpwd2" placeholder="패스워드 확인"required></td></tr>
<tr><td><div id="checkpassword">패스워드는 영어 대소문자와 @, !, #, $중 하나의 기호를 포함하여 6~12자로 작성해주세요.</div></td></tr>
<tr><td><input type="text" id="nname" name="nname" placeholder="사용할 닉네임 입력" required><!--  &nbsp;  &nbsp;  -->
<tr><td><input type="email" name="email" placeholder="Email" required><!--  &nbsp;  &nbsp;  -->
</td><td><input type="button" value="중복확인" id="dupcheck2" onclick="#"></td></tr>
</table>
<input type="submit" value="가입하기"> &nbsp;
</form>
<br>
<%@ include file="../common/footer.jsp" %>
</body>
</html>