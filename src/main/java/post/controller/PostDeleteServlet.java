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
import standardpost.model.vo.StandardPost;
import tradepost.model.vo.TradePost;

/**
 * Servlet implementation class StandardPostDeleteServlet
 */
@WebServlet("/pdelete")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
        // TEST COMMIT
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostSerivce pSerivce = new PostSerivce();
		ReplyService rService = new ReplyService();
//		ArrayList<Post> list = pSerivce.getPostList();
//		ArrayList<Reply> rList = rService.getReplyList();
		int postSeq = Integer.parseInt(request.getParameter("dpostseq"));
		int memberSeq = Integer.parseInt(request.getParameter("dmemberseq"));
		String postType = request.getParameter("dposttype");
		int result = 0;
		Post p = null;

		if(postType.equals("standardpost")) {
			p = new StandardPost();
			p.setPostSeq(postSeq);
		}else {
			p = new TradePost();
			p.setPostSeq(postSeq);
		}
		
		result = pSerivce.deletePost(p); 
		
		if (result > 0) {
			String path = "/petmily/plist?memberseq=" + String.valueOf(memberSeq);
			response.sendRedirect(path);
		} else {
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
