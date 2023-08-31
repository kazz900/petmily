<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="java.util.ArrayList, standardpost.model.vo.StandardPost, java.sql.Date" %>
		<% ArrayList<StandardPost> list = (ArrayList<StandardPost>)request.getAttribute("list");
				int count = list.size();
				%>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<title>Community</title>
					<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
					<link rel="preconnect" href="https://fonts.googleapis.com">
					<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
					<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">\
					<script type="text/javascript">
						$(function () {
							// $.ajax({
							// 	url: "/petmily/"
							// })
							const popup = document.getElementById('newPostForm');
							// window.onclick = e => {
							// 	if (e.target === popup) {
							// 		// console.log('clicked else where');
							// 		popup.style.display = 'block';

							// 	}else{
							// 		console.log('clicked else where');
							// 		popup.style.display = 'none';
							// 	}
							// }


							$('html').click(function (e) {
								if ($(e.target).parents('.newPostformBox').length < 1) {
									console.log('팝업 외 부분이 맞습니다')
									//실행 이벤트 부분
									document.getElementById("newPostForm").style.display = 'none';
								} else {
									console.log('?????')
								}
							});
						});

						// function openNewPostForm() {
						// 	document.getElementById("newPostForm").style.display = "block";
						// }
						// function closeNewPostForm() {
						// 	document.getElementById("newPostForm").style.display = "none";
						// }


						function openNewPostForm() {
							console.log("new post input field clicked");
							document.getElementById("newPostForm").style.display = "block";
						}

					</script>
					<style type="text/css">
						@media (min-width : 1050px) {
							.block {
								width: 1050px;
								margin: 98px auto 0 auto;
								word-wrap: break-word;
							}
						}

						html,
						body {
							height: 100%;
							font-family: 'Noto Sans KR', sans-serif;
						}

						div#main {
							width: 1050px;
							height: 100%;
							border: 1px solid black;
						}

						div#top {
							width: 100%;
							height: 100px;
							border: 1px solid black;
							margin-bottm: 3px;
						}

						div#bottom {
							width: 100%;
							margin: 10px auto;
						}

						div#map {
							width: 523px;
							height: 67%;
							border: 1px solid black;
							float: left;
						}

						div#info {
							width: 523px;
							height: 67%;
							border: 1px solid black;
							float: right;
						}

						div input#newpost {
							width: 690px;
							height: 30px;
							font-size: 15px;
							background-color: #dddddd;
							align-items: center;
							border: 0;
							border-radius: 5px;
							outline: none;
						}

						table#post {
							height: auto;
							width: 700px;
							border: 1px solid;
							border-radius: 20px;
							border-collapse: collapse;
						}

						::placeholder {
							text-align: center;
						}

						table tr#postmemberid {
							background-color: #fda90d;
							padding-left: 20px;
							margin: 0px;
						}

						table tr td#posteditdate {
							text-align: left;
							padding-left: 20px;
						}

						table tr td#postbuttons {
							float: right;
							position: sticky;
							left: 70%;
						}

						table tr#postbottom {
							border-top: 1px solid black;
							height: 50px;
							display: flex;
							align-items: center;
						}

						:root {
							--button-color: #ffffff;
							--button-bg-color: #fda90d;
						}

						button {
							-webkit-appearance: none;
							-moz-appearance: none;
							appearance: none;

							background: var(--button-bg-color);
							color: var(--button-color);

							/* margin: 0; */
							padding: 0.5rem 1rem;

							font-family: 'Noto Sans KR', sans-serif;
							font-size: 1rem;
							font-weight: 400;
							text-align: center;
							text-decoration: none;

							border: none;
							border-radius: 4px;

							display: inline-block;
							width: auto;

							box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);

							cursor: pointer;

							transition: 0.5s;
						}

						button#postsubmit{
							position: fixed;
							bottom: 10px;
							right: 10px;
						}

						/* The popup form - hidden by default */
						.new-post-form-popup {
							display: none;
							position: fixed;
							top: 50%;
							left: 50%;
							transform: translate(-50%, -50%);
							background-color: white;
							box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px rgba(0, 0, 0, 0.22);
							width: 700px;
							height: 500px;
							z-index: 9;
						}

						/* Add styles to the form container */
						.form-container {
							max-width: 300px;
							padding: 10px;
							background-color: white;
						}
					</style>
				</head>

				<body>

					<%@ include file="../common/main.jsp" %>

						<div class="block" align="center">
							<div class="newPostformBox">
								<input id="newpost" type="text" placeholder="오늘 무슨 일이 있었나요?" onclick="openNewPostForm();">
								<div class="new-post-form-popup" id="newPostForm">
									<!-- TEST CREATE NEW POST : NEED TO CHANGE LATER -->
									<form action="/petmily/spnewpost?memberseq=16" class="form-container" method="post">
										<input type="text" id="testpostcontent" name="post-content" placeholder="내용을 입력해주세요">
										<button type="submit" id="postsubmit">게시글 추가</button>
									</form>
								</div>
							</div>
							<br>
							<% for(StandardPost sp : list) { %>
								<table id="post">
									<tr id="postmemberid">
										<td colspan="2" style="height:30px; padding-left: 20px;">
											<b>
												<%= sp.getMemberId() %>
											</b>
										</td>
									</tr>
									<tr id="postcontent" style="text-align: center; padding: 30px;">
										<td colspan="2" style="padding: 30px; text-align: center;">
											<%= sp.getPostContent() %>
										</td>
									</tr>
									<tr id="postbottom">
										<td id="posteditdate">수정일자 &nbsp;:&nbsp; <%= sp.getPostDate() %>
										</td>
										<td id="postbuttons"><button>수정하기</button></td>
									</tr>
									<br>
								</table>
								<% } %>
						</div>
				</body>

				</html>