package config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * SqlSession 객체를 제공하는 팩토리 클래스
 * @author PC-13
 */
public class MyBatisUtill {
	private static SqlSessionFactory sessionFactory;
	
	static{
		
		try {
			//1-1.xml 설정 파일 읽어오기
			Charset charset = Charset.forName("UTF-8"); //한글처리를 위해
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");
			
			//1-2. Reader객체를 이용하여 sqlSessionFactory객체 생성하기
			sessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
			//1-3. Reader 닫기
			rd.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * SqlSession 객체를 제공하는 팩토리 메소드
	 * (기본값: autoCommit = false)
	 * @return SqlSession객체
	 */
	public static SqlSession getInstance() {
		return sessionFactory.openSession(); //기본값: autoCommit = false
	}
	
	/**
	 * SqlSession 객체를 제공하는 팩토리 메소드
	 * @param autoCommit 오토커밋 여뷰
	 * @return SqlSession객체
	 */
	public static SqlSession getInstance(boolean autoCommit) {
		return sessionFactory.openSession(autoCommit); 
	}
}
