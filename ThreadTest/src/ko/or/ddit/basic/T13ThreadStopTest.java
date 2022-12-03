package ko.or.ddit.basic;

public class T13ThreadStopTest {
	/*
	 
	 
	 */
	public static void main(String[] args) {
//		ThreadStopEx1 th = new ThreadStopEx1();
//		
//		th.start();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		/*
		 	Thread의 stop()을 호출하면 스레드가 바로 멈춘다.
		 	이때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어서
		 	나중에 실행되는 프로그램에 영향을 주 수 있다.
		 */
//		th.setStop(true);
		
		// interrupt()를 이용한 스레드 멈추기
		
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		th2.interrupt(); // 인터럽트 걸기
		
	}
}

class ThreadStopEx1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("스레드 처리중...");
		}
		
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료.");
	}
}

class ThreadStopEx2 extends Thread {
	
	@Override
	public void run() {
		// 방법1 => sleep()메서드나 join()메서드 등을 사용했을 때
		// 		   interrupt()를 호출하면 interruptedException이 발생한다.
		
//		try {
//			while(true) {
//				System.out.println("스레드 처리 중...");
//				Thread.sleep(1);
//			}
//		} catch (InterruptedException e) {}
		
		// 방법2 => interrupt() 가 호출되었는지 검사하기
		while(true) {
			System.out.println("스레드 처리 중...");
			
			// 검사방법1 => 스레드의 인스턴스메서드를 이용하는 방법
//			if(this.isInterrupted()) {
//				System.out.println("인스턴스용 isInterrupted() 호출됨.");
//				break;
//			}
			// 검사방법2 => 스레드의 정적메서드를 이용하는 방법
			if(Thread.interrupted()) { // 호출될때 true 되고 false로 자동 초기화됨
				System.out.println("정적메서드 interrupted() 호출됨");
				System.out.println("Thread.interrupted() => " + Thread.interrupted());
				break;
			}
		}
		
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료.");
	}
}