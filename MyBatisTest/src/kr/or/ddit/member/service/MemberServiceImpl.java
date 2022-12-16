package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.Dao.IMemberDao;
import kr.or.ddit.member.Dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{

	private IMemberDao memDao;
	
	private static IMemberService memService;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memService == null) {
			memService = new MemberServiceImpl();
		}
		
		return memService;
	}

	@Override
	public int registMember(MemberVO mv) {
		 
		return memDao.insertMember(mv);
	}

	@Override
	public boolean checkMember(String memId) {
		return memDao.checkMember(memId);
	}

	@Override
	public int modifyMemeber(MemberVO mv) {
		return memDao.updateMemeber(mv);
	}

	@Override
	public int removeMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public List<MemberVO> listAllMember() {
		return memDao.printAllMember();
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		
		return memDao.searchMember(mv);
	}

}
