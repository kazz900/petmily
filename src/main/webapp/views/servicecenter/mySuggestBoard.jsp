<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="servicecenter.model.vo.Board, java.util.ArrayList"%>

<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>

<link rel="stylesheet" href="/petmily/resources/css/servicecenter/myContentLog.css">
<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>

</head>
<body>
<%@ include file="dCommon/menubar.jsp"%>

	<table id="outer" align="center" cellspacing="5" cellpadding="0">
<!-- 		<tr>
			
		</tr> -->
		<tr>
			<th style="width: 100px;">No.</th>
			<th style="width: 200px;">Title</th>
			<th style="width: 310px;">Content</th>
			<th style="width: 110px;">Date</th>
		</tr>
		<%
		for (Board b : list) {
		%>
		<tr>
			<td style="font-size:14px;"><%=b.getBrdNo()%></td>
			<td style="padding-right: 15px; font-size:14px;"><%=b.getBrdTitle()%></td>
			<td style="padding-left: 15px; font-size:14px;"><%=b.getBrdContent()%></td>
			<td style="font-size:14px;"><%=b.getBrdDate()%></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>