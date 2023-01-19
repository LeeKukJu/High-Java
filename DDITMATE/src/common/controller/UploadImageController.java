package common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.FileVO;

@MultipartConfig
@WebServlet("/common/uploadImageFile.do")
public class UploadImageController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		FileVO fileVO = fileService.saveAtchFileList(req);
		
		resp.getWriter().write(fileVO.getFileUrl());
		
	}

}
