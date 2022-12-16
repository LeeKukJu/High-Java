package homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImgFileCopy {
	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		// 버퍼 추가
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("D:/D_Other/filecopy/Tulips.jpg");
			fos = new FileOutputStream("d:/D_Other/filecopy/Tulips Copy2.jpg");
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int data = 0;
			
			while((data = bis.read()) != -1) {
//				fos.write(data);
				bos.write(data);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
