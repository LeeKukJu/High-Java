package kr.or.ddit.member.Dao;

import java.util.List;

import kr.or.ddit.member.VO.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 받아 서비스에 전달하는
 * DAO 인터페이스
 */
public interface IMemberDao {
	
	/**
	 * MemberVO에 담겨진 데이터를 DB에 insert하기 위한 메서드
	 * @param mv DB에 insert할 데이터를 담은 VO객체
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int insertMember(MemberVO mv);
	
	/**
	 * 회원ID에 해당하는 회원정보가 존재하는지 체크하기 위한 메서드
	 * @param memId 존재여부를 체크할 회원 ID
	 * @return 회원이 존재한다면 true, 존재하지 않으면 false 리턴함.
	 */
	public boolean checkMember(String memId);
	
	/**
	 * 
	 * MemberVO에 담겨진 데이터를 DB에 update하기 위한 메서드
	 * @param mv DB에 update할 데이터를 담은 VO객체
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int updateMemeber(MemberVO mv);
	
	/**
	 * 회원정보를 삭제하기 위한 메서드
	 * @param memId 삭제할 회원ID
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int deleteMember(String memId);
	
	/**
	 * DB에 존재하는 모든 회원정보를 조회하기 위한 메서드
	 * @return 모든 회원정보를 담은 List객체
	 */
	public List<MemberVO> printAllMember();
	
	/**
	 * 검색할 데이터에 해당하는 회원정보 목록을 조회하기 위한 검색 메서드
	 * @param mv 검색할 데이터를 담은 VO객체
	 * @return 검색된 회원정보를 담은 List객체
	 */
	public List<MemberVO> searchMember(MemberVO mv);
	
}
