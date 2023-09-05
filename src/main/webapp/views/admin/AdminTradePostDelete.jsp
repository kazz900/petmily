<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="java.util.ArrayList, admin.model.vo.AdminPost, java.sql.Date, member.model.vo.Member" %>
		<% ArrayList<AdminPost> list = (ArrayList<AdminPost>)request.getAttribute("list");
				int count = list.size();
				Member m = (Member)session.getAttribute("member");
				String keyword = (String)request.getAttribute("keyword");
				String action = (String)request.getAttribute("action");
				%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Community</title>
<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">

<script type="text/javascript">
$(function(){			
	$('input[name=item]').on('change', function(){
		console.log("??");
		$('input[name=item]').each(function(index){
			if($(this).is(':checked')){
				$('form.sform').eq(index).css('display', 'block');
			}else{
				$('form.sform').eq(index).css('display', 'none');
			}
		});  
	});  
}); 
$(function(){
	$('input[name=item]').each(function(index){
		if($(this).is(':checked')){
			$('form.sform').eq(index).css('display', 'block');
		}else{
			$('form.sform').eq(index).css('display', 'none');
		}
	});  
});  

$(function(){
	$('input[name=item]').each(function(index){
		if($(this).is(':checked')){
			$('form.sform').eq(index).css('display', 'block');
		}else{
			$('form.sform').eq(index).css('display', 'none');
		}
	});  
});

function testbtn(seq, keyword){	

	var item = document.getElementsByName('item');
	console.log(item);
	console.log(seq);
	console.log(keyword);
}

</script>
<style type="text/css">
@media ( min-width : 1050px) {
	.block {
		width: 1050px;
		margin: 98px auto 0 auto;
		word-wrap: break-word;
	}
}
div#tab-0 {
	border-radius:5px;
 	margin: 10px auto;
}
form#tab-1 {
	border-radius:5px;
	width: 1050px;
	height: 720px;
	overflow : auto;
}
#chggrade {
	border-radius:5px;
    background-color: hsl(36deg 70.37% 68.61%);
    font-family: 'Surround';

}
form.sform {
	background: lightgray;
	width: 630px;
	left: 400px;
	display: none;  
}
</style>
<link rel="stylesheet" href="/petmily/resources/css/admin/adminmain.css">
	src="/petmily/resources/js/info/infotap.js"></script>
</head>

<body>
	
	<%@ include file="../common/main.jsp"%>
	<p>
	<div class="block" align="center">
		 <fieldset id="ss">
			<legend>검색할 항목을 선택하세요.</legend>
			<input type="radio" name="item" id="memberid"> 회원 아이디 &nbsp; 
			<input type="radio" name="item" id="content"> 내용 &nbsp; 
			<input type="radio" name="item" id="membergrade"> 회원등급 &nbsp; 
		</fieldset>
		<br>
		<form id="idform" class="sform" action="/petmily/atps" method="post">
		<input type="hidden" name="action" value="id"> 
			<fieldset>
				<legend>검색할 아이디를 입력하세요.</legend>
				<input type="search" name="keyword" id="key" value="<%= keyword %>">
				
				<input type="submit" id="csssearch" value="검색">
			</fieldset>
		</form>
		
		<form id="contentform" class="sform" action="/petmily/atps" method="post">
		<input type="hidden" name="action" value="content"> 
			<fieldset>
				<legend>검색할 내용을 입력하세요.</legend>
				<input type="search" name="keyword" id="keyc" value="<%= keyword %>">
				
				<input type="submit" id="csssearch" value="검색">
			</fieldset>
		</form>
		<form id="gradeform" class="sform" action="/petmily/atps" method="post">
		<input type="hidden" name="action" value="grade"> 
			<fieldset>
				<legend>회원 등급을 입력하세요.</legend>
				<input type="radio" name="keyword" value="1"> 일반회원 &nbsp;
				<input type="radio" name="keyword" value="2"> 정지회원 &nbsp;
				<input type="submit" value="검색">
			</fieldset>
		</form>
	</div>
	<br>
	<hr>
	</p>
	<h1 align="center">거래 게시글 관리</h1>
	<h4 align="center">게시물 <%= list.size()%> 개 조회</h5>
	<form id="tab-1" class="block">
		<table id="outer" align="center" border="1" cellspacing="0"
			cellpadding="3">
			<tr>
				<th color="hsl(30.46deg 58.9% 45.68%)">게시번호</th>
				<th>회원번호</th>
				<th>회원등급</th>
				<th>아이디</th>
				<th>닉네임</th>
				<th width="550px">내용</th>
				<th>삭제</th>
			</tr>
			<%
			if(list.size() >0){
			for (AdminPost adm : list) {
			%>
			<tr>
				<td><%= adm.getPostSeq() %>
				<td><%= adm.getMemberSeq() %></td>
				<td><%= adm.getMemberGrade() %></td>
				<td><%= adm.getMemberId() %></td>
				<td><%= adm.getMemberNick() %></td>
				<td><%= adm.getPostContent() %></td>
				<td><input type="button" value="삭제" id="chggrade" 
					onclick="location.href='/petmily/atts?postSeq=<%= adm.getPostSeq()%>&keyword=<%=keyword %>&action=<%= action%>';"></td>
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
	</form>
</body>

</html>