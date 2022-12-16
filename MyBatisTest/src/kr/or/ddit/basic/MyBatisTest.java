package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.vo.MemberVO;

public class MyBatisTest {
	public static void main(String[] args) {
	// byBatis를 이용하여 DB작업을 처리하는 방법
	// 1. myBatis의 환경설정 파일을 읽어와 실행시킨다.
		
	SqlSessionFactory sessionFactory = null;
	
	try {
		// 1-1. xml설정파일 읽어오기
		Charset charset = Charset.forName("UTF-8"); // 한글처리를 위해
		Resources.setCharset(charset);
		
		Reader rd = 
				Resources.getResourceAsReader("mybatis-config.xml");
		
		// 1-2. Reader객체를 이용하여 SqlSessionFactory객체 생성하기
		sessionFactory = new SqlSessionFactoryBuilder().build(rd);
		
		// 1-3. Reader 닫기
		rd.close();
		
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	// 2. 실행할 SQL문에 맞는 쿼리문을 호출하여 원하는 작업을 수행한다.
	/*
	// 2-1. insert작업 연습
	System.out.println("insert 작업 시작...");
	
	// 1) 저장할 데이터를 VO에 담는다
	MemberVO mv = new MemberVO();
	mv.setMemId("h001");
	mv.setMemName("강감찬");
	mv.setMemTel("1111-2222");
	mv.setMemAddr("경남 진주");
	
	// 2) SqlSession 객체를 이용하여 해당 쿼리문을 실행한다.
	// 형식) sqlSession.insert("namespace값.id값", 파라미터객체);
	//  반환값 : 성공한 레코드 수
	 * 
	SqlSession session = sessionFactory.openSession(false); // 오토커밋 여부
	
	try {
		int cnt = session.insert("memberTest.insertMember", mv);
								// namespace.id값
		if(cnt > 0 ) {
			System.out.println("insert 작업 성공");
			session.commit(); // 커밋.
		}else {
			System.out.println("insert 작업 실패");
		}
		
	}catch(PersistenceException e) {
		e.printStackTrace();
		session.rollback();
	}finally {
		session.close();
	}
	
	System.out.println("------------------------------------------------");
	
	// 2-2 update 연습
	System.out.println("update 작업 시작...");
	
	MemberVO mv2 = new MemberVO();
	mv2.setMemId("d001");
	mv2.setMemName("김대덕");
	mv2.setMemTel("3333-3333");
	mv2.setMemAddr("부산시 해운대구");
	
	SqlSession session = sessionFactory.openSession(false);
	
	try {
		// update()메서드의 반환값도 성공한 레코드 수 이다.
		int cnt = session.update("memberTest.updateMember", mv2);
		
		if(cnt > 0) {
			System.out.println("업데이트 성공!");
			session.commit();
		}else {
			System.out.println("업데이트 실패!");
			session.rollback();
		}
		
	}catch(PersistenceException e) {
		e.printStackTrace();
		session.rollback();
	}finally {
		session.close();
	}
	
	
	System.out.println("-------------------------------------------------");
	
	// 2-3 delete 연습 
	System.out.println("delete 연습 시작...");
	
	SqlSession session = sessionFactory.openSession();
	
	try {
		// delete()메서드도 성공한 레코드 수를 반환한다.
		int cnt = session.delete("memberTest.deleteMember", "d001");
		
		if(cnt > 0) {
			System.out.println("삭제 작업 성공!");
			session.commit();
		}else {
			System.out.println("삭제 작업 성공!");
		}
	}catch(PersistenceException e) {
		e.printStackTrace();
		session.rollback();
	}finally {
		session.close();
	}
	
	*/
	System.out.println("-------------------------------------------------");
	
	// 2-4. select 연습
	// 1) 응답결과가 여러개인 경우
	System.out.println("select 연습(응답결과가 여러개인 경우...)");
	
	// 응답결과가 여러개일 경우에는 selectList 메서드를 사용한다.
	// 이 메서드는 여러개의 레코드를 VO에 담은 후 이 VO객체를 List에
	// 추가해 주는 작업을 자동으로 수행한다.
	
	SqlSession session = sessionFactory.openSession();
	
	try {
		List<MemberVO> memList = 
				session.selectList("memberTest.selectAllMember");
		System.out.println("크기 : " + memList.size());
		for(MemberVO mv : memList) {
			System.out.println("ID: " + mv.getMemId());
			System.out.println("이름 : " + mv.getMemName());
			System.out.println("전화 : " + mv.getMemTel());
			System.out.println("주소 : " + mv.getMemAddr());
			System.out.println("===============================");
		}
		System.out.println("출력 끝...");
	}finally {
		session.close();
	}
	
	
	// 2) 응답이 1개인 경우
	System.out.println("select 연습 시작(결과가 1개인 경우...)");
	
	session = sessionFactory.openSession();
	
	try {
		// 응답결과가 1개가 확실한 경우에는 selectOne() 메서드를 사용한다.
//		MemberVO mv3 = session.selectOne(
//				"memberTest.getMember", "h001");
//		
//		System.out.println("ID: " + mv3.getMemId());
//		System.out.println("이름 : " + mv3.getMemName());
//		System.out.println("전화 : " + mv3.getMemTel());
//		System.out.println("주소 : " + mv3.getMemAddr());
//		System.out.println("출력 끝...");
		
		int cnt = session.selectOne(
				"memberTest.checkMember", "h001");
		
		if(cnt > 0) {
			System.out.println("회원 존재함. ");
		} else {
			System.out.println("회원 없음. ");
			
		}
	} finally {
		session.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	}
}
