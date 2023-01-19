package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.BoardVO;
import vo.BoardVO1;

public interface IBoardDAO {

	//로그인 id-pw검증
	//예외가 발생한 경우 dao에서 예외를 처리하지 않고 서버에서 예외를 처리하도록 throws
	public String loginChk(Map<String, Object> map) throws SQLException;
	
	//전체 글 갯수 조회하기
	public int countList() throws SQLException;
		
	//게시글 목록 조회
	public List<BoardVO> boardList(Map<String, Object> map2) throws SQLException;
}
