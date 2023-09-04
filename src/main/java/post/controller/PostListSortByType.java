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
 * Servlet implementation class PostListSortByType
 */
@WebServlet("/plistbytype")
public class PostListSortByType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostListSortByType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostSerivce pSerivce = new PostSerivce();
		ReplyService rService = new ReplyService();
		String postType = request.getParameter("posttype");
		ArrayList<Post> list = pSerivce.getPostListByType(postType);
		ArrayList<Reply> rList = rService.getReplyList();

		RequestDispatcher view = null;
		
		if(list.size() > 0) {
			view = request.getRequestDispatcher("views/post/postList.jsp");
			
			request.setAttribute("list", list);
			request.setAttribute("rList", rList);
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
