package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T09ServletContextListenerTest extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// req.getServletContext()와 getServletContext() 같은 기능을 하는 메소드임
		req.getServletContext().setAttribute("ATTR1", "속성1"); // 추가
		req.getServletContext().setAttribute("ATTR1", "속성11"); // 변경
		req.getServletContext().setAttribute("ATTR2", "속성2");
		
		getServletContext().removeAttribute("ATTR1");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
