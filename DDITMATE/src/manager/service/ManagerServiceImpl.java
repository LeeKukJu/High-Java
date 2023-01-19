package manager.service;

import java.util.List;

import manager.dao.IManagerDao;
import manager.dao.ManagerDaoImpl;
import member.vo.MemberVO;

public class ManagerServiceImpl implements IManagerService {
	
	private IManagerDao mngDao;
	
	private static IManagerService mngService;
	
	private ManagerServiceImpl() {
		mngDao = ManagerDaoImpl.getInstance();
	}

	public static IManagerService getInstance() {
		if(mngService ==null) {
			mngService =new ManagerServiceImpl();
		}
		return mngService;
	}

//	@Override
//	public boolean checkMember(String memId) {
//		return mngDao.checkMember(memId);
//	}

	@Override
	public MemberVO getMember(String memId) {
		return mngDao.getMember(memId);
	}

	@Override
	public int removeMember(String memId) {
		return mngDao.deleteMember(memId);
	}

	@Override
	public List<MemberVO> listAllMember() {
		return mngDao.printAllMember();
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		return mngDao.searchMember(mv);
	}


}