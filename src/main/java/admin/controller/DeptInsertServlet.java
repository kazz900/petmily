package admin.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.model.service.DepartmentService;

/**
 * Servlet implementation class DeptManageServlet
 */
@WebServlet("/deptins")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptSeq = request.getParameter("deptSeq");
		String keyword = request.getParameter("keyword");

		int result = new DepartmentService().approveDept(deptSeq);

		request.setAttribute("deptSeq", deptSeq);
		request.setAttribute("keyword", keyword);

		response.sendRedirect("/petmily/ads?deptSeq=" + deptSeq + "&keyword=" + URLEncoder.encode(keyword, "UTF-8"));

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
