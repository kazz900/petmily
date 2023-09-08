package post.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.FileNameChange;
import post.model.service.PostSerivce;
import post.model.vo.Post;
import standardpost.model.vo.StandardPost;
import tradepost.model.vo.TradePost;

/**
 * Servlet implementation class StandardPostNewPostViewServlet
 */
@WebServlet("/pnewpost")
public class PostNewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostNewPostServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		RequestDispatcher view = null;
		Post p = null;
		PostSerivce pService = new PostSerivce();

		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form의 enctype='multipart/form-data' 속성 누락됨.");
			view.forward(request, response);
		}
		
		int maxSize = 1024 * 1024 * 10;

		String savePath = request.getSession().getServletContext().getRealPath("/resources/postupfiles");

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		// GET POST INFORMATIONS
		int memberSeq = Integer.parseInt(mrequest.getParameter("memberseq"));
		String originalFileName = mrequest.getFilesystemName("upfile");
		String postType = mrequest.getParameter("post-type");
		String postContent = mrequest.getParameter("post-content");
		String memberNick = mrequest.getParameter("membernick");
		postContent = postContent.replace('\n', ' ').replace('\r', ' ');
		
		
		// 일반게시글일떄
		if (postType.equals("standardpost")) {
			p = new StandardPost();
			p.setMemberSeq(memberSeq);
			p.setPostContent(postContent);
			p.setOriginalFileName(originalFileName);
			p.setMemberNick(memberNick);
			if(originalFileName != null) {
				String renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
				p.setChangedFileName(renameFileName);
			}
		} else { // 중고거래게시글일떄
			p = new TradePost();
			p.setMemberSeq(memberSeq);
			p.setPostContent(postContent);
			p.setOriginalFileName(originalFileName);
			p.setMemberNick(memberNick);
			if(originalFileName != null) {
				String renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
				p.setChangedFileName(renameFileName);
			}
		}

		result = pService.insertPost(p.getMemberSeq(), p);

		if (result > 0) {
			// insert successful
			String path = "/petmily/plist?memberseq=" + String.valueOf(memberSeq);
			response.sendRedirect(path);
		} else {
			// insert fail
			// TODO : MAKE INSERT FAIL HTML
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
