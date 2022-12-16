package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.Dao.IMemberDao;
import kr.or.ddit.member.Dao.MemberDaoImplForJdbc;
import kr.or.ddit.member.VO.MemberVO;

public class MemberServiceImpl implements IMemberService{

	private IMemberDao memDao;
	
	public MemberServiceImpl() {
		memDao = new MemberDaoImplForJdbc();
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
