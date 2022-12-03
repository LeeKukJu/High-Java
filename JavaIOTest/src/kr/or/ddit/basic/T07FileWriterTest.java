package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * FileWriter(문자기반스트림) 예제
 */
public class T07FileWriterTest {
	public static void main(String[] args) {
		
		// 콘솔(표준 입추력장치)과 연결된 문자 스트림 객체 생성하기
		// InputStreamReader => 바이트 기반 스트림을 문자기반 스트림으로
		// 						변환해주는 보조 스트림이다.
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = null; // 파일 출력용 문자기반 스트림
		
		try {
			// 파일 출력용 문자 스트림 객체 생성하기
			fw = new FileWriter("d:/D_Other/testChar.txt");
			
			int data = 0;
			
			System.out.println("아무거나 입력하세요.");
			
			// 콘솔에서 입력할 때 입력의 끝 표시는 Ctrl + Z 키를 누르면 된다.
			while((data = isr.read()) != -1) {
				fw.write(data);
			}
			
			System.out.println("작업 끝...");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fw.close();
				isr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
