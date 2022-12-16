package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 소켓을 통해서 메세지를 보내는 역할 담당.
 * 
 * @author PC-22
 */
public class Sender extends Thread {
	private Scanner scan;
	private String name;
	private DataOutputStream dos;

	public Sender(Socket socket) {

		name = "[" + socket.getInetAddress() + ":" + socket.getLocalPort() + "]";

		scan = new Scanner(System.in);

		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (dos != null) {
			try {
				dos.writeUTF(name + " >>> " + scan.nextLine());
				System.out.println("메세지 전송 완료");
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
