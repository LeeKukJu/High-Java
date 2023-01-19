package room.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import ment.service.IMentService;
import ment.service.MentServiceImpl;
import ment.vo.MentVO;

@WebServlet("/room/viewRoomBoard.do")
public class ViewRoomBoardControlller extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, String> param = new HashMap<>();
		
		String boNo = req.getParameter("boNo");
		String cateCode = req.getParameter("cateCode");
		String roomCode = req.getParameter("roomCode");
		int roomMaster = Integer.parseInt(req.getParameter("roomMaster"));
		
		param.put("boNo", boNo);
		param.put("cateCode", cateCode);
		param.put("roomCode", roomCode);
		
		MentVO mv = new MentVO();
		
		System.out.println("viewRoomBoard로 넘어온 cateCode: " + cateCode 
				+ ", boNo: " + boNo + ", roomCode: " + roomCode + ", 관리자여부: " + roomMaster);
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		//댓글 목록 조회
		IMentService mentService = MentServiceImpl.getInstance();
		
		List<MentVO> mentList = new ArrayList<MentVO>();
		mentList = mentService.listMent(param);
		
		//조회수 증가
		boardService.updateClickNum(param);
		
		BoardVO bv = new BoardVO();
		bv.setCateCode(cateCode);
		bv.setBoNo(Integer.parseInt(boNo));
		
		mv.setBoNo(Integer.parseInt(boNo));
		mv.setCateCode(cateCode);
		
		bv = boardService.getBoard(bv);
		
		req.setAttribute("roomCode", roomCode);
		req.setAttribute("roomMaster", roomMaster);
		req.setAttribute("bv", bv);
		req.setAttribute("mentList", mentList);
		
		req.getRequestDispatcher("roomBoardDetail.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
