package member.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;
import member.vo.PictureVO;

@WebServlet("/member/insert.do")
public class InsertMemberController extends HttpServlet {

	private static final String UPLOAD_DIR = "member_pic";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String saveDirectory = req.getServletContext().getRealPath("/") + File.separator + UPLOAD_DIR; // 저장할 디렉터리
		int maxPostSize = 1024 * 1000; // 파일 최대 크기(1MB)
		String encoding = "UTF-8"; // 인코딩 방식

		File uploadDir = new File(saveDirectory);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		System.out.println(saveDirectory);

		try {
			// 1. MultipartRequest 객체 생성 -> 저장
			MultipartRequest mr = new MultipartRequest(req, saveDirectory, maxPostSize, encoding);

			req.setCharacterEncoding("UTF-8");

			String memId = mr.getParameter("memId");
			String memPw = mr.getParameter("memPw");
			String memName = mr.getParameter("memName");
			String memEmail = mr.getParameter("memEmail");
			String memBirth = mr.getParameter("memBirth");
			String memTel = mr.getParameter("memTel");
			String memDate = mr.getParameter("memDate");
			String memNick = mr.getParameter("memNick");
			String memIntro = mr.getParameter("memIntro");

			// 아이디 중복 검사 만들어야댐 중복검사 버튼 or ajax로 만들까....?

			IMemberService memService = MemberServiceImpl.getInstance();

			MemberVO mv = new MemberVO();
			mv.setMemId(memId);
			mv.setMemPw(memPw);
			mv.setMemName(memName);
			mv.setMemEmail(memEmail);
			mv.setMemBirth(memBirth);
			mv.setMemTel(memTel);
			mv.setMemDate(memDate);
			mv.setMemNick(memNick);
			mv.setMemIntro(memIntro);
			
			int cnt = memService.registMember(mv);


			if (mr.getFilesystemName("memPic") != null) { // 첨부파일 있으면
				
				// 2. 새로운 파일명 생성
				String fileName = mr.getFilesystemName("memPic"); // 현재 파일 이름
				String ext = fileName.substring(fileName.lastIndexOf(".")); // 파일 확장자
				String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
				String newFileName = now + ext; // 새로운 파일 이름 ("업로드일시.확장자")

				// 3. 파일명 변경
				File oldFile = new File(saveDirectory + File.separator + fileName);
				File newFile = new File(saveDirectory + File.separator + newFileName);
				oldFile.renameTo(newFile);
				
				// 4. PictureVO 생성
				PictureVO pv = new PictureVO();
				pv.setMemId(memId);
				pv.setOrignlPic(fileName);
				pv.setSavePic(newFileName);

				// 5. PictureVO DB에 저장
				memService.registPicture(pv);
			}

			if (cnt > 0) {
				String msg = "회원가입 완료";
				String text = "로그인을 진행 해주세요.";
				String icon = "success";

				HttpSession session = req.getSession();
				session.setAttribute("msg", msg);
				session.setAttribute("text", text);
				session.setAttribute("icon", icon);

				resp.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
