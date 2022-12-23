package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.net.URLDecoder;
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
				 
				 // URL 디코딩 처리(한글 깨짐 문제)
				 reqPath = URLDecoder.decode(reqPath, "UTF-8");
				 
				 
				 // 접근할 파일경로
				 String filePath = "./WepContent" + reqPath;
				 System.out.println("요청 경로 => " + filePath);
				 
				 // 해당 파일 이름을 이용하여 Content-Type 정보 추출하기
				 String contentType = URLConnection.getFileNameMap().getContentTypeFor(filePath);
				 
				 // css파일인 경우 인식이 안되서 추가함
				 if(contentType == null && filePath.endsWith(".css")) {
					 contentType = "text/css";
				 }
				 
				 File file = new File(filePath);
				 if(!file.exists()) {
					 makeErrorPage(out, 404, "Not Found");
					 return;
				 }
				 
				 byte[] body = makeResponseBody(filePath);
				 byte[] header = makeResponseHeader(body.length, contentType);
				 
				 // 헤더정보 보내기
				 out.write(header);
				 
				 printMsg("응답헤더", new String(header));
				 
				 // 응답내용 보내기 전 반드시 Empty Line 보내기
				 out.write("\r\n\r\n".getBytes());
				 
				 // 응답내용 보내기
				 out.write(body);
				 
				 out.flush();
				 
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
	 
	 /**
	  * 응답 내용(BODY) 생성하기
	  * @param filePath 응답으로 사용할 파일 경로
	  * @return 바이트 배열 데이터
	  */
	 private byte[] makeResponseBody(String filePath) {
		 
		 FileInputStream fis = null;
		 
		 byte[] data = null;
		 
		 try {
			 File file = new File(filePath);
			 data = new byte[(int)file.length()];
			 
			 fis = new FileInputStream(file);
			 fis.read(data);
			 
			 
		 }catch(IOException e) {
			 e.printStackTrace();
		 }finally {
			 try {
				 fis.close();
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		 }
		 return data;
		 
	 }
	 
	 /**
	  * 응답헤더 생성하기
	  * @param contentLength 응답내용 크기
	  * @param mimeType 마임타입
	  * @return 헤더내용 바이트 배열
	  */
	 private byte[] makeResponseHeader(int contentLength, String mimeType) {
		 
		 String header = "HTTP/1.1 200 OK\r\n"
				 		+ "Server: MyHttpServer 1.0\r\n"
				 		+ "Content-length: " + contentLength + "\r\n" 
				 		+ "Content-Type: " + mimeType + ";charset="
				 		+ this.encoding;
		 
		 return header.getBytes();
		 
	 }
	 
	 /**
	  * 에러페이지 생성
	  * @param out 출력스트림
	  * @param statusCode 상태코드
	  * @param errMsg 에러메세지
	  */
	 private void makeErrorPage(OutputStream out, int statusCode, String errMsg) {
		 String statusLine = "HTTP/1.1 " + statusCode + " " + errMsg;
		 
		 try {
			 out.write(statusLine.getBytes());
			 out.flush();
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 
	 public static void main(String[] args) {
		new MyHttpServer().start();
	}
}


