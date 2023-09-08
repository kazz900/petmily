<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="java.util.ArrayList, post.model.vo.Post, standardpost.model.vo.StandardPost, tradepost.model.vo.TradePost , 
	java.sql.Date, member.model.vo.Member, 
	reply.model.vo.Reply" %>
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
							<link rel="stylesheet" href="/petmily/resources/css/post/postListCSS.css">
							<link rel="preconnect" href="https://fonts.googleapis.com">
							<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
							<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
								rel="stylesheet">
							<script type="text/javascript">
								$(function () {
									$('.likeimg').on('click', function(){
										var parent = $(this).parent().parent().parent().parent().parent();
										var data_post_seq = parent.attr('data-post-seq');
										var data_member_seq = parent.attr('data-member-seq');
										var data_post_type = parent.attr('data-post-type');
										var likeNo = parent.find('.likenotext');
										var val = Number(likeNo.text());

										console.log('data_post_seq : ' + data_post_seq);
										console.log('data-member-seq : ' + data_member_seq);
										$.ajax({
											url : '/petmily/lcs',
											type : 'post',
											dataType : 'json',
											data : {
												post_seq : data_post_seq,
												member_seq : data_member_seq,
												post_type : data_post_type
											},
											success : function(){
												likeNo.text(val+1);
											},
											error : function (error) {
												alert("이미 좋아요한 게시글 입니다");
											}
										})
									});

									// 새 게시글 폼 바깥쪽 클릭하면 사라지게 하기
									$('html').click(function (e) {
										// If clcicked outside of new post form div
										if ($(e.target).parents('div.snsbuttonswrap').length < 1) {
											// disable visibility of new post form
											document.querySelector("div.newPostformBox").style.display = 'none';
										}
									});

									// 수정폼 바깥쪽 클릭하면 사라지게 하기
									$('html').click(function (e) {
										// If clcicked outside of new post form div
										if ($(e.target).parents('div.post-edit-form-wrap').length < 1) {
											if ($(e.target).attr('id') == 'postEditButton') {
												console.log("수정버튼 클릭");
											} else {
												console.log("clicked else where");
												console.log('$(e.target) ' + $(e.target).attr('id'));
												document.querySelector("div.editPostformBox").style.display = 'none';
											}
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
									document.querySelector("div.newPostformBox").style.display = "block";
								}

								function clearTextArea(element) {
									var str = element.value.trim();
									if (str == '오늘 있었던 일을 공유해봐요') {
										element.value = '';
									}
								}

								function fileUpload1() {
									$("input#newfileupload").click();
								}

								function fileUpload2() {
									$("input#editfileupload").click();
								}

								function showMyPostList(memberSeq) {
									var path = "/petmily/pmypost?memberseq=" + memberSeq;
									location.href = path;
								}

								function sortByPopularity() {
									var path = "/petmily/plistsortbypopularity";
									location.href = path;
								}

								function sortByPostType() {
									var postType = $("select#sortbytype").val();
									var path = "/petmily/plistbytype?posttype=" + postType;
									location.href = path;
								}

								function showEditForm(postSeq, memberSeq, postContent, changedFileName, originalFileName, postType) {
									console.log("열기");
									$("div.editPostformBox").css("display", "block");
									// 수정폼
									$("input#inputpostseq").val(postSeq);
									$("input#inputmemberseq").val(memberSeq);
									$("textarea#post-content-textarea").val(postContent);
									$("select#editformposttype").val(postType);
									$("input#inputoriginalfilename").val(originalFileName);
									$("input#inputchangedfilename").val(changedFileName);

									// 삭제폼
									$("input#dinputpostseq").val(postSeq);
									$("input#dinputposttype").val(postType);
									$("input#dinputmemberseq").val(memberSeq);
								}

								function postReply(memberSeq, postSeq) {
									$("input#replymemberseq").val(memberSeq);
									$("input#replypostseq").val(postSeq);
									$("button#postreply").click();
								}

								function deleteReply(replySeq, memberSeq) {
									var path = "/petmily/rdelete?replyseq=" + replySeq + "&memberseq=" + memberSeq;
									location.href = path;
								}

								// function deletePost() {
								// 	console.log("clicked");
								// 	var postSeq = $("input#inputpostseq").val();
								// 	var postType = $("input#dinputposttype").val();
								// 	var memberSeq = $("input#dinputmemberseq").val();

								// 	console.log(postSeq + ", " + postType);
						
								// 	var path = "/petmily/pdelete?postseq=" + postSeq + "&post-type=" + postType + "&memberseq=" + memberSeq;
								// 	alert(path);
								// 	console.log(path);
								// 	// location.href = path;
								// }

								
								
							</script>
						</head>

						<body>

							<%@ include file="../common/main.jsp" %>

								<div class="block">
									<div class="snsbuttonswrap">
										<!-- 정렬버튼들 -->
										<button id="show-my-post" onclick="showMyPostList(<%= m.getMemberSeq() %>);">내 게시글 보기</button>
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
										<!-- 새 게시글 생성 폼 -->
										<div class="newPostformBox">
											<div class="new-post-form-popup" id="newPostForm">
												<form action="/petmily/pnewpost?memberseq=<%= m.getMemberSeq() %>&membernick=<%= m.getMemberNick() %>"
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
													</select> <input type="file" name="upfile" id="newfileupload"
														style="display: none;" accept="images/*"
														onchange="loadFile(event);"> <img id="new-post-file-upload"
														src="/petmily/resources/images/post/image-upload.png"
														alt="사진 업로드" onclick="fileUpload1();">
													<button type="submit" id="postsubmit">게시물 등록</button>
												</form>
											</div>
										</div>
									</div>
									<!-- 수정폼 wrap -->
									<div class="post-edit-form-wrap">
										<!-- 게시글 수정 폼 -->
										<div class="editPostformBox">
											<div class="edit-post-form-popup" id="editPostForm">
												<form action="/petmily/pedit" class="form-container" method="post"
													enctype="multipart/form-data">
													<textarea name="post-content" id="post-content-textarea" cols="30"
														rows="10" autofocus required
														oninvalid="this.setCustomValidity('내용을 입력해주세요');"
														oninput="setCustomValidity('')"></textarea>
													<select name="post-type" id="editformposttype" class="pl" required
														oninvalid="this.setCustomValidity('게시물 종류를 선택 해주세요')"
														oninput="setCustomValidity('')">
														<option value="" selected>게시글종류</option>
														<option value="standardpost">일반게시글</option>
														<option value="tradepost">중고거래글</option>
													</select> <input type="file" name="upfile" id="editfileupload"
														style="display: none;" accept="images/*"
														onchange="loadFile(event);"> <img id="new-post-file-upload"
														src="/petmily/resources/images/post/image-upload.png"
														alt="사진 업로드" onclick="fileUpload2();">
														<input type="hidden" name="postseq" id="inputpostseq">
														<input type="hidden" name="memberseq" id="inputmemberseq">
													<input type="hidden" name="originalfilename" id="inputoriginalfilename">
													<input type="hidden" name="changedfilename" id="inputchangedfilename">
													<button type="submit" id="postedit">수정</button>
												</form>
												<form action="/petmily/pdelete">
													<input type="hidden" name="dpostseq" id="dinputpostseq">
													<input type="hidden" name="dposttype" id="dinputposttype">
													<input type="hidden" name="dmemberseq" id="dinputmemberseq">
													<button type="submit" id="postdelete">삭제</button>
												</form>
											</div>
										</div>
									</div>
									</div>
									<br>
									<br>
									<br>
									<% if(list.size() > 0) { %>
									<!-- 게시글 전체 띄우기 -->
									<div class="block">
									<% for(Post p : list) { %>
										<% if(p instanceof StandardPost){ %>
											<!-- 일반게시글 -->
											<div id="standard-post" style="width: 700px; padding: 10px;" data-post-seq="<%= p.getPostSeq() %>" data-member-seq="<%= m.getMemberSeq() %>" data-post-type="standardpost">
												<table id="standardpost"
													style="position: relative; width: 100%; border-collapse: collapse; border: 1px solid hsl(36deg 70.37% 68.61%); top: 50px;">
													<tr id="postmemberid"
														style="padding-left: 20px; background-color: hsl(36deg 70.37% 68.61%);">
														<td
															style="text-align: left; height: 30px; padding-left: 20px; font-weight: bold; color: white;">
															일반게시글</td>
														<td
															style="width: 180px; font-weight: bold; color: white; padding-right: 20px;">
															<%= p.getLastModifiedDate() %>&nbsp;&nbsp;&nbsp;&nbsp;<%= p.getMemberNick() %>
														</td>
													</tr>
													<!-- 게시글 내용 -->
													<tr id="postcontent">
														<td colspan="2">
															<!-- 게시글에 사진이 있다면 사진표시 -->
															<% if(p.getChangedFileName()!=null) { %>
																<img alt="사진"
																	src="/petmily/resources/postupfiles/<%= p.getChangedFileName() %>"
																	width="400px" height="auto"> <br>
																<% } %> <!-- 게시글 내용 표시 -->
																	<%= p.getPostContent() %>
														</td>
													</tr>
													<!-- 좋아요 숫자 표시 -->
													<tr>
														<td class="likeNo">
															<img src="/petmily/resources/images/post/love.png" class="likeimg">
														</td>
														<td class="likenotext">
															<%= p.getLikeNo() %>
														</td>
													</tr>
													<!-- 자기 게시글일 경우 수정버튼 표시 -->
													<% if (m.getMemberSeq()==p.getMemberSeq()){ %>
														<tr id="postbottom" style="height: 50px; align-items: center;">
															<td colspan="2" id="posteditbutton"
																style="text-align: right; padding-right: 20px;">
																<button id="postEditButton" onclick="showEditForm('<%= p.getPostSeq() %>', '<%= p.getMemberSeq() %>', '<%= p.getPostContent() %>', '<%= p.getChangedFileName() %>', '<%= p.getOriginalFileName() %>', 'standardpost');">수정</button>
															</td>
														</tr>
														
														<% } %>
															<!-- 댓글달기 Row -->
															<tr id="replyrow">
																<td colspan="2">
																	<form action="/petmily/rnr" method="post">
																		<input type="text" name="reply-content" id="replyinputfield"
																		placeholder="댓글을 달아보세요" required> 
																		<!-- 댓글달기 버튼 -->
																		<input type="hidden" name="reply-memberseq" id="replymemberseq" value="<%= m.getMemberSeq() %>">
																		<input type="hidden" name="reply-postseq" id="replypostseq" value="<%= p.getPostSeq() %>">
																		<button id="postreply" type="submit">댓글</button>
																	</form>
																	</td>
															</tr>
															<!-- 게시글에 댓글이 있을 경우 댓글 띄우기 -->
																<% for (Reply r : rList) { %>
																	<!-- 댓글 띄우기 -->
																	<% if(p.getPostSeq()==r.getPostSeq()) { %>
																		<tr class="replies">
																			<td class="replyinfo">
																				<%= r.getMemberNick() %>&nbsp;&nbsp;&nbsp;&nbsp;<%= r.getReplyDate() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= r.getReplyContent() %>
																			</td>
																			<td>
																				<% if(m.getMemberSeq() == r.getMemberSeq()) { %>
																				<button class="replydelete" onclick="deleteReply(<%= r.getReplySeq() %>, <%= m.getMemberSeq() %>)">삭제</button>
																				<% } %>
																			</td>
																		</tr>
																		<% }} %>
												</table>
											</div>
											<% } else if (p instanceof TradePost) { %>
												<!-- 중고거래게시글 -->
												<div id="trade-post" style="width: 700px; padding: 10px;" data-post-seq="<%= p.getPostSeq() %>" data-member-seq="<%= m.getMemberSeq() %>" data-post-type="tradepost">
													<table id="standardpost"
														style="position: relative; width: 100%; border-collapse: collapse; border: 1px solid hsl(36deg 70.37% 68.61%); top: 50px;">
														<tr id="postmemberid"
															style="padding-left: 20px; background-color: hsl(36deg 70.37% 68.61%);">
															<td
																style="text-align: left; height: 30px; padding-left: 20px; font-weight: bold; color: white;">
																중고거래글</td>
															<td
																style="width: 180px; font-weight: bold; color: white; padding-right: 20px;">
																<%= p.getLastModifiedDate() %>&nbsp;&nbsp;&nbsp;&nbsp;<%= p.getMemberNick() %>
															</td>
														</tr>
														<!-- 게시글 내용 -->
														<tr id="postcontent">
															<td colspan="2">
																<!-- 게시글에 사진이 있다면 사진표시 -->
																<% if(p.getChangedFileName()!=null) { %>
																	<img alt="사진"
																		src="/petmily/resources/postupfiles/<%= p.getChangedFileName() %>"
																		width="400px" height="auto"> <br>
																	<% } %> <!-- 게시글 내용 표시 -->
																		<%= p.getPostContent() %>
															</td>
														</tr>
														<!-- 좋아요 숫자 표시 -->
														<tr>
															<td class="likeNo">
																<img src="/petmily/resources/images/post/love.png" class="likeimg">
															</td>
															<td class="likenotext">
																<%= p.getLikeNo() %>
															</td>
														</tr>
																<!-- 자기 게시글일 경우 수정버튼 표시 -->
																<% if (m.getMemberSeq()==p.getMemberSeq()){ %>
																	<tr id="postbottom" style="height: 50px; align-items: center;">
																		<td colspan="2" id="posteditbutton"
																			style="text-align: right; padding-right: 20px;">
																			<button id="postEditButton" onclick="showEditForm('<%= p.getPostSeq() %>', '<%= p.getMemberSeq() %>', '<%= p.getPostContent()  %>', '<%= p.getChangedFileName() %>', '<%= p.getOriginalFileName() %>', 'tradepost');">수정</button>
																		</td>
																	</tr>
																	<% } %>
															<!-- 댓글달기 Row -->
															<tr id="replyrow">
																<td colspan="2">
																	<form action="/petmily/rnr" method="post">
																		<input type="text" name="reply-content" id="replyinputfield"
																		placeholder="댓글을 달아보세요" required> 
																		<!-- 댓글달기 버튼 -->
																		<input type="hidden" name="reply-memberseq" id="replymemberseq" value="<%= m.getMemberSeq() %>">
																		<input type="hidden" name="reply-postseq" id="replypostseq" value="<%= p.getPostSeq() %>">
																		<button id="postreply" type="submit">댓글</button>
																	</form>
																	</td>
															</tr>
															<!-- 게시글에 댓글이 있을 경우 댓글 띄우기 -->
															<% for (Reply r : rList) { %>
																<!-- 댓글 띄우기 -->
																<% if(p.getPostSeq()==r.getPostSeq()) { %>
																	<tr class="replies">
																		<td class="replyinfo">
																			<%= r.getMemberNick() %>&nbsp;&nbsp;&nbsp;&nbsp;<%= r.getReplyDate() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= r.getReplyContent() %>
																		</td>
																		<td>
																			<% if(m.getMemberSeq() == r.getMemberSeq()) { %>
																			<button class="replydelete" onclick="deleteReply(<%= r.getReplySeq() %>, <%= m.getMemberSeq() %>)">삭제</button>
																			<% } %>
																		</td>
																	</tr>
																	<% }} %>
													</table>

												</div>
												<% }} %>
											</div>
											<% } else { %>
											<div class="block">
												<div id="postnotfound">
													게시물이 없습니다 게시물을 등록해보세요.
												</div>
											</div>
											
											<% }%>
						</body>

						</html>