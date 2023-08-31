package standardpost.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import standardpost.model.service.StandardPostService;

/**
 * Servlet implementation class StandardPostDeleteServlet
 */
@WebServlet("/spdelete")
public class StandardPostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StandardPostDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
        // TEST COMMIT
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postSeq = Integer.parseInt(request.getParameter("postSeq"));
		int memberSeq = Integer.parseInt(request.getParameter("memberseq"));
		int result = 0;
		StandardPostService spService = new StandardPostService();
		result = spService.deleteStrandardPost(memberSeq, postSeq);
		
		if (result > 0) {
			//insert successful
			response.sendRedirect("/petmily/splist");
		} else {
			//insert fail
			// TODO : MAKE INSERT FAIL HTML
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
