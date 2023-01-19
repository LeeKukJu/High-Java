package ment.dao;

import java.util.List;
import java.util.Map;

import common.dao.MyBatisDao;
import ment.vo.MentVO;

public class MentDaoImpl extends MyBatisDao implements IMentDao{
	
	private static IMentDao mentDao;
	
	private MentDaoImpl() {}
	
	public static IMentDao getInstance() {
		if(mentDao == null) {
			mentDao = new MentDaoImpl();
		}
		return mentDao;
	}

	@Override
	public List<MentVO> listAllMent(MentVO mv) {
		return selectList("ment.selectMent");
	}

	@Override
	public List<MentVO> listMent(Map<String, String> param) {
		return selectList("ment.selectMent", param);
//		return null;
	}

	@Override
	public int selectMent(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int insertMent(MentVO mv) {
		return insert("ment.insertMent", mv);
	}

	@Override
	public int updateMent(MentVO mv) {
		return update("ment.updateMent", mv);
	}

	@Override
	public int deleteMent(MentVO mv) {
		return delete("ment.deleteMent", mv);
	}

	@Override
	public List<MentVO> listMyMent(MentVO mv) {
		return selectList("ment.listMyMent",mv);
	}


}
