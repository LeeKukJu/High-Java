package board.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import common.dao.MyBatisDao;

public class BoardDaoImpl extends MyBatisDao implements IBoardDao {
	
	private static IBoardDao BoardDao;

	private BoardDaoImpl() {
	}

	public static IBoardDao getInstance() {
		if (BoardDao == null) {
			BoardDao = new BoardDaoImpl();
		}

		return BoardDao;
	}

	@Override
	public List<BoardVO> listMyBoard(String memId) {
		
		return selectList("board.selectMyBoard", memId);
	}
	@Override
	public int deleteMyBoard(BoardVO bv) {
		return delete("board.deleteBoard", bv);
	}

	@Override
	public List<BoardVO> listCateBoard(Map<String, Object> param) {
		
		return selectList("board.getBoard", param);
	}

	@Override
	public int selectCount(Map<String, Object> param) {
		return selectOne("board.totalCount", param);
	}

	@Override
	public int insertBoard(BoardVO bv) {
		
		return insert("board.insertBoard", bv);
	}

	@Override
	public List<BoardVO> searchBoard(Map<String, Object> param) {
		
		return selectList("board.searchBoard", param);
	}
	
	@Override
	public BoardVO selectBoard(BoardVO bv) {
		 
		return selectOne("board.selectBoard", bv);
	}

	@Override
	public int boardClickNum(Map<String, String> param) {
		
		return update("board.clickNum", param);
	}

	@Override
	public int deleteBoard(BoardVO bv) {
		return delete("board.deleteBoard", bv);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return update("board.updateBoard", bv);
	}
	
}
