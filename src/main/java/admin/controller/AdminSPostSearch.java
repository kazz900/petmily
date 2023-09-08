package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminPostService;
import admin.model.vo.AdminPost;





/**
 * Servlet implementation class AdminSPostSearch
 */
@WebServlet("/asps")
public class AdminSPostSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSPostSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String action = request.getParameter("action");
		String keyword = request.getParameter("keyword");
		
		if(keyword == null) {
			keyword = "";
		}
		AdminPostService apservice = new AdminPostService();
		ArrayList<AdminPost> list = null;
		
		switch(action) {
		case "id": 		list = apservice.selectSearchMemberId(keyword);	break;
		case "content":		list = apservice.selectSearchContent(keyword);	break;
		case "grade":		list = apservice.selectSearchMemberGrade(keyword);		break;
		}
		
		
		
	
				
		RequestDispatcher view = null;
		

		view = request.getRequestDispatcher("views/admin/AdminStandardPostDelete.jsp");
		request.setAttribute("list", list);
		request.setAttribute("keyword", keyword);
		request.setAttribute("action", action);
		

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
