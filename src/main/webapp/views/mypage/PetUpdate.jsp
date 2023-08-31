<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pet.model.vo.Pet" %>
 <% 
  	Pet pet = (Pet)request.getAttribute("pet");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@media ( min-width : 1050px) {
   .block {
      width: 1050px;
      margin: 98px auto 0 auto;
      word-wrap: break-word;
   }
}
</style>
</head>
<body>
<%@ include file="../common/main.jsp" %>
	<form class="block">
	<input type="hidden" name="commitment" value="N">
					<table width="500" align="center" cellspacing="5">

						<tr>
							<th width="150">펫밀리 이름</th>
							<td><input type="text" name="petname" value="<%= pet.getPetName() %>" size="31" maxlength="50"
								placeholder="펫밀리 이름을 입력해주세요." required></td>
						</tr>
						
						
						
						<tr class="yes">
							<th width="300">펫밀리 종류</th>
							<%
							String petType = pet.getPetType();						
							String[] checked = new String[3];
								switch(petType){
								case "0":  checked[0] = "checked"; break;
								case "1":  checked[1] = "checked"; break;
								case "2":  checked[2] = "checked"; break;
								}
							
							
							
							%>
							<td>
								<table>
									<tr>
										<td><input type="radio" name="pettype" value="0" <%= checked[0] %>>고양이 </td>
										<td><input type="radio" name="pettype" value="1" <%= checked[1] %>>강아지</td>
										<td><input type="radio" name="pettype" value="2" <%= checked[2] %>>모든 동물</td>
										
										
								  </tr>
									
								</table>
							</td>
						</tr>
						
						<tr class="yes">
							<th width="300">펫밀리 사이즈 </th>
							
						<%
							String petTypes = pet.getPetType();						
							String[] checke= new String[3];
								switch(petType){
								case "small":  checke[0] = "checked"; break;
								case "regular":  checke[1] = "checked"; break;
								case "large":  checke[2] = "checked"; break;
								}
							
							
							
						%>
							
							
							<td>
								<table>
									<tr>
										<td><input type="radio" name="petsize" value="small" <%= checke[0] %>>소형(10kg 미만) </td>
										<td><input type="radio" name="petsize" value="regular" <%= checke[1] %>>중형(10kg 이상 25kg 미만)</td>
										<td><input type="radio" name="petsize" value="large" <%= checke[2] %>>대형(25kg 이상)</td>
																			
									</tr>
								</table>
							</td>
						</tr>
						
						<th colspan="2"><input type="submit" value="펫 수정하기"
							id="submitBtn"></th>
						
				</form>		
</body>
</html>