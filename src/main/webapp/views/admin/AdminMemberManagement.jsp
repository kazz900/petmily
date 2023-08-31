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
div#tab-0 {
 	margin: 10px auto;
}
div#tab-1 {
	width: 1050px;
	height: 800px;
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
<div id="tab-0">
<br>
<form id="idform" class="block" action="/petmily/amss" method="post">
<fieldset>
	<legend>검색할 아이디를 입력하세요.</legend>
	<input type="search" name="keyword"> <br>
	<input type="hidden" name="action" value="id">
	<input type="submit" value="검색">
</fieldset>
</form>
<br>

</div>
	<h1 align="center">회원등급 변경</h1>
	<div id="tab-1" class="block">
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
				<td><input type="button" value="변경"
					onclick="location.href='/petmily/admmm?memberSeq=<%= mem.getMemberSeq()%>&memberGrade=<%= mem.getMemberGrade() %>';
							return false;"></td>
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
	</div>


</body>
</html>