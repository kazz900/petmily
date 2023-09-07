package admin.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminPostService;

/**
 * Servlet implementation class AdminTerminateSPostServlet
 */
@WebServlet("/atss")
public class AdminTerminateSPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTerminateSPostServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("postSeq");
		String keyword = request.getParameter("keyword");
		String action = request.getParameter("action");
		
		
		
		int result = new AdminPostService().terminatePost(value);
		if(action != null) {
			response.sendRedirect("/petmily/adsp?keyword=" + URLEncoder.encode(keyword, "UTF-8")+"&action="+action);
		} else {			
			response.sendRedirect("/petmily/adsp");
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
