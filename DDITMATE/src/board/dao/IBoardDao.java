package board.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;

public interface IBoardDao {
	
	/**
	 * DB에 존재하는 자신의 게시판 글 조회 하는 메서드
	 * @param memId
	 * @return 모든 게시판 정보를 담은 list객체
	 */
	public List<BoardVO> listMyBoard(String memId);
	
	int deleteMyBoard(BoardVO bv);
	
	/**
	 * DB상에 카테고리에 따른 게시판 조회하기 위한 메서드
	 * @return 해당 카테고리 게시판 정보를 담은 list객체
	 */
	public List<BoardVO> listCateBoard(Map<String, Object> param);
	
	/**
	 * DB상에 해당 카테고리 게시판 전체 글 수를 반환하는 메서드
	 * @param cateCode
	 * @return 해당 카테고리 게시판 전체 글 수
	 */
	public int selectCount(Map<String, Object> param);

	/**
	 * 게시글 작성
	 * @param bv
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환
	 */
	public int insertBoard(BoardVO bv);

	
	public BoardVO selectBoard(BoardVO bv);
	
	/**
	 * 게시글 검색 메서드
	 * @param param
	 * @return 해당 카테고리 게시판에서 검색 단어를 포함하는 list객체
	 */
	public List<BoardVO> searchBoard(Map<String, Object> param);
	
	/**
	 * 게시글 조회수를 카운팅하기 위한 메소드
	 * @param boClickNum
	 * @return int타입으로 반환
	 */
	public int boardClickNum(Map<String, String> param);
	
	/**
	 * 게시글 삭제 메소드
	 * @param bv
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환
	 */
	public int deleteBoard(BoardVO bv);
	
	/**
	 * 게시글 수정 메소드
	 * @param bv
	 * @return
	 */
	public int updateBoard(BoardVO bv);

	
}
