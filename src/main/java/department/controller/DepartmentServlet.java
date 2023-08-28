package department.controller;

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
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/selectdepartment")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		
		response.sendRedirect("views/department/deptsearch.jsp");
		
//		DepartmentService dservice = new DepartmentService();
//		String value = request.getParameter("select");
//		ArrayList<Department> list = dservice.selectList(value);
//		
//		//받은 결과에 따라 성공 또는 실패 페이지 내보내기
//		RequestDispatcher view = null;
//		
//		if(list.size() > 0) {
//			view = request.getRequestDispatcher("views/department/deptsearch.jsp");
//			request.setAttribute("list", list);
//		} else {
//			view = request.getRequestDispatcher("views/common/error.jsp");
//			
//			request.setAttribute("message",  "selectdepartment");
//		}
//		
//		//내보내기
//		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
