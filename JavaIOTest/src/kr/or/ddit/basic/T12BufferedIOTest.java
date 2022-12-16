package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 문자기반 스트림을 위한 Buffered스트림 사용 예제
 */
public class T12BufferedIOTest {
	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(
					"./src/kr/or/ddit/basic/T11BufferedIOTest.java");
			br = new BufferedReader(fr);
			
			String tmpStr = "";
			int cnt = 1;		
//			int data = 0;
			
			while((tmpStr = br.readLine()) != null) {
				System.out.printf("%4d: %s\n", cnt++, tmpStr);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
