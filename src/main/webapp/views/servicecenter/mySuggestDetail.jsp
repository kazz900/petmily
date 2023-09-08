<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servicecenter.model.vo.Board"%>
    
<%
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 건의사항</title>
<script type="text/javascript">
function toEdit(){
	location.href="/petmily/suggestDetail?bno=<%=board.getBrdNo()%>";
}

function toAddReply(){
	location.href="/petmily/adminSuggestDetail?bno=<%=board.getBrdNo()%>";
}
</script>
<style type="text/css">
div.upper {
	margin-top: 150px;
	font-family: OhsquareAir;
	width: 500px;
	margin: 100px auto 0;
	text-align: center;
/* 	border: 2px solid #cfcfcf; */
	padding: 20px;
}

button {
	margin-top:5px;
	margin-bottom:15px; 
	width:100px; 
	height:30px; 
	border-radius:5px; 
	border:1px solid rgba(200,124,25,0.2);
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	
	
	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,1) 0%, rgba(218,131,0,1) 100%);
}

button:hover {
	background: transparent;
	background: rgba(230,154,55,1);
}


</style>
</head>
<body>
<%@ include file="../common/main.jsp"%>
<div class="upper">
	<h1 style="margin-bottom:10px;"><%=board.getBrdTitle()%></h1>
	<hr>
	<h5 style="margin:0">작성일자 : <%=board.getBrdDate() %></h5>
	<h5 style="margin:5px auto">처리현황 : <%=board.getBrdResult() %></h5>
	<hr>
	<% if (board.getBrdReply() != null) { %>
	<div class="content" 
	style="height:300px; border:2px solid #cfcfcf; 
	padding:5px 15px 5px 15px; text-align:left;">
		<p><%=board.getBrdContent()%></p>
	</div>
	
	<div class="reply" 
	style="height:200px; border:2px solid #cfcfcf; 
	padding:5px 15px 5px 15px; text-align:left;">
		<p><%=board.getBrdReply()%></p>
	</div>
	
	<% } else { %>
		<div class="content" 
		style="height:500px; border:2px solid #cfcfcf; 
		padding:5px 15px 5px 15px; text-align:left;">
		<p><%=board.getBrdContent()%></p>
	</div>
	<% } %>
	
	<% if (member.getMemberGrade().equals("1")) { %>
	<button class="toListBtn" onclick="history.go(-1);" 
	style="margin-top:20px;">목록으로</button>
	
	<button class="editText" style="margin-top:20px;" 
	onclick="toEdit();">수정하기</button>
	
	<% } else if (member.getMemberGrade().equals("0")) { %>
	<button class="toListBtn" onclick="history.go(-1);" 
	style="margin-top:20px;">목록으로</button>
	
	<button class="addReply" style="margin-top:20px;" 
	onclick="toAddReply();">답변하기</button>
	<% } %>
</div>

</body>
</html>