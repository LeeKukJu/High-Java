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

@WebServlet("/room/deletRoomMember.do")
public class DeletRoomMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String roomCode = (String) req.getParameter("roomCode");
		String memberId = (String) req.getParameter("memberId");
		int roomMaster = Integer.parseInt(req.getParameter("roomMaster"));

		IRoomService roomService = RoomServiceImpl.getInstance();

		RoomVO rv = new RoomVO();
		rv.setMemId(memberId);
		rv.setRoomCode(roomCode);

		System.out.println("서버로 넘어온 rv 코드: " + roomCode);

		roomService.deletRoomMember(rv);

		resp.sendRedirect("selectRoom.do?roomCode="+roomCode+"&roomMaster="+roomMaster);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
