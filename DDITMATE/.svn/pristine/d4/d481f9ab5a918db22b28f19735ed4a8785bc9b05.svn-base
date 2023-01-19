package manager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

// 회원탈퇴 컨트롤러
@WebServlet("/manager/mngMemDelete.do")
public class DeleteManagerController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String memId = req.getParameter("memId");
		
		// 서비스 객체 생성
		IMemberService mngService = MemberServiceImpl.getInstance();
		
		List<MemberVO> mvlist = mngService.listAllMember();
		
		int cnt = mngService.removeMember(memId);	
	
		String msg ="";
		if(cnt>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		session.setAttribute("msg",msg);
		
		resp.sendRedirect(req.getContextPath() + "/manager/memList.do");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
