package blame.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blame.service.BlameServiceImpl;
import blame.service.IBlameService;
import blame.vo.BlameVO;

@WebServlet("/blame/mentBlame.do")
public class ListMentBlameController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		IBlameService blaService = BlameServiceImpl.getInstance();
		//blaCate값이 mb1이면..
		//게시판이랑 댓글이랑 구분하고싶다
		//list를 뽑을때 카테고리로 구분
		String blaCate = "mb1";
		
		List<BlameVO> blaList = blaService.listAllBlame(blaCate);
		req.setAttribute("blaList",blaList);
		req.getRequestDispatcher("/manager/managingComment.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
