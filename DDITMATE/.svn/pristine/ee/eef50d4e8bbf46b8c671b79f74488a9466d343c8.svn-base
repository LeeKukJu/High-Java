package mail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.service.IMailService;
import mail.service.MailServiceImpl;

@WebServlet("/mail/mailDelete.do")
public class DeleteMailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		int mailNo = Integer.parseInt(req.getParameter("mailNo"));
		
		IMailService mailService = MailServiceImpl.getInstance();
		
		int cnt = mailService.removeMail(mailNo);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		session.setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/mail/mailReceiveList.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
