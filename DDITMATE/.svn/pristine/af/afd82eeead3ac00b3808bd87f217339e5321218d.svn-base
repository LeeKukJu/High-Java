package room.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import room.vo.RoomVO;

@WebServlet("/room/listRoom.do")
public class ListRoomController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String memId = (String) session.getAttribute("memId");
		
//		Map<String, Object> param = new HashMap<String, Object>();
		
		IRoomService roomService = RoomServiceImpl.getInstance();
		
		List<RoomVO> myRoomList = roomService.selectRoomList(memId);
		
		req.setAttribute("myRoomList", myRoomList);
		
		req.getRequestDispatcher("/room/roomList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
