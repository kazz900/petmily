<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.ArrayList, department.model.vo.Department, java.sql.Date"%>
<%
ArrayList<Department> list = (ArrayList<Department>) request.getAttribute("list");
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
#chggrade {
	border-radius:5px;
    background-color: hsl(36deg 70.37% 68.61%);
    font-family: 'Surround';

}
div#tab-1{
	width: 1050px;
	height: 720px;
	overflow: auto;
}
form.sform {
	background: lightgray;
	width: 630px;
	left: 400px;
	display: none;  
	}
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
<body>
	<%@ include file="../common/main.jsp"%>
	<div class="block" style="text-align: center;">
	<form id="idform" class="block" action="/petmily/adf" method="post">
		<!-- <input type="hidden" name="action" value="id">  -->
			<fieldset>
				<legend>검색하실 업체명을 입력하세요.</legend>
				<input type="search" name="keyword" id="key" value="<%= keyword %>">
				
				<input type="submit" id="csssearch" value="검색">
			</fieldset>
		</form>	
		<h1 class="block" style="text-align: center; margin-top: 0;">업체 삭제</h1>
		<h4 align="center">업체 <%= list.size()%> 개 조회</h5>
	<div id="tab-1" class="block" style="text-align: center; margin-top: 0;">
		<table id="outer" align="center" border="1" cellspacing="0"
			cellpadding="3">
			<tr>
				<th>등록번호</th>
				<th>시설종류</th>
				<th width="150px">시설명</th>
				<th width="150px">전화번호</th>
				<th width="350px">주소</th>
				<th>삭제요청</th>
				<th>삭제</th>
			</tr>
			<%
			if(list.size() >0){
			for (Department dept : list) {
			%>
			<tr>
				<td><%=dept.getDeptSeq()%></td>
				<td><%=dept.getDeptType()%></td>
				<td><%=dept.getDeptName()%></td>
				<td><%=dept.getDeptPhone()%></td>
				<td><%=dept.getDeptAddress()%></td>
				<td><%=dept.getDeptDeleteOk()%></td>
				<td><input type="button" value="삭제" id="chggrade" 
					onclick="location.href='/petmily/deptter?deptSeq=<%=dept.getDeptSeq()%>&keyword=<%= keyword %>';
							return false;"></td>
			</tr>
			
			<%
			}
			}else{ %>
			<tr>
				<td colspan="7">
				검색결과없음
				</td>
			</tr>		
			<% } %>
		</table>
	</div>

</body>
</html>