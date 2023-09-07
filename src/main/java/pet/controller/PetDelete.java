package pet.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pet.model.service.PetService;
import pet.model.vo.Pet;

/**
 * Servlet implementation class PetDelete
 */
@WebServlet("/petdel")
public class PetDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Pet pet = new Pet();
		
		pet.setMemberSeq(Integer.parseInt(request.getParameter("dmemberSeq")));
		pet.setPetSeq(Integer.parseInt(request.getParameter("deletePet")));
		
		
		int result = new PetService().petDelete(pet);
		if (result > 0) {
			if(!request.getParameter("deleteImg").equals("882.jpg")) {
			String renameFileName = request.getParameter("deleteImg");
			String savePath = request.getSession().getServletContext().getRealPath("/resources/images/petImg");
			new File(savePath + "\\" + renameFileName).delete(); 
			}
			String link = "/petmily/mypet?memberSeq="+pet.getMemberSeq();
			response.sendRedirect(link);
		} else {
			String link = "/petmily/mypet?memberSeq="+pet.getMemberSeq();
			response.sendRedirect(link);
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
