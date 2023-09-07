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
 * Servlet implementation class petMoverServlet
 */
@WebServlet("/moveup")
public class petMoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public petMoverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int memberSeq = Integer.parseInt(request.getParameter("memberseq"));
		int petSeq = Integer.parseInt(request.getParameter("petseq"));
		//ArrayList<Pet> list = new PetService().selectPet(memberSeq);		
		
		Pet pet = new PetService().selectPetmily(petSeq, memberSeq);
				
		//4. 받은 결과로 성공/실패 페이지 내보내기
		
		RequestDispatcher view = null;
		if(pet != null) {
			view = request.getRequestDispatcher("views/mypage/PetUpdate.jsp");
			request.setAttribute("pet", pet);
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
