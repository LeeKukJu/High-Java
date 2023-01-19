package member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;
import member.vo.PictureVO;

@MultipartConfig
@WebServlet("/member/updateProfile.do")
public class UpdateProfileController extends HttpServlet {

	private static final String UPLOAD_DIR = "member_pic";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		//파라미터 정보 가져오기
		String memId = (String) session.getAttribute("memId");

		//서비스 객체 생성
		IMemberService memService = MemberServiceImpl.getInstance();

		MemberVO mv = new MemberVO();

		mv = memService.getMember(memId);
		
		PictureVO pv = new PictureVO();
		pv = memService.getPicture(memId);

		req.setAttribute("mv", mv);
		req.setAttribute("pv", pv);

		req.getRequestDispatcher("/updateProfile.jsp").forward(req, resp);

	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		//파라미터 정보 가져오기
		String memId = (String) session.getAttribute("memId");
		String memNick = req.getParameter("memNick");
		String memIntro = req.getParameter("memIntro");
		
		Map<String, String> param = new HashMap<>();
		param.put("memId", memId);
		param.put("memNick", memNick);
		param.put("memIntro", memIntro);
		
		//서비스 객체 생성
		IMemberService memService = MemberServiceImpl.getInstance();

		MemberVO mv = new MemberVO();
		
		// 닉네임,소개글 수정
		memService.updateProfile(param);
		
		mv = memService.getMember(memId);
		
		PictureVO pv = new PictureVO();
		
		pv = memService.updatePicture(memId, req);
		
		System.out.println("orignlPic: " + pv.getOrignlPic());
		System.out.println("savePic: " + pv.getSavePic());
		
		req.setAttribute("mv", mv);
		req.setAttribute("pv", pv);

		req.getRequestDispatcher("/updateProfile.jsp").forward(req, resp);
	}

}
