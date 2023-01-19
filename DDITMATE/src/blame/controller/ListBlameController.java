package blame.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blame.service.BlameServiceImpl;
import blame.service.IBlameService;
import blame.vo.BlameVO;

@WebServlet("/blame/blame.do")
public class ListBlameController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		IBlameService blaService = BlameServiceImpl.getInstance();
		
		//blaCate값이 bb1이면..
		String blaCate = "bb1";
		
		List<BlameVO> blaList = blaService.listAllBlame(blaCate);
		
		req.setAttribute("blaList", blaList);
		req.getRequestDispatcher("/manager/managingPost.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
