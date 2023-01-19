package room.dao;

import java.util.List;
import java.util.Map;

import room.vo.RoomBoardVO;
import room.vo.RoomMemberVO;
import room.vo.RoomVO;

public interface IRoomDao {
	
	/**
	 * 모임방 정보 DB에 저장하는 메서드
	 * @param memId
	 * @param rv
	 * @return 성공1, 실패0 반환
	 */
	public int createRoom(RoomVO rv);
	
	/**
	 * 모임 명단 정보를 DB에 저장하는 메서드
	 * @param rmv
	 * @return 성공1, 실패0 반환
	 */
	public int insertRoomMember(RoomVO rmv);
	
	/**
	 * 자신의 모임방 목록 정보를 조회하는 메서드
	 * @param memId
	 * @return RoomVO객체를 담은 List객체
	 */
	public List<RoomVO> selectRoomList(String memId);
	
	/**
	 * 모임방을 나가기 위한 메서드
	 * @param rv
	 * @return 성공1, 실패0 반환
	 */
	public int deletRoom(RoomVO rv);
	
	/**
	 * 해당 방 모임명단 전체 삭제(모임장 나가기용)를 위한 메서드  
	 * @param rv
	 * @return 성공1, 실패0 반환
	 */
	public int deletRoomAllMember(RoomVO rv);
	
	/**
	 * 해당 방 모임명단 삭제(모임원 나가기용)를 위한 메서드
	 * @param rv
	 * @return 성공1, 실패0 반환
	 */
	public int deletRoomMember(RoomVO rv);
	
	/**
	 * 해당 모임방에 등록되어 있는 모임원 정보를 조회하는 메서드
	 * @param roomCode
	 * @return roomMemberVO타입 List객체
	 */
	public List<RoomMemberVO> selectRoomMemberList(String roomCode);
	
	/**
	 * 모임별 게시판 정보 조회하는 메서드
	 * @param param
	 * @return RoomBoardVO타입 List객체
	 */
	public List<RoomBoardVO> listRoomBoard(Map<String, Object> param);
	
	/**
	 * 모임 게시글 검색 메서드
	 * @param param
	 * @return 검색 단어를 포함하는 RoomBoardVO타입 List객체
	 */
	public List<RoomBoardVO> searchRoomBoard(Map<String, Object> param);
	
	/**
	 * 모임 게시판 글쓰기 메서드
	 * @param rbv
	 * @return 성공1, 실패0 반환
	 */
	public int insertRoomBoard(RoomBoardVO rbv);
	
	/**
	 * 모임게시글 수정하는 메서드
	 * @param rbv
	 * @return 성공1, 실패0 반환
	 */
	public int updateRoomBoard(RoomBoardVO rbv);
	
	/**
	 * 모임 게시판 전체 글 수 반환하는 메서드
	 * @param param
	 * @return 모임 게시판 전체 글 수
	 */
	public int selectCount(Map<String, Object> param);
}
