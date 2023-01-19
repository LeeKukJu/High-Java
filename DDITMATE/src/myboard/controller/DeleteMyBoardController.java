package myboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/myboard/deleteMyBoard.do")
public class DeleteMyBoardController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String memId = (String)session.getAttribute("memId");
		
		String cateCode = req.getParameter("cateCode");
		String boNo = req.getParameter("boNo");
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		BoardVO bv = new BoardVO();
		
		bv.setCateCode(cateCode);
		bv.setBoNo(Integer.parseInt(boNo));
		bv = boardService.getBoard(bv);
		
		int cnt = boardService.deleteMyBoard(bv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.setAttribute("bv", bv);
		
		
		resp.sendRedirect("/DDITMATE/myboard/listMyBoard.do");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
