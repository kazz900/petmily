package servicecenter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import servicecenter.model.service.BoardService;
import servicecenter.model.vo.Board;

/**
 * Servlet implementation class SelectAllSuggest
 */
@WebServlet("/suggest")
public class SelectAllSuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllSuggestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int currentPage = 1;
		
		int mseq = Integer.parseInt(request.getParameter("mseq"));
		
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 10;
		
		BoardService bserv = new BoardService();
		
		int listCount = bserv.getListCount(mseq);
		
		Paging paging = new Paging(listCount, currentPage, limit, "suggest");
		
		paging.calculator();
		
		ArrayList<Board> list = bserv.selectAllSuggest(
				mseq, paging.getStartRow(), paging.getEndRow());

		RequestDispatcher view = null;

		view = request.getRequestDispatcher("views/servicecenter/serviceCenter.jsp");
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("currentPage", currentPage);
		
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
