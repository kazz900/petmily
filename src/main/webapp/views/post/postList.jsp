<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.ArrayList, post.model.vo.Post, standardpost.model.vo.StandardPost, tradepost.model.vo.TradePost , 
	java.sql.Date, member.model.vo.Member, 
	reply.model.vo.Reply"%>
<% ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");
				int count = list.size();
				Member m = (Member)session.getAttribute("member");
				ArrayList<Reply> rList = (ArrayList<Reply>)request.getAttribute("rList");
				%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Community</title>
<script type="text/javascript"
	src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<link rel="stylesheet"
	href="/petmily/resources/css/post/postListCSS.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
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


							$("button#postsubmit").on('clicked', function () {
								if (confirm("정말 등록하시겠습니까 ?") == true) {
									alert("등록되었습니다");
								}
								else {
									return;
								}
							});

							$('select.pl').on('change', function () {
								if (this.value != "") {
									this.removeAttribute("required");
									this.required = false;
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
							var path = "/petmily/pdelete?memberseq=16&postSeq=" + postSeq;
							location.href = path;
						}

						function clearTextArea(element) {
							var str = element.value.trim();
							if (str == '오늘 있었던 일을 공유해봐요') {
								element.value = '';
							}
						}

						function fileUpload() {
							$("input#fileupload").click();
							console.log($("select[name=post-type]").val());
						}

						function showMyPostList(memberSeq) {
							var path = "/petmily/pmypost?memberseq=" + memberSeq;
							location.href = path;
						}

						function sortByPopularity() {
							
							var path = "/petmily/plistfilter"
						}

						function sortByPostType(){
							var postType = $("select#sortbytype").val();
							var path = "/petmily/plistbytype?posttype=" + postType;
							location.href = path;
						}
					</script>
</head>

<body>

	<%@ include file="../common/main.jsp"%>

	<div class="block">
		<div class="snsbuttonswrap">
			<!-- 정렬버튼들 -->
			<button id="show-my-post"
				onclick="showMyPostList(<%= m.getMemberSeq() %>);">내 게시글 보기</button>
			<button id="sort-by-like" onclick="sortByPopularity();">인기순
				정렬</button>
			<select name="sort-post-type" id="sortbytype" class="pl"
				onchange="sortByPostType();">
				<option value="" selected>게시글종류</option>
				<option value="standardpost">일반게시글</option>
				<option value="tradepost">중고거래글</option>
			</select> <br> <br>
			<button id="newpost" type="text" onclick="openNewPostForm();">오늘
				무슨 일이 있었나요?</button>
			<div class="newPostformBox">
				<div class="new-post-form-popup" id="newPostForm">
					<form action="/petmily/pnewpost?memberseq=<%= m.getMemberSeq() %>"
						class="form-container" method="post" enctype="multipart/form-data">
						<textarea name="post-content" id="post-content-textarea" cols="30"
							rows="10" autofocus required
							oninvalid="this.setCustomValidity('내용을 입력해주세요');"
							onclick="clearTextArea(this);" oninput="setCustomValidity('')">
												오늘 있었던 일을 공유해봐요
											</textarea>
						<select name="post-type" class="pl" required
							oninvalid="this.setCustomValidity('게시물 종류를 선택 해주세요')"
							oninput="setCustomValidity('')">
							<option value="" selected>게시글종류</option>
							<option value="standardpost">일반게시글</option>
							<option value="tradepost">중고거래글</option>
						</select> <input type="file" name="upfile" id="fileupload"
							style="display: none;" accept="images/*"
							onchange="loadFile(event);"> <img
							id="new-post-file-upload"
							src="/petmily/resources/images/post/image-upload.png"
							alt="사진 업로드" onclick="fileUpload();">
						<button type="submit" id="postsubmit">게시물 등록</button>
					</form>
				</div>
			</div>
		</div>

		<br>
		<br>
		<br>
		<!-- 게시글 전체 띄우기 -->
		<% for(Post p : list) { %>
		<% if(p instanceof StandardPost){ %>
		<!-- 일반게시글 -->
		<div id="standard-post" style="width: 700px; padding: 10px;">
			<table id="standardpost"
				style="position: relative; width: 100%; border-collapse: collapse; border: 1px solid #fda90d; top: 50px;">
				<tr id="postmemberid"
					style="padding-left: 20px; background-color: #fda90d;">
					<td
						style="text-align: left; height: 30px; padding-left: 20px; font-weight: bold; color: white;">
						일반게시글</td>
					<td
						style="width: 180px; font-weight: bold; color: white; padding-right: 20px;">
						<%= p.getLastModifiedDate() %>&nbsp;&nbsp;&nbsp;&nbsp;<%=
															p.getMemberId() %>
					</td>
				</tr>
				<!-- 게시글 내용 -->
				<tr id="postcontent">
					<td colspan="2">
						<!-- 게시글에 사진이 있다면 사진표시 --> <% if(p.getChangedFileName()!=null) { %>
						<img alt="사진"
						src="/petmily/resources/postupfiles/<%= p.getChangedFileName() %>"
						width="400px" height="auto"> <br> <% } %> <!-- 게시글 내용 표시 -->
						<%= p.getPostContent() %>
					</td>
				</tr>
				<!-- 좋아요 숫자 표시 -->
				<tr>
					<td colspan="2" class="likeNo">
						<!-- 좋아요 기능 추가 해야됨 --> <img
						src="/petmily/resources/images/post/love.png" id="likeButton">
						&nbsp;&nbsp;<%= p.getLikeNo() %>
					</td>
				</tr>
				<% if (m.getMemberSeq()==p.getMemberSeq()){ %>
				<tr id="postbottom" style="height: 50px; align-items: center;">
					<td colspan="2" id="posteditbutton"
						style="text-align: right; padding-right: 20px;">
						<button>수정</button>
					</td>
				</tr>
				<% } %>
				<!-- 댓글달기 Row -->
				<tr id="replyrow">
					<td colspan="2"><input type="text" id="replyinputfield"
						placeholder="댓글을 달아보세요"> <!-- 댓글달기 버튼 --> <img
						id="replybutton" src="/petmily/resources/images/post/reply.png"
						alt="댓글달기"></td>
				</tr>
				<!-- 게시글에 댓글이 있을 경우 댓글 띄우기 -->
				<% if(p.getReplyNO() !=0) { %>
				<%  for (Reply r : rList) { %>
				<!-- 댓글 띄우기 -->
				<% if(p.getPostSeq() == r.getPostSeq()) { %>
				<tr class="replies">
					<td><%= r.getReplyContent() %></td>
					<td><%= r.getReplyDate() %></td>
				</tr>
				<% }}} %>
			</table>
		</div>
		<% } else if (p instanceof TradePost) { %>
		<!-- 중고거래게시글 -->
		<div id="trade-post" style="width: 700px; padding: 10px;">
			<table id="standardpost"
				style="position: relative; width: 100%; border-collapse: collapse; border: 1px solid #fda90d; top: 50px;">
				<tr id="postmemberid"
					style="padding-left: 20px; background-color: #fda90d;">
					<td
						style="text-align: left; height: 30px; padding-left: 20px; font-weight: bold; color: white;">
						중고거래글</td>
					<td
						style="width: 180px; font-weight: bold; color: white; padding-right: 20px;">
						<%= p.getLastModifiedDate() %>&nbsp;&nbsp;&nbsp;&nbsp; <%=p.getMemberId() %>
					</td>
				</tr>
				<!-- 게시글 내용 -->
				<tr id="postcontent">
					<td colspan="2">
						<!-- 게시글에 사진이 있다면 사진표시 --> <% if(p.getChangedFileName()!=null) { %>
						<img alt="사진"
						src="/petmily/resources/postupfiles/<%= p.getChangedFileName() %>"
						width="400px" height="auto"> <br> <% } %> <!-- 게시글 내용 표시 -->
						<%= p.getPostContent() %>
					</td>
				</tr>
				<!-- 좋아요 숫자 표시 -->
				<tr>
					<td colspan="2" class="likeNo">
						<!-- 좋아요 기능 추가 해야됨 --> <img
						src="/petmily/resources/images/post/love.png" id="likeButton">
						&nbsp;&nbsp;<%= p.getLikeNo() %>
					</td>
				</tr>
				<% if(m.getMemberSeq() !=p.getMemberSeq()) { %>
				<!-- 중고거래글이면서 자기 게시글이 아닐 경우 채팅요청 할 수 있음 -->
				<!-- 중고거래 채팅 -->
				<tr id="chatrow" style="border-style: none; text-align: right;">
					<td id="chatbutton" colspan="2" style="border-style: none;"><img
						src="/petmily/resources/images/post/chat.png" alt="채팅시작"
						style="position: relative; right: 20px; width: 35px; height: 35px;">
					</td>
				</tr>
				<% } %>
				<% if (m.getMemberSeq()==p.getMemberSeq()){ %>
				<tr id="postbottom" style="height: 50px; align-items: center;">
					<td colspan="2" id="posteditbutton"
						style="text-align: right; padding-right: 20px;">
						<button>수정</button>
					</td>


				</tr>
				<% } %>
				<!-- 댓글달기 Row -->
				<tr id="replyrow">
					<td colspan="2"><input type="text" id="replyinputfield"
						placeholder="댓글을 달아보세요"> <!-- 댓글달기 버튼 --> <img
						id="replybutton" src="/petmily/resources/images/post/reply.png"
						alt="댓글달기"></td>
				</tr>
				<!-- 게시글에 댓글이 있을 경우 댓글 띄우기 -->
				<% if(p.getReplyNO() !=0) { %>
				<% } %>
			</table>

		</div>
		<% }} %>
	</div>
</body>

</html>