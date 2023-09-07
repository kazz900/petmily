package reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.service.ReplyService;
import reply.model.vo.Reply;

/**
 * Servlet implementation class ReplyNewReplyServlet
 */
@WebServlet("/rnr")
public class ReplyNewReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyNewReplyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		request.setCharacterEncoding("utf-8");
		ReplyService rSerivce = new ReplyService();
		Reply r = new Reply();
		String replyContent = request.getParameter("reply-content");
		int memberSeq = Integer.parseInt(request.getParameter("reply-memberseq"));
		int postSeq = Integer.parseInt(request.getParameter("reply-postseq"));
		r.setMemberSeq(memberSeq);
		r.setPostSeq(postSeq);
		r.setReplyContent(replyContent);
		
		result = rSerivce.insertReply(r);
		
		if(result > 0) {
			String path = "/petmily/plist?memberseq=" + String.valueOf(memberSeq);
			response.sendRedirect(path);
		}else {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
