package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	10마리의 말들이 경주하는 경마 프로그램 작성하기

	말은 Horse라는 이름의 클래스로 구성하고,
	이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
	그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
	기능이 있다.( Comparable 인터페이스 구현)
	
	경기 구간은 1~50구간으로 되어 있다.
	
	경기 중 중간중간에 각 말들의 위치를 >로 나타내시오.
	예)
	1번말 --->------------------------------------
	2번말 ----->----------------------------------
	...
	
	경기가 끝나면 등수를 기준으로 정렬하여 출력한다.
 */
public class HorseGame {
	public static int CURR_RANK = 1;

	public static void main(String[] args) {

		List<Horse> horseList = new ArrayList<>();

		horseList.add(new Horse(" 1번말"));
		horseList.add(new Horse(" 2번말"));
		horseList.add(new Horse(" 3번말"));
		horseList.add(new Horse(" 4번말"));
		horseList.add(new Horse(" 5번말"));
		horseList.add(new Horse(" 6번말"));
		horseList.add(new Horse(" 7번말"));
		horseList.add(new Horse(" 8번말"));
		horseList.add(new Horse(" 9번말"));
		horseList.add(new Horse("10번말"));

		for (Thread th : horseList) {
			th.start();
		}

		for (Thread th : horseList) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Collections.sort(horseList);
		System.out.println();
		System.out.println("경기 끝!!!!");
		System.out.println("--------------------------");
		System.out.println("경기 결과");
		System.out.println();
		System.out.println("==========================");
		System.out.println("순위\t:\t이름");
		System.out.println("--------------------------");
		for (Horse h : horseList) {
			System.out.println(h.getRank() + "등\t:\t" + h.getName());
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {

	private String name;
	private int rank;

	public Horse(String name) {
		super(name);
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {
		String[] rail = new String[50];
		// 경기구간 1~50 "-"으로 생성
		for (int r = 0; r < 50; r++) {
			rail[r] = "-";
		}

		for (int i = 0; i < 50; i++) {
			// rail[0]일때 에러 방지용
			if (i != 0) {
				rail[i - 1] = "-";
			}
			// 말 위치
			rail[i] = ">";
			System.out.print(name + " : ");
			// 해당 말 위치의 전체 모습 출력
			for (int j = 0; j < 50; j++) {
				System.out.print(rail[j]);
			}
			System.out.println();
			try {
				Thread.sleep((int) (Math.random() * 301 + 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " : 골인!!");
		setRank(HorseGame.CURR_RANK++);
	}

	@Override
	public int compareTo(Horse h) {
		if (rank > h.getRank()) {
			return 1;
		} else if (rank == h.getRank()) {
			return 0;
		} else {
			return -1;
		}
	}
}