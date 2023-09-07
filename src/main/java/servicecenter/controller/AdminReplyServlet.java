package servicecenter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicecenter.model.service.BoardService;

/**
 * Servlet implementation class AdminReplyServlet
 */
@WebServlet("/addAdminReply")
public class AdminReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String reply = request.getParameter("reply");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String result = request.getParameter("result");

		int eResult = new BoardService().addAdminReply(reply, boardNo, result);
		if (eResult > 0) {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/updateSucceed3.jsp");
		} else {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/readFailed.jsp");
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
