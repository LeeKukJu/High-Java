package room.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import room.vo.RoomVO;

@WebServlet("/room/joinRoom.do")
public class JoinRoomController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String memId = (String) session.getAttribute("memId");
		
		String roomCode = req.getParameter("roomCode");
		int roomMaster = 1; // 모임원
		
		IRoomService roomService = RoomServiceImpl.getInstance();
		
		RoomVO rv = new RoomVO();
		rv.setRoomCode(roomCode);
		rv.setMemId(memId);
		rv.setRoomMaster(roomMaster);
		
		roomService.insertRoomMember(rv);
		
		resp.sendRedirect("listRoom.do");
	}
	
	
	
}
