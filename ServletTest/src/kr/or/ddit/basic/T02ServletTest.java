package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T02ServletTest extends HttpServlet {
	/*
	 * 서블릿 동작 방식에 대하여...
	 * 
	 * 1. 사용자(클라이언트)가 URL을 클릭하면 Http Request를 서블릿 컨테이너로 전송(요청)한다. 
	 * 2. 컨테이너는 web.xml에 정의된 URL패턴을 확인하여 어느 서블릿을 통해 처리해야 할지를 검색한다. 
	 * (로딩이 안된경우에는 로딩함. 로딩 후 init()메서드 호출됨.) 
	 * 3. 서블릿 컨테이너는 요청을 처리할 개별 스레드 객체를 생성하여 해당 서블릿 객체의 service()메서드를 호출한다. 
	 * (요청 및 응답 객체를 생성하여 파라미터로 넘겨준다.) 
	 * 4. service()는 메서드타입을 확인하여 적절한 메서드를 호출한다. 
	 * (doGet, doPost, doPut, doDelete 등) 
	 * 5. 요청 처리가 완료되면 HttpServletRequest 및 HtpServletResponse객체는 소멸된다. 
	 * 6. 컨테이너로 부터 서블릿이 제거되는 경우에 destroy()메서드가 호출된다.
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Request객체의 메서드 확인하기
		System.out.println("getCharacterEncoding => " + req.getCharacterEncoding());
		System.out.println("getContentLength => " + req.getContentLength());
		System.out.println("getQueryString => " + req.getQueryString());
		System.out.println("getProtocol => " + req.getProtocol());
		System.out.println("getMethod => " + req.getMethod());
		System.out.println("getRequestURI => " + req.getRequestURI());
		System.out.println("getRemoteAddr => " + req.getRemoteAddr());
		System.out.println("getRemotePort => " + req.getRemotePort());
		
		// POST방식으로 넘어오는 Body데이터를 인코딩 처리함.
		// GET방식은 톰캣의 URIEncoding 설정을 이용함.
		// 반드시 request에서 값을 가져오기 전에 먼저 설정해야 함.
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		System.out.println("name => " + name);
		
		// 요청 객체에 정보 저장하기
		req.setAttribute("tel", "3333-3333");
		req.setAttribute("addr", "대전시 중구 오류동");
		
		// 요청 객체에서 정보 꺼내기
		System.out.println("tel => " + req.getAttribute("tel"));
		System.out.println("addr => " + req.getAttribute("addr"));
		
		/////////////////////////////////////////////////////
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("name => " + name);
		out.println("서블릿 경로: " + req.getServletPath());
		out.println("서블릿 컨텍스트 경로 : " + req.getContextPath());
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET과 POST 방식 구분하지 않고 실행하고자 할 때
		doGet(req,resp);
	}
}
