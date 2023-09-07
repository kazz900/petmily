package admin.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import department.model.service.DepartmentService;
import department.model.vo.Department;

/**
 * Servlet implementation class SelectRequestTerminateDept
 */
@WebServlet("/srtd")
public class SelectRequestTerminateDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectRequestTerminateDept() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//출력할 페이지 지정
		int currentPage = 1;
		// 전송온 페이지 값이 있다면 추출함
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 10;

		DepartmentService dservice = new DepartmentService();
		
		//총 페이지 수 계산을 위한 전체 목록 갯수 조회
		int listCount = dservice.getDeleteDeptListCount();
		
		//뷰 페이지에서 사용할 페이징 관련 값 계산 처리
		Paging paging = new Paging(listCount, currentPage, limit, "srtd");
		paging.calculator();
		
		request.setCharacterEncoding("utf-8");
		
		ArrayList<Department> list = dservice.selectRequestTerminateDept(paging.getStartRow(), paging.getEndRow());
		String keyword = (String)request.getParameter("keyword");
		
		if(keyword == null) {
			keyword = "";
			
			RequestDispatcher view = null;
			
			view = request.getRequestDispatcher("views/admin/AdminDeptTerminate.jsp");
			request.setAttribute("list", list);
			request.setAttribute("listcount", listCount);
			request.setAttribute("keyword", keyword);
			request.setAttribute("paging", paging);
			request.setAttribute("currentPage", currentPage);
			
			view.forward(request, response);
		} else {
			response.sendRedirect("/petmily/adf?keyword="+URLEncoder.encode(keyword, "UTF-8"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
