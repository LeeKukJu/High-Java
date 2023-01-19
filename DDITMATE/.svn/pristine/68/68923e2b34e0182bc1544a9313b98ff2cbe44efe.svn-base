package calendar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendar.service.CalendarServiceImpl;
import calendar.service.ICalendarService;


@WebServlet("/calendar/delete.do")
public class DeleteCalendarController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int calNo = Integer.parseInt(req.getParameter("calNo"));
		
		ICalendarService calService = CalendarServiceImpl.getInstance();
		
		int cnt = calService.removeCalendar(calNo);
		
		String msg= "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		HttpSession session = req.getSession();
		session.setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
