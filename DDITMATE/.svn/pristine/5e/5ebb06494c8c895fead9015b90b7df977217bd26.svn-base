<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%
	String memId = (String) session.getAttribute("memId");
	System.out.println("로그인 아이디: " + memId);
%>
<% 
	if(memId.equals("admin")){
%>	
	<%@include file="/manager/managerSide.jsp" %>
<%
	}else {
%>
	<%@include file="/memberSide.jsp" %>
<%
	}
%>
<%	List<MemberVO> managerList = (List<MemberVO>) request.getAttribute("mvlist");
 %>


<div class="container-lg py-5">
	<div class="container">
		<!--          <div class="row"> -->
		<div class="col-lg-6 mx-auto my-4 p-3">
			<form action="#" method="get">
				<div class="input-group py-3"></div>
			</form>
		</div>
	</div>
	<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////배너, 검색 끝 -->

	<!-- /////////////////////////////////////////////////게시판 테이블 시작///////////////////////////////////////////////////////////////////////////// -->


	<div class="row px-lg-3">
		<!--    검색창 아래 게시판 위 div         <div class="container mt-3"> -->
		<div class="card">

			<div class="card-header" style="text-align: center;">
				<h4>회원관리</h4>
			</div>

			<div class="card-body">
				<div class="container mt-3">
					<table class="table table-striped">

						<thead>
							<tr>
								<th style="background-color: #eeeeee; text-align: center;">아이디</th>
								<th style="background-color: #eeeeee; text-align: center;">이름</th>
								<th style="background-color: #eeeeee; text-align: center;">닉네임</th>
								<th style="background-color: #eeeeee; text-align: center;">이메일</th>
								<th style="background-color: #eeeeee; text-align: center;">생년월일</th>
								<th style="background-color: #eeeeee; text-align: center;">전화번호</th>
								<th style="background-color: #eeeeee; text-align: center;">수강시작일</th>
								<th style="background-color: #eeeeee; text-align: center;">회원삭제</th>
							</tr>
						</thead>

						<tbody>
<!-- 							<button class="btn btn-primary float-center btn-sm" type="submit" style="float: right;">회원삭제</button> -->
							<%
								int managerListSize = managerList.size();
							if (managerListSize > 0) {
								for (MemberVO mb : managerList) {
							%>
							<tr style="text-align: center;">
								<td><%=mb.getMemId()%></td>
								<td><%=mb.getMemName()%></td>
								<td><%=mb.getMemNick()%></td>
								<td><%=mb.getMemEmail()%></td>
								<td><%=mb.getMemBirth()%></td>
								<td><%=mb.getMemTel()%></td>
								<td><%=mb.getMemDate()%></td>
								<td><a href="<%=request.getContextPath()%>/manager/mngMemDelete.do?memId=<%=mb.getMemId() %>"><input type="button" class="btn btn-primary msg" value="삭제"></a></td>
							</tr>
							<%
								}
							}
							%>
						</tbody>
					</table>

				</div>
			</div>
			<div class="card-footer"></div>

		</div>
		<!-- class="card" -->
		<!--             </div> 검색창 아래 게시판 위 div-->
	</div>
</div>




<!-- End Content -->


<section class="container py-5"></section>


<script>
$('.msg').on('click',function(){
    let a = confirm("정말 삭제하시겠습니까?")
    if(a == true){
       return true;
    }
    else{
       return false;
    }
 });
</script>

<%@include file="/footer.jsp"%>