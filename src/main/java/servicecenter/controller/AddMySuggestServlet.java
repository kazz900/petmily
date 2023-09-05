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
 * Servlet implementation class AddMySuggest
 */
@WebServlet("/addsuggest")
public class AddMySuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMySuggestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Board board = new Board();
		
		board.setBrdTitle(request.getParameter("title"));
		board.setBrdContent(request.getParameter("content"));
		board.setBrdResult(request.getParameter("result"));
		board.setBrdMemberNo(Integer.parseInt(request.getParameter("mNo")));

		int result = new BoardService().addMySuggest(board);

		if (result > 0) {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/addSuggestSucceed.jsp");
		} else {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/addFailed.jsp");
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
