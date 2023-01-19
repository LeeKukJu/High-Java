package mail.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.service.IMailService;
import mail.service.MailServiceImpl;
import mail.vo.MailVO;

@WebServlet("/mail/mailQnA.do")
public class QnAController extends HttpServlet{
	
	// 문의하기 전송하기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/mail/mailQnA.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String memId = (String)session.getAttribute("memId");
		
		String mailSender = memId; 
		String mailReceiver = "admin";
		String mailDate = req.getParameter("mailDate");
		String mailCon = req.getParameter("mailCon");
		System.out.println(mailSender);
		
		// 서비스 객체 생성하기
		IMailService mailService = MailServiceImpl.getInstance();	
		
					// 메일 보내기
		MailVO mav = new MailVO();
//		mav.setMailNo(mailNo);
		mav.setMailSender(mailSender);
		mav.setMailReceiver(mailReceiver);
		mav.setMailDate(mailDate);
		mav.setMailCon(mailCon);
		
		System.out.println(mailCon);
		
		int cnt = mailService.registerMail(mav);
		
		PrintWriter out = resp.getWriter();
		
		out.print("{\"result\": \"ok\"}");
		
	}

}
