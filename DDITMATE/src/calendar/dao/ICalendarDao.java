package calendar.dao;

import java.util.List;

import calendar.vo.CalendarVO;

public interface ICalendarDao {

	public int insertCalender(CalendarVO cv);
	
	public boolean checkCalender(int calNo);
	
	public CalendarVO getCalendar(int calNo);
	
	public int updateCalender(CalendarVO cv);
	
	public int deleteCalender(int calNo);
	
	public List<CalendarVO> printAllCalendar(String roomCode);

	public List<CalendarVO> searchCalendar(CalendarVO cv);

}

