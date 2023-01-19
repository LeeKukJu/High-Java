package calendar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calendar.service.CalendarServiceImpl;
import calendar.service.ICalendarService;
import calendar.vo.CalendarVO;

@WebServlet("/calendar/calendar.do")
public class ListCalendarController extends HttpServlet {

	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		
		String roomCode = req.getParameter("roomCode");
		
		ICalendarService calService = CalendarServiceImpl.getInstance();

		List<CalendarVO> calList = calService.listAllCalendar(roomCode);
		
		req.setAttribute("roomCode", roomCode);
		req.setAttribute("calList", calList);
		
		req.getRequestDispatcher("/calendar/FullCalendarExam.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

		resp.sendRedirect("/calendar.jsp");
	}
}
