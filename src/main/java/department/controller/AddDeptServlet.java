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
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/adddept")
public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddDeptServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Department dept = new Department();
		
		dept.setDeptName(request.getParameter("name"));
		dept.setDeptType(request.getParameter("type"));
		dept.setDeptAddress(request.getParameter("address"));
		dept.setDeptPhone(request.getParameter("phone"));
		dept.setDeptTime(request.getParameter("open") + " ~ " + request.getParameter("close"));
		dept.setDeptRestrict(request.getParameter("animalSize"));
		dept.setDeptParking(request.getParameter("parking"));
		dept.setDeptEntrancefee(request.getParameter("entFee"));
		dept.setDeptWithpetfee(request.getParameter("petFee"));
		dept.setDeptRestrict(request.getParameter("restrict"));
		dept.setDeptInsertOk(request.getParameter("insertOk"));
		dept.setDeptDeleteOk(request.getParameter("deleteOk"));
		
		int result = new DepartmentService().insertDepartment(dept);
		
		if (result > 0) {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/addSucceed.jsp");
		} else {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/addFailed.jsp");
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
