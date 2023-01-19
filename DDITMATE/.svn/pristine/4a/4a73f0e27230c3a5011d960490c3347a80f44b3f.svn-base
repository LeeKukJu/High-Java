<%@page import="member.vo.PictureVO"%>
<%@page import="member.vo.MemberVO"%>
<%@page import="member.service.MemberServiceImpl"%>
<%@page import="member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	String memId1 = (String) session.getAttribute("memId");

	IMemberService memService = MemberServiceImpl.getInstance();
	MemberVO mv1 = new MemberVO();
	mv1 = memService.getMember(memId1);

	PictureVO pv1 = new PictureVO();
	pv1 = memService.getPicture(memId1);

	request.setAttribute("mv1", mv1);
	request.setAttribute("pv1", pv1);
%>