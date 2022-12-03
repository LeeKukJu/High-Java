package ko.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T11DisplayCharacterTest {

	public static int CURR_RANK = 1; // 현재 순위 정보

	public static void main(String[] args) {
		/*
		 * 3개(명)의 스레드가 각각 알파벳 대문자를 출력하는데 출력을 끝낸 순서대로 결과를 나타내는 프로그램을 작성하시오.
		 */
		List<DisplayCharacter> disCharList = new ArrayList<>();
		disCharList.add(new DisplayCharacter("홍길동"));
		disCharList.add(new DisplayCharacter("일지매"));
		disCharList.add(new DisplayCharacter("변학도"));

		for (Thread th : disCharList) {
			th.start();
		}
		
		for (Thread th : disCharList) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("경기 끝...");
		System.out.println("--------------------------");
		System.out.println("경기 결과");
		System.out.println();
		System.out.println("==========================");
		System.out.println("순위\t:\t이름");
		System.out.println("--------------------------");
		for(DisplayCharacter dc : disCharList) {
			System.out.println(dc.getRank() + "\t:\t" + dc.getName());
		}
	}
}

// 알파벳 대문자를 출력하기 위한 스레드 클래스
class DisplayCharacter extends Thread {

	private String name;
	private int rank;

	public DisplayCharacter(String name) {
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
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(name + "의 출력문자 " + ch);

			// sleep()의 시간을 200~500 사이의 난수로 한다.
			try {
				Thread.sleep((int) (Math.random() * 301 + 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " 출력 끝...");
		setRank(T11DisplayCharacterTest.CURR_RANK++); //순위정보 설정하기
	}
}