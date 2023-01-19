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
import ment.service.IMentService;
import ment.service.MentServiceImpl;
import ment.vo.MentVO;

@WebServlet("/blame/mentDelete.do")
public class DeleteMentBlameController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BlameVO bv = new BlameVO();
		
		int boNo = Integer.parseInt(req.getParameter("boNo"));
		String cateCode = req.getParameter("cateCode");
		int mentNo = Integer.parseInt(req.getParameter("mentNo"));
		
		IBlameService blaService = BlameServiceImpl.getInstance();
		
		bv.setBoNo(boNo);
		bv.setCateCode(cateCode);
		bv.setMentNo(mentNo);
		// 신고 테이블에서 삭제
		
		int cnt = blaService.removeMentBlame(bv);
		
		// 댓글 게시물도 삭제
		IMentService mentService = MentServiceImpl.getInstance();
		
		MentVO mv = new MentVO();
		
		mv.setCateCode(cateCode);
		mv.setBoNo(boNo);
		mv.setMentNo(mentNo);
		
		int mnt = mentService.deleteMent(mv);
		
		resp.sendRedirect("/DDITMATE/blame/mentBlame.do");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}