package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
	파일읽기 예제
 */
public class T05FileStreamTest {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(
					new File("d:/D_Other/test.txt"));
			
			int data = 0;
			
			// 읽어온 값이 -1이면 파일의 끝까지 읽었다는 의미
			while((data = fis.read()) != -1) {
				// 읽어온 데이터 콘솔에 출력하기
				System.out.print((char) data);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fis.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
