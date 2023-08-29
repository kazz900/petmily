<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="department.model.vo.Department, java.util.ArrayList" %>
<% 
	ArrayList<Department> list = (ArrayList<Department>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/first/resources/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
function InsertDept(element){ //함수 재설정 필요
	//radio 의 체크 상태가 변경된(change) input 태그의 name 속성값에서 userid 를 분리 추출함
	var userid = element.name.substring(8);
	console.log("userid : " + userid);
	
	if(element.checked == true && element.value == 'false'){
		//제한을 체크한 경우
		location.href = "/first/loginok?userid=" + userid + "&ok=false";
	}else{
		//가능을 체크한 경우
		location.href = "/first/loginok?userid=" + userid + "&ok=true";
	}
}
</script>
</head>
<body>
<table align="center" border="1" cellspacing="0" cellpadding="3">
	<tr><th>아이디</th><th>이름</th><th>성별</th><th>나이</th>
	<th>전화번호</th><th>이메일</th><th>가입날짜</th><th>마지막 수정날짜</th>
	<th>가입방식</th><th>관리자여부</th><th>로그인 제한여부</th></tr>
	<% for(Department d : list){ %>
		<tr>
			<td><%= d.getDeptSeq() %></td>
			<td><%= d.getDeptType() %></td>
			<td><%= d.getDeptName() %></td>
			<td><%= d.getDeptAddress() %></td>
			<td><%= d.getDeptPhone() %></td>
			<td><%= d.getDeptLatitude() %></td>
			<td><%= d.getDeptLongitude() %></td>
			<td><%= d.getDeptTime() %></td>
			<td><%= d.getDeptParking() %></td>
			<td><%= d.getDeptEntrancefee() %></td>
			<td><%= d.getDeptSizerestrict() %></td>
			<td><%= d.getDeptRestrict() %></td>
			<td><%= d.getDeptWithpetfee() %></td>
			<td><%= d.getDeptUrl() %></td>
			<td><%= d.getDeptPic() %></td>
			<td><%= d.getdept %></td>
			<td><%= d.getDeptWithpetfee() %></td>
			<td>
				<%-- 관리자가 회원의 로그인 제한을 설정할 수 있도록 함 --%>
				<% if(d.getDeptInsertOk("Y")){ %>
					<input type="radio" name="insertok_<%= d.getDeptInsertOk() %>" value="true" 
					onchange="InsertDept(this);" checked> 승인 &nbsp;
					<input type="radio" name="insertok_<%= d.getDeptInsertOk() %>" value="false" 
					onchange="InsertDept(this)" > 제한
				<% }else{ %>
					<input type="radio" name="insertok_<%= d.getDeptInsertOk() %>" value="true" 
					onchange="InsertDept(this);" > 승이 &nbsp;
					<input type="radio" name="insertok_<%= d.getDeptInsertOk() %>" value="false" 
					onchange="InsertDept(this);" checked> 제한
				<% } %>
			</td>
		</tr>
	<% } %>
</table>
</body>
</html>