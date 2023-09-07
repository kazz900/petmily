package servicecenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicecenter.model.service.BoardService;
import servicecenter.model.vo.Board;

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
		
		Board board = new Board();
		
		board.setBrdReply(request.getParameter("reply"));
		board.setBrdNo(Integer.parseInt(request.getParameter("boardNo")));
		board.setBrdResult(request.getParameter("result"));

		int eResult = new BoardService().adminEditReply(board);

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
