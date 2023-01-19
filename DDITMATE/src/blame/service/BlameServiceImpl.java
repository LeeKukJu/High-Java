package blame.service;

import java.util.List;

import blame.dao.BlameDaoImpl;
import blame.dao.IBlameDao;
import blame.vo.BlameVO;

public class BlameServiceImpl implements IBlameService{

	private IBlameDao blaDao;
	
	private static IBlameService blaService;
	
	private BlameServiceImpl() {
		blaDao = BlameDaoImpl.getInstance();
	}
	public static IBlameService getInstance() {
		if(blaService == null) {
			blaService = new BlameServiceImpl();
		}
		return blaService;
	}
	
	//댓글 없이하기 등록하기
	@Override
	public int registBlame(BlameVO bv) {

		return blaDao.insertBlame(bv);
	}
	
	//댓글 포함 등록하기
	@Override
	public int registMentBlame(BlameVO bv) {
		
		return blaDao.insertMentBlame(bv);
	}

	@Override
	public BlameVO getBlame(int blaNo) {
		
		return blaDao.getBlame(blaNo);
	}

	@Override
	public int modifyBlame(BlameVO bv) {
		
		return blaDao.updateBlame(bv);
	}

	@Override
	public int removeBlame(BlameVO bv) {
		
		return blaDao.deleteBlame(bv);
	}
	
	@Override
	public int removeMentBlame(BlameVO bv) {
		
		return blaDao.deleteMentBlame(bv);
	}

	@Override
	public List<BlameVO> listAllBlame(String blaCate) {
		
		return blaDao.printAllBlame(blaCate);
	}
	
}