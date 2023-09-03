<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="java.util.ArrayList, post.model.vo.Post, standardpost.model.vo.StandardPost, tradepost.model.vo.TradePost , java.sql.Date, member.model.vo.Member" %>
		<% ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");
				int count = list.size();
				Member m = (Member)session.getAttribute("member");
				%>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<title>Community</title>
					<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
					<link rel="stylesheet" href="/petmily/resources/css/post/postListCSS.css">
					<link rel="preconnect" href="https://fonts.googleapis.com">
					<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
					<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
					<script type="text/javascript">
						$(function () {
							const popup = document.getElementById('newPostForm');

							$('html').click(function (e) {
								// If clcicked outside of new post form div
								if ($(e.target).parents('div.snsbuttonswrap').length < 1) {
									console.log("clicked else where");
									// disable visibility of new post form
									document.querySelector("div.newPostformBox").style.display = 'none';
								}
							});
						}); // DOCUMENT READY


						function openNewPostForm() {
							console.log("clicked");
							
							document.querySelector("div.newPostformBox").style.display = "block";
						}

						function deletePost(postSeq) {
							// TEST DELETEPOST TODO : CHAMGE MEMBERSEQ
							var seq = postSeq;
							var path = "/petmily/spdelete?memberseq=16&postSeq=" + postSeq;
							location.href = path;
						}

						function clearTextArea(element) {
							element.value = '';
						}
					</script>
				</head>

				<body>

					<%@ include file="../common/main.jsp" %>

						<div class="block">
							<div class="snsbuttonswrap">
								<button id="newpost" type="text"onclick="openNewPostForm();">오늘 무슨 일이 있었나요?</button>

								<div class="newPostformBox">
									<div class="new-post-form-popup" id="newPostForm">
										<form action="/petmily/pnewpost?memberseq=16" class="form-container" method="post">
											<textarea name="post-content" id="post-content-textarea" cols="30" rows="10" autofocus required onfocus="clearTextArea(this);">tell us your story :</textarea>
											<img src="/petmily/resources/images/post/upload.png" alt="사진 업로드" style="width: 50px; height: 50px; position: relative;">
											<button type="submit" id="postsubmit">게시글 추가</button>
										</form>
									</div>
								</div>
							</div>
							
							<br><br><br>

							<% for(Post p : list) { %>
								<% if(p instanceof StandardPost){ %>
								<div id="post" style="width: 700px; border-radius: 10px; padding: 10px;">
								<table id="standardpost" style="width: 100%; border-collapse: collapse; border: 1px solid #fda90d;">
									<tr id="postmemberid" style="padding-left : 20px; background-color: #fda90d;">
										<td style="text-align: left; height: 30px; padding-left: 20px; font-weight: bold; color: white;">일반게시글</td>
										<td style="width: 180px; font-weight: bold; color: white;"><%= p.getLastModifiedDate() %>&nbsp;&nbsp;&nbsp;&nbsp;<%= p.getMemberId() %></td>
									</tr>
									<tr id="postcontent" style="text-align: center;">
										<td colspan="2" style="padding: 30px;">
											<%= p.getPostContent() %>
										</td>
									</tr>
									<% if (m.getMemberSeq()== p.getMemberSeq()){ %>
									<tr id="postbottom" style="height: 50px; align-items: center;">
											<td colspan="2" id="posteditbutton" style="text-align: right; padding-right: 20px;"><button>수정</button></td>
											<!-- <td id="postdeletebutton" style="position: relative;"> -->
												<!-- <button onclick="deletePost(<%= p.getPostSeq() %>);">삭제</button></td> -->

									</tr>
									<% } %>
									<!-- <tr>
										<td></td>
										<td></td>
									</tr> -->
								</table>
							</div>
								<br>
								<% } else if (p instanceof TradePost) { %>
							<div>
								<table id="tradepost">
									<tr id="postmemberid">
										<td colspan="3" style="height:30px; padding-left: 20px;">
											<b>중고거래 <%= p.getMemberId() %></b>
										</td>
									</tr>
									<tr id="postcontent" style="text-align: center; padding: 30px;">
										<td colspan="3" style="padding: 30px; text-align: center;">
											<%= p.getPostContent() %>
										</td>
									</tr>
									<tr id="postbottom">
										<td id="posteditdate">작성일자 &nbsp;:&nbsp; <%= p.getLastModifiedDate() %>
										</td>
										<% if (m.getMemberSeq()== p.getMemberSeq()){ %>
											<td id="posteditbutton"><button>수정</button></td>
											<td id="postdeletebutton"><button
													onclick="deletePost(<%= p.getPostSeq() %>);">삭제</button></td>
											<% } %>
									</tr>
									<br>
								</table>
							</div>
								<% }} %>
						</div>
				</body>

				</html>