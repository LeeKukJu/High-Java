package board.service;

import java.util.List;
import java.util.Map;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao boardDao;
	
	private static IBoardService boardService;

	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}

	public static IBoardService getInstance() {
		if (boardService == null) {
			boardService = new BoardServiceImpl();
		}

		return boardService;
	}

	@Override
	public List<BoardVO> listMyBoard(String memId) {
		return boardDao.listMyBoard(memId);
	}
	@Override
	public int deleteMyBoard(BoardVO bv) {
		return boardDao.deleteMyBoard(bv);
	}

	@Override
	public List<BoardVO> listCateBoard(Map<String, Object> param) {
		return boardDao.listCateBoard(param);
	}

	@Override
	public int selectCount(Map<String, Object> param) {
		return boardDao.selectCount(param);
	}

	@Override
	public int insertBoard(BoardVO bv) {
		
		return boardDao.insertBoard(bv);
	}
	
	@Override
	public int updateClickNum(Map<String, String> param) {
		return boardDao.boardClickNum(param);
	}
	
	@Override
	public BoardVO getBoard(BoardVO bv) {
		return boardDao.selectBoard(bv);
	}


	@Override
	public List<BoardVO> searchBoard(Map<String, Object> param) {
		
		return boardDao.searchBoard(param);
	}

	@Override
	public int deleteBoard(BoardVO bv) {
		return boardDao.deleteBoard(bv);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return boardDao.updateBoard(bv);
	}

}
