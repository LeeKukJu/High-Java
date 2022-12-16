package board.service;

import java.util.List;

import board.DAO.BoardDaoImpl;
import board.DAO.IBoardDao;
import board.VO.BoardVO;

public class BoardServiceImpl implements IBoardService{

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
	public int registBoard(BoardVO bv) {
		
		return boardDao.insertBoard(bv);
	}

	@Override
	public boolean checkBoard(int boardNo) {
		return boardDao.checkBoard(boardNo);
	}

	@Override
	public int modifyBoard(BoardVO bv) {
		return boardDao.updateBoard(bv);
	}

	@Override
	public int removeBoard(int boardNo) {
		return boardDao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> printAllBoard() {
		return boardDao.printAllBoard();
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		return boardDao.searchBoard(bv);
	}

	@Override
	public BoardVO searchBoardOne(int boardNo) {
		return boardDao.searchBoardOne(boardNo);
	}

}
