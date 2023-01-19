package calendar.dao;

import java.util.List;

import calendar.vo.CalendarVO;
import common.dao.MyBatisDao;

public class CalendarDaoImpl extends MyBatisDao implements ICalendarDao{
	
	private static ICalendarDao calDao;
	
	private CalendarDaoImpl() {
		
	}
	public static ICalendarDao getInstance() {
		if(calDao == null) {
			calDao = new CalendarDaoImpl();
		}
		
		return calDao;
		
	}
	
	@Override
	public int insertCalender(CalendarVO cv) {
		
		return insert("calendar.insertCalendar",cv);
	}

	@Override
	public boolean checkCalender(int calNo) {
		boolean isExist = false;
		int cnt = selectOne("calendar.checkCalendar", calNo);
		if(cnt > 0) {
			isExist = true;
		}
		return isExist;
	}
////////////////////////////////////////////////////////////////////
//  캘린더 넘버 말고도 룸코드가 추가되어야 할것같은데....
	
////////////////////////////////////////////////////////////////////

	@Override
	public CalendarVO getCalendar(int calNo) {
		
		return selectOne("calendar.getCalendar", calNo);
	}
	
	@Override
	public int updateCalender(CalendarVO cv) {
		
		return update("calendar.updateCalendar", cv);
	}

	@Override
	public int deleteCalender(int calNo) {
		
		return delete("calendar.deleteCalendar", calNo);
	}

	@Override
	public List<CalendarVO> printAllCalendar(String roomCode) {
		List<CalendarVO> calList = 
				selectList("calendar.calendarList", roomCode);
		return calList;
	}

	@Override
	public List<CalendarVO> searchCalendar(CalendarVO cv) {
		
		List<CalendarVO> calList =
				selectList("calendar.searchCalendar", cv);
		return calList;
	}

	
	//새롭게 추가된 제목 시작일 끝나는날짜 불러오기


}
