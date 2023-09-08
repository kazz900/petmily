<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="member.model.vo.Member, pet.model.vo.Pet, java.util.ArrayList"%>
<%
	ArrayList<Pet> pet = (ArrayList<Pet>) request.getAttribute("list");
if (request.getAttribute("message") != null) {
    if (request.getAttribute("message").equals("성공적으로 변경되었습니다.")) {
%>
    <script>
        alert('<%=request.getAttribute("message") %>');
    </script>
<% } } %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>My Page</title>

<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript"
	src="/petmily/resources/js/info/infotap.js"></script>

<style type="text/css">
.info-content {
	width: 900px;
	margin: 98px auto 0 auto;
	word-wrap: break-word;
}

.info-share {
	position: relative;
	left: 95%;
}

.info-detail02 {
	margin-top: 120px;
	font-family: OhsquareAir;
	src: url('/petmily/resources/font/OhsquareAir.woff2') format('woff2');
	font-size: 18px;
	color: black;
}

ul.tabs {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

ul.tabs li {
	background: none;
	color: #222;
	display: inline-block;
	padding: 10px 15px;
	cursor: pointer;
}

ul.tabs li.current {
	/* background: #ededed; */
	color: #222;
	border-bottom: 3px solid hsl(30.46deg 58.9% 45.68%);
}

.tab-content {
	display: none;
	/* background: #ededed; */
	padding: 15px;
}

.tab-content.current {
	display: inherit;
}

.tabs {
	text-align: center;
}

input[type=text] {
	width: 280px;
	height: 30px;
	border:1px solid gray;
}

input[type=email] {
	width: 280px;
	height: 30px;
	border:1px solid gray;
}

input[type=time] {
	height: 30px;
	width: 132px;
}

/* input[type=submit] {
	margin-top:15px;
	width:200px;
	height:35px;
	border-radius:30px;
} */
input[type=tel] {
	width: 280px;
	height: 30px;
}

select[name=type] {
	width: 280px;
	height: 30px;
}

form table tr textarea {
	width: 280px;
}

form {
	margin-top: 0px;
}

.yes {
	height: 30px;
}

div.wrapper {
	border: 2px solid #cfcfcf;
	text-align: center;
	background-color: #fafafa;
	box-shadow: 2px 2px 5px 2px #cfcfcf;
}

div.wrapper form {
	text-align: center;
}

td {
	justify-content: center;
	display: inline-flex;
}

/* 펫 정보들 */
.pet {
	overflow: auto;
	display: inline-grid;
	justify-items: center;
	background-color: white;
	border: 1px solid gray;
	width: 210px;
	position: relative;
	align-items: center;
	
}
.pet:hover{
box-shadow: 0px 0px 7px black;
}
.petimg {
	height: 200px;
	width: 200px;
	overflow: hidden;
	display: grid;
	justify-content: center;
	position: relative;
	margin-top: 35px;
}

.petintable {
	
}

.petintr {
	display: table-row-group;
	width: 200px;
}

.petintd-radio {
	display: inherit;
	width: 200px;
}

.petin-image1 {
	display: flex;
	overflow: hidden;
	justify-content: center;
}

.petin-image2 {
	display: flex;
}
#upetName{
font-family: OhsquareAir;
}
#petName{
font-family: OhsquareAir;
}

input[type=submit]#changeSubmit {
	margin-top:5px;
	margin-bottom:15px; 
	width:250px; 
	height:35px; 
	border-radius:5px; 
	border:none;
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;


	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,0.7) 0%, rgba(218,131,0,0.7) 100%);
}

input[type=submit]#changeSubmit:hover {
	background: transparent;
	background: rgba(230,154,55,0.8);
}

input[type=submit]#addpetsub {
	margin-top:5px;
	margin-bottom:15px; 
	width:250px; 
	height:35px; 
	border-radius:5px; 
	border:0px solid rgba(200,124,25,0.1);
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	

	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,1) 0%, rgba(218,131,0,1) 100%);
}

input[type=submit]#addpetsub:hover {
	background: transparent;
	background: rgba(230,154,55,1);
}

