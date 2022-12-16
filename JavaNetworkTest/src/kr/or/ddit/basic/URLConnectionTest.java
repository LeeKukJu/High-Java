package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class URLConnectionTest {
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://www.naver.com/index.html");
		
		// Header정보 가져오기
		
		// URLConnection 객체 구하기
		URLConnection urlConn = url.openConnection();
		
		System.out.println("Content-Type: " + urlConn.getContentType());
		System.out.println("Encoding: " + urlConn.getContentEncoding());
		System.out.println("Content: " + urlConn.getContent());
		System.out.println();
		
		// 전체 Header 정보 출력하기
		Map<String, List<String>> headerMap = urlConn.getHeaderFields();
		
		Iterator<String> it = headerMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + headerMap.get(key));
		}
		System.out.println("----------------------------------------------------");
		
		// 컨텐츠 내용 가져오기
		InputStream is = (InputStream) urlConn.getContent();
		
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		
		BufferedReader br = new BufferedReader(isr);
		
		String tmpStr = "";
		
		while((tmpStr = br.readLine()) != null) {
			System.out.println(tmpStr);
		}
		
		/*
		int data = 0;
		while((data = isr.read()) != -1) {
			System.out.print((char) data);
		}
		
		isr.close();
		*/
		
		
		
	}
}
