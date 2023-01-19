package blame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blame.service.BlameServiceImpl;
import blame.service.IBlameService;
import blame.vo.BlameVO;
import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/blame/delete.do")
public class DeleteBlameController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BlameVO blav = new BlameVO();
		
		int boNo = Integer.parseInt(req.getParameter("boNo"));
		String cateCode = req.getParameter("cateCode");
		
		System.out.println("boNo: " + boNo);
		System.out.println("cateCode: " + cateCode);
		
		IBlameService blaService = BlameServiceImpl.getInstance();
		
		blav.setBoNo(boNo);
		blav.setCateCode(cateCode);
		
		// 신고 테이블에서 삭제
		int cnt = blaService.removeBlame(blav);
		
		// 게시판 게시물 삭제
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		BoardVO bv = new BoardVO();
		
		bv.setCateCode(cateCode);
		bv.setBoNo(boNo);
		bv = boardService.getBoard(bv);
		
		int bnt = boardService.deleteBoard(bv);

		resp.sendRedirect("/DDITMATE/blame/blame.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}