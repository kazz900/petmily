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
		
		int memberSeq = Integer.parseInt(request.getParameter("memberSeq"));
		
		ArrayList<Pet> list = new PetService().selectPet(memberSeq);		
		
		RequestDispatcher view = null;
		System.out.println(list.size());
		if(list.size() > 0) {

			request.setAttribute("message", "정보있음");

			request.setAttribute("list", list);
		}else {
			request.setAttribute("message", "정보없음");
		}
		view = request.getRequestDispatcher("views/mypage/changeMyinfo.jsp");
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
