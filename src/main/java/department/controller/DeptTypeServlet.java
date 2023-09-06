package department.controller;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson;

import department.model.service.DepartmentService;
import department.model.vo.Department;

/**
 * Servlet implementation class DeptTypeServlet
 */
@WebServlet("/selectdepttype")
public class DeptTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptTypeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DepartmentService dservice = new DepartmentService();
		String value = request.getParameter("selecttype");
		String search = request.getParameter("typename");		
	
		ArrayList<Department> list = dservice.selectType(value);	
		
		
		/*
		 * Gson gson = new Gson(); String jsonPlace = gson.toJson(list); // //
		 * BufferedWriter writer = new BufferedWriter(new //
		 * FileWriter("C:\\Users\\user\\Desktop\\a.json")); writer.write(jsonPlace);
		 * writer.close();
		 */
		 		
		 //받은 결과에 따라 성공 또는 실패 페이지 내보내기
		
		  RequestDispatcher view = null;
		  
		  view = request.getRequestDispatcher("views/department/deptsearch.jsp");
		  request.setAttribute("list", list); request.setAttribute("search", search);
		  request.setAttribute("type", "0");
		  
		  //내보내기 
		  view.forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)in
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
