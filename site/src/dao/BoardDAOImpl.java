package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import common.MyBatisDAO;
import vo.BoardVO;
import vo.BoardVO1;

public class BoardDAOImpl extends MyBatisDAO implements IBoardDAO{
	
	//dao객체 생성하기 - 싱글톤 방식으로
	private static IBoardDAO dao;
	
	//1. private constructor
	private BoardDAOImpl() {}
	
	//2.static method
	public static IBoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAOImpl();
		}
		return dao; 
	}
	
	@Override
	public String loginChk(Map<String, Object> map) throws SQLException {
//		return selectOne("xml파일이 가지는 namespace", map); //member.xml파일의 member의 id값
		return selectOne("member.loginChk", map);
	}

	@Override
	public int countList() throws SQLException{
		return selectOne("board.countList");
	}

	@Override
	public List<BoardVO> boardList(Map<String, Object> map2) throws SQLException {
		return selectList("board.boardList", map2); //board.boardList : namespace.id
	}

}
