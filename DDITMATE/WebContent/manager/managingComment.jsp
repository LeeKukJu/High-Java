<%@page import="blame.vo.BlameVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>

<%List<BlameVO> blaList = (List<BlameVO>) request.getAttribute("blaList"); 
%>
<%	String memId = (String)session.getAttribute("memId"); 
	System.out.println("로그인 아이디: " + memId);
%>
<% 
	if(memId.equals("admin")){
%>
<%@include file="/manager/managerSide.jsp"%>
<%
	}else {
%>
<%@include file="/memberSide.jsp"%>
<%	
	}
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
				<h4>
					신고 댓글 관리
				</h4>
			</div>

			<div class="card-body">
				<div class="container mt-3">
					<table class="table table-striped">

						<thead>
							<tr>
								<th style="background-color: #eeeeee; text-align: center;">신고번호</th>
								<th style="background-color: #eeeeee; text-align: center;">카테고리번호</th>
								<th style="background-color: #eeeeee; text-align: center;">댓글번호</th>
								<th style="background-color: #eeeeee; text-align: center;">아이디</th>
								<th style="background-color: #eeeeee; text-align: center;">신고내용</th>
								<th style="background-color: #eeeeee; text-align: center;">신고일시</th>
								<th style="background-color: #eeeeee; text-align: center;">삭제</th>
							</tr>
						</thead>

						<tbody>
							<%
                             	int blameSize = blaList.size();
                             	if(blameSize > 0){
                         			int cnt = 0;
                             		for(BlameVO bv : blaList){	
                             			if(cnt == 0){
                             	%>
							<tr style="text-align: center;">
								<td style =' vertical-align : middle ' ><%=bv.getBlaNo()%></td>
								<td style =' vertical-align : middle ' ><%=bv.getCateCode()%></td>
								<td style =' vertical-align : middle ' ><%=bv.getMentNo()%></td>
								<td style =' vertical-align : middle ' ><%=bv.getMemId()%></td>
								<td style =' vertical-align : middle ' ><a href="/DDITMATE/board/viewBoard.do?boNo=<%=bv.getBoNo()%>&cateCode=<%=bv.getCateCode()%>"><%=bv.getBlaContents()%></a></td>
								<td style =' vertical-align : middle ' ><%=bv.getBlaDate()%></td>
								<td style =' vertical-align : middle ' >

									<form
										action="<%=request.getContextPath()%>/blame/mentDelete.do"
										method="POST" class="joinForm">
										<input type="hidden" name="boNo" value="<%=bv.getBoNo()%>">
										<input type="hidden" name="cateCode" value="<%=bv.getCateCode()%>">
										<input type="hidden" name="mentNo" value="<%=bv.getMentNo()%>">
										
										<button class="btn btn-primary">삭제</button>
									</form>
								</td>
							</tr>
							<%
                             			}else{
                              %>
							<tr style="text-align: center;">
								<td style =' vertical-align : middle ' ><%=bv.getBlaNo()%></td>
								<td style =' vertical-align : middle ' ><%=bv.getCateCode()%></td>
								<td style =' vertical-align : middle ' ><%=bv.getMentNo()%></td>
								<td style =' vertical-align : middle ' ><%=bv.getMemId()%></td>
								<td style =' vertical-align : middle ' ><a href="/DDITMATE/board/viewBoard.do?boNo=<%=bv.getBoNo()%>&cateCode=<%=bv.getCateCode()%>"><%=bv.getBlaContents()%></a></td>
								<td style =' vertical-align : middle ' ><%=bv.getBlaDate()%></td>
								<td style =' vertical-align : middle ' >
									<form
										action="<%=request.getContextPath()%>/blame/mentDelete.do"
										method="POST" class="joinForm">
										<input type="hidden" name="boNo" value="<%=bv.getBoNo()%>">
										<input type="hidden" name="cateCode" value="<%=bv.getCateCode()%>">
										<input type="hidden" name="mentNo" value="<%=bv.getMentNo()%>">
										
										<button class="btn btn-primary">삭제</button>
									</form>
									</td>
									</tr>
									<%
                             			}
                             			cnt++;
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


<%@include file="/footer.jsp"%>