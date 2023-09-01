package servicecenter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicecenter.model.service.BoardService;
import servicecenter.model.vo.Board;

/**
 * Servlet implementation class BoardDetailPageServlet
 */
@WebServlet("/bdetail")
public class BoardDetailPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		Board board = new BoardService().selectBoard(bnum);
		
		RequestDispatcher view = null;
		if (board != null) {
			view = request.getRequestDispatcher("views/servicecenter/mySuggestDetail.jsp");
			request.setAttribute("board", board);
		} else {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/readFailed.jsp");
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
