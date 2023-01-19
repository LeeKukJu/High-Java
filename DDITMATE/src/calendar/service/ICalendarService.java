package calendar.service;

import java.util.List;

import calendar.vo.CalendarVO;

public interface ICalendarService {
	
	public int registCalendar(CalendarVO cv);
	
	public boolean checkCalendar(int calNo);	
	
	public CalendarVO getCalendar(int calNo);
	
	public int modifyCalendar(CalendarVO cv);
	
	public int removeCalendar(int calNo);
	
	public List<CalendarVO> listAllCalendar(String roomCode);
	
	public List<CalendarVO> searchCalendar(CalendarVO cv);
	
}
