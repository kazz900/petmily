package department.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.model.service.DepartmentService;
import department.model.vo.Department;

/**
 * Servlet implementation class DelDeptServlet
 */
@WebServlet("/deldept")
public class RequestDeleteDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDeleteDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Department dept = new Department();
		
		dept.setDeptDeleteOk(request.getParameter("deleteOk"));
		dept.setDeptName(request.getParameter("name"));
		dept.setDeptAddress(request.getParameter("address"));
		
		int result = new DepartmentService().requestDeleteDept(dept);

		if (result > 0) {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/delSucceed.jsp");
		} else {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/delFailed.jsp");
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
