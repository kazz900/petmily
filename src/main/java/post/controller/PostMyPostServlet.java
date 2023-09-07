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
 * Servlet implementation class StandardPostMyPostViewServlet
 */
@WebServlet("/pmypost")
public class PostMyPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostMyPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostSerivce pSerivce = new PostSerivce();
		ReplyService rService = new ReplyService();
		ArrayList<Post> list = new ArrayList<Post>();
		ArrayList<Reply> rList = new ArrayList<Reply>();
		int memberSeq = Integer.parseInt(request.getParameter("memberseq"));
		list = pSerivce.getMyPostList(memberSeq);
		rList = rService.getReplyList();

		RequestDispatcher view = null;

		view = request.getRequestDispatcher("views/post/postList.jsp");

		request.setAttribute("list", list);
		request.setAttribute("rList", rList);

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
