package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.BoardDAOImpl;
import dao.IBoardDAO;
import dao.IMemberDAO;
import dao.MemberDAOImpl;
import vo.BoardVO;
import vo.BoardVO1;

public class BoardServiceImpl implements IBoardService{
	
	private IBoardDAO dao;
	private static IBoardService service;
	//싱글톤 작업
	//1
	private BoardServiceImpl() {
		dao = BoardDAOImpl.getInstance();
	}
	
	//2
	public static IBoardService getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	public String loginChk(Map<String, Object> map) {

		String memId = "";
		
		//dao가 넘겨주는 자료를 받아서 controller로 넘겨줘야 함
		try {
			memId = dao.loginChk(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memId;
	}

	@Override
	public int countList() {
		int countList =0;
		
		try {
			countList = dao.countList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countList;
	}

	@Override
	public List<BoardVO> boardList(Map<String, Object> map2) {
		List<BoardVO> list = null;
		try {
			list = dao.boardList(map2);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	
}
