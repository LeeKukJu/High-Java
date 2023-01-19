package board.controller;

import java.io.IOException;
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
import util.pagingUtil;

@WebServlet("/board/searchBoard.do")
public class SearchBoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		// 넘어와야 할것 : 카테고리 코드, 검색할 단어
		String cateCode = req.getParameter("cateCode");
		String searchWord = req.getParameter("searchWord");
		
		System.out.println("검색서버로 넘어온 카테고리 코드: " + cateCode);
		System.out.println("검색서버로 넘어온 검색단어: " + searchWord);
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		String pageTemp;
		pageTemp = req.getParameter("pageNum");
		if(pageTemp == null) {
			pageTemp = "1";
		}
		
		param = pagingUtil.boardSearch(cateCode, pageTemp, searchWord);
		
		List<BoardVO> boardList = boardService.searchBoard(param);
		
		req.setAttribute("paging", param);
		req.setAttribute("boardList", boardList);
		req.setAttribute("req", "dopost");

		req.getRequestDispatcher("/board/listBoard.jsp").forward(req, resp);
		
	}
	
	
}
