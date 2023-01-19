package room.dao;

import java.util.List;
import java.util.Map;

import common.dao.MyBatisDao;
import room.vo.RoomBoardVO;
import room.vo.RoomMemberVO;
import room.vo.RoomVO;

public class RoomDaoImpl extends MyBatisDao implements IRoomDao {
	
	private static IRoomDao roomDao;

	private RoomDaoImpl() {
	}

	public static IRoomDao getInstance() {
		if (roomDao == null) {
			roomDao = new RoomDaoImpl();
		}

		return roomDao;
	}
	
	@Override
	public int createRoom(RoomVO rv) {
		
		return insert("room.createRoom", rv);
	}

	@Override
	public int insertRoomMember(RoomVO rv) {
		
		return insert("room.insertRoomMember", rv);
	}

	@Override
	public List<RoomVO> selectRoomList(String memId) {
		
		return selectList("room.selectRoomList", memId);
	}

	@Override
	public int deletRoom(RoomVO rv) {
		
		return delete("room.deletRoom", rv);
	}

	@Override
	public int deletRoomAllMember(RoomVO rv) {
		
		return delete("room.deletRoomAllMember", rv);
	}

	@Override
	public int deletRoomMember(RoomVO rv) {
		
		return delete("room.deletRoomMember", rv);
	}

	@Override
	public List<RoomMemberVO> selectRoomMemberList(String roomCode) {
		
		return selectList("room.selectRoomMemberList", roomCode);
	}

	@Override
	public List<RoomBoardVO> listRoomBoard(Map<String, Object> param) {
		
		return selectList("room.getRoomBoard", param);
	}

	@Override
	public List<RoomBoardVO> searchRoomBoard(Map<String, Object> param) {
		
		return selectList("room.searchRoomBoard", param);
	}

	@Override
	public int insertRoomBoard(RoomBoardVO rbv) {
		
		return insert("room.insertRoomBoard", rbv);
	}

	@Override
	public int updateRoomBoard(RoomBoardVO rbv) {
		
		return update("room.updateRoomBoard", rbv);
	}

	@Override
	public int selectCount(Map<String, Object> param) {
		
		return selectOne("room.totalCount", param);
	}
	
	

}
