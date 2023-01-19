package room.vo;

public class RoomVO {
	private String roomCode;
	private String roomTitle;
	private String roomDate;
	String memId;		//회원아이디
	int roomMaster;  //관리자 여부(관리자:0 / 일반회원:1)
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getRoomMaster() {
		return roomMaster;
	}
	public void setRoomMaster(int roomMaster) {
		this.roomMaster = roomMaster;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getRoomTitle() {
		return roomTitle;
	}
	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}
	public String getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(String roomDate) {
		this.roomDate = roomDate;
	}
	
	@Override
	public String toString() {
		return "RoomVO [roomCode=" + roomCode + ", roomTitle=" + roomTitle + ", roomDate=" + roomDate + ", memId="
				+ memId + ", roomMaster=" + roomMaster + "]";
	}
	
	
	
}
