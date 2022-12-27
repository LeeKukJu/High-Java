package kr.or.ddit.comm.dao;

import java.util.List;

import kr.or.ddit.comm.vo.AtchFileVO;

public interface IAtchFileDao {
	
	/**
	 * 첨부파일 저장
	 * @param atchFileVO 첨부파일 정보를 담은 VO객체
	 * @return 성공 시 1, 실패 시 0 리턴함.
	 */
	public int insertAtchFile(AtchFileVO atchFileVO);
	
	/**
	 * 첨부파일 세부정보 저장
	 * @param atchFileVO 첨부파일 세부정보를 담은 VO객체
	 * @return 성공 시 1, 실패 시 0 리턴함.
	 */
	public int insertAtchFileDetail(AtchFileVO atchFileVO);
	
	/**
	 * 첨부파일 목록 조회
	 * @param atchFileVO
	 * @return
	 */
	public List<AtchFileVO> getAtchFIleList(AtchFileVO atchFileVO);
	
	/**
	 * 첨부파일 세부정보 조회
	 * @param atchFileVO
	 * @return 첨부파일 세부정보를 담은 VO객체
	 */
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO);
}
