package blame.service;

import java.util.List;

import blame.vo.BlameVO;

public interface IBlameService {
	
	/**
	 * 
	 * @param blaNo
	 * @return
	 */
	//댓글없이 등록
	public int registBlame(BlameVO bv);
	//댓글포함 등록
	public int registMentBlame(BlameVO bv);
	
	public BlameVO getBlame(int blaNo);
	
	public int modifyBlame(BlameVO bv);
	
	public int removeBlame(BlameVO bv);
	//블래임카테고리로 구분하는 리스트출력
	public int removeMentBlame(BlameVO bv);
	
	public List<BlameVO> listAllBlame(String blaCate);
	
	
}
