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

// 회원정보 조회 컨트롤러
@WebServlet("/manager/memList.do")
public class ListManagerController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String memId = (String) session.getAttribute("memId");
		
		// 서비스 객체 생성
		IMemberService mngService = MemberServiceImpl.getInstance();
		System.out.println("=======================!!!!!=================");
		List<MemberVO> mvlist = mngService.listAllMember();
		
		//setAttribute(String name, Object value)
		req.setAttribute("mvlist",mvlist);
		
		req.getRequestDispatcher("/manager/managingMember.jsp").forward(req, resp);
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
