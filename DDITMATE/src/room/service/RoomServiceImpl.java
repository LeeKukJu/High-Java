package room.service;

import java.util.List;
import java.util.Map;

import board.service.IBoardService;
import room.dao.IRoomDao;
import room.dao.RoomDaoImpl;
import room.vo.RoomBoardVO;
import room.vo.RoomMemberVO;
import room.vo.RoomVO;

public class RoomServiceImpl implements IRoomService {
	
	private IRoomDao roomDao;
	
	private static IRoomService roomService;

	private RoomServiceImpl() {
		roomDao = RoomDaoImpl.getInstance();
	}

	public static IRoomService getInstance() {
		if (roomService == null) {
			roomService = new RoomServiceImpl();
		}

		return roomService;
	}

	@Override
	public int createRoom(RoomVO rv) {
		return roomDao.createRoom(rv);
	}

	@Override
	public int insertRoomMember(RoomVO rv) {
		return roomDao.insertRoomMember(rv);
	}

	@Override
	public List<RoomVO> selectRoomList(String memId) {
		
		return roomDao.selectRoomList(memId);
	}

	@Override
	public int deletRoom(RoomVO rv) {
		
		return roomDao.deletRoom(rv);
	}

	@Override
	public int deletRoomAllMember(RoomVO rv) {
		
		return roomDao.deletRoomAllMember(rv);
	}

	@Override
	public int deletRoomMember(RoomVO rv) {
		
		return roomDao.deletRoomMember(rv);
	}

	@Override
	public List<RoomMemberVO> selectRoomMemberList(String roomCode) {
		
		return roomDao.selectRoomMemberList(roomCode);
	}

	@Override
	public List<RoomBoardVO> listRoomBoard(Map<String, Object> param) {
		
		return roomDao.listRoomBoard(param);
	}

	@Override
	public List<RoomBoardVO> searchRoomBoard(Map<String, Object> param) {
		
		return roomDao.searchRoomBoard(param);
	}

	@Override
	public int insertRoomBoard(RoomBoardVO rbv) {
		
		return roomDao.insertRoomBoard(rbv);
	}

	@Override
	public int updateRoomBoard(RoomBoardVO rbv) {
		
		return roomDao.updateRoomBoard(rbv);
	}

	@Override
	public int selectCount(Map<String, Object> param) {
		
		return roomDao.selectCount(param);
	}

	

}
