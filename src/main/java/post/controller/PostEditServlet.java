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
 * Servlet implementation class StandardPostEditViewServlet
 */
@WebServlet("/pedit")
public class PostEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostEditServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		int checkIfTypeChanged = 0;
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

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		String originalFileName = mrequest.getFilesystemName("upfile");
		int postSeq = Integer.parseInt(mrequest.getParameter("postseq"));
		String postType = mrequest.getParameter("post-type");
		String postContent = mrequest.getParameter("post-content");
		int memberSeq = Integer.parseInt(mrequest.getParameter("memberseq"));

		checkIfTypeChanged = pService.checkIfTypeChanged(postSeq, postType);
		System.out.println(checkIfTypeChanged);

//		checkIfTypeChanged 가 0보다 높다면 포스트 타입이 변경되었음을 의미
		if (checkIfTypeChanged > 0) {
			System.out.println("타입 변경");
			//기존 테이블에서 post 가져옴
			p = pService.selectPost(postSeq, postType);
			System.out.println(p.toString());
			// 기존 테이블에 있던 POST를 DELETE하고
			// 다른 테이블에 똑같은 POST를 생성함
			if (postType.equals("standardpost")) {
				StandardPost sp = new StandardPost();
				sp.setMemberId(p.getMemberId());
				sp.setPostSeq(p.getPostSeq());
				sp.setMemberSeq(p.getMemberSeq());
				sp.setMemberNick(p.getMemberNick());
				sp.setPostContent(postContent);
				sp.setPostImg(p.getPostImg());
				sp.setLikeNo(p.getLikeNo());
				sp.setReplyNO(p.getReplyNO());
				sp.setPostDate(p.getPostDate());
				sp.setLastModifiedDate(p.getLastModifiedDate());
				sp.setTradeResult(p.getTradeResult());
				sp.setOriginalFileName(p.getOriginalFileName());
				sp.setChangedFileName(p.getChangedFileName());
				// 만약 사진 파일이 변경된다면 originalfilename, changedfilename 변경함
				if (originalFileName != null) {
					pService.deleteImage(p);
					String renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
					p.setOriginalFileName(originalFileName);
					p.setChangedFileName(renameFileName);
				}
				//기존 포스트 삭제
				pService.deletePost(p);
				//다른 테이블에 포스트 인서트
				result = pService.insertPost(memberSeq, sp);
			} else {
				TradePost tp = new TradePost();
				tp.setMemberId(p.getMemberId());
				tp.setPostSeq(p.getPostSeq());
				tp.setMemberSeq(p.getMemberSeq());
				tp.setMemberNick(p.getMemberNick());
				tp.setPostContent(postContent);
				tp.setPostImg(p.getPostImg());
				tp.setLikeNo(p.getLikeNo());
				tp.setReplyNO(p.getReplyNO());
				tp.setPostDate(p.getPostDate());
				tp.setLastModifiedDate(p.getLastModifiedDate());
				tp.setTradeResult(p.getTradeResult());
				tp.setOriginalFileName(p.getOriginalFileName());
				tp.setChangedFileName(p.getChangedFileName());
				// 만약 사진 파일이 변경된다면 originalfilename, changedfilename 변경함
				if (mrequest.getFilesystemName("upfile") != null) {
					pService.deleteImage(p);
					String renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
					p.setOriginalFileName(originalFileName);
					p.setChangedFileName(renameFileName);
				}
				//기존 포스트 삭제
				pService.deletePost(p);
				//다른 테이블에 포스트 인서트
				result = pService.insertPost(memberSeq, tp);
			}
			
			
		} else {
			System.out.println("타입 변경 안됨");
			// 타입이 변경되지 않았으므로 그냥 해당 테이블에서 UPDATE함
			if (postType.equals("standardpost")) {
				p = new StandardPost();
				p.setPostSeq(postSeq);
				p.setMemberSeq(memberSeq);
				p.setPostContent(postContent);
				p.setOriginalFileName(null);
				p.setChangedFileName(null);
				if (originalFileName != null) {
					pService.deleteImage(p);
					String renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
					p.setOriginalFileName(originalFileName);
					p.setChangedFileName(renameFileName);
				}
			} else {
				p = new TradePost();
				p.setPostSeq(postSeq);
				p.setMemberSeq(memberSeq);
				p.setPostContent(postContent);
				p.setOriginalFileName(null);
				p.setChangedFileName(null);
				if (mrequest.getFilesystemName("upfile") != null) {
					pService.deleteImage(p);
					String renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
					p.setOriginalFileName(originalFileName);
					p.setChangedFileName(renameFileName);
				}
			}
			
			result = pService.updatePost(p.getMemberSeq(), p);
		}


		if (result > 0) {
			// insert successful
			String path = "/petmily/plist?memberseq=" + String.valueOf(memberSeq);
			response.sendRedirect(path);
		} else {
			String path = "/petmily/plist?memberseq=" + String.valueOf(memberSeq);
			response.sendRedirect(path);
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
