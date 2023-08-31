<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.ArrayList, member.model.vo.Member, java.sql.Date"%>
<%
ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
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
	}
}
div#tab-1 {
	width: 1050px;
	height: 720px;
	overflow : auto;
}
</style>
<link rel="stylesheet" href="/petmily/resources/css/admin/adminmain.css">

<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript"
	src="/petmily/resources/js/info/infotap.js"></script>
<body>
	<%@ include file="../common/main.jsp"%>

	<div id="tab-1" class="block">
		<table id="outer" align="center" border="1" cellspacing="0"
			cellpadding="3">
			<tr>
				<th>등록번호</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>닉네임</th>
				<th>회원등급</th>
				<th>변경</th>
			</tr>
			<%
			for (Member mem : list) {
			%>
			<tr>
				<td><%= mem.getMemberSeq()%></td>
				<td><%= mem.getMemberId() %></td>
				<td><%= mem.getMemberEmail()%></td>
				<td><%= mem.getMemberNick()%></td>
				<td><%= mem.getMemberGrade()%></td>
				<td><input type="button" value="변경"
					onclick="location.href='/petmily/admmm?memberSeq=<%= mem.getMemberSeq()%>';
							return false;"></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>


</body>
</html>