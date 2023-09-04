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
 * Servlet implementation class PetSelect
 */
@WebServlet("/PetSelect")
public class PetSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int petSeq = Integer.parseInt(request.getParameter("petSeq"));
		
		Pet pet = new PetService().selectPetSeq(petSeq);
		
		
		
		
		
		RequestDispatcher view = null;
		if(pet != null) { 
			view = request.getRequestDispatcher("views/mypage/updatePet.jsp");
			request.setAttribute("petSeq", pet);
		}else { 
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", pet + "정보 조회 실패!");
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
