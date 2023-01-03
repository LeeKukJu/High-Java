package member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.Part;

@MultipartConfig
@WebServlet("/member/insert.do")
public class insertMemberController extends HttpServlet {

	public insertMemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("joinForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("memId");   
		String memPw = request.getParameter("memPw");
		String memName = request.getParameter("memName"); 
		String memEmail = request.getParameter("memEmail");
		String memBirth = request.getParameter("memBirth");
		String memTel = request.getParameter("memTel");
		String memDate = request.getParameter("memDate");
		String memNick = request.getParameter("memNick");
		String memIntro = request.getParameter("memIntro");
		
		
	}

}
