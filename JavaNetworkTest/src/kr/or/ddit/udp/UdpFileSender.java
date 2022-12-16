package kr.or.ddit.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpFileSender {
	private DatagramSocket ds;
	private DatagramPacket dp;

	private InetAddress receiverAddr;
	private int port; // 데이터 보낼 떄 사용할 포트번호
	private File file;

	public UdpFileSender(String receiveIp, int port) {
		try {
			ds = new DatagramSocket();
			this.port = port;
			receiverAddr = InetAddress.getByName(receiveIp);
			file = new File("d:/D_Other/chopa.jpg");

			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				System.exit(0);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		
		long fileSize = file.length();
		long totalReadBytes = 0;
		
		long startTime = System.currentTimeMillis();
		
		try {
			// 전송 시작을 알려주기 위한 문자열
			sendData("start".getBytes());
			
			// 파일명 전송
			sendData(file.getName().getBytes());
			
			// 총 파일 사이즈 정보 전송
			sendData(String.valueOf(fileSize).getBytes());
			
			FileInputStream fis = new FileInputStream(file);
			
			byte[] buffer = new byte[1000];
			
			while(true) {
				Thread.sleep(10); // 패킷 전송간의 간격을 주기 위해서...
				
				int readBytes = fis.read(buffer, 0 , buffer.length);
				
				if(readBytes == -1) { // 다 읽은 경우...
					break;
					
				}
				
				sendData(buffer, readBytes); // 파일내용 선존
				
				totalReadBytes += readBytes;
				System.out.println("진행 생태 : " + totalReadBytes + "/" 
						+ fileSize + " Byte(s) (" + (totalReadBytes * 100/fileSize) + " %)");
				
			}
			
			long endTime = System.currentTimeMillis();
			long diffTime = endTime - startTime;
			double transferSpeed = fileSize/diffTime;
			
			System.out.println("걸린 시간 : " + diffTime + " (ms)");
			System.out.println("평균 전송속도 : " + transferSpeed + " (Bytes/ms)");
			
			System.out.println("전송 완료...");
			
			fis.close();
			ds.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void sendData(byte[] data) throws IOException {
		sendData(data, data.length);
	}

	public void sendData(byte[] data, int length) throws IOException {
		dp = new DatagramPacket(data, length, receiverAddr, port);
		ds.send(dp);
	}
	
	public static void main(String[] args) {
		new UdpFileSender("192.168.34.49", 8888).start();
		
	}

}
