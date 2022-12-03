package ko.or.ddit.basic;

import javax.swing.JOptionPane;

/**
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 */
public class T07ThreadGame {
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
		
	}
}

/**
 * 데이터를 입력하는 스레드
 */
class DataInput extends Thread {

	@Override
	public void run() {
		String user = JOptionPane
				.showInputDialog("가위 바위 보 중 하나를 입력하세요.");
		
		// 입력이 완료되면 inputCheck변수를 true로 설정한다.
		T06ThreadTest.inputCheck = true;
		
		
		
	}
}

/**
 * 카운트다운 처리를 위한 스레드
 */
class CountDown extends Thread {
	
	@Override
	public void run() {
		
		for(int i=5; i>=1; i--) {
			// 입력이 완료되었는지 여부를 검사하고 입력이 완료되면
			// run()을 종료시킨다. 즉, 현재 스레드를 종료시킨다.
			if(T06ThreadTest.inputCheck == true) {
				return;
			}
			
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 10초가 경과되었는데도 입력이 없으면 프로그램을 종료시킨다.
		System.out.println("5초가 지났습니다. 패배했습니다.");
		System.exit(0);// 프로그램을 강제종료시키는 명령
	}
}