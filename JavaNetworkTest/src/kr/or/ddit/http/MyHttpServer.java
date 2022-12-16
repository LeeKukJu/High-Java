package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * 간단한 웹 서버 예제
 * @author PC-22
 */
public class MyHttpServer {
	 private final int port = 80;
	 private final String encoding = "UTF-8";
	 
	 public void start() {
		 System.out.println("HTTP 서버가 시작되었습니다.");
		 
		 try(ServerSocket server = new ServerSocket(this.port)){
			 while(true) {
				 try {
					 Socket socket = server.accept();
					 
					 // Http 요청을 처리할 스레드 생성하기
					 HttpHandler handler = new HttpHandler(socket);
					 handler.start();
					 
					 
				 }catch(IOException e) {
					 e.printStackTrace();
				 }
			 }
			 
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 private class HttpHandler extends Thread {
		 private final Socket socket;
		 
		 public HttpHandler(Socket socket) {
			 this.socket = socket;
		}
		 
		 @Override
		public void run() {
			 
			 OutputStream out = null;
			 BufferedReader br = null;
			 
			 try {
				 out = new BufferedOutputStream(
						 socket.getOutputStream());
				 
				 br = new BufferedReader(
						 new InputStreamReader(
								 socket.getInputStream()));
				 
				 // 요청헤더 정보 파싱하기
				 StringBuilder sb = new StringBuilder();
				 
				 // request Line
				 String reqLine = br.readLine();
				 
				 printMsg("Request Line : ", reqLine);
				 
				 while(true) {
					 String str = br.readLine();
					 
					 // Empty Line
					 if(str.equals("")) break;
					 
					 sb.append(str + "\n");
				 }
				 
				 // 헤더정보(Header)
				 String reqHeaderStr = sb.toString();
				 
				 printMsg("요청헤더", reqHeaderStr);
				 
				 String reqPath = ""; // 요청 경로
				 
				 StringTokenizer st =
						 new StringTokenizer(reqLine);
				 
				 while(st.hasMoreTokens()) {
					 String token = st.nextToken();
					 if(token.startsWith("/")) {
						 reqPath = token;
						 break;
					 }
				 }
				 
				 // 접근할 파일경로
				 String filePath = "./WebContent" + reqPath;
				 
				 
			 }catch(IOException e) {
				 e.printStackTrace();
			 }finally {
				 try {
					 socket.close(); // 소켓 닫기
					 
				 }catch (IOException e) {
					 e.printStackTrace();
				 }
			 }
		}
		 
		/**
		 * Http 메세지 콘솔 출력
		 * @param title
		 * @param reqHeaderStr
		 */
		private void printMsg(String title, String reqHeaderStr) {
			System.out.println("================================================");
			System.out.println(title);
			System.out.println("================================================");
			System.out.println(reqHeaderStr);
			System.out.println("------------------------------------------------");
			
		}
	 }
	 
	 public static void main(String[] args) {
		new MyHttpServer().start();
	}
}


