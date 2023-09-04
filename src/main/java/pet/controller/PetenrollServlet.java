package pet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.FileNameChange;
import member.model.vo.Member;
import pet.model.service.PetService;
import pet.model.vo.Pet;

/**
 * Servlet implementation class PetenrollServlet
 */
@WebServlet("/peten")
public class PetenrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetenrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 원글 등록 처리용 컨트롤러 : 파일업록드가 있는 전송인 경우임
		
				//1. multipart 방식으로 인코딩되어서 전송왔는지 확인
				//아니면 에러 페이지를 내보냄
				RequestDispatcher view = null;
				if(!ServletFileUpload.isMultipartContent(request)) {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "form의 enctype='multipart/form-data' 속성 누락됨");
					view.forward(request, response);
				}
				
				//2. 업로드할 파일의 용량 제한 설정 : 10메가바이트로 제한한다면 
				int maxSize = 1024 * 1024 * 10;
				
				//3. 업로드되는 파일의 저장 폴더 지정
				String savePath = request.getSession().getServletContext().getRealPath("/resources/images/petImg");
				//request.getSession().getServletContext() => "/first" + 뒤에 하위 폴더 경로 추가함
				
				//4. request 를 MultipartRequest 로 반환해야 함
				//MultipartRequest 클래스는 외부 라이브러리를 사용해야 함 : cos.jar 사용한 경우
				//MultipartRequest 객체가 생성되면, 자동으로 지정 폴더에 업로드된 파일이 저장됨
				MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, 
						"utf-8", new DefaultFileRenamePolicy());
				
				//5. 데이터베이스 board 테이블에 기록할 값 추출
				//mrequest 사용해야 함 (request 사용 못 함)
				Pet pet = new Pet();
				HttpSession session = request.getSession();
				Member member = (Member)session.getAttribute("member");
				pet.setMemberSeq(member.getMemberSeq());
				pet.setPetName(mrequest.getParameter("petName"));
				pet.setPetType(mrequest.getParameter("petType"));
				pet.setPetSize(mrequest.getParameter("petSize"));
				String renameFileName = null;
				if(mrequest.getFilesystemName("input-image") != null) {
				//6. 업로드된 원본 파일이름 추출
				String originalFileName = mrequest.getFilesystemName("input-image");
				
				renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
					
					
				
				}else {
				renameFileName = "882.jpg";
				}
				
				pet.setPetImg(renameFileName);
				
				//모델 서비스 메소드로 전달하고 결과 받기
				int result = new PetService().insertPet(pet);
				
				//받은 결과로 성공/실패 페이지 내보내기
						if(result > 0) {
							//서블렛에서 서블렛을 실행함
							String link = "/petmily/mypet?memberSeq="+member.getMemberSeq();
							response.sendRedirect(link);
						}else { 
							view = request.getRequestDispatcher("views/common/error.jsp");
							request.setAttribute("message", "새 게시 원글 등록 실패!");
							view.forward(request, response);
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
