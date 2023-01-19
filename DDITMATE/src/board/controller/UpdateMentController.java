package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ment.service.IMentService;
import ment.service.MentServiceImpl;
import ment.vo.MentVO;

@WebServlet("/board/updateMent.do")
public class UpdateMentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("컨트롤러로 넘어오니?");
		
		HttpSession session = req.getSession();
		
		String memId = (String) session.getAttribute("memId");
		System.out.println("현재 세션 memId: " + memId);
		
		
		int boNo = Integer.parseInt(req.getParameter("boNo")); 
		String cateCode = req.getParameter("cateCode");
		int mentNo = Integer.parseInt(req.getParameter("mentNo"));
		String mentContent = req.getParameter("mentContent");
		
		IMentService mentService = MentServiceImpl.getInstance();
		
		MentVO mv = new MentVO();
		
		mv.setBoNo(boNo);
		mv.setCateCode(cateCode);
		mv.setMentNo(mentNo);
		mv.setMentContents(mentContent);
		
		int cnt = mentService.updateMent(mv);
		
		PrintWriter out = resp.getWriter();
		
		out.print("{\"result\": \"ok\"}");
		
//		String msg = "";
//		if (cnt > 0) {
//			msg = "성공";
//		} else {
//			msg = "실패";
//		}
//
//		session.setAttribute("msg", msg);
		
//		resp.sendRedirect("viewBoard.do?boNo="+boNo+"&cateCode="+cateCode);
	}
}
