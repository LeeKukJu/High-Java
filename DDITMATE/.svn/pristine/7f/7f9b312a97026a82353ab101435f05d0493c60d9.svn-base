package mail.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.service.IMailService;
import mail.service.MailServiceImpl;
import mail.vo.MailVO;

@WebServlet("/mail/mailDetail.do")
public class DetailMailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session = req.getSession();
//		String memId = (String)session.getAttribute("memId");
		
		int mailNo = Integer.parseInt(req.getParameter("mailNo"));
		
		IMailService mailService = MailServiceImpl.getInstance();
		
		MailVO mav = new MailVO();
		
		mav.setMailNo(mailNo);
		
		mav = mailService.getMail(mailNo);
		
		req.setAttribute("mav", mav);
				
		req.getRequestDispatcher("/mail/mailDetail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
