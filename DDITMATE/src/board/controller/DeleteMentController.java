package board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import ment.service.IMentService;
import ment.service.MentServiceImpl;
import ment.vo.MentVO;

@WebServlet("/board/deleteMent.do")
public class DeleteMentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String memId = (String)session.getAttribute("memId");
		
		String cateCode = req.getParameter("cateCode");
		String boNo = req.getParameter("boNo");
		String mentNo = req.getParameter("mentNo");
		
		System.out.println("(deleteMent)로 넘어온 mentNo:" + mentNo);
		
		IMentService mentService = MentServiceImpl.getInstance();
		
//		Map<String, String> param = new HashMap<>();
//		IBoardService boardService = BoardServiceImpl.getInstance();
		//조회수 증가
//		boardService.updateClickNum(param);
		
		MentVO mv = new MentVO();
		
		mv.setCateCode(cateCode);
		mv.setBoNo(Integer.parseInt(boNo));
		mv.setMentNo(Integer.parseInt(mentNo));
		
		int cnt = mentService.deleteMent(mv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.setAttribute("mv", mv);
		
//		req.getRequestDispatcher("boardDetail.jsp").forward(req, resp);
		resp.sendRedirect("viewBoard.do?boNo="+boNo+"&cateCode="+cateCode);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
