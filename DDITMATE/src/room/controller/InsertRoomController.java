package room.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import room.vo.RoomMemberVO;
import room.vo.RoomVO;

@WebServlet("/room/insertRoom.do")
public class InsertRoomController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String memId = (String) session.getAttribute("memId");
		
		String roomTitle = req.getParameter("roomTitle");
		System.out.println("그룹생성 제목: " + roomTitle);
		
		// 코드 생성
		String roomCode = RandomStringUtils.randomAlphanumeric(8);
		System.out.println("생성된 방 코드: " + roomCode);
		
		RoomVO rv = new RoomVO();
		rv.setRoomCode(roomCode);
		rv.setRoomTitle(roomTitle);
		rv.setMemId(memId);
		rv.setRoomCode(roomCode);
		rv.setRoomMaster(0);
		
		IRoomService roomService = RoomServiceImpl.getInstance();
		
		roomService.createRoom(rv);
		roomService.insertRoomMember(rv);
		
		resp.sendRedirect("listRoom.do");
	}
}
