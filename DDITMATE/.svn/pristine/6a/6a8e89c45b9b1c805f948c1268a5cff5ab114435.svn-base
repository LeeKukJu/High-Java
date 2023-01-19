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

// 보낸 쪽지함
@WebServlet("/mail/mailSendList.do")
public class MailSendListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String memId = (String)session.getAttribute("memId");
		
		IMailService mailService = MailServiceImpl.getInstance();
		
		List<MailVO> mailList = mailService.SendAllList(memId);
		
		req.setAttribute("mailList", mailList);
		req.setAttribute("mailBox", "receive");
		
		req.getRequestDispatcher("/mail/mail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
