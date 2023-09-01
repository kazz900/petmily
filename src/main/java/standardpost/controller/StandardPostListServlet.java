package standardpost.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import standardpost.model.service.StandardPostService;
import standardpost.model.vo.StandardPost;

/**
 * Servlet implementation class StandardPostListViewServlet
 */
@WebServlet("/splist")
public class StandardPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StandardPostListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StandardPostService spSerivce = new StandardPostService();
		ArrayList<StandardPost> list = new ArrayList<StandardPost>();
		list = spSerivce.getStandardPostList();
		
		RequestDispatcher view = null;
		
		if(list.size() > 0) {
			view = request.getRequestDispatcher("views/post/postList.jsp");
			
			request.setAttribute("list", list);
		} else {
			view = request.getRequestDispatcher("views/common/waiting.jsp");
		}
		
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
