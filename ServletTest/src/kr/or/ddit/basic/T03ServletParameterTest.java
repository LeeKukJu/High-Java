package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T03ServletParameterTest extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String hobby = req.getParameter("hobby");
		
		String rlgn = req.getParameter("rlgn");
		String[] foods = req.getParameterValues("food");
		
		////////////////////////////////////////////////////////////////////
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<p>username : " + username + "</p>");
		out.println("<p>password : " + password + "</p>");
		out.println("<p>gender : " + gender + "</p>");
		out.println("<p>hobby : " + hobby + "</p>");
		out.println("<p>rlgn : " + rlgn + "</p>");
		out.println("<p>food : " + Arrays.toString(foods));
//		if(foods != null) {
//			for(String food : foods) {
//				out.print("<p>food : " + food + "</p>");
//			}
//		}
		
		Enumeration<String> params = req.getAttributeNames();
		
		while(params.hasMoreElements()) {
			String param = params.nextElement();
			out.println("<p>파라미터 이름 : " + param + "</p>");
		}
		
		out.println("</body></html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
