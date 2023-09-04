package pet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pet.model.service.PetService;
import pet.model.vo.Pet;

/**
 * Servlet implementation class MypetServlet
 */
@WebServlet("/mypet")
public class MypetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		
		
		int memberSeq = Integer.parseInt(request.getParameter("memberSeq"));
		//System.out.println(memberSeq);
		
		
		//3. 모델 서비스 메소드로 값 전달 실행하고 결과 받기
		
		//Pet pet = new PetService().selectPet(memberseq);
		
		//String value = request.getParameter("Pettype");
		
		
		//ArrayList<Pet> list = new PetService().selectPet(value);
		
		ArrayList<Pet> list = new PetService().selectPet(memberSeq);		
		
		//System.out.println(list.size());
		
		
		
		//4. 받은 결과로 성공/실패 페이지 내보내기
		
		RequestDispatcher view = null;
		System.out.println(list.size());
		if(list.size() > 0) {
			view = request.getRequestDispatcher("views/mypage/changeMyinfo.jsp");
			request.setAttribute("list", list);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "펫밀리 전체 조회 실패!");
		}
		view.forward(request, response);
		
		
		
		
	
	}	
		
		

		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
