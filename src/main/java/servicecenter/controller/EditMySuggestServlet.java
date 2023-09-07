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
 * Servlet implementation class EditMySuggestServlet
 */
@WebServlet("/editSuggest")
public class EditMySuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMySuggestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Board board = new Board();

		board.setMemberNo(Integer.parseInt(request.getParameter("userid")));
		board.setBrdNo(Integer.parseInt(request.getParameter("boardNo")));
		board.setResult(request.getParameter("result"));
		board.setBrdTitle(request.getParameter("title"));
		board.setBrdContent(request.getParameter("content"));
		
		int eResult = new BoardService().updateMySuggest(board);

//		RequestDispatcher view = null;

		if (eResult > 0) {
//			response.sendRedirect("/petmily/suggest?message='정상적으로 수정되었습니다.'");
			response.sendRedirect("/petmily/views/servicecenter/dCommon/updateSucceed2.jsp");
//			String message = "건의사항이 수정되었습니다.";
//		    response.sendRedirect(request.getContextPath() + "/suggest?message=" + message);
			
		} else {
			response.sendRedirect("/petmily/views/servicecenter/dCommon/readFailed.jsp");
//			String message = "수정 중 문제가 발생하였습니다.";
//			request.setAttribute("message", message);
//			response.sendRedirect(request.getContextPath() + "/suggest");
		}
//		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
