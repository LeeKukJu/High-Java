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
import calendar.vo.CalendarVO;

//("calendar/update.do")
@WebServlet("/calendar/update.do")
public class UpdateCalendarController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		int calNo = (int)session.getAttribute("calNo");
		
	
	ICalendarService calService = CalendarServiceImpl.getInstance();
	
	CalendarVO cv = new CalendarVO();
			
	cv = calService.getCalendar(calNo);
	
	req.setAttribute("cv", cv);
	//경로 맞는지 모르겠음
	req.getRequestDispatcher("/calendar.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//파라미터 정보를 가져올때,캘린더번호와 방코드는 바꿀 필요없으니깐 지움
//		int calNo = Integer.parseInt(req.getParameter("calNo"));
//		String roomCode = req.getParameter("roomCode");
		String calTitle = req.getParameter("calTitle");
		String calMemo = req.getParameter("calMemo");
		String calStart = req.getParameter("calStart");;
		String calEnd = req.getParameter("calEnd");;
		
		ICalendarService calService = 
				CalendarServiceImpl.getInstance();
		
		CalendarVO cv = new CalendarVO();
	//캘린더번호와 방코드는 바꿀 필요가없으니깐 지움
//	cv.setCalNo(calNo);
//	cv.setRoomCode(roomCode);
		cv.setCalTitle(calTitle);
		cv.setCalMemo(calMemo);
		cv.setCalStart(calStart);
		cv.setCalEnd(calEnd);
		
		int cnt = calService.modifyCalendar(cv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "수정완료";
		}else {
			msg = "수정실패";
		}
		HttpSession session = req.getSession();
		
		session.setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/calendar.jsp");
	}	
}

