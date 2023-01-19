package common.dao;

import common.vo.FileVO;

public class AtchFileDaoImpl extends MyBatisDao implements IAtchFileDao {

	private static IAtchFileDao fileDao;

	private AtchFileDaoImpl() {
	}

	public static IAtchFileDao getInstance() {
		if (fileDao == null) {
			fileDao = new AtchFileDaoImpl();
		}
		return fileDao;
	}

	@Override
	public int insertAtchFile(FileVO fileVO) {

		return insert("atchFile.insertFile", fileVO);
	}

}
