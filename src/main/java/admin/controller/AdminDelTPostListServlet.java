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
 * Servlet implementation class AdminDelTPost
 */
@WebServlet("/adtp")
public class AdminDelTPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDelTPostListServlet() {
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
			list = new AdminPostService().showTradePostList();
			keyword = "";
		} else {
			switch (action) {
			case "id":
				list = apservice.findSearchMemberId(keyword);
				break;
			case "content":
				list = apservice.findSearchContent(keyword);
				break;
			case "grade":
				list = apservice.findSearchMemberGrade(keyword);
				break;
			}
		}
		RequestDispatcher view = null;

			request.setAttribute("keyword", keyword);
			request.setAttribute("list", list);
			request.setAttribute("action", action);
			view = request.getRequestDispatcher("views/admin/AdminTradePostDelete.jsp");
			view.forward(request, response);
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
