package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoProgram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Set<Integer> lotto = new HashSet<Integer>();
		int num;
		int cash;

		loof: while (true) {
			System.out.println("\t==========================\r\n" + "             Lotto 프로그램\r\n"
					+ "	--------------------------\r\n" + "	  1. Lotto 구입\r\n" + "	  2. 프로그램 종료\r\n"
					+ "	==========================	");
			System.out.print("메뉴 선택 : ");
			num = scanner.nextInt();
			System.out.println();

			switch (num) {
			case 1:
				System.out.println("<Lotto 구입 시작>");
				System.out.println("1000원에 1게임입니다.");
				System.out.print("금액 입력 : ");
				cash = scanner.nextInt();
				System.out.println("----------------------------");

				for (int i = 1; i < (cash / 1000) + 1; i++) {
					while (lotto.size() < 6) {
						int lottoNum = (int) (Math.random() * 45 + 1);
						lotto.add(lottoNum);
					}

//					Iterator selectNum = lotto.iterator();
//					System.out.printf("로또번호%d: ", i);
//					while (selectNum.hasNext()) {
//						System.out.print("[" + selectNum.next() + "]");
//					}

					List<Integer> lottoList = new ArrayList<Integer>(lotto);
					Collections.sort(lottoList);
					System.out.printf("로또번호%d: ", i);
					for (Integer lo : lottoList) {
						System.out.print(lo + " ");
					}

					lotto.clear();
					System.out.println();
				}
				System.out.println("----------------------------");
				System.out.printf("받은 금액은 %,d원이고 거스름돈은 %d원입니다.\n\n", cash, (cash % 1000));
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.\n감사합니다.");
				break loof;
			}
		}
	}
}
