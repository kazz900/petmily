package department.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import department.model.service.DepartmentService;
import department.model.vo.Department;



/**
 * Servlet implementation class MainInfoServlet
 */
@WebServlet("/mis")
public class MainInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String deptSeq = request.getParameter("dept_seq");*/
		//String deptSeq = "1";
		String deptnum = request.getParameter("deptSeq");
		Department dptmt = new DepartmentService().selectMainInfo(deptnum);
		dptmt.typeSelect();
		dptmt.entranceFee();
		dptmt.sizeSelect();
		dptmt.parkingSelect();
		
		
		
		RequestDispatcher view = null;
		if(dptmt != null) { 
			view = request.getRequestDispatcher("views/info/info.jsp");
			request.setAttribute("dptmt", dptmt);
		}else { 
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", dptmt + "정보 조회 실패!");
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
