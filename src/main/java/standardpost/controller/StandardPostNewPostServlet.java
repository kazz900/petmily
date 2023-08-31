package standardpost.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import standardpost.model.service.StandardPostService;
import standardpost.model.vo.StandardPost;

/**
 * Servlet implementation class StandardPostNewPostViewServlet
 */
@WebServlet("/spnewpost")
public class StandardPostNewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StandardPostNewPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		StandardPostService spService = new StandardPostService();

		request.setCharacterEncoding("utf-8");

		String postContent = request.getParameter("post-content");
		// TODO : MEMBER VALIDITY CHECK
		int memberSeq = Integer.parseInt(request.getParameter("memberseq"));
		
		StandardPost sp = new StandardPost();
		sp.setMemberSeq(memberSeq);
		sp.setPostContent(postContent);
		

		result = spService.insertStandardPost(sp.getMemberSeq(), sp);

		if (result > 0) {
			//insert successful
			response.sendRedirect("/petmily/splist");
		} else {
			//insert fail
			// TODO : MAKE INSERT FAIL HTML
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
