package ko.or.ddit.basic;

/**
 * 스레드의 상태를 출력해 보기 위한 예제
 */
public class T10ThreadStateTest {
	/*
	   <스레드의 상태>
	   
	   - NEW : 스레드가 생성되고 아직 start()가 호출되지 않은 상태
	   - RUNNABLE : 실행 중 또는 실행가능한 상태 
	   - BLOCKED : 동기화 블럭에 의해서 일시정지한 상태(Lock이 풀릴때 까지 기다리는 상태) 
	   - WAITING, TIMED_WAITING : 스레드의 작업이 종료되지는 않았지만 실행가능하지 않은 일시정지 상태
	   						(TIEMD_WAITING은 일시정지 시간이 부여된 경우임) 
	   - TERMINATED : 스레드의 작업이 종료된 상태
	 */
	public static void main(String[] args) {
		StatePrintThread spt = new StatePrintThread(new TargetThread());
		spt.start();
	}
}

// 모니터링 대상 스레드 클래스
class TargetThread extends Thread {

	@Override
	public void run() {
		for (long i = 0; i <= 1000000000; i++) {
		} // 시간 딜레이용

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (long i = 1; i <= 1000000000; i++) {
		} // 딜레이용
	}
}

// 스레드의 상태를 모니터링하면서 출력하기 위한 스레드 클래스
class StatePrintThread extends Thread {
	
	private Thread targetThread; // 모니터링 대상 스레드가 저장될 변수
	
	public StatePrintThread(Thread targetThead) {
		this.targetThread = targetThead;
	}
	
	@Override
	public void run() {
		
		while(true) {
			// Thread의 상태값 구하기
			Thread.State state = targetThread.getState();
			System.out.println("타겟 스레드의 상태값 : " + state);
			
			// NEW 상태인지 검사
			if(state == Thread.State.NEW) {
				targetThread.start();
			}
			
			// 타겟 스레드가 종료되었는지 검사
			if(state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
