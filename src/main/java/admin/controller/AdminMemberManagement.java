package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberManagement
 */
@WebServlet("/admmm")
public class AdminMemberManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberManagement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberSeq = request.getParameter("memberSeq");
		String memberGrade = request.getParameter("memberGrade");
		String memberId = request.getParameter("memberId");

		int result = new MemberService().managementMember(memberSeq, memberGrade);
		
		
		
		ArrayList<Member> member = new MemberService().againList(memberId);
		
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("views/admin/AdminMemberManagement.jsp");
		request.setAttribute("list", member);
		request.setAttribute("keyword", memberId);
		view.forward(request, response);
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
