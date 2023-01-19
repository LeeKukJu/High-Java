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

import room.service.IRoomService;
import room.service.RoomServiceImpl;
import room.vo.RoomBoardVO;
import util.roomPagingUtil;

@WebServlet("/room/roomBoard.do")
public class RoomBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, Object> param = new HashMap<String, Object>();

		IRoomService roomService = RoomServiceImpl.getInstance();
		
		int roomMaster= Integer.parseInt(req.getParameter("roomMaster"));
		String cateCode = req.getParameter("cateCode");
		String roomCode = req.getParameter("roomCode");
		
		System.out.println("서버로 넘어온 카테고리 코드: " + cateCode);
		System.out.println("서버로 넘어온 방 코드: " + roomCode);
		

		String pageTemp;
		pageTemp = req.getParameter("pageNum");
		if (pageTemp == null) {
			pageTemp = "1";
		}
		System.out.println("페이지번호: " + pageTemp);

		String searchWord = req.getParameter("searchWord");
		System.out.println(searchWord);			
		List<RoomBoardVO> roomBoardList = new ArrayList<RoomBoardVO>();

		if (req.getParameter("searchWord") == null) {
			// 전체 리스트 출력
			param = roomPagingUtil.roomBoardPaging(cateCode, pageTemp, roomCode);
			param.put("roomCode", roomCode);
			roomBoardList = roomService.listRoomBoard(param);
		
		} else {
			// 검색 단어에 따른 리스트 출력
			param = roomPagingUtil.roomBoardSearch(cateCode, pageTemp, searchWord, roomCode);
			param.put("roomCode", roomCode);
			roomBoardList = roomService.searchRoomBoard(param);

		}
		
		req.setAttribute("roomMaster", roomMaster);
		req.setAttribute("paging", param);
		req.setAttribute("roomBoardList", roomBoardList);

		req.getRequestDispatcher("/room/roomBoard.jsp").forward(req, resp);

	}

}
