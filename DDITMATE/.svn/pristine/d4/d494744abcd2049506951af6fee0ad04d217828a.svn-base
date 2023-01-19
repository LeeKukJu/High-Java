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

@WebServlet("/room/deletRoom.do")
public class DeletRoomController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String memId = (String) session.getAttribute("memId");
		
		String roomCode = (String) req.getParameter("roomCode");
		// 0: 모임장, 1: 팀원
		int roomMaster = Integer.parseInt(req.getParameter("roomMaster"));
		
		IRoomService roomService = RoomServiceImpl.getInstance();
		
		RoomVO rv = new RoomVO();
		rv.setMemId(memId);
		rv.setRoomCode(roomCode);
		rv.setRoomMaster(roomMaster);
		
		System.out.println("서버로 넘어온 rv 코드: " + roomCode);
		
		if(roomMaster == 0) { //모임장이 방을 나가면 멤버 모두 삭제 후 방 삭제
			roomService.deletRoomAllMember(rv);
			
			roomService.deletRoom(rv);
			
		}else { //모임원이 방을 나가면 모임원만 명단에서 삭제
			roomService.deletRoomMember(rv);
		}
		
		resp.sendRedirect("listRoom.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
