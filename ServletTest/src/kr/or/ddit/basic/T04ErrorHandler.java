package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T04ErrorHandler extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception"); // 예외 객체
		Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
		String message = (String) req.getAttribute("javax.servlet.error.message");
		String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
		
		if(servletName == null) {
			servletName = "알 수 없는 서블릿명";
		}
		
		String reqURI = (String) req.getAttribute("javax.servlet.error.request_uri");
		
		if(reqURI == null) {
			reqURI = "알 수 없는 URI";
		}
		
		//////////////////////////////////////////////////////////////
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String title = "에러/예외 정보";
		
		out.println("<html><head><title>" + title
				+ "</title></head><body>");
		
		if(throwable == null && statusCode == null) {
			out.println("<h2>에러/예외 정보 없음</h2>");
		}else {
			out.println("<h2>에러/예외 정보</h2>");
			out.println("<p>상태코드 : " + statusCode + "</p><br>");
			out.println("<p>메세지 : " + message + "</p><br>");
			out.println("<p>서블릿 : " + servletName + "</p><br>");
			out.println("<p>요청URI : " + reqURI + "</p><br>");
			
			if(statusCode != null) {
				out.println("<p>예외타입 : " + throwable.getClass().getName() + "</p><br>");
				out.println("<p>예외메세지 : " + throwable.getMessage() + "</p><br>");
			}
		}
		out.println("</body></html>");
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
