package post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.PostSerivce;
import post.model.vo.Post;
import reply.model.service.ReplyService;
import reply.model.vo.Reply;

/**
 * Servlet implementation class StandardPostFilterListServlet
 */
@WebServlet("/plistsortbypopularity")
public class PostListSortByPopularityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostListSortByPopularityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostSerivce pService = new PostSerivce();
		ReplyService rService = new ReplyService();
		ArrayList<Post> list = pService.getPostListSortByPopularity();
		ArrayList<Reply> rList = rService.getReplyList();
		
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("views/post/postList.jsp");

		request.setAttribute("list", list);
		request.setAttribute("rList", rList);

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
