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

						table#post {
							height: auto;
							width: 700px;
							border: 1px solid;
							border-radius: 4px;
							border-collapse: collapse;
						}

						table tr#postmemberid{
							background-color: #fda90d;
							padding-left: 20px;
							margin: 0px;
						}



						table tr#postcontent td{
							text-align: center;
							padding: 30px;
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

						table tr#postbottom{
							border-top: 1px solid black;
							height: 50px;
							display: flex;
							align-items: center;
						}

						:root {
							--button-color: #ffffff;
							--button-bg-color: #fda90d;
						}

						table tr td#postbuttons button {
							-webkit-appearance: none;
							-moz-appearance: none;
							appearance: none;

							background: var(--button-bg-color);
							color: var(--button-color);

							margin: 0;
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
					</style>
				</head>

				<body>

					<%@ include file="../common/main.jsp" %>


						<div class="block" align="center">
							<input id="newpost" type="text" placeholder="오늘 무슨 일이 있었나요?">
						</div>

						<div class="block" align="center">
							<% for(StandardPost sp : list) { %>
								<table id="post">
									<tr id="postmemberid">
										<td colspan="2" style="height:30px; padding-left: 20px;">
											<%= sp.getMemberId() %>
										</td>
									</tr>
									<tr id="postcontent">
										<td colspan="2">
											<%= sp.getPostContent() %>
										</td>
									</tr>
									<tr id="postbottom">
										<td id="posteditdate">수정일자 <%= sp.getPostDate() %></td>
										<td id="postbuttons"><button>수정하기</button></td>
									</tr>
									<br>
								</table>
								<% } %>
						</div>


				</body>

				</html>