package kr.or.ddit.comm.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;

public class MyBatisDao {

	// 쿼리만 실행할 경우
	public <T> T selectOne(String statement) {

		// 세션 열기
		SqlSession session = MybatisUtil.getInstance();

		T obj = null;

		try {

			obj = session.selectOne(statement);

		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 작업 중 예외발생", e);
		} finally {
			session.close(); // 세션 닫기
		}

		return obj;
	}

	// 쿼리 실행과 그에 필요한 객체가 필요한 경우
	public <T> T selectOne(String statement, Object parameter) {

		// 세션 열기
		SqlSession session = MybatisUtil.getInstance();

		T obj = null;

		try {

			obj = session.selectOne(statement, parameter);

		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 작업 중 예외발생", e);
		} finally {
			session.close(); // 세션 닫기
		}

		return obj;
	}

	// 쿼리만 실행할 경우
	public <T> List<T> selectList(String statement) {

		// 세션 열기
		SqlSession session = MybatisUtil.getInstance();

		List<T> list = null;

		try {

			list = session.selectList(statement);

		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 목록조회 작업 중 예외발생", e);
		} finally {
			session.close(); // 세션 닫기
		}

		return list;
	}

	// 쿼리 실행과 그에 필요한 객체가 필요한 경우
	public <T> List<T> selectList(String statement, Object parameter) {

		// 세션 열기
		SqlSession session = MybatisUtil.getInstance();

		List<T> list = null;

		try {

			list = session.selectList(statement, parameter);

		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 목록조회 작업 중 예외발생", e);
		} finally {
			session.close(); // 세션 닫기
		}

		return list;
	}

	public int insert(String statement, Object parameter) {

		// 세션 열기
		SqlSession session = MybatisUtil.getInstance();

		int cnt = 0;

		try {

			cnt = session.insert(statement, parameter);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			session.rollback();
			throw new RuntimeException("데이터 등록 작업 중 예외발생", e);
		} finally {
			session.close(); // 세션 닫기
		}

		return cnt;
	}

	public int update(String statement, Object parameter) {

		// 세션 열기
		SqlSession session = MybatisUtil.getInstance();

		int cnt = 0;

		try {

			cnt = session.update(statement, parameter);
			
			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			session.rollback();
			throw new RuntimeException("데이터 수정 작업 중 예외발생", e);
		} finally {
			session.close(); // 세션 닫기
		}

		return cnt;
	}

	public int delete(String statement, Object parameter) {

		// 세션 열기
		SqlSession session = MybatisUtil.getInstance();

		int cnt = 0;

		try {

			cnt = session.delete(statement, parameter);
			
			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			session.rollback();
			throw new RuntimeException("데이터 삭제 작업 중 예외발생", e);
		} finally {
			session.close(); // 세션 닫기
		}

		return cnt;
	}

}
