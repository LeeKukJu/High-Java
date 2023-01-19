package dao;

import java.sql.SQLException;
import java.util.Map;

import common.MyBatisDAO;

public class MemberDAOImpl extends MyBatisDAO implements IMemberDAO{
	
	//dao객체 생성하기 - 싱글톤 방식으로
	private static IMemberDAO dao;
	
	//1. private constructor
	private MemberDAOImpl() {}
	
	//2.static method
	public static IMemberDAO getInstance() {
		if(dao == null) {
			dao = new MemberDAOImpl();
		}
		return dao; 
	}
	
	
	@Override
	public String loginChk(Map<String, Object> map) throws SQLException {
		
//		return selectOne("xml파일이 가지는 namespace", map); //member.xml파일의 member의 id값
		return selectOne("member.loginChk", map);
	}

}
