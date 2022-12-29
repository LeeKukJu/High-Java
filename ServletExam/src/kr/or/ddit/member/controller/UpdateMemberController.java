package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@MultipartConfig
@WebServlet("/member/update.do")
public class UpdateMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 파라미터 정보 가져오기
		String memId = req.getParameter("memId");

		// 2. 서비스 객체 생성
		IMemberService memService = MemberServiceImpl.getInstance();
		
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		MemberVO mv = memService.getMember(memId);
		
		AtchFileVO atchFileVO = new AtchFileVO();
		atchFileVO.setAtchFileId(mv.getAtchFileId());
		List<AtchFileVO> atchFileList = fileService.getAtchFileList(atchFileVO);

		req.setAttribute("mv", mv);
		req.setAttribute("atchFileList", atchFileList);

		req.getRequestDispatcher("/WEB-INF/views/member/updateForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 파라미터 정보 가져오기
		String memId = req.getParameter("memId");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		String atchFileId = req.getParameter("atchFileId");

		// 2. 서비스 객체 생성하기
		IMemberService memService = MemberServiceImpl.getInstance();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		AtchFileVO atchFileVO = fileService.saveAtchFileList(req);

		// 3. 회원정보 수정하기
		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		
		if(atchFileVO == null) { // 새로운 첨부파일이 없는 경우..
			mv.setAtchFileId(Long.parseLong(atchFileId));
		}else {
			// 신규 첨부파일ID 저장
			mv.setAtchFileId(atchFileVO.getAtchFileId());
		}

		int cnt = memService.modifyMemeber(mv);

		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}

		HttpSession session = req.getSession();
		session.setAttribute("msg", msg);

//		req.getRequestDispatcher("/member/list.do").forward(req, resp);
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
	}

}
