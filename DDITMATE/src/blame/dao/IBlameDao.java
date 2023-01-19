package blame.dao;

import java.util.List;

import blame.vo.BlameVO;

public interface IBlameDao {
	//댓글 없이 등록
	public int insertBlame(BlameVO bv);
	//댓글 포함 등록
	public int insertMentBlame(BlameVO bv);
		
	public BlameVO getBlame(int blaNo);
	
	public int updateBlame(BlameVO bv);
	
	public int deleteBlame(BlameVO bv);
	
	public int deleteMentBlame(BlameVO bv);
	
	public List<BlameVO> printAllBlame(String blaCate);
	
}
