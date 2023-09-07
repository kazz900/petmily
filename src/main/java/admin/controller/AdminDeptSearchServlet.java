package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.model.service.DepartmentService;
import department.model.vo.Department;

/**
 * Servlet implementation class AdminDeptSearch
 */
@WebServlet("/ads")
public class AdminDeptSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeptSearchServlet() {
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
		
		    DepartmentService dservice = new DepartmentService();
			ArrayList<Department> list = dservice.selectDeptName(keyword);
			
			RequestDispatcher view = null;
			

			view = request.getRequestDispatcher("views/admin/AdminDeptInsert.jsp");
			request.setAttribute("list", list);
			request.setAttribute("keyword", keyword);

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
