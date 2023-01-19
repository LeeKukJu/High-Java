package service;

import java.util.List;
import java.util.Map;

import vo.BoardVO;
import vo.BoardVO1;

public interface IBoardService {
	
	//메소드를 작성: 접근제한자 반환타입 메소드명(매개변수)
	
	//리스트 조회
	public String loginChk(Map<String, Object> map);
	
	//전체 글 갯수 조회하기
	public int countList();
	
	//게시글 목록 조회
	public List<BoardVO> boardList(Map<String, Object> map2);
	
	
}
