package board.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.VO.BoardVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 받아 서비스에 전달하는
 * DAO 인터페이스
 */
public interface IBoardDao {
	
	/**
	 * BoardVO에 담겨진 데이터를 DB에 insert하기 위한 메서드
	 * @param mv DB에 insert할 데이터를 담은 VO객체
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * 회원ID에 해당하는 회원정보가 존재하는지 체크하기 위한 메서드
	 * @param boardNo 존재여부를 체크할 회원 ID
	 * @return 회원이 존재한다면 true, 존재하지 않으면 false 리턴함.
	 */
	public boolean checkBoard(int boardNo);
	
	/**
	 * 
	 * BoardVO에 담겨진 데이터를 DB에 update하기 위한 메서드
	 * @param bv DB에 update할 데이터를 담은 VO객체
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int updateBoard(BoardVO bv);
	
	/**
	 * 회원정보를 삭제하기 위한 메서드
	 * @param boardNo 삭제할 회원ID
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int deleteBoard(int boardNo);
	
	/**
	 * DB에 존재하는 모든 게시글 정보를 조회하기 위한 메서드
	 * @return 모든 게시글 정보를 담은 List객체
	 */
	public List<BoardVO> printAllBoard();
	
	/**
	 * DB에 존재하는 게시글 하나의 정보를 조회하기 위한 메서드
	 * @return 하나의 게시글 정보를 담은 BoardVO객체
	 */
//	public BoardVO searchOne();
	
	/**
	 * 검색할 데이터에 해당하는 회원정보 목록을 조회하기 위한 검색 메서드
	 * @param bv 검색할 데이터를 담은 VO객체
	 * @return 검색된 회원정보를 담은 List객체
	 */
	public List<BoardVO> searchBoard(BoardVO bv);
	
	/**
	 * 검색할 데이터에 해당하는 게시글 하나의 정보를 조회하기 위한 검색 메서드
	 * @param bv 검색할 데이터를 담은 BoardVO객체
	 * @return 검색된 게시글 하나의 정보를 담은 BoardVO객체
	 */
	public BoardVO searchBoardOne(int boardNo);
	
}
