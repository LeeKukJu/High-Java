package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T06ServletSessionTest extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	/*
		 세션(HttpSession)객체에 대하여...
		  => 사용자별 데이터를 유지하기 위해 사용함.
		  
		  - 세션을 통해서 사용자(웹브라우저)별로 구분하여 정보를 관리할 수 있다.
		  - 쿠키를 사용할 때 보다 보안이 향상된다.(서버에 정보를 관리함.)
		  
		 - 세션 삭제처리 방법
		  1. invalidation()메서드 호출
		  2. setMaxInactiveInterval(int interval) 호출
		  	=> 일정시간(초)동안 요청이 없으면 세션객체 삭제됨.
		  3. web.xml 에 <session-config> 설정하기(분단위)
		  	=> 모든 사용자별 세션 객체 초기화에 사용 (ex.은행에서 사용자가 일정시간 동안 로그인 하지 않으면 세션 초기화) 
	*/	  
		// 세션객체를 가져오는 방법
		// boolean값 : true인 경우 => 세션객체가 존재하지 않는 경우 새로 생성함.
		//			  false => 세션객체가 존재하지 않으면 null 반환함.
		HttpSession session = req.getSession(true);
		
//		session.setMaxInactiveInterval(30);
		
		// 생성 시간 가져오기
		Date createTime = new Date(session.getCreationTime());
		
		// 마지막 접근 시간 가져오기
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		String title = "재방문을 환영합니다.";
		int visitCnt = 0;
		String userId = "LKJ";
				
		if(session.isNew()) { // 세션이 새로 만들어졌는지 확인
			title = "처음 방문을 환영합니다.";
			session.setAttribute("userId", userId);
		}else {
			visitCnt = (Integer) session.getAttribute("visitCnt");
			visitCnt++;
			userId = (String) session.getAttribute("userId");
		}
		session.setAttribute("visitCnt", visitCnt);
		
//		session.invalidate(); // 세션 삭제 처리
		
		///////////////////////////////////////////////////////////
//		req.getRequestDispatcher("/T01ServletLifeCycle").forward(req, resp);
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html><html><head><title>" + title 
				+ "</title></head><body>"
				+ "<h1 align=\"center\">" + title + "</h1>"
				+ "<h2 align=\"center\">세션정보</h2>"
				+ "<table border=\"1\" align=\"center\">"
				+ "<tr bgcolor=\"orange\">"
				+ "<th>구분</th><th>값</th></tr>"
				+ "<tr><td>세션ID</td><td>" + session.getId()
				+ "</td></tr>"
				+ "<tr><td>생성시간</td><td>" + createTime
				+ "</td></tr>"
				+ "<tr><td>마지막 접근시간</td><td>" + lastAccessTime
				+ "</td></tr>"
				+ "<tr><td>유저 아이디</td><td>" + userId
				+ "</td></tr>"
				+ "<tr><td>방문 횟수</td><td>" + visitCnt
				+ "</td></tr>"
				+ "</td></tr></table></body></html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
