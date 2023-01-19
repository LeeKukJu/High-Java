<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<div id="work_banner" class="banner-wrapper bg-light w-100 py-5">
	<div class="banner-vertical-center-work container text-light d-flex justify-content-center align-items-center py-5 p-0">
		<div class="banner-content col-lg-8 col-12 m-lg-auto text-center">
			<h1 class="banner-heading h2 display-3 pb-5 semi-bold-600">
			<%
			if(request.getParameter("cateCode").contains("s")){
			%>
			스터디/프로젝트 모집 게시판
			<%	
			}else if(request.getParameter("cateCode").contains("q")){
			%>
			질문 게시판
			<%	
			}else if(request.getParameter("cateCode").contains("n")){
			%>
			공지사항
			<%
			}else if(request.getParameter("cateCode").contains("j")){
			%>
			취업 정보 게시판
			<%	
			}else if(request.getParameter("cateCode").contains("f")){
			%>
			자유 게시판
			<%	
			}
			%>
			</h1>
		</div>
	</div>
</div>