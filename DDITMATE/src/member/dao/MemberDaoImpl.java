package member.dao;

import java.util.List;
import java.util.Map;

import common.dao.MyBatisDao;
import member.vo.MemberVO;
import member.vo.PictureVO;

public class MemberDaoImpl extends MyBatisDao implements IMemberDao {

	private static IMemberDao memDao;
	
	private MemberDaoImpl() {
		
	}
	
	public static IMemberDao getInstance() {
		if(memDao == null) {
			memDao = new MemberDaoImpl();
		}
		
		return memDao;
	}
	
	
	@Override
	public int insertMember(MemberVO mv) {

		return insert("member.insertMember", mv);
	}

	@Override
	public boolean checkMember(String memId) {

		boolean isExist = false;

		int cnt = selectOne("member.checkMember", memId);

		if (cnt > 0) {
			isExist = true;
		}

		return isExist;
	}

	@Override
	public int updateMember(MemberVO mv) {

		return update("member.updateMember", mv);
	}

	@Override
	public int deleteMember(String memId) {

		return delete("member.deleteMember", memId);
	}
	
	@Override
	public int deleteMemberPic(String memId) {
		
		return delete("member.deleteMemberPic", memId);
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
				selectList("member.searchMember", mv);
		
		return memList;
	}

	@Override
	public MemberVO getMember(String memId) {
		
		return selectOne("member.getMember", memId);
	}

	@Override
	public int insertPicture(PictureVO pv) {
		
		return insert("member.insertPicture", pv);
	}

	@Override
	public int updatePicture(PictureVO pv) {
		return update("member.updatePicture", pv);
	}

	@Override
	public int updateProfile(Map<String, String> param) {
		// TODO Auto-generated method stub
		return update("member.updateProfile", param);
	}

	@Override
	public PictureVO getPicture(String memId) {
		
		return selectOne("member.getPicture", memId);
	}


}
