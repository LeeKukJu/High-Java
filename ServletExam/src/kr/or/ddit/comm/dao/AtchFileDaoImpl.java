package kr.or.ddit.comm.dao;

import java.util.List;

import kr.or.ddit.comm.vo.AtchFileVO;

public class AtchFileDaoImpl extends MyBatisDao implements IAtchFileDao{
	
	private static IAtchFileDao fileDao;
	
	private AtchFileDaoImpl() {
	}
	
	public static IAtchFileDao getInstance() {
		if(fileDao == null) {
			fileDao = new AtchFileDaoImpl();
		}
		return fileDao;
	}
	
	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) {
		
		return insert("atchFile.insertAtchFile", atchFileVO);
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) {
		
		return insert("atchFile.insertAtchFileDetail", atchFileVO);
	}

	@Override
	public List<AtchFileVO> getAtchFIleList(AtchFileVO atchFileVO) {
		
		return selectList("atchFile.getAtchFileList", atchFileVO);
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		
		return selectOne("atchFile.getAtchFileDetail", atchFileVO);
	}

}
