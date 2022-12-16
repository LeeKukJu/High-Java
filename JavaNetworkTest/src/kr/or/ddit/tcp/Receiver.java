package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 소켓으로부터 메세지를 받아서 콘솔에 출력하는 역할 담당.
 * 
 * @author PC-22
 */
public class Receiver extends Thread {

	private DataInputStream dis;

	public Receiver(Socket socket) {

		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(dis != null) {
			try {
				System.out.println(dis.readUTF());
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
