package myment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import ment.service.IMentService;
import ment.service.MentServiceImpl;
import ment.vo.MentVO;


@WebServlet("/myment/ListMyMent.do")
public class ListMyMentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String memId =(String)session.getAttribute("memId");
		
		IMentService mentService = MentServiceImpl.getInstance();
		
		MentVO mv= new MentVO();
		
		mv.setMemId(memId);
		
		List<MentVO> mymentList = mentService.listMyMent(mv);
		
		req.setAttribute("mymentList", mymentList);
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		List<BoardVO> mbList = boardService.listMyBoard(memId);
		
		req.setAttribute("mbList", mbList);
		
		req.getRequestDispatcher("/myMent.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
