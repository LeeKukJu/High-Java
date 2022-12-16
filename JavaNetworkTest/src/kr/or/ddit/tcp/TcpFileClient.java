package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpFileClient {

	private Socket socket;
	private FileOutputStream fos;
	private DataInputStream dis;
	private DataOutputStream dos;
	private String fileName;

	public void clientStart() throws IOException {

//		File file = new File("d:/D_Other");

		socket = new Socket("192.168.34.16", 7777);

		// 소켓 접속이 성공하면 받고 싶은 파일명을 전송한다.
		dos = new DataOutputStream(socket.getOutputStream());
		fileName = "chopa.jpg";
		dos.writeUTF(fileName); // 받고 싶은 파일명 전송

		dis = new DataInputStream(socket.getInputStream());

		String resultMsg = dis.readUTF();

		if (resultMsg.equals("OK")) {

			fos = new FileOutputStream("d:/D_Other/" + fileName);
			System.out.println("파일 전송 완료...");
			
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			int data = 0;

			while ((data = bis.read()) != -1) {
				bos.write(data);
			}
			
			// close()
			bis.close();
			bos.close();
			dis.close();
			dos.close();
			socket.close();
			

		}

	}
	
	public static void main(String[] args) {
		
		try {
			new TcpFileClient().clientStart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
