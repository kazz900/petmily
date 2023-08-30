<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.ArrayList, department.model.vo.Department, java.sql.Date"%>
<%
ArrayList<Department> list = (ArrayList<Department>) request.getAttribute("list");
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
				<th>시설종류</th>
				<th>시설명</th>
				<th>주소</th>
				<th>등록</th>
			</tr>
			<%
			for (Department dept : list) {
			%>
			<tr>
				<td><%=dept.getDeptSeq()%></td>
				<td><%=dept.getDeptType()%></td>
				<td><%=dept.getDeptName()%></td>
				<td><%=dept.getDeptAddress()%></td>
				<td><input type="button" value="등록"
					onclick="location.href='/petmily/deptins?deptSeq=<%=dept.getDeptSeq()%>';
							return false;"></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
</body>
</html>