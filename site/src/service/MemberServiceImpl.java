package service;

import java.sql.SQLException;
import java.util.Map;

import dao.IMemberDAO;
import dao.MemberDAOImpl;

public class MemberServiceImpl implements IMemberService{
	
	private IMemberDAO dao;
	private static IMemberService service;
	//싱글톤 작업
	//1
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
	}
	
	//2
	public static IMemberService getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	@Override
	public String loginChk(Map<String, Object> map) {

		String memId = "";
		
		//dao가 넘겨주는 자료를 받아서 controller로 넘겨줘야 함
		try {
			memId = dao.loginChk(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memId;
	}

}
