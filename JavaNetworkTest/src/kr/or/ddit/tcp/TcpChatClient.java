package kr.or.ddit.tcp;

import java.io.IOException;
import java.net.Socket;

public class TcpChatClient {
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("192.168.34.16", 7777);
			System.out.println("서버에 연결이 되었습니다.");
			
			Sender sender = new Sender(socket);
			sender.start();
			
			Receiver receiver = new Receiver(socket);
			receiver.start();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
