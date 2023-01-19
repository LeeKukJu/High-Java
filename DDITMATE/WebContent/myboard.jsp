<%@page import="util.pagingUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>

<%
	String memId = (String) session.getAttribute("memId");
	System.out.println("로그인 아이디: " + memId);
	List<BoardVO> mbList = (List<BoardVO>) request.getAttribute("mbList");

%>
<%
	if (memId.equals("admin")) {
%>
<%@include file="/manager/managerSide.jsp"%>
<%
	} else {
%>
<%@include file="/memberSide.jsp"%>
<%
	}
%>

<div class="container-lg py-5" style="margin-top: 120px">
	


	<!-- 게시판 테이블 시작 -->

<div style="text-align: center; padding-bottom: 100px;">
			<h3>내가 쓴 게시글</h3>
		</div>
	<div class="row px-lg-3">
		<!--    검색창 아래 게시판 위 div  -->
		<div class="card">
			<div class="card-body">
				<div class="container mt-3">
					<table class="table table-striped">
						<thead>
							<tr>
								<th width="10%" style="background-color: #eeeeee; text-align: center;">카테고리</th>
								<th width="40%" style="background-color: #eeeeee; text-align: center;">제목</th>
								<th width="13%" style="background-color: #eeeeee; text-align: center;">작성자</th>
								<th width="6%" style="background-color: #eeeeee; text-align: center;">조회수</th>
<!-- 								<th width="6%" style="background-color: #eeeeee; text-align: center;">삭제</th> -->
							</tr>
						</thead>
						<tbody>
							<%
						   		int mbSize = mbList.size();
							if(mbSize > 0){
								for(int i = 0; i<mbSize; i++){
							
							%>
							<tr style="text-align: center;">
								<td><%=mbList.get(i).getCateName() %></td>
								<td><a href="<%=request.getContextPath()%>/board/viewBoard.do?boNo=<%=mbList.get(i).getBoNo()%>&cateCode=<%=mbList.get(i).getCateCode()%>&boClickNum=<%=mbList.get(i).getBoClickNum()%>"><%=mbList.get(i).getBoTitle()%></a></td>
								<td><%=mbList.get(i).getMemNick() %></td>
								<td><%=mbList.get(i).getBoClickNum() %></td>
<%-- 								<td><a href="<%=request.getContextPath()%>/myboard/deleteMyBoard.do?cateName=<%=mbList.get(i).getCateName() %>&boNo=<%=mbList.get(i).getBoNo() %>"><input type="button" class="btn btn-primary msg" value="삭제"></a></td> --%>
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
		<!--  </div> 검색창 아래 게시판 위 div-->
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
<%@include file="footer.jsp" %>
