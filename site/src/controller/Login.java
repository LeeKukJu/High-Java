package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardServiceImpl;
import service.IBoardService;
import service.IMemberService;
import service.MemberServiceImpl;
import vo.BoardVO;
import vo.BoardVO1;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uId = request.getParameter("userId");
		String uPw = request.getParameter("userPw");

//	System.out.println("넘어온 값 : " + uId + ", " + uPw);

		// MVC2패턴으로 각 역할을 나누어 유지보수성을 높임
		// 요청을 보냄 -> controller -> service -> DAO (DB에 접근해서 데이터를 얻음) <-> DB

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uId", uId);
		map.put("uPw", uPw);

		// 서비스객체 얻기
		IMemberService memberService = MemberServiceImpl.getInstance();
		String memId = memberService.loginChk(map);

//		System.out.println("생성된 데이터 >> " + memId);

		if (memId != null) {
			// 회원자격을 가지고 메인페이지로 이동 - loginCode생성후 가져감
			HttpSession session = request.getSession();
			session.setAttribute("loginCode", memId);

//		request.getRequestDispatcher("jsp경로").forward(request, response);
			request.getRequestDispatcher("/Main").forward(request, response);

		} else {
			// 기존 로그인 페이지 유지
			response.sendRedirect("login.html");

		}

	}
}
