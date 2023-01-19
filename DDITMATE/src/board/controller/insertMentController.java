package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ment.service.IMentService;
import ment.service.MentServiceImpl;
import ment.vo.MentVO;

@WebServlet("/board/insertMent.do")
public class insertMentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String memId = (String) session.getAttribute("memId");
		String cateCode = req.getParameter("cateCode");
		String boNo = req.getParameter("boNo");
		if(cateCode.equals("f")) {
			cateCode = cateCode.replace("f", "f000");
		}
		String mentContents = req.getParameter("mentContents");
		
		System.out.println("boardDetail->서버 넘어온 아이디: " + memId);
		System.out.println("boardDetail->서버 넘어온 코드: " + cateCode);
		System.out.println("boardDetail->서버 넘어온 코드: " + boNo);
		System.out.println("boardDetail->서버 넘어온 댓글내용: " + mentContents);
		
		IMentService mentService = MentServiceImpl.getInstance();
		
		MentVO mv = new MentVO();
		
		mv.setMemId(memId);
		mv.setCateCode(cateCode);
		mv.setBoNo(Integer.parseInt(boNo));
		mv.setMentContents(mentContents);
	
		int cnt = mentService.insertMent(mv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}

		session.setAttribute("msg", msg);

		resp.sendRedirect("viewBoard.do?boNo="+boNo+"&cateCode="+cateCode);
	}

}
