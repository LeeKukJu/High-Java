package util;

import java.util.HashMap;
import java.util.Map;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import room.service.IRoomService;
import room.service.RoomServiceImpl;

public class roomPagingUtil {
	
	public static final int PER_LIST = 10; //페이지당 게시물 10개 보여줌
	public static final int PER_PAGE = 5; //게시물 이동 번호 5개 보여줌
	
	public static <K,V> Map<K, V> roomBoardPaging(String cateCode, String pageTemp, String roomCode) {
		Map<String, Object> paging = new HashMap<String, Object>();
		paging.put("cateCode", cateCode);
		paging.put("roomCode", roomCode);
		
		IRoomService roomService = RoomServiceImpl.getInstance();
		
		int totalCount = roomService.selectCount(paging);
		int totalPage = (int)Math.ceil((double)totalCount / PER_LIST);
		paging.put("totalPage", totalPage);
		paging.put("totalCount", totalCount);
		
		// 현재 페이지 확인
		int pageNum = 1;  // 기본값
		
		if (pageTemp != null && !pageTemp.equals(""))
		    pageNum = Integer.parseInt(pageTemp); // 요청받은 페이지로 수정
		
		paging.put("pageNum", pageNum);
		
		int start = (pageNum - 1) * PER_LIST + 1;  // 첫 게시물 번호
		int end = pageNum * PER_LIST; // 마지막 게시물 번호
		paging.put("start", start);
		paging.put("end", end);
		
		return (HashMap<K, V>) paging;
	}
	
	public static <K,V> Map<K, V> roomBoardSearch(String cateCode, String pageTemp, String searchWord, String roomCode) {
		Map<String, Object> paging = new HashMap<String, Object>();
		
		paging.put("searchWord", searchWord);
		paging.put("cateCode", cateCode);
		paging.put("roomCode", roomCode);
		
		IRoomService roomService = RoomServiceImpl.getInstance();
		
		int totalCount = roomService.selectCount(paging);
		int totalPage = (int)Math.ceil((double)totalCount / PER_LIST);
		paging.put("totalPage", totalPage);
		paging.put("totalCount", totalCount);
		
		// 현재 페이지 확인
		int pageNum = 1;  // 기본값
		
		if (pageTemp != null && !pageTemp.equals(""))
		    pageNum = Integer.parseInt(pageTemp); // 요청받은 페이지로 수정
		
		paging.put("pageNum", pageNum);
		
		int start = (pageNum - 1) * PER_LIST + 1;  // 첫 게시물 번호
		int end = pageNum * PER_LIST; // 마지막 게시물 번호
		paging.put("start", start);
		paging.put("end", end);
		
		return (HashMap<K, V>) paging;
	}
	
}
