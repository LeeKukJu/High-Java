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

@WebServlet("/mail/reMail.do")
public class ReMailController extends HttpServlet {
	// 답장하기 controller
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/mail/remailSend.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String memId = (String)session.getAttribute("memId");
		
		String mailSender = memId;
		String mailReceiver = req.getParameter("mailReceiver");
		String mailDate = req.getParameter("mailDate");
		String mailCon = req.getParameter("mailCon");
//		System.out.println(mailReceiver);
		
		IMailService mailService = MailServiceImpl.getInstance();
		
		MailVO mav = new MailVO();
		mav.setMailSender(mailSender);
		mav.setMailReceiver(mailReceiver);
		mav.setMailDate(mailDate);
		mav.setMailCon(mailCon);
		
		int cnt = mailService.registerMail(mav);
		
		PrintWriter out = resp.getWriter();
		
		out.print("{\"result\": \"ok\"}");
		
		
	}
}
