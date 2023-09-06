<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="servicecenter.model.vo.Board, member.model.vo.Member, java.util.ArrayList"%>

<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	Board board = (Board)request.getAttribute("board");
	
	int nowpage = 1;
	if (request.getAttribute("currentPage") != null) {
		nowpage = ((Integer)request.getAttribute("currentPage")).intValue();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<link rel="stylesheet"
	href="/petmily/resources/css/servicecenter/serviceCenter.css">

<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript"
	src="/petmily/resources/js/info/infotap.js"></script>
	
<script type="text/javascript">

<%if (request.getAttribute("message") != null) { %>
	alert("건의사항이 수정되었습니다.");
<% } %>

</script>
<style type="text/css">
body{
	background: url('resources/images/admin/0905bg.png') left top fixed;
	background-size : cover;
}
</style>
</head>
<%@ include file="../common/main.jsp"%>

<body>
	<div class="info-content">
		<div class="info-detail02">

			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">고객 문의내역</li>
			</ul>

			<hr style="opacity: 0.5; margin: 0px;">



			<div id="tab-1" class="tab-content current">
				<% if (list != null) { %>
				<table id="outer" align="center" cellspacing="5" cellpadding="0">
					<tr>
						<th style="width: 80px;">번호</th>
						<th style="width: 200px;">제목</th>
						<th style="width: 310px;">글 내용</th>
						<th>현황</th>
						<th style="width: 110px;">작성일자</th>
					</tr>

					
					<% for (Board b : list) { %>
					<tr style="border-top: 1px solid black; border-bottom: 1px solid black;">
						<td style="font-size: 14px;"><%=b.getBrdNo()%></td>
						<td style="padding-right: 15px; font-size: 14px;"><%=b.getBrdTitle()%></td>
						
						<td style="padding-left: 15px; font-size: 14px;">
						<% if (b.getBrdReply() != null) { %>
						&nbsp; &nbsp; (답변완료)
						<% } %>
						<a href="/petmily/bdetail?bnum=<%=b.getBrdNo()%>&page=<%=nowpage%>">
						<%=b.getBrdContent()%></a></td>
						
						<td style="font-size:12px;">
						<% if (b.getBrdResult().equals("n")) { %>
						접수
						<% } else if (b.getBrdResult().equals("y")) { %>
						답변완료
						<% } %>
						</td>
						
						
						<td style="font-size: 10px;"><%=b.getBrdDate()%></td>
					</tr>
					<% } %>

				</table>
					<% } else { %>
					    <h1>아직 문의사항이 없습니다.</h1>
					<% } %>
					<%@ include file="../common/pagingView_admin.jsp" %>
			</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>