package room.controller;

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

@WebServlet("/room/deleteRoomBoard.do")
public class DeleteRoomBoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String memId = (String)session.getAttribute("memId");
		
		String cateCode = req.getParameter("cateCode");
		String boNo = req.getParameter("boNo");
		String roomCode = req.getParameter("roomCode");
		String roomMaster = req.getParameter("roomMaster");
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		BoardVO bv = new BoardVO();
		
		bv.setCateCode(cateCode);
		bv.setBoNo(Integer.parseInt(boNo));
		bv = boardService.getBoard(bv);
		
		int cnt = boardService.deleteBoard(bv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.setAttribute("bv", bv);
		
		//get방식으로 화면에 띄워준다.
//		req.getRequestDispatcher("/board/listBoard.do").forward(req, resp);
		resp.sendRedirect("roomBoard.do?cateCode=" + cateCode + "&roomCode=" + roomCode + "&roomMaster=" + roomMaster);
//		resp.sendRedirect(req.getContextPath() + "/DDITMATE/main.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
