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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		RequestDispatcher view = null;
		Post p = null;
		PostSerivce pService = new PostSerivce();
		
		//1. multipart 방식으로 인코딩되어서 전송왔는지 확인
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form의 enctype='multipart/form-data' 속성 누락됨.");
			view.forward(request, response);
		}
		
		//2. 업로드할 파일의 용량 제한 설정 : 10메가바이트로 제한한다면
		int maxSize = 1024 * 1024 * 10;
		
		//3. 업로드되는 파일의 저장 폴더 지정
		String savePath = request.getSession().getServletContext().getRealPath("/resources/postupfiles");
		//request.getSession().getServletContext()  => "/first"  + 뒤에 하위 폴더 경로 추가함
		

		//4. request 를 MultipartRequest 로 변환해야 함
		//MultipartRequest 클래스는 외부 라이브러리를 사용해야 함 : cos.jar 사용한 경우
		//MultipartRequest 객체가 생성되면, 자동으로 지정 폴더에 업로드된 파일이 저장됨
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		String originalFileName = "";
		
		//6. 업로드된 원본 파일이름 추출
		if(mrequest.getFilesystemName("upfile") != null) {
			System.out.println("파일존재");
			originalFileName = mrequest.getFilesystemName("upfile");			
		}else {
			System.out.println("파일없음");
			originalFileName = null;
		}
		
		//7. 폴더에 저장된 파일의 이름바꾸기 처리
		// 저장 폴더에 같은 이름의 파일이 있을 경우를 대비하기 위함
		// "년월일시분초.확장자" 형식으로 변경할 것임
		// GET POST INFORMATIONS
		int memberSeq = Integer.parseInt(mrequest.getParameter("memberseq"));
		System.out.println(memberSeq);
		String postType = mrequest.getParameter("post-type");
		String postContent = mrequest.getParameter("post-content");
		
		// 일반게시글일떄
		if (postType.equals("standardpost")) {
			System.out.println(5);
			p = new StandardPost();
			p.setMemberSeq(memberSeq);
			p.setPostContent(postContent);
			if(originalFileName != null) {
				p.setOriginalFileName(originalFileName);				
				String renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
				p.setChangedFileName(renameFileName);
			}else {
				p.setOriginalFileName(null);
				p.setChangedFileName(null);
			}
		} else { // 중고거래게시글일떄
			p = new TradePost();
			p.setMemberSeq(memberSeq);
			p.setPostContent(postContent);
			if(originalFileName != null) {
				p.setOriginalFileName(originalFileName);				
				String renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
				p.setChangedFileName(renameFileName);
			}else {
				p.setOriginalFileName(null);
				p.setChangedFileName(null);
			}
		}
		
		System.out.println(p.getMemberSeq() + ", " +  p.getPostContent() + ", " + p.getChangedFileName());

		result = pService.updatePost(p.getMemberSeq(), p);

		if (result > 0) {
			// insert successful
			System.out.println(8);
			String path = "/petmily/plist?memberseq=" + String.valueOf(memberSeq);
			response.sendRedirect(path);
		} else {
			// insert fail
			// TODO : MAKE INSERT FAIL HTML
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