input[type=button]#pwdChange {
	margin-top:5px;
	margin-bottom:15px; 
	width:250px; 
	height:35px; 
	border-radius:5px; 
	border:none;
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	
	
	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,0.7) 0%, rgba(218,131,0,0.7) 100%);
}

input[type=button]#pwdChange:hover {
	background: transparent;
	background: rgba(230,154,55,0.8);
}

button#fixBtn {
	margin-top:5px;
	margin-bottom:15px; 
	width:80px; 
	height:35px; 
	border-radius:5px; 
	border:0px solid rgba(200,124,25,0.1);
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	
	
	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,1) 0%, rgba(218,131,0,1) 100%);
}

button#fixBtn:hover {
	background: transparent;
	background: rgba(230,154,55,1);
}

input[type=reset] {
	margin-top:5px;
	margin-bottom:15px; 
	width:250px; 
	height:35px; 
	border-radius:5px; 
	border:0px solid rgba(200,124,25,0.1);
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	
	
	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,1) 0%, rgba(218,131,0,1) 100%);
}

input[type=reset]:hover {
	background: transparent;
	background: rgba(230,154,55,1);
}

input[type=submit]#uEdit {
	margin-top:5px;
	margin-bottom:15px; 
	width:250px; 
	height:35px; 
	border-radius:5px; 
	border:0px solid rgba(200,124,25,0.1);
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	
	
	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,1) 0%, rgba(218,131,0,1) 100%);
}

input[type=submit]#uEdit:hover {
	background: transparent;
	background: rgba(230,154,55,1);
}

input[type=submit]#deleteOk {
	margin-top:5px;
	margin-bottom:15px; 
	width:80px; 
	height:35px; 
	border-radius:5px; 
	border:0px solid rgba(200,124,25,0.1);
	box-shadow:2px 2px 3px 1px #cfcfcf;
	cursor:pointer;
	
	
	font-family: OhsquareAir;
	color:white;
	transition: all 0.3s ease;
	background: linear-gradient(0deg, rgba(255,184,75,1) 0%, rgba(218,131,0,1) 100%);
}

input[type=submit]#deleteOk:hover {
	background: transparent;
	background: rgba(230,154,55,1);
}

