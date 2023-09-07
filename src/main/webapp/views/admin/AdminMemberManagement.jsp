<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.ArrayList, member.model.vo.Member, java.sql.Date"%>
<%
ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
String keyword = (String)request.getAttribute("keyword");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<style type="text/css">
@media ( min-width : 1050px) {
	.block {
		width: 1050px;
		margin: 98px auto 0 auto;
		word-wrap: break-word;
		font-family: 'Surround';
	}
}
form#tab-0 {
	border-radius:5px;
 	margin: 10px auto;
}
form#tab-1 {
	border-radius:5px;
	width: 1050px;
	height: 800px;
	overflow : auto;
}
#chggrade {
	border-radius:5px;
    background-color: hsl(36deg 70.37% 68.61%);
    font-family: 'Surround';

}
body{
	background: url('resources/images/admin/0905bg.png') left top fixed;
	background-size : cover;
}
#csssearch {
	margin-top:5px;
	margin-bottom:15px; 
	width:100px; 
	height:35px; 
	border-radius:5px; 
	border:none;
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	

	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,1) 0%, rgba(218,131,0,1) 100%);
}

#csssearch:hover {
	background: transparent;
	background: rgba(230,154,55,1);
}
#chggrade {
	margin-top:0px;
	margin-bottom:0px; 
	width:50px; 
	height:20px; 
	border-radius:5px; 
	border:none;
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	

	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,1) 0%, rgba(218,131,0,1) 100%);
}

#chggrade:hover {
	background: transparent;
	background: rgba(230,154,55,1);
	}
</style>
<link rel="stylesheet" href="/petmily/resources/css/admin/adminmain.css">

<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript"
	src="/petmily/resources/js/info/infotap.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function() {

		
	});	
	
	function send(seq, grade) {
		var id = document.getElementById("key").value;
		console.log(id);
		location.href = "/petmily/admmm?memberSeq=" + seq + "&memberGrade=" + grade + "&memberId=<%= keyword %>"; 		
	}
	
	</script>
<body>
	<%@ include file="../common/main.jsp"%>
<br>
<div class="block" style="text-align: center;">
<form id="idform" class="block" action="/petmily/amss" method="post">
<fieldset>
	<legend>검색할 아이디를 입력하세요.</legend>
	<input type="search" name="keyword" id="key" value="<%=keyword%>">
	<input type="hidden" name="action" value="id">
	<input type="submit" id="csssearch" value="검색">
</fieldset>
<br>

</form>
	<h1 style="text-align: center; margin-top: 0;">회원등급 변경</h1>
	<h4 align="center">회원 <%= list.size()%> 명 조회</h5>
	<form id="tab-1" class="block" style="text-align: center; margin-top: 0;">
		<table id="outer" align="center" border="1" cellspacing="0"
			cellpadding="3">
			<tr>
				<th color="hsl(30.46deg 58.9% 45.68%)">등록번호</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>닉네임</th>
				<th>회원등급</th>
				<th>변경</th>
			</tr>
			<%
			if (list.size() > 0){
			for (Member mem : list) {
			%>
			<tr>
				<td><%= mem.getMemberSeq()%></td>
				<td><%= mem.getMemberId() %></td>
				<td><%= mem.getMemberEmail()%></td>
				<td><%= mem.getMemberNick()%></td>
				<td>
				<% if(mem.getMemberGrade().equals("1")) { %>
					일반회원
				<% }else if(mem.getMemberGrade().equals("2")) {%>
					정지회원
				<% } %>
				</td>
				<td><input type="button" value="변경" id="chggrade" 
					onclick="send('<%= mem.getMemberSeq() %>', '<%= mem.getMemberGrade() %>'); return false"></td>
			</tr>
			<%
			}
			}else{ %>
			<tr>
				<td colspan="6">
				검색결과없음
				</td>
			</tr>				
			<% } %>
			
		</table>
	</form>


</body>
</html>