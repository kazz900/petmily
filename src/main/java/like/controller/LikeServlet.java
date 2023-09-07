package like.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import like.model.service.LikeService;
import like.model.vo.Like;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/lcs")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		JSONObject job = new JSONObject();
		LikeService lService = new LikeService();
		Like l = new Like();
		int memberSeq = Integer.parseInt(request.getParameter("member_seq"));
		int postSeq = Integer.parseInt(request.getParameter("post_seq"));
		String postType = request.getParameter("post_type");
		String likeKey = String.valueOf(postSeq) + "-" + String.valueOf(memberSeq);
		l.setMemberSeq(memberSeq);
		l.setPostSeq(postSeq);
		l.setLikeKey(likeKey);

		result = lService.updateLike(l, postType);
		if(result > 0) {
			JSONObject sendJson = new JSONObject();
			sendJson.put("result", result);
			
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(sendJson.toJSONString());
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
