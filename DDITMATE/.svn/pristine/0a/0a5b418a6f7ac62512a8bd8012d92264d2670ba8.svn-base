package calendar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calendar.service.CalendarServiceImpl;
import calendar.service.ICalendarService;
import calendar.vo.CalendarVO;

//("/controller/calendar.jsp")?????????
@WebServlet
public class DetailCalendarController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int calNo = Integer.parseInt(req.getParameter("calNo"));
	
		ICalendarService calService = CalendarServiceImpl.getInstance();
		CalendarVO cv = calService.getCalendar(calNo);
		
		req.setAttribute("cv", cv);
		req.getRequestDispatcher("/WEB-INF/views/calendar/calendar.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
