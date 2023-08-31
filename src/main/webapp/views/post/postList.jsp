<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="java.util.ArrayList, standardpost.model.vo.StandardPost, java.sql.Date, member.model.vo.Member" %>
		<% ArrayList<StandardPost> list = (ArrayList<StandardPost>)request.getAttribute("list");
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
								if ($(e.target).parents('.newPostformBox').length < 1) {
									// disable visibility of new post form
									document.getElementById("newPostForm").style.display = 'none';
								}
							});
						}); // DOCUMENT READY


						function openNewPostForm() {
							document.getElementById("newPostForm").style.display = "block";
						}

						function deletePost(postSeq) {
							// TEST DELETEPOST TODO : CHAMGE MEMBERSEQ
							var seq = postSeq;
							var path = "/petmily/spdelete?memberseq=16&postSeq=" + postSeq;
							location.href = path;
						}

					</script>
				</head>

				<body>

					<%@ include file="../common/main.jsp" %>

						<div class="block" align="center">
							<div class="newPostformBox">
								<input id="newpost" type="text" placeholder="오늘 무슨 일이 있었나요?"
									onclick="openNewPostForm();">
								<div class="new-post-form-popup" id="newPostForm">
									<!-- TEST CREATE NEW POST : NEED TO CHANGE LATER -->
									<form action="/petmily/spnewpost?memberseq=16" class="form-container" method="post">
										<textarea name="post-content" id="post-content-textarea" cols="30" rows="10" autofocus required></textarea>
										<button type="submit" id="postsubmit">게시글 추가</button>
									</form>
								</div>
							</div>
							<br>
							<% for(StandardPost sp : list) { %>
								<table id="post">
									<tr id="postmemberid">
										<td colspan="3" style="height:30px; padding-left: 20px;">
											<b>
												<%= sp.getMemberId() %>
											</b>
										</td>
									</tr>
									<tr id="postcontent" style="text-align: center; padding: 30px;">
										<td colspan="3" style="padding: 30px; text-align: center;">
											<%= sp.getPostContent() %>
										</td>
									</tr>
									<tr id="postbottom">
										<td id="posteditdate">작성일자 &nbsp;:&nbsp; <%= sp.getLastModifieddate() %>
										</td>
										<% if (m.getMemberSeq()==sp.getMemberSeq()){ %>
											<td id="posteditbutton"><button>수정</button></td>
											<td id="postdeletebutton"><button
													onclick="deletePost(<%= sp.getPostSeq() %>);">삭제</button></td>
											<% } %>
									</tr>
									<br>
								</table>
								<% } %>
						</div>
				</body>

				</html>