package kr.or.ddit.comm.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import kr.or.ddit.comm.dao.AtchFileDaoImpl;
import kr.or.ddit.comm.dao.IAtchFileDao;
import kr.or.ddit.comm.vo.AtchFileVO;

public class AtchFileServiceImpl implements IAtchFileService {
	
	private static IAtchFileService fileService;
	
	private IAtchFileDao fileDao;
	
	public AtchFileServiceImpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}
	
	public static IAtchFileService getInstance() {
		if(fileService == null) {
			fileService = new AtchFileServiceImpl();
		}
		return fileService;
	}

	@Override
	public AtchFileVO saveAtchFileList(HttpServletRequest req) {

		// 업로드 경로 설정하기
		String uploadPath = "D:/D_Other/upload_files";

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		AtchFileVO atchFileVO = null;
		
		try {
			boolean isFirstFile = true; // 첫번째 파일 여부
			
			for(Part part : req.getParts()) {
				
				String fileName = getFileName(part);
				
				if(fileName != null && !fileName.equals("")) {
					
					if(isFirstFile) {
						
						isFirstFile = false;
						
						// 파일 기본정보 저장하기
						atchFileVO = new AtchFileVO();
						
						fileDao.insertAtchFile(atchFileVO);
					}
					
					String orignFileName = fileName; // 원본파일명
					long fileSize = part.getSize(); // 파일 크기
					String saveFileName = ""; // 저장파일명
					String saveFilePath = "";
					
					saveFileName = UUID.randomUUID().toString().replaceAll("-", "");
					
					saveFilePath = uploadPath + File.separator + saveFileName;
					
					// 확장명 추출
					String fileExtension = orignFileName.lastIndexOf(".") < 0 ?
							"" : orignFileName.substring(
									orignFileName.lastIndexOf(".")+1);
					
					// 업로드 파일 저장하기
					part.write(saveFilePath);
					
					atchFileVO.setFileStreCours(saveFilePath);
					atchFileVO.setStreFileNm(saveFileName);
					atchFileVO.setOrignlFileNm(orignFileName);
					atchFileVO.setFileExtsn(fileExtension);
					atchFileVO.setFileSize(fileSize);
					
					// 파일 세부정보 저장하기
					fileDao.insertAtchFileDetail(atchFileVO);
					
					part.delete(); // 임시 업로드 파일 삭제하기
					
				}
				
				
			}
		} catch (Exception e) {
//			e.printStackTrace();
			throw new RuntimeException("파일서비스 처리 중 에러발생!", e);
		}

		
		return atchFileVO;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) {
		
		return fileDao.getAtchFIleList(atchFileVO);
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {

		return fileDao.getAtchFileDetail(atchFileVO);	
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
		
		2. multipart 바디를 위한 헤더 정보로 사용되는 경우... ex) 파일 업로드
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
