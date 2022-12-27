package kr.or.ddit.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 서블릿 3부터 지원하는 Part인터페이스를 이용한 파일 업로드 예제
 * 
 * @author PC-22
 */
@WebServlet("/upload2.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 3, maxFileSize = 1024 * 1024 * 40, maxRequestSize = 1024 * 1024 * 50)
public class UploadServlet2 extends HttpServlet {
	
	private static final String UPLOAD_DIR = "upload_files";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Multipart Parsing전에 파라미터 정보 조회해 보기
		System.out.println("Multipart Parsing전 => " + req.getParameter("sender"));

		// 웹애플리케이션 루트 디렉토리 기준 업로드 경로 설정하기
		String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIR;

		System.out.println("uploadPath => " + uploadPath);

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			String fileName = "";
			
			for(Part part : req.getParts()) {
				
				System.out.println("Content-Disposition => " + part.getHeader("Content-Disposition"));
				
				fileName = getFileName(part);
				
				if(fileName != null && !fileName.equals("")) {
					part.write(uploadPath + File.separator + fileName); // 업로드(저장)
					
					System.out.println("파일 저장경로 : " + uploadPath + File.separator + fileName);
					
				}
				
			}
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Part 객체 파싱하여 파일이름 추출하기
	 * @param part
	 * @return 파일명(존재하지 않으면 null 리턴함)
	 */
	private String getFileName(Part part) {
		
	/*
		Content-Disposition 헤더에 대하여...
		
		1. 응답 헤더에 사용되는 경우... ex)파일 다운로드
			Content-Disposition: inline(default)
			Content-Disposition: attachment // 파일 다운로드
			Content-Disposition: attachment; filename="a.jpg"
			
		/////////////////////////////////////////////////////
		
		2. multipart 바디를 위한 헤더 정ㅂ로 사용되는 경우... ex) 파일 업로드
			Content-Disposition: form-data
			Content-Disposition: form-data; name="필드명"
			Content-Disposition: form-data; name="필드명"; filename="a.jpg"
	 */
		for(String content: part.getHeader("Content-Disposition").split(";")) {
			
			if(content.trim().startsWith("filename")) {
				
				return content.substring(content.indexOf("=") + 1)
						.trim().replace("\"", "");
			}
		}
		
		return null; // filename이 없는 경우(폼필드)
	}

}
