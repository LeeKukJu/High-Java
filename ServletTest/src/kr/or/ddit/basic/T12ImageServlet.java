package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿을 이용한 이미지 출력 예제
 * @author PC-22
 *
 */
public class T12ImageServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("image/jpg");
		
		ServletOutputStream out = resp.getOutputStream();
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:/D_Other/images/Koala.jpg"));
		
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		int data = 0;
		while((data = bis.read()) != -1) {
			bos.write(data);
		}
		
		bis.close();
		bos.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
