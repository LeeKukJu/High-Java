package common.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import common.dao.AtchFileDaoImpl;
import common.dao.IAtchFileDao;
import common.vo.FileVO;

public class AtchFileServiceImpl implements IAtchFileService {
	
	private static final String UPLOAD_DIR = "uploadImg";
	private static IAtchFileService fileService;
	private IAtchFileDao fileDao;

	public AtchFileServiceImpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}

	public static IAtchFileService getInstance() {
		if (fileService == null) {
			fileService = new AtchFileServiceImpl();
		}
		return fileService;
	}

	@Override
	public FileVO saveAtchFileList(HttpServletRequest req) {
		
		//업로드 파일 경로 설정
		String contextRoot = req.getSession().getServletContext().getRealPath("");
		String imgUploadPath = contextRoot + File.separator + UPLOAD_DIR;
		
		/*폴더 존재 여부 확인*/
		File uploadDir = new File(imgUploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		/*정보를 저장할 VO 미리 초기화*/
		FileVO fileVO = new FileVO();
		
		try {
			/*request에 담긴 Part정보를 분리함.. 기본적으로 List로 불러오는 것 같음
			* Part에 담긴 만큼 for문을 돌림*/
			for(Part part : req.getParts()) {
				
				/*fileName 지정*/
				String fileName = getFileName(part);
				
				/*파일 네임이 널이 아니거나 널이 아니라면*/
				if(fileName != null && !fileName.equals("")) {
					
					String fileOrignName = fileName; //원본파일명
					String fileSaveName = ""; //저장파일명
					String fileSavePath = ""; //
					
					fileSaveName = UUID.randomUUID().toString().replaceAll("-", "");
					
					// 확장자명 추출
					String fileExtsn = 
							fileOrignName.lastIndexOf(".") < 0 ?
									"" : fileOrignName.substring(
											fileOrignName.lastIndexOf("."));
					
					fileSavePath = imgUploadPath + File.separator + fileSaveName + fileExtsn;
					
					String fileUrl = "/DDITMATE/uploadImg/" + fileSaveName + fileExtsn;
					
					// 업로드 파일 저장하기
					part.write(fileSavePath);
					
					fileVO.setFileSavePath(fileSavePath);
					fileVO.setFileSaveName(fileSaveName);
					fileVO.setFileOrignName(fileOrignName);
					fileVO.setFileExtsn(fileExtsn);
					fileVO.setFileUrl(fileUrl);
					
					// 파일 정보 DB에 저장하기
					fileDao.insertAtchFile(fileVO);
					
					part.delete(); // 임시 업로드 파일 삭제
					
				}
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("파일서비스 처리중 에러발생!", e);
		}
		
		return fileVO;
	}
	
	private String getFileName(Part part) {
		for(String content:
				part.getHeader("Content-Disposition").split(";")) {
			
			if(content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 1)
									 .trim().replace("\"", "");
			}
		}
		
		return null; // filename이 없는 경우(폼필드)
	}
}
