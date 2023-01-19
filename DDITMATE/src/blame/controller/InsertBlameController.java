package blame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blame.service.BlameServiceImpl;
import blame.service.IBlameService;
import blame.vo.BlameVO;

@WebServlet("/blame/insert.do")
public class InsertBlameController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		HttpSession session = req.getSession();
		
		String blaContents = req.getParameter("blaContents");
		String memId = req.getParameter("memId"); // 게시물 작성자 id
		
		int mentNo;
		int boNo = Integer.parseInt(req.getParameter("boNo"));
		String cateCode = req.getParameter("cateCode");//스트링 1번째값만 남겨서 넣어줘야함 .. 그걸 url에 넣어주면 해결되긴함 ^~^
		String blaCate = req.getParameter("blaCate");
		
		IBlameService blameService = BlameServiceImpl.getInstance();
		BlameVO bv = new BlameVO();
		
		bv.setBlaContents(blaContents);
		bv.setMemId(memId);
		
		if(req.getParameter("mentNo") != null && !req.getParameter("mentNo").equals("")) {
			mentNo = Integer.parseInt(req.getParameter("mentNo"));
			bv.setMentNo(mentNo);
		}
		
		bv.setBoNo(boNo);
		bv.setCateCode(cateCode);
		bv.setBlaCate(blaCate);
		
		if(req.getParameter("mentNo") != null && !req.getParameter("mentNo").equals("")) {
			// 댓글 신고
			blameService.registMentBlame(bv);
		}else {
			// 게시판 신고
			blameService.registBlame(bv);
		}
		
		resp.sendRedirect("/DDITMATE/board/listBoard.do?boNo="+boNo+"&cateCode="+cateCode);
	}	
}

