package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04ByteArrayIOTest {
	public static void main(String[] args) throws Exception {
		
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // 자료를 읽고 쓸때 사용할 배열 선언
		
		
//		스트림 객체 생성하기
		ByteArrayInputStream bais = 
				new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = 
				new ByteArrayOutputStream();
		
		int readByte = 0; // 읽어온 바이트 수 저장함.
		
		// read()메서드 => byte단위로 자료를 읽어와 int형으로 변환한다.
		// 			  => 더 이상 읽어올 자료가 없으면 -1을 변환한다.
		
		while((readByte = bais.read(temp)) != -1){
			System.out.println("와일문 실행...");
			System.out.println("temp => " + Arrays.toString(temp));
			
			baos.write(temp); // 출력하기
		}
		
		// 출력된 데이터를 바이트배열로 반환하는 메서드 호출
		outSrc = baos.toByteArray();
		
		System.out.println("inSrt => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
		
		// 스트림 객체 닫아주기
		bais.close();
		baos.close();
		
	}
}
