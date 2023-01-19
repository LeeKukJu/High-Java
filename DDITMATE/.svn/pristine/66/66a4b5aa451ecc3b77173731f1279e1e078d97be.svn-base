package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@MultipartConfig
@WebServlet("/board/insertBoard.do")
public class InsertBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		// 1.요청한 파라미터 정보 가져오기
		String memId = (String) session.getAttribute("memId");
		String cateCode = req.getParameter("cateCode");
		if(cateCode.equals("f")) {
			cateCode = cateCode.replace("f", "f000");
		}
		String boTitle = req.getParameter("boardTitle");
		String boContents = req.getParameter("boardContents");
		
		System.out.println("글쓰기 Id: " + memId);
		System.out.println("글쓰기->서버 넘어온 코드: " + cateCode);
		System.out.println("글쓰기->서버 넘어온 제목: " + boTitle);

		// 서비스 객체 생성하기
		IBoardService boardService = BoardServiceImpl.getInstance();

		BoardVO bv = new BoardVO();

		bv.setMemId(memId);
		bv.setCateCode(cateCode);
		bv.setBoTitle(boTitle);
		bv.setBoContents(boContents);

		int cnt = boardService.insertBoard(bv);

		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}

		session.setAttribute("msg", msg);

		resp.sendRedirect("listBoard.do?cateCode=" + cateCode);
	}
}
