package board.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.VO.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	/*
		<SqlSessions>
		 mybatis를 사용하기 위한 자바 인터페이스.
		 이 인터페이스를 통해 명령어를 실행하고 매퍼를 얻으며 트랜잭션 관리를 할 수 있다.
		
		- 인스턴스 만드는 법
		 SqlSessionFactory인스턴스를 사용해서 만든다.
	 */
	private SqlSession session;
	
	public static SqlSessionFactory sessionFactory = null; //DB연결과 SQL쿼리문 실행을 위한 SqlSessionFactory 

	private static IBoardDao boardDao;

	private BoardDaoImpl() {
	}

	public static IBoardDao getInstance() {
		if (boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	
	@Override
	public int insertBoard(BoardVO bv) {

		session = sessionFactory.openSession(false);
		int cnt = 0;

		try {
			cnt = session.insert("boardSql.insertBoard", bv);
			session.commit();
			if (cnt > 0) {
				session.commit();
				
			} else {
				session.rollback();
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public boolean checkBoard(int boardNo) {

		boolean isExist = false;
		session = sessionFactory.openSession();

		try {

			int cnt = session.selectOne("boardSql.checkBoard", boardNo);

			if (cnt > 0) {
				isExist = true;
			}

		} finally {
			session.close();
		}

		return isExist;
	}

	@Override
	public int updateBoard(BoardVO bv) {

		session = sessionFactory.openSession(false);

		int cnt = 0;

		try {
			cnt = session.update("boardSql.updateBoard", bv);
			if(cnt > 0) {
				session.commit();
			}else {
				session.rollback();
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {

		session = sessionFactory.openSession(false);
		int cnt = 0;

		try {
			cnt = session.delete("boardSql.deleteBoard", boardNo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public List<BoardVO> printAllBoard() {

		session = sessionFactory.openSession(false);

		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {
			boardList = session.selectList("boardSql.printAllBoard");

		} finally {
			session.close();
		}

		return boardList;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		session = sessionFactory.openSession();
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			
			boardList = session.selectList("boardSql.searchBoard", bv);

		} finally {
			session.close();
		}

		return boardList;
	}

	@Override
	public BoardVO searchBoardOne(int boardNo) {

		session = sessionFactory.openSession();
		BoardVO boardOne = null;

		try {
			boardOne = session.selectOne("boardSql.boardOne", boardNo);

		} finally {
			session.close();
		}

		return boardOne;
	}

}
