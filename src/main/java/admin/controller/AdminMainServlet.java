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
import department.model.service.DepartmentService;
import department.model.vo.Department;

/**
 * Servlet implementation class DeptManageServlet
 */
@WebServlet("/adminmain")
public class AdminMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminMainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");

		ArrayList<Department> list = new DepartmentService().selectNotInsertedDept();
		
		
		RequestDispatcher view = request.getRequestDispatcher("views/admin/AdminDeptInsert.jsp");
		
		if (keyword == null) {
			keyword = "";
		}
		
		request.setAttribute("list", list);
		request.setAttribute("keyword", keyword);
		
		

		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
