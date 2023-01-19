<%@page import="room.vo.RoomVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="util.pagingUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>

<%
String memId = (String) session.getAttribute("memId");
System.out.println("로그인 아이디: " + memId);
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
<%--
	Map<String, Object> paging = (HashMap<String, Object>) request.getAttribute("paging");
int pageNum = (Integer) paging.get("pageNum");
int totalPage = (Integer) paging.get("totalPage");
int perPage = pagingUtil.PER_PAGE; // 페이지 이동블럭 5개
int perList = pagingUtil.PER_LIST; // 게시물 10개
int pageTemp = (((pageNum - 1) / perPage) * perPage) + 1;
int totalCount = (Integer) paging.get("totalCount");
--%>
<%
List<RoomVO> myRoomList = (List<RoomVO>) request.getAttribute("myRoomList");
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
				<h4>스터디 목록</h4>
				
			</div>

			<div class="card-body">
				<div class="container mt-3">
					<table class="table table-striped">
						<thead>
							<tr>
								<th width="5%" style="background-color: #eeeeee; text-align: center;">번호</th>
								<th width="50%" style="background-color: #eeeeee; text-align: center;">그룹명</th>
								<th width="10%" style="background-color: #eeeeee; text-align: center;">개설일</th>
								<th width="10%" style="background-color: #eeeeee; text-align: center;">권한</th>
								<th width="10%" style="background-color: #eeeeee; text-align: center;">참석 코드</th>
								<th width="15%" style="background-color: #eeeeee; text-align: center;">관리</th>
							</tr>
						</thead>
						<tbody>
							<%
							int myRoomSize = myRoomList.size();
							if(myRoomSize > 0){
								int roomNo = 1;
								for (RoomVO rv : myRoomList){
							%>
							<tr style="text-align: center;">
								
									<td><%=roomNo%></td>
									<td><a href="selectRoom.do?roomCode=<%=rv.getRoomCode()%>&roomTitle=<%=rv.getRoomTitle()%>&roomMaster=<%=rv.getRoomMaster()%>"><%=rv.getRoomTitle()%></a></td>
									<td><%=rv.getRoomDate()%></td>
									<td>
									<%if(rv.getRoomMaster() == 0){
									%>
									모임장
									<%
									}else{
									%>
									모임원
									<%	
									}
									%>
									</td>
									<td>
									<%if(rv.getRoomMaster() == 0){ //모임장이면
									%>
									<%=rv.getRoomCode() %>
									<%
									}else{
									%>
									--------
									<%	
									}
									%>
									</td>
									<td>
										<a href="deletRoom.do?roomCode=<%=rv.getRoomCode()%>&roomMaster=<%=rv.getRoomMaster()%>"><button class="msg btn btn-primary float-center btn-sm" type="button">나가기</button></a>
									</td>
								
							</tr>
							<%		
							roomNo++;
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



</div>
</div>
<!-- End Content -->


<section class="container py-5"></section>

<script>
$('.msg').on('click',function(){
    let modifyBo = confirm("나가시겠습니까?")
    if(modifyBo == true){
       return true;
    }
    else{
       return false;
    }

});

</script>

<%@include file="/footer.jsp"%>