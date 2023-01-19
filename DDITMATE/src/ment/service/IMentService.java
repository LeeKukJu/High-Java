package ment.service;

import java.util.List;
import java.util.Map;

import ment.vo.MentVO;

public interface IMentService {

	/**
	 * DB에 존재하는 모든 댓글을 조회하기 위한 메소드
	 * @return 모든 댓글 정보를 담은 list객체
	 */
//	public List<MentVO> listAllMent(String cateCode, String boNo);
	public List<MentVO> listAllMent(MentVO mv);
	
	
	public List<MentVO> listMent(Map<String, String> param);
	
	
	public int selectMent(Map<String, Object> param);
	
	/**
	 * 댓글을 작성하는 메소드
	 * @param mv
	 * @return 성공하면 1이상의 값이 반횐되고 실패하면 0이 반환
	 */
	public int insertMent(MentVO mv);
	
	/**
	 * 댓글을 수정하는 메소드
	 * @param mv
	 * @return 성공하면 1이상의 값이 반횐되고 실패하면 0이 반환
	 */
	public int updateMent(MentVO mv);
	
	/**
	 * 댓글을 삭제하는 메소드
	 * @param mv
	 * @return 성공하면 1이상의 값이 반횐되고 실패하면 0이 반환
	 */
	public int deleteMent(MentVO mv);


	public List<MentVO> listMyMent(MentVO mv);


}
