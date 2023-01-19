<%@page import="member.vo.PictureVO"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>

<%
	String memId = (String)session.getAttribute("memId");
	System.out.println("로그인 아이디: " + memId);
	MemberVO mv = (MemberVO) request.getAttribute("mv");
	PictureVO pv = (PictureVO) request.getAttribute("pv");
	
// 	String msg = session.getAttribute("msg")== null ? "" :(String)session.getAttribute("msg");
	
// 	session.removeAttribute("msg");
	
%>
<% 
	if(memId.equals("admin")){
%>		
	<%@include file="/manager/managerSide.jsp" %>
<%
	}else {
%>
	<%@include file="memberSide.jsp" %>
<%	
	}
%>



<!-- 회원정보조회 폼 시작 -->
<form action="./memCheck.do" method="get" class="memCheckForm" enctype="multipart/form-data">
    <section style="padding-bottom: 40px;">
        <div id="ddnavi" style="padding-top: 5%;">
            <h3 id="m1" style="text-align: center;">회원정보조회</h3>
        </div>
    </section>
    <section>

        <div class="container mt-3">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <!-- <th style="background-color: #615858;"></th> -->
                    </tr>
                </thead>
                <tbody>
					<tr>
						<td class="w-25 p-3" style="background-color: #eee; vertical-align: middle;">회원아이디</td>
						<td style="margin: 0; padding: 0;">
							<div style="display: flex; align-content: center;">
								<div style="float:left; width: 80%; display: flex; align-content: center; ">
									<input type="text" readonly class="form-control-plaintext"
										value="<%=mv.getMemId() %>" aria-label="Disabled input example" style="width: 500px; ">
								</div>
								
								<div style="float:left;">
								<%if(pv == null){
								%>
								<img src="https://bootdey.com/img/Content/avatar/avatar7.png" class="avatar img-circle img-thumbnail" alt="avatar"
								style="width: 128px; height: 128px;">
								<%
								}else{
								%>
								<img src="/DDITMATE/member_pic/<%=pv.getSavePic() %>" class="avatar img-circle img-thumbnail" alt="프로필사진" 
								style="width: 128px; height: 128px;">
								<%
								}
								%>
<!-- 									<img src="/DDITMATE/assets/img/변백현.jpg" alt="프로필사진" -->
<!-- 										style="width: 128px; height: 128px;"> -->
								</div>
							</div>	

						</td>
					</tr>

					<tr>
                        <td class="w-25 p-3" style="background-color:#eee;">이름</td>
                        <td>
                                <input type="text" readonly class="form-control-plaintext" value="<%=mv.getMemName() %>" aria-label="Disabled input example" style="width: 500px;"> 
                        </td>
                    </tr>
                    
					<tr>
                        <td class="w-25 p-3" style="background-color:#eee;">생년월일</td>
                        <td>
                                <input type="text" readonly class="form-control-plaintext" value="<%=mv.getMemBirth() %>" aria-label="Disabled input example" style="width: 500px;"> 
                        </td>
                    </tr>
                    
                    <tr>
                        <td class="w-25 p-3" style="background-color:#eee;">닉네임</td>
                        <td>
                                <input type="text" readonly class="form-control-plaintext" value="<%=mv.getMemNick() %>" aria-label="Disabled input example" style="width: 500px;"> 
                        </td>
                    </tr>
                    
                    <tr>
                        <td class="w-25 p-3" style="background-color:#eee;">이메일</td>
                        <td>
                                <input type="text" readonly class="form-control-plaintext" value="<%=mv.getMemEmail() %>" aria-label="Disabled input example" style="width: 500px;"> 
                        </td>
                    </tr>
                    
                    <tr>
                        <td class="w-25 p-3" style="background-color:#eee;">전화번호</td>
                        <td>
                                <input type="text" readonly class="form-control-plaintext" value="<%=mv.getMemTel() %>" aria-label="Disabled input example" style="width: 500px;"> 
                        </td>
                    </tr>
                    
                    <tr>
                        <td class="w-25 p-3" style="background-color:#eee;">개강일</td>
                        <td>
                                <input type="text" readonly class="form-control-plaintext" value="<%=mv.getMemDate() %>" aria-label="Disabled input example" style="width: 500px;"> 
                        </td>
                    </tr>
                    
                    <tr>
                        <td class="w-25 p-3" style="background-color:#eee;">소개글</td>
                        <td>
                        
 						<%
                        	if(mv.getMemIntro()==null){
                        %>
                        	<input type="hidden" readonly class="form-control-plaintext" value="<%=mv.getMemIntro() %>" aria-label="Disabled input example" style="width: 500px;">
                        <%
                        	}else{
                        %>
                            <input type="text" readonly class="form-control-plaintext" value="<%=mv.getMemIntro() %>" aria-label="Disabled input example" style="width: 500px;">
                        <%
                        	}
                        %> 
                        </td>
                    </tr>
                </tbody>
            </table>

            <div>
                <div class="col text-center">
                <a href="/DDITMATE/main.jsp">
                    <button type="button" class="btn btn-outline-primary">뒤로가기</button>
                </a>
                <a href="<%=request.getContextPath()%>/member/updateProfile.do" class="collapse__sublink">
                    <button type="button" class="btn btn-primary">프로필수정</button>
                </a>
                <a href="<%=request.getContextPath()%>/member/memChange.do">
                    <button type="button" class="btn btn-primary">회원정보수정</button>
                </a>
                </div>
            </div>
        </div>
    </section>
</form>

<%-- <%if(msg.equals("성공")){ %> --%>
<!-- <script> -->
<!--  	alert('회원정보가 수정되었습니다'); -->
<!-- </script> -->
<%-- <%} %> --%>
<script src="<%=application.getContextPath()%>/assets/js/sidemain.js"></script>
