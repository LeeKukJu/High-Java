package board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import util.pagingUtil;

@WebServlet("/board/listQuestion.do")
public class QuestionBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> param = new HashMap<String, Object>();
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		String cateCode = req.getParameter("cateCode");
		
		if(cateCode != null) {
			cateCode = req.getParameter(cateCode);
		}
		
		System.out.println("서버로 넘어온 카테고리 코드(질문) : " + cateCode);
		
		String pageTemp = req.getParameter("pageNum");
		
		if(pageTemp == null) {
			pageTemp ="1";
		}
		System.out.println("페이지 번호 : " + pageTemp);
		
		param = pagingUtil.boardPaging(cateCode, pageTemp);
		
		//원하는 카테고리 게시판 게시물 가져오기
		List<BoardVO> boardList = boardService.listCateBoard(param);
		
		req.setAttribute("paging", param);
		req.setAttribute("boardList", boardList);
		req.setAttribute("req", "dopost");
		
		req.getRequestDispatcher("/board/question.jsp").forward(req, resp);
	}

}
