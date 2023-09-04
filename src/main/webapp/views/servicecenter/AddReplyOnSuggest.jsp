<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servicecenter.model.vo.Board"%>
<%
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>

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

div.content p textarea {
	font-family: OhsquareAir;
}

</style>

</head>
<body>
<%@ include file="../common/main.jsp"%>
<div class="upper">
<form action="/petmily/addAdminReply">
	<input type="hidden" name="userid" value="<%=member.getMemberSeq()%>">
	<input type="hidden" name="boardNo" value="<%=board.getBrdNo()%>">
	<input type="hidden" name="result" value="<%=board.getBrdResult() %>">
	
	<h1 style="margin-bottom:10px;">제목 : 
		<input type="text" name="title" value="<%=board.getBrdTitle()%>" style="height:35px; font-size:20px; font-weight:bold; text-align:center;">
	</h1>
	
	<hr>
	
	<h5 style="margin:0">작성일자 : <%=board.getBrdDate() %></h5>
	
	<h5 style="margin:5px auto">처리현황 : <%=board.getBrdResult() %></h5>
	
	<hr>
	
	<div class="content" style=" height:300px; border:2px solid #cfcfcf; padding:5px 15px 5px 15px;">
		<p>
			<textarea name="content" style=" width:430px; height:450px; 
			padding:10px 15px 5px 15px; text-size:20px;"><%=board.getBrdContent()%></textarea>
		</p>
	</div>
		<div class="content" style=" height:200px; border:2px solid #cfcfcf; padding:5px 15px 5px 15px;">
		<p>
			<textarea name="reply" style=" width:430px; height:450px; 
			padding:10px 15px 5px 15px; text-size:20px;" placeholder="답변을 작성해주세요."></textarea>
		</p>
	</div>
	
	<input type="button" onclick="history.go(-1);" value="수정취소">
	<input type="submit" value="수정하기">
</form>
</div>

</body>
</html>