package pet.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.FileNameChange;
import member.model.vo.Member;
import pet.model.service.PetService;
import pet.model.vo.Pet;

/**
 * Servlet implementation class petUpdateServlet
 */
@WebServlet("/petup")
public class petUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public petUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form의 enctype='multipart/form-data' 속성 누락됨");
			view.forward(request, response);
		}
//
//
		int maxSize = 1024 * 1024 * 10;
//
//
		String savePath = request.getSession().getServletContext().getRealPath("/resources/images/petImg");
//
//
//
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8",
				new DefaultFileRenamePolicy());

		Pet pet = new Pet();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		pet.setMemberSeq(member.getMemberSeq());
		pet.setPetSeq(Integer.parseInt(mrequest.getParameter("upetSeq")));
		pet.setPetName(mrequest.getParameter("upetName"));
		pet.setPetType(mrequest.getParameter("upetType"));
		pet.setPetSize(mrequest.getParameter("upetSize"));
		int result = 0;
		if (mrequest.getFilesystemName("uinput-image") != null) {
			
			if(!mrequest.getParameter("duImg").equals("882.jpg")) {
			String deletFileName = mrequest.getParameter("duImg");
			new File(savePath + "\\" + deletFileName).delete(); 
			}
			String originalFileName = mrequest.getFilesystemName("uinput-image");

			String renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");

			pet.setPetImg(renameFileName);
			result = new PetService().updatePet(pet);
		}else {
			result = new PetService().updatePetNoneImg(pet);
		}


		if (result > 0) {
			String link = "/petmily/mypet?memberSeq=" + member.getMemberSeq();
			response.sendRedirect(link);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "새 게시 원글 등록 실패!");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
