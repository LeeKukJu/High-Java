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
import member.vo.MemberVO;

// 회원정보 수정 컨트롤러
@WebServlet("/member/memChange.do")
public class UpdateMemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String memId = (String) session.getAttribute("memId");
		
		// 서비스 객체 생성
		IMemberService memService = MemberServiceImpl.getInstance();
		
		MemberVO mv = new MemberVO();
		
		mv = memService.getMember(memId);
		
		req.setAttribute("mv",mv);
		
	   // 포워드
		req.getRequestDispatcher("/memChange.jsp").forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// 파라미터 정보 가져오기
		String memId = (String) session.getAttribute("memId"); 
		String memPw = req.getParameter("memPw");
		//String memName = req.getParameter("memName");
		String memEmail = req.getParameter("memEmail");
		String memTel = req.getParameter("memTel");
		String memDate = req.getParameter("memDate");
		
		System.out.println("수정 후 : " + memId);
		
		
		// 서비스 객체 
		IMemberService memService = MemberServiceImpl.getInstance();
		
		// 회원정보 수정하기
		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemPw(memPw);
		mv.setMemEmail(memEmail);
		mv.setMemTel(memTel);
		mv.setMemDate(memDate);
		
		int cnt = memService.modifyMember(mv);
		
		String msg="";
//		String icon = "";
		if(cnt > 0) {
			msg = "성공";
//			icon = "success";
		}else {
			msg = "실패";
//			icon = "warning";
		}
		
		session.setAttribute("msg", msg);
//		session.setAttribute("icon", icon);
		
		resp.sendRedirect(req.getContextPath() + "/member/memCheck.do");
		
		//req.getRequestDispatcher("/memCheck.jsp").forward(req, resp);
	}
}
