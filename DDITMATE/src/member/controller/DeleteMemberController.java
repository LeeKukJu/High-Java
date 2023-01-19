package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;

// 회원탈퇴 컨트롤러
@WebServlet("/member/memDelete.do")
public class DeleteMemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String memId = (String)session.getAttribute("memId");
		
		// 서비스 객체 생성
		IMemberService memService = MemberServiceImpl.getInstance();
		
		int cnt2 = memService.removeMember(memId);
		
		String msg2 = "";
		if(cnt2 > 0) {
			msg2 = "성공";
		}else {
			msg2 = "실패";
		}
		
		
		session.setAttribute("msg2", msg2);
		
		resp.sendRedirect(req.getContextPath() + "/");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
