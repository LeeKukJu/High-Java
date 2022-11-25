package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	// 필드
	private Scanner scan;
	private Map<Integer, HotelVO> hotelMap;

	// 생성자
	public Hotel() {
		scan = new Scanner(System.in);
		hotelMap = new HashMap<Integer, HotelVO>();
	}

	// 메뉴 출력 메서드
	public void displayMenu() {
		System.out.println("**********************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println("**********************************************");
		System.out.print("메뉴선택 => ");
	}

	// 프로그램 시작 메서드
	public void hotelStart() {
		System.out.println("************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("************************");
		
		while(true) {
			
			displayMenu(); //메뉴 출력
			
			int menuNum = Integer.parseInt(scan.nextLine()); //메뉴 번호 입력
			
			switch(menuNum) {
			case 1: checkIn(); //등록
			break;
			case 2: checkOut(); //삭제
			break;
			case 3: roomStatus(); // 전체 출력
			break;
			case 4: 
				System.out.println("프로그램을 종료합니다...");
				return;
			default :
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} //switch문
		} //while문
	}

	private void roomStatus() {
		Set<Integer> keySet = hotelMap.keySet();
		
		System.out.println("----------------------------------");
		if(keySet.size() == 0) {
			System.out.println("호텔에 투숙객에 없습니다.");
		}else {
			Iterator<Integer> it = keySet.iterator();
			
			while(it.hasNext()) {
				int roomNum = it.next();
				HotelVO h = hotelMap.get(roomNum);
				System.out.println("방번호 : " + h.getRoomNum()+ ", " + "투숙객 : " + h.getName());
			}
		}
		System.out.println("----------------------------------");
	}

	private void checkOut() {
		System.out.println();
		System.out.println("어느 방에 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		//nextLine() 하면 공백들어가서 에러남
		int roomNum = Integer.parseInt(scan.nextLine());
		System.out.println();
		
		if(hotelMap.remove(roomNum) == null){
			System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
		}else {
			System.out.println(roomNum + "방이 체크아웃 되었습니다.");
		}
	}

	private void checkIn() {
		System.out.println();
		System.out.println("어느 방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		//nextLine() 하면 공백들어가서 에러남
		int roomNum = Integer.parseInt(scan.nextLine());
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		scan.nextLine();
		String name = scan.nextLine();
		
		if(hotelMap.get(roomNum) != null) {
			System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
			return;
		}
		
		HotelVO h = new HotelVO(roomNum, name);
		hotelMap.put(roomNum, h);
		System.out.println(roomNum + "방에 체크인 되었습니다.");
	}
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.hotelStart(); //프로그램 시작
	}

}

class HotelVO {
	private int roomNum;
	private String name;

	public HotelVO(int roomNum, String name) {
		this.roomNum = roomNum;
		this.name = name;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HotelVO [roomNum=" + roomNum + ", name=" + name + "]";
	}

}