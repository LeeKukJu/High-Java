package ment.service;

import java.util.List;
import java.util.Map;

import ment.dao.IMentDao;
import ment.dao.MentDaoImpl;
import ment.vo.MentVO;

public class MentServiceImpl implements IMentService{
	
	private IMentDao mentDao;
	
	private static IMentService mentService;
	
	private MentServiceImpl(){
		mentDao = MentDaoImpl.getInstance();
	}
	public static IMentService getInstance() {
		if(mentService == null) {
			mentService = new MentServiceImpl();
		}
		return mentService;
	}
	
	@Override
	public List<MentVO> listAllMent(MentVO mv) {
		return mentDao.listAllMent(mv);
	}

	@Override
	public List<MentVO> listMent(Map<String, String> param) {
		return mentDao.listMent(param);
	}

	@Override
	public int selectMent(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int insertMent(MentVO mv) {
		return mentDao.insertMent(mv);
	}

	@Override
	public int updateMent(MentVO mv) {
		return mentDao.updateMent(mv);
	}

	@Override
	public int deleteMent(MentVO mv) {
		return mentDao.deleteMent(mv);
	}
	@Override
	public List<MentVO> listMyMent(MentVO mv) {
		return mentDao.listMyMent(mv);
	}

}
