package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpReceiver {
	private DatagramSocket ds;
	private DatagramPacket dp;
	
	private byte[] msg; // 데이터가 저장될 byte배열 변수 선언
	
	public UdpReceiver() {
		try {
			msg = new byte[100];
			// 소켓생성(포트번호 명시하지 않으면 임의의 포트번호 할당됨.) 
			ds = new DatagramSocket();
		}catch(SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			InetAddress serverAddr = InetAddress.getByName("192.168.34.16");
			
			dp = new DatagramPacket(msg, 1, serverAddr, 8888);
			ds.send(dp); // 패킷 전송
			
			dp = new DatagramPacket(msg,  msg.length);
			ds.receive(dp); // 패킷 수신
			
			System.out.println("현재 서버 시간 => " + new String(dp.getData()));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new UdpReceiver().start();
	}
}
