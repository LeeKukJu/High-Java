package manager.dao;

import java.util.List;

import common.dao.MyBatisDao;
import member.vo.MemberVO;

public class ManagerDaoImpl extends MyBatisDao implements IManagerDao{
	
	private static IManagerDao mngDao;
	
	private ManagerDaoImpl() {
		
	}
	
	public static IManagerDao getInstance() {
		if(mngDao == null) {
			mngDao = new ManagerDaoImpl();
		}
		return mngDao;
	}



	

	@Override
	public MemberVO getMember(String memId) {
		return selectOne("manager.getMember", memId);
	}

	@Override
	public int deleteMember(String memId) {
		return delete("manager.deleteMember", memId);

	}

	@Override
	public List<MemberVO> printAllMember() {
		List<MemberVO> memList = 
				selectList("member.selectAllMember");

		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = 
				selectList("manager.searchMember", mv);
		
		return memList;
	}


}
