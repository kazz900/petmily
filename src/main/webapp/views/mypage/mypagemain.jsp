<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
 h1 {
 
  font-size: 45px; 
  color:red;
 }
 
 ul {
 list-style-type:none;
 }
 
 li {
  float: left;
  margin-left: 100px;
 
 }
 .clear{
  clear:both;
 }
 
 h3{
  color: blue;
  font-size: 30px;
  margin-top: 60px;
  margin-left: 90px;
 
 }
 
 .welcome {
  colro: green;
  font-size: 25px;
  margin-top: 60px;
  
 }
 
 table {
  
  margin-top: 80px;
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

th {
  background-color: #f2f2f2;
}
 
.my-button {
      padding: 10px 20px;
      background-color: #3498db;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    .my-button:hover {
      background-color: #2980b9;
    } 

 

</style>
<body>
<h1 align="center">My Page</h1>
<br>
  <ul>
    
	<a href="/petmily/views/mypage/board.jsp"><li> 나의 게시물 목록 </li></a>
	<a href="/petmily/views/mypage/center.jsp"><li> 나의 문의 내역 </li></a>
	<a href="/petmily/views/mypage/Member.jsp"><li>내 정보 </li></a>
	
  </ul>

	
	
	<p class="welcome"> 님 환영합니다! </p>

	<h3>나의 펫밀리</h3> 
	
	
     <fieldset>
 		<legend>My petmily</legend>
 		<ol>
 			<li>
 			  <label for="prod">Petmily 이름</label>
 			  <input type="text" size="25" >
 			</li>
 			<li>
 				<label for="num">Petmily 종</label>
 				<input type="text" size="25">
 			</li>
 			<li>
 				<label for="num">Petmily 체중</label>
 				<input type="text" size="25">
 			</li>
 			
 		</ol>
 	</fieldset>

  
 	
  


   
 			
 			
   
   
  </div>
</div>


    
</body>
</body>
</html>