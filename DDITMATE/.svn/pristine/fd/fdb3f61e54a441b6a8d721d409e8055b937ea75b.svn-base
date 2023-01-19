package room.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import room.vo.RoomMemberVO;

@WebServlet("/room/selectRoom.do")
public class SelectRoomController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String roomCode = req.getParameter("roomCode");
		int roomMaster = Integer.parseInt(req.getParameter("roomMaster"));
		
		IRoomService roomService = RoomServiceImpl.getInstance();
		
		// 해당 모임방에 참가중인 모임원 정보
		List<RoomMemberVO> roomMemberList = roomService.selectRoomMemberList(roomCode);
		
		req.setAttribute("roomMaster", roomMaster);
		req.setAttribute("roomMemberList", roomMemberList);
		
		req.getRequestDispatcher("/room/myRoom.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
