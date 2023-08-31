package pet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//  //1. 전송온 값에 한글이 있다면 인코딩처리함
		request.setCharacterEncoding("UTF-8");  //전송보낸 뷰페이지의 문자셋(charset)을 값으로 사용함
		
		//2. 전송온 값 꺼내서 변수 또는 객체에 옮겨 저장하기
		Pet pet = new Pet();  //모델 서비스로 보낼 값의 갯수가 1개 이상이면 객체에 저장함
		
	
		pet.setPetName(request.getParameter("petname"));
		pet.setPetType(request.getParameter("pettype"));
		pet.setPetSize(request.getParameter("petsize"));
		
		int memberSeq = Integer.parseInt(request.getParameter("memberSeq"));
		
		
		//3. 모델의 서비스 메소드로 값 전달 실행하고 결과받기
		//int result = new PetService().insertPet(pet, memberseq);
		int result = new PetService().insertPet(pet, memberSeq);
		//에러 페이지 테스트
		//int result = 0;
		System.out.println("result" + result);
		//4. 받은 결과로 성공 또는 실패 페이지 내보내기
		if(result > 0) {
			//펫 등록 성공시 마이 페이지로 이동 처리
			response.sendRedirect("/petmily/mypet?memberSeq=" + memberSeq);
			
		}else {
			//회원가입 실패시 error.jsp 로 에러메세지를 보냄
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			//상대경로만 사용할 수 있음
			
			//지정한 뷰로 내보낼 정보나 객체가 있으면 request 에 기록 저장함
			//request.setAttribute(String name, Object value);
			request.setAttribute("message", "pet등록 실패!");
			
			//뷰를 포워딩함
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
