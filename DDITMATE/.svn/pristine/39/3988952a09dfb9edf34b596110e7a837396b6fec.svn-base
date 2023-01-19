package board.controller;

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

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import util.pagingUtil;

@WebServlet(urlPatterns = "/board/listBoard.do", asyncSupported = true)
public class ListBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, Object> param = new HashMap<String, Object>();

		IBoardService boardService = BoardServiceImpl.getInstance();

		String cateCode = req.getParameter("cateCode");

		if (req.getParameter("cateCode") != null) {
			cateCode = req.getParameter("cateCode");
		}
		System.out.println("서버로 넘어온 카테고리 코드: " + cateCode);

		String pageTemp;
		pageTemp = req.getParameter("pageNum");
		if (pageTemp == null) {
			pageTemp = "1";
		}
		System.out.println("페이지번호: " + pageTemp);

		String searchWord = req.getParameter("searchWord");
		List<BoardVO> boardList = new ArrayList<BoardVO>();

		if (req.getParameter("searchWord") == null) {
			// 전체 리스트 출력
			param = pagingUtil.boardPaging(cateCode, pageTemp);

			boardList = boardService.listCateBoard(param);
		
		} else {
			// 검색 단어에 따른 리스트 출력
			param = pagingUtil.boardSearch(cateCode, pageTemp, searchWord);

			boardList = boardService.searchBoard(param);

		}

		req.setAttribute("paging", param);
		req.setAttribute("boardList", boardList);
		req.setAttribute("req", "dopost");

		req.getRequestDispatcher("/board/listBoard.jsp").forward(req, resp);

	}

}
