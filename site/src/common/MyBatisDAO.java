package common;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtill;

public class MyBatisDAO {
	
	public int insert(String statement, Object parameter) {
		
		//세션열기
		SqlSession session = config.MyBatisUtill.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert(statement, parameter);
			
			if(cnt>0) {
				session.commit();
			}
		}catch(PersistenceException e) {
			session.rollback();
			throw new RuntimeException("데이터 등록 작업 중 예외가 발생", e);
		}finally {
			session.close(); //세션 닫기
		}
		
		return cnt;
	}
	
	public int update(String statement, Object parameter) {
		
		//세션열기
		SqlSession session = config.MyBatisUtill.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = session.update(statement, parameter);
			
			if(cnt>0) {
				session.commit();
			}
		}catch(PersistenceException e) {
			session.rollback();
			throw new RuntimeException("데이터 수정 작업 중 예외가 발생", e);
		}finally {
			session.close(); //세션 닫기
		}
		
		return cnt;
	}
	
	public int delete(String statement, Object parameter) {
		
		//세션열기
		SqlSession session = config.MyBatisUtill.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = session.delete(statement, parameter);

			if(cnt>0) {
				session.commit();
			}
		}catch(PersistenceException e) {
			session.rollback();
			throw new RuntimeException("데이터 삭제 작업 중 예외가 발생", e);
		}finally {
			session.close(); //세션 닫기
		}
		
		return cnt;
	}
	
	//쿼리만 조회만 할 때 사용
	public <T> T selectOne(String statement) { 
		
		//세션열기
		SqlSession session = config.MyBatisUtill.getInstance();
		
		T obj = null;
		
		try {
			
			obj = session.selectOne(statement);

		}catch(PersistenceException e) {
			throw new RuntimeException("데이터 조회 작업 중 예외가 발생", e);
		}finally {
			session.close(); //세션 닫기
		}
		
		return obj;
	}
	//쿼리를 조회 + 데이터 수정할 때 사용
	public <T> T selectOne(String statement, Object parameter) { 
		
		//세션열기
		SqlSession session = config.MyBatisUtill.getInstance();
		
		T obj = null;
		
		try {
			
			obj = session.selectOne(statement, parameter);
			
		}catch(PersistenceException e) {
			throw new RuntimeException("데이터 조회 작업 중 예외가 발생", e);
		}finally {
			session.close(); //세션 닫기
		}
		
		return obj;
	}
	
	public <T> List<T> selectList(String statement){
		//세션열기
		SqlSession session = config.MyBatisUtill.getInstance();
				
		List<T> list = null;
				
		try {
					
			list = session.selectList(statement);
					
		}catch(PersistenceException e) {
			e.printStackTrace();
//			throw new RuntimeException("데이터 목록 조회 작업 중 예외가 발생", e);
		}finally {
			session.close(); //세션 닫기
		}
		return list;
	}
	
	public <T> List<T> selectList(String statement, Object parameter){
		//세션열기
		SqlSession session = config.MyBatisUtill.getInstance();
						
		List<T> list = null;
						
		try {
							
			list = session.selectList(statement, parameter);
							
		}catch(PersistenceException e) {
			throw new RuntimeException("데이터 목록 조회 작업 중 예외가 발생", e);
		}finally {
			session.close(); //세션 닫기
		}
		return list;	
	}
}
