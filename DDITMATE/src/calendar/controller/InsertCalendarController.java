package calendar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import calendar.service.CalendarServiceImpl;
import calendar.service.ICalendarService;
import calendar.vo.CalendarVO;

@WebServlet("/calendar/insert.do")
public class InsertCalendarController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("calendar.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String encoding = "UTF-8";
		try {
		
			req.setCharacterEncoding("UTF-8");
			
//			int calNo = Integer.parseInt(req.getParameter("calNo"));
			//Char이지만...String으로..
			String roomCode = req.getParameter("roomCode");
			String calTitle = req.getParameter("calTitle");
			String calMemo = req.getParameter("calMemo");
			String calStart = req.getParameter("calStart");
			String calEnd = req.getParameter("calEnd");
			
			ICalendarService calService = CalendarServiceImpl.getInstance();
			
			CalendarVO cv = new CalendarVO();
//			cv.setCalNo(calNo);
			// 룸코드..
			cv.setRoomCode(roomCode);
			cv.setCalTitle(calTitle);
			cv.setCalMemo(calMemo);
			cv.setCalStart(calStart);
			cv.setCalEnd(calEnd);
			
			int cnt = calService.registCalendar(cv);
			

			
			
			resp.setCharacterEncoding("utf-8");
			//성공 실패가 깨져서 그것에 대한 인코딩을 한것임
			resp.setContentType("application/json; charset=utf-8");
			PrintWriter out = resp.getWriter();
			//성공, 실패여부를 보여주기위한것
			if(cnt>0) {
				out.write("{ \"rst\" : \"ok\", \"msg\": \"성공\" , \"calNo\" : " + cv.getCalNo() + "}");
				
				//하등필요가없는것 //calService.listAllCalendar();
				
			}else {
				out.write("{ \"rst\" : \"fail\", \"msg\": \"실패\" }");
			}
				
//				resp.sendRedirect("./ListCalendarController.java");
//				resp.sendRedirect(req.getContextPath() + "/calendar/insert.do");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}