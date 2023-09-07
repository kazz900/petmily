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
 * Servlet implementation class AdminDelSPost
 */
@WebServlet("/adsp")
public class AdminDelSPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDelSPostListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<AdminPost> list = null;
		AdminPostService apservice = new AdminPostService();
		String keyword = request.getParameter("keyword");
		String action = request.getParameter("action");

		if (keyword == null || keyword == "") {
			list = new AdminPostService().selectPostList();
			keyword = "";
		} else {
			switch (action) {
			case "id":
				list = apservice.selectSearchMemberId(keyword);
				break;
			case "content":
				list = apservice.selectSearchContent(keyword);
				break;
			case "grade":
				list = apservice.selectSearchMemberGrade(keyword);
				break;
			}
		}
		RequestDispatcher view = null;

			request.setAttribute("keyword", keyword);
			request.setAttribute("list", list);
			request.setAttribute("action", action);
			view = request.getRequestDispatcher("views/admin/AdminStandardPostDelete.jsp");
			view.forward(request, response);

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
