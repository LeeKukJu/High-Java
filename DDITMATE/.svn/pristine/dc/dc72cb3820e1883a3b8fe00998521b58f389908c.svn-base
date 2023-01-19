package room.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import room.vo.RoomBoardVO;

@MultipartConfig
@WebServlet("/room/updateRoomBoard.do")
public class UpdateRoomBoardController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		//1.요청한 파라미터 정보 가져오기
		String memId = (String) session.getAttribute("memId");
		System.out.println("현재 세션 memId: " + memId);
		
		int boNo = Integer.parseInt(req.getParameter("boNo")); 
		String cateCode = req.getParameter("cateCode");
		
		String boTitle = req.getParameter("boardTitle");
		String boContents = req.getParameter("boardContents");
		String roomCode = req.getParameter("roomCode");
		int roomMaster = Integer.parseInt(req.getParameter("roomMaster"));
		
		System.out.println("글쓰기->서버 넘어온 코드: " + cateCode);
		System.out.println("글쓰기->서버 넘어온 글번호: " + boNo);
		
		System.out.println("글쓰기->서버 넘어온 제목: " + boTitle);
		System.out.println("글쓰기->서버 넘어온 제목: " + boContents);
		
		// 서비스 객체 생성하기
		IRoomService roomService = RoomServiceImpl.getInstance();

		RoomBoardVO rbv = new RoomBoardVO();

		rbv.setMemId(memId);
		rbv.setBoNo(boNo);
		rbv.setCateCode(cateCode);
		rbv.setBoTitle(boTitle);
		rbv.setBoContents(boContents);
		rbv.setRoomCode(roomCode);
		
		int cnt = roomService.updateRoomBoard(rbv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}

		session.setAttribute("msg", msg);
		
		resp.sendRedirect("viewRoomBoard.do?boNo="+ boNo +"&cateCode=" + cateCode + "&roomCode="+roomCode+"&roomMaster="+roomMaster);
	}
	
}
