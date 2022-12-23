package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet(value = "/member/list.do")
public class ListMemberController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 서비스객체 생성하기
		IMemberService memService = MemberServiceImpl.getInstance();
		
		// 2. 회원목록 정보 조회
		List<MemberVO> memList = memService.listAllMember();
		
		// 3. 뷰에서 사용할 데이터 저장하기
		req.setAttribute("memList", memList);
		
		// 4. 뷰 페이지로 전달하기
		req.getRequestDispatcher("/views/member/list.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
