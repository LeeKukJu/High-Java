package member.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.vo.MemberVO;
import member.vo.PictureVO;

public class MemberServiceImpl implements IMemberService {

	private static final String UPLOAD_DIR = "member_pic";

	private IMemberDao memDao;

	private static IMemberService memService;

	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
	}

	public static IMemberService getInstance() {
		if (memService == null) {
			memService = new MemberServiceImpl();
		}

		return memService;
	}

	@Override
	public int registMember(MemberVO mv) {

		return memDao.insertMember(mv);
	}

	@Override
	public boolean checkMember(String memId) {
		return memDao.checkMember(memId);
	}

	@Override
	public int modifyMember(MemberVO mv) {
		return memDao.updateMember(mv);
	}

	@Override
	public int removeMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public int removeMemberPic(String memId) {
		return memDao.deleteMemberPic(memId);
	}

	@Override
	public List<MemberVO> listAllMember() {
		return memDao.printAllMember();
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {

		return memDao.searchMember(mv);
	}

	@Override
	public MemberVO getMember(String memId) {

		return memDao.getMember(memId);
	}

	@Override
	public int registPicture(PictureVO pv) {

		return memDao.insertPicture(pv);
	}

	@Override
	public PictureVO updatePicture(String memId, HttpServletRequest req) {

		// 업로드 파일 경로 설정
		String contextRoot = req.getSession().getServletContext().getRealPath("");
		String imgUploadPath = contextRoot + File.separator + UPLOAD_DIR;

		/* 폴더 존재 여부 확인 */
		File uploadDir = new File(imgUploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		/* 정보를 저장할 VO 미리 초기화 */
		PictureVO pictureVO = new PictureVO();

		try {
			/*
			 * request에 담긴 Part정보를 분리함.. 기본적으로 List로 불러오는 것 같음 Part에 담긴 만큼 for문을 돌림
			 */
			for (Part part : req.getParts()) {

				/* fileName 지정 */
				String fileName = getFileName(part);

				/* 파일 네임이 널이 아니거나 널이 아니라면 */
				if (fileName != null && !fileName.equals("")) {

					String orignlPic = fileName; // 원본파일명
					String savePic = ""; // 저장파일명
					String fileSavePath = ""; //
					
					// 확장자명 추출
					String fileExtsn = orignlPic.lastIndexOf(".") < 0 ? ""
							: orignlPic.substring(orignlPic.lastIndexOf("."));
					String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
					savePic = now + fileExtsn; // 새로운 파일 이름 ("업로드일시.확장자")


					fileSavePath = imgUploadPath + File.separator + savePic;

//					String picUrl = "/DDITMATE/member_pic/" + savePic;

					// 업로드 파일 저장하기
					part.write(fileSavePath);

					pictureVO.setMemId(memId);
					pictureVO.setOrignlPic(orignlPic);
					pictureVO.setSavePic(savePic);
					
					if(memDao.getPicture(memId) == null) {
						memDao.insertPicture(pictureVO);
					}else {
					
					// 파일 정보 DB에 수정하기
					memDao.updatePicture(pictureVO);
					}
					part.delete(); // 임시 업로드 파일 삭제

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("파일서비스 처리중 에러발생!", e);
		}

		return pictureVO;
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("Content-Disposition").split(";")) {

			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
			}
		}

		return null; // filename이 없는 경우(폼필드)
	}

	@Override
	public int updateProfile(Map<String, String> param) {
		
		return memDao.updateProfile(param);
	}

	@Override
	public PictureVO getPicture(String memId) {
		
		return memDao.getPicture(memId);
	}
}