</style>
<script>

	function readImage(input) {
		if (input.files && input.files[0]) {
			const reader = new FileReader();
			reader.onload = function(e) {
				const previewImage = document.getElementById("preview-image");
				previewImage.src = e.target.result;
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	 

	const inputImage = document.getElementById("input-image");
	inputImage.addEventListener("change", function() {
		readImage(this);
	});
	function ureadImage(input) {
		if (input.files && input.files[0]) {
			const reader = new FileReader();
			reader.onload = function(e) {
				const upreviewImage = document.getElementById("upreview-image");
				upreviewImage.src = e.target.result;
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	const uinputImage = document.getElementById("uinput-image");
	uinputImage.addEventListener("change", function() {
		ureadImage(this);
	});
</script>
<script type="text/javascript">
 
	function checkinputpet() {
	 var frm = document.form1;
		var petname = document.getElementById('petName');
		/* var upettype = document.getElementByName('upetType');
		var upetsize = document.getElementById('upetSize'); */
		if(petname.value.length < 1){
			alert("펫이름을 입력해 주세요.");
			return false;}
		
		  
		 
		if(!frm.petType[0].checked && !frm.petType[1].checked && !frm.petType[2].checked){
			alert("펫타입을 입력해 주세요.");
			return false;
		}else if(!frm.petSize[0].checked && !frm.petSize[1].checked && !frm.petSize[2].checked){
			alert("펫타입을 입력해 주세요.");
			return false;
		}
			return true;
	}
 function ucheckinputpet () {
	 var frm = document.form2;
		var upetname = document.getElementById('upetName');
		/* var upettype = document.getElementByName('upetType');
		var upetsize = document.getElementById('upetSize'); */
		if(upetname.value.length < 1){
			alert("펫이름을 입력해 주세요.");
			return false;}
		
		  
		 
		if(!frm.upetType[0].checked && !frm.upetType[1].checked && !frm.upetType[2].checked){
			alert("펫타입을 입력해 주세요.");
			return false;
		}else if(!frm.upetSize[0].checked && !frm.upetSize[1].checked && !frm.upetSize[2].checked){
			alert("펫타입을 입력해 주세요.");
			return false;
		}
			return true;
	}

	function changePwd() {
		location.href = "/petmily/views/mypage/changePwd.jsp";
	}

	var petSeq = null;
	var petName = null;
	var petType = null;
	var petSize = null;
	var petImg = null;
	function getValue(value) {
		console.log(value);

		petSeq = document.getElementById("UpetSeq" + value).value;
		petName = document.getElementById("UpetName" + value).value;
		petType = document.getElementById("UpetType" + value).value;
		petSize = document.getElementById("UpetSize" + value).value;
		petImg = document.getElementById("UpetImg" + value).value;

		document.getElementById("upetSeq").value = petSeq;
		document.getElementById("upetName").value = petName;
		document.getElementById("duImg").value = petImg;
		if (petType === "고양이") {
			petType = "0";
		} else if (petType === "강아지") {
			petType = "1";
		} else {
			petType = "2";
		}
		if (document.getElementById('upetType1').value === petType) {
			$('#upetType1').prop("checked", true);
		} else if (document.getElementById('upetType2').value === petType) {
			$('#upetType2').prop("checked", true);
		} else {
			$('#upetType3').prop("checked", true);
		}

		if (document.getElementById('upetSize1').value === petSize) {
			$('#upetSize1').prop("checked", true);
		} else if (document.getElementById('upetSize2').value === petSize) {
			$('#upetSize2').prop("checked", true);
		} else {
			$('#upetSize3').prop("checked", true);
		}
		$("#upreview-image").attr({
			src : "/petmily/resources/images/petImg/" + petImg
		});
	}

	var btn = document.getElementById("fixBtn");
	var div = document.getElementById("update");

	$(function() {
		const popup = document.getElementById('update1');

		$('html').click(function(e) {
			// If clcicked outside of new post form div
			if ($(e.target).parents('div#tab-1').length < 1) {
				console.log("clicked else where");
				// disable visibility of new post form
				document.querySelector("div.update").style.display = 'none';
			}
		});
	}); // DOCUMENT READY

	function openNewPostForm() {
		console.log("clicked");

		document.querySelector("div.update").style.display = 'block';
	}
</script>
<script type="text/javascript">
window.onload = function(){

	var submitBtn = document.getElementById("changeSubmit");
	var nickname = document.getElementById("nickname");
	
	const unchangedNick = nickname.value;
	
	submitBtn.disabled = true;
	submitBtn.style.background = "#dfdfdf";
	
	nickname.addEventListener("keyup", function(){
		var changedNick = nickname.value;
		
		if (changedNick !== unchangedNick) {
			
			submitBtn.disabled = false;
			submitBtn.style.removeProperty("background");
			
		} else if (changedNick === unchangedNick) {
			
			submitBtn.disabled = true;
			
		}
	});
}
</script>
</head>
<body>
	<%@ include file="../common/main.jsp"%>



	<div class="info-content">

		<div class="info-detail02">

			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">나의 펫 정보</li>

				<li class="tab-link" data-tab="tab-2">나의 정보</li>

			</ul>

			<hr style="opacity: 0.5; margin: 0px;">

			<div id="tab-1" class="tab-content current">
				<div style="position: absolute; background-color: white; left: 5%;z-index:2;">
					<form action="/petmily/peten" method="post" name="form1"
						enctype="multipart/form-data" onsubmit="return checkinputpet();">
						<table
							style="border-radius: 12px; box-shadow: 0px 0px 7px black; font-size: 15px; "
							class="petintable">
							<tr class="petintr">
								<td colspan="3" class="petintd">나의 Petmily 추가하기.</td>
							</tr>
							<tr>
								<td colspan="3" id="tdpetName" class="petintd"><input
									type="text" name="petName" id="petName" maxlength="4" placeholder="Petmily 이름"
									style="width: 200px; height: 30px;"></td>
							</tr>
							<tr class="petintr">
								<td colspan="3" class="petintd"
									style="display: flex; width: 200px;">나의 Petmily의 종류와 크기를 설정하세요.</td>
							</tr>
							<tr class="petintr" style="width: 200px; display: block;">
								<td class="petintd-radio"><input type="radio"
									name="petType" id="petType" value="0">고양이</td>
								<td class="petintd-radio"><input type="radio"
									name="petType" id="petType" value="1">강아지</td>
								<td class="petintd-radio"><input type="radio"
									name="petType" id="petType" value="2">기타
							</tr>
							<tr class="petintr">
								<td class="petintd-radio"><input type="radio"
									name="petSize" id="petSize" value="소형">소형(10kg 미만)</td>
								<td class="petintd-radio"><input type="radio"
									name="petSize" id="petSize" value="중형">중형(10~25kg 미만)</td>
								<td class="petintd-radio"><input type="radio"
									name="petSize" id="petSize" value="대형">대형(25kg 이상)</td>
							</tr>
							<tr class="petintr">
								<td colspan="2" class="petin-image1"
									style="width: 200px; height: 200px;"><img
									name="preview-image" id="preview-image"
									src="/petmily/resources/images/mainbanner/882.jpg"
									style="width: 350px;"></td>
							</tr>
							<tr style="display: flex; width: 200px;">
								<td id="image_container" class="petin-image2"><input
									type="file" id="input-image" name="input-image"
									onchange="readImage(this);" style="width: 200px;"></td>
							</tr>
							<tr class="petintr">
								<td colspan="2" style="width: 100px;"><input type="submit" id="addpetsub"
									value="추가" style="width: 80px;"></td>
								<td style="width: 100px;"><input type="reset" value="모두 지우기"
									style="width: 80px;"></td>
							</tr>
						</table>
					</form>
				</div>

				<%
				if (pet != null) {
				%>
				<%
				for (Pet p : pet) {
					int i = 1;
				%>
				<div class="pet" style="margin-top:10px; border-radius: 12px;  font-size: 15px; z-index=1;">
					<div class="petimg"
						style="width: 200px; height: 200px; display: flex; overflow: hidden; justify-content: center;">
						<img src="/petmily/resources/images/petImg/<%=p.getPetImg()%>"
							style="width: 350px;">
					</div>
					<div class="petinfo">
						이름:<%=p.getPetName()%><br> 종류:<%=p.getPetType()%><br>
						크기:<%=p.getPetSize()%><br>

					</div>
					<div class="updateBtn" style="display: inline-flex;">

						
						<input type="hidden" name="UpetSeq<%=p.getPetSeq()%>"
							id="UpetSeq<%=p.getPetSeq()%>" value="<%=p.getPetSeq()%>">
						<input type="hidden" name="UpetName<%=p.getPetSeq()%>"
							id="UpetName<%=p.getPetSeq()%>" value="<%=p.getPetName()%>">
						<input type="hidden" name="UpetType<%=p.getPetSeq()%>"
							id="UpetType<%=p.getPetSeq()%>" value="<%=p.getPetType()%>">
						<input type="hidden" name="UpetSize<%=p.getPetSeq()%>"
							id="UpetSize<%=p.getPetSeq()%>" value="<%=p.getPetSize()%>">
						<input type="hidden" name="UpetImg<%=p.getPetSeq()%>"
							id="UpetImg<%=p.getPetSeq()%>" value="<%=p.getPetImg()%>">
						<button id="fixBtn" value="<%=p.getPetSeq()%>"
							onclick="getValue(this.value);openNewPostForm();">수정하기</button>

						<form action="/petmily/petdel" method="post"  style="margin-left:15px;">
							<input type="hidden" name="dmemberSeq" id="deletePet"
								value="<%=p.getMemberSeq()%>"> <input type="hidden"
								name="deletePet" id="deletePet" value="<%=p.getPetSeq()%>">
								<input type="hidden" name="deleteImg" id="deleteImg" value="<%=p.getPetImg()%>">
							<input type="submit" id="deleteOk" value="삭제">
						</form>
					</div>
				</div>
				<%
				}
				}else{
				%>
				<h1 style="text-align: center;">등록된 펫밀리가 없습니다. 좌측의 펫밀리 추가하기로 나의 펫밀리를 추가해 주세요.</h1>
				<% } %>
				<div class="update1" id="update1">
					<div class="update" id="update"
						style="position: absolute; background-color: white; left: 5%; top: 186px; z-index: 3; display: none;border-radius: 20px; width:210px;">
						<form action="/petmily/petup" method="post" name="form2"
							enctype="multipart/form-data"onsubmit="return ucheckinputpet();">
							<input type="hidden" name="duImg" id="duImg">
							<input type="hidden" name="memberSeq" id="memberSeq"
								value="<%=member.getMemberSeq()%>"> <input type="hidden"
								name="upetSeq" id="upetSeq">
							<table
								style="  font-size: 15px;"
								class="petintable">
								<tr class="petintr">
									<td colspan="3" class="petintd">나의 Petmily 수정하기</td>
								</tr>
								<tr class="petintr">
									<td colspan="3" class="petintd"><input type="text"
										name="upetName" id="upetName" placeholder="Petmily 이름"
										style="width: 200px; height: 30px;" class="petintd" maxlength="4"></td>
								</tr>
								<tr class="petintr">
									<td colspan="3" class="petintd"
										style="display: flex; width: 200px;">나의 Petmily의 종류와 크기를 설정하세요.</td>
								</tr>
								<tr class="petintr">
									<td class="petintd-radio"><input type="radio"
										name="upetType" id="upetType1" value="0">고양이</td>
									<td class="petintd-radio"><input type="radio"
										name="upetType" id="upetType2" value="1">강아지</td>
									<td class="petintd-radio"><input type="radio"
										name="upetType" id="upetType3" value="2">기타
								</tr>
								<tr class="petintr">
									<td class="petintd-radio"><input type="radio"
										name="upetSize" id="upetSize1" value="소형">소형(10kg 미만)</td>
									<td class="petintd-radio"><input type="radio"
										name="upetSize" id="upetSize2" value="중형">중형(10~25kg
										미만)</td>
									<td class="petintd-radio"><input type="radio"
										name="upetSize" id="upetSize3" value="대형">대형(25kg 이상)</td>
								</tr>
								<tr class="petintr">
									<td colspan="2" class="petin-image1"
										style="width: 200px; height: 200px;"><img
										name="upreview-image" id="upreview-image"
										src="/petmily/resources/images/mainbanner/882.jpg"
										style="width: 350px;"></td>
									<td id="image_container" class="petin-image2"><input
										type="file" id="uinput-image" name="uinput-image"
										onchange="ureadImage(this);" style="width: 200px;"></td>
								</tr>
								<tr class="petintr">
									<td colspan="2" style="width: 100px;"><input type="submit" id="uEdit"
										value="수정완료" style="width: 80px;"></td>
									<td><input type="reset" value="모두 지우기" style="width: 80px;"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				
			</div>
			
			<div id="tab-2" class="tab-content">
				<div class="wrapper">
					<div style="text-align:center;">
						<p style="margin-bottom:2px;">고객님께서 가입하신 펫밀리 계정정보입니다.</p>
						<p style="font-size:15px; margin-top:3px;">닉네임만 변경 가능합니다.</p>
					</div>
					<form action="/petmily/myinfo" method="post">
						<table id="outer" align="center" width="500" cellspacing="5"
							cellpadding="0">

							<tr>
								<th width="140">아이디</th>
								<td><input type="text" name="userid" value="<%=member.getMemberId()%>"
									readonly>
							<tr>
								<th width="140">이메일</th>
								<td><input type="email" name="email" value="<%=member.getMemberEmail()%>">
								</td>
							</tr>
							
							<tr>
								<th width="140">(*)닉네임</th>
								<td><input type="text" name="nickname" id="nickname" value="<%=member.getMemberNick()%>">
								</td>
							</tr>
						</table>
						<div style="text-align:center; margin-top:10px;">
						
							<input type="button" value="비밀번호 변경" id="pwdChange" onclick="changePwd();" 
							style="margin-bottom:15px; width:150px; height:30px; 
							border-radius:5px;
							box-shadow:1px 1px 0px 1px #cfcfcf;">
							&nbsp; 
							<input type="submit" value="변경하기" id="changeSubmit"
							style="margin-bottom:15px; width:150px; height:30px; 
							border-radius:5px;
							box-shadow:1px 1px 0px 1px #cfcfcf;">
						
						</div>
					</form>
				</div>
			</div>

		</div>
</body>
</html>