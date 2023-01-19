package blame.dao;

import java.util.List;

import blame.vo.BlameVO;
import common.dao.MyBatisDao;

public class BlameDaoImpl extends MyBatisDao implements IBlameDao{

	private static IBlameDao blaDao;
	
	private BlameDaoImpl() {
		
	}
	public static IBlameDao getInstance() {
		if(blaDao == null) {
			blaDao = new BlameDaoImpl();
		}
		return blaDao;
	}
	//댓글없이 등록
	@Override
	public int insertBlame(BlameVO bv) {
		
		return insert("blame.insertBlame", bv);
	}
	//댓글포함 등록
	@Override
	public int insertMentBlame(BlameVO bv) {
		
		return insert("blame.insertMentBlame", bv);
	}

	@Override
	public BlameVO getBlame(int blaNo) {
		
		return selectOne("blame.getBlame", blaNo);
	}

	@Override
	public int updateBlame(BlameVO bv) {
		return update("blame.updateBlame", bv);
	}

	@Override
	public int deleteBlame(BlameVO bv) {
		return delete("blame.deleteBlame", bv);
	}
	
	@Override
	public int deleteMentBlame(BlameVO bv) {
		return delete("blame.deleteMentBlame", bv);
	}
	
//블래임 카테고리로 구분하는 리스트 출력
	@Override
	public List<BlameVO> printAllBlame(String blaCate) {
		List<BlameVO> blaList = 
				selectList("blame.blameList", blaCate);
		return blaList;
	}
}
