<%@page import="room.vo.RoomBoardVO"%>
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

<%
Map<String, Object> paging = (HashMap<String, Object>) request.getAttribute("paging");
int pageNum = (Integer) paging.get("pageNum");
int totalPage = (Integer) paging.get("totalPage");
int perPage = pagingUtil.PER_PAGE; // 페이지 이동블럭 5개
int perList = pagingUtil.PER_LIST; // 게시물 10개
int pageTemp = (((pageNum - 1) / perPage) * perPage) + 1;
int totalCount = (Integer) paging.get("totalCount");

List<RoomBoardVO> roomBoardList = (List<RoomBoardVO>) request.getAttribute("roomBoardList");

String cateCode = request.getParameter("cateCode");
String searchWord = (String) paging.get("searchWord");
String roomCode = request.getParameter("roomCode");
int roomMaster = Integer.parseInt((String.valueOf(request.getAttribute("roomMaster"))));

System.out.println("jsp로 넘어온 카테고리 코드: " + cateCode);
System.out.println("jsp로 넘어온 페이지 번호: " + pageNum);
System.out.println("jsp로 넘어온 검색단어: " + searchWord);
System.out.println("jsp로 넘어온 방코드: " + roomCode);
System.out.println("jsp로 넘어온 관리자여부: " + roomMaster);

%>

<!-- 검색바 -->
<div class="container-lg py-5">
	<div class="container">
		<!--          <div class="row"> -->
		<div class="col-lg-6 mx-auto my-4 p-3">
			<form action="roomBoard.do" method="post">
				<div class="input-group py-3">
					
					<input type="hidden" name="roomMaster" value="<%=roomMaster%>"> 
					<input type="hidden" name="cateCode" value="<%=cateCode%>"> 
					<input type="hidden" name="roomCode" value="<%=roomCode%>">
					<input name="searchWord" type="text" class="form-control form-control-lg rounded-pill rounded-end" required placeholder="검색할 내용을 입력하세요">
					<button class="btn btn-secondary text-white btn-lg rounded-pill rounded-start px-lg-4" type="submit">검색</button>
				</div>
			</form>
		</div>
	</div>

	<!-- 게시판 테이블 시작 -->


	<div class="row px-lg-3">
		<!--    검색창 아래 게시판 위 div  -->
		<div class="card">
			<div class="card-header">
				<a class="btn btn-primary float-start" href="selectRoom.do?roomCode=<%=roomCode%>&roomMaster=<%=roomMaster%>" >
					모임 홈으로 이동
				</a>

				<a class="btn btn-primary float-end" href="<%=application.getContextPath()%>/room/roomBoardWrite.jsp?cateCode=<%=cateCode%>&roomCode=<%=roomCode%>&roomMaster=<%=roomMaster%>">
					<i class="fas fa-edit"></i>
					글쓰기
				</a>
			</div>
			<div class="card-body">
				<div class="container mt-3">
					<table class="table table-striped">
						<thead>
							<tr>
								<th width="5%" style="background-color: #eeeeee; text-align: center;">번호</th>
								<th width="20%" style="background-color: #eeeeee; text-align: center;">카테고리</th>
								<th width="40%" style="background-color: #eeeeee; text-align: center;">제목</th>
								<th width="10%" style="background-color: #eeeeee; text-align: center;">작성자</th>
								<th width="13%" style="background-color: #eeeeee; text-align: center;">작성일</th>
								<th width="6%" style="background-color: #eeeeee; text-align: center;">조회수</th>
								<th width="6%" style="background-color: #eeeeee; text-align: center;">추천수</th>
							</tr>
						</thead>
						<tbody>
							<%
								int roomBoardSize = roomBoardList.size();
							if (roomBoardSize > 0) { //게시물 있으면
								int virtualNum = 0;
								int countNum = 0;

								for (RoomBoardVO rbv : roomBoardList) {
									virtualNum = totalCount - (((pageNum - 1) * perList) + countNum++);
							%>
							<tr style="text-align: center;">
								<td><%=virtualNum%></td>
								<td>모임방</td>
								<td>
									<a href="viewRoomBoard.do?boNo=<%=rbv.getBoNo()%>&cateCode=<%=rbv.getCateCode()%>&boClickNum=<%=rbv.getBoClickNum()%>&roomCode=<%=roomCode%>&roomMaster=<%=roomMaster%>"><%=rbv.getBoTitle()%></a>
								</td>
								<td><%=rbv.getMemName()%></td>
								<td><%=rbv.getBoWriteDate()%></td>
								<td><%=rbv.getBoClickNum()%></td>
								<td><%=rbv.getBoLikeNum()%></td>
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
		<div id="pageList" class="float-center" style="display: flex; justify-content: center; margin-top: 25px;">
			<ul style="float: left;">
				<li>
					<a href="roomBoard.do?pageNum=1&cateCode=<%=paging.get("cateCode")%>&roomCode=<%=roomCode%>&roomMaster=<%=roomMaster%>" id="previous" style="margin: 10px;">[첫 페이지]</a>
					&nbsp;
					<%
						int pageTempLeft;
					if (pageNum > 1) {
						pageTempLeft = pageNum - 1;

					} else {
						pageTempLeft = pageNum;
					}
					if (pageNum != 1) {
					%>
					<a href="roomBoard.do?pageNum=<%=pageTempLeft%>&cateCode=<%=paging.get("cateCode")%>&roomCode=<%=roomCode%>&roomMaster=<%=roomMaster%>" id="previous" style="margin: 10px;"><</a>
				</li>
				<%
					} else {
				%>
				<a id="previous" style="margin: 10px;"><</a>
				</li>
				<%
					}
				%>

			</ul>

			<ul class="pagination pager">
				<%
					// 페이지 번호 출력
				int pageCount = 1;
				while (pageCount <= perPage && pageTemp <= totalPage) {
					if (pageTemp == pageNum) {
						// 현재 페이지는 링크를 걸지 않음
				%>
				<li class="active">
					<a style="margin: 10px;"><%=pageTemp%></a>
				</li>
				<%
					} else {
				%>
				<li class="active">
					<a href="roomBoard.do?pageNum=<%=pageTemp%>&cateCode=<%=paging.get("cateCode")%>&roomCode=<%=roomCode%>&roomMaster=<%=roomMaster%>
               <%if (searchWord != null) {%>
               &searchWord=<%=searchWord%>
               <%}%>
               
               " style="margin: 10px;"><%=pageTemp%></a>
				</li>
				<%
					}
				pageTemp++;
				pageCount++;
				}
				%>
			</ul>
			<ul style="float: left;">
				<%
					int pageTempRight;
				if (pageNum <= totalPage) {
					pageTempRight = pageNum + 1;

				} else {
					pageTempRight = pageNum;
				}
				if (pageNum != totalPage) {
				%>
				<li>
					<a href="roomBoard.do?pageNum=<%=pageTempRight%>&cateCode=<%=paging.get("cateCode")%>&roomCode=<%=roomCode%>&roomMaster=<%=roomMaster%>" id="previous" style="margin: 10px;">></a>
					&nbsp;
					<%
						} else {
					%>
				
				<li>
					<a id="previous" style="margin: 10px;">></a>
					&nbsp;
					<%
						}
					%>
					<a href="roomBoard.do?pageNum=<%=totalPage%>&cateCode=<%=paging.get("cateCode")%>&roomCode=<%=roomCode%>&roomMaster=<%=roomMaster%>" id="previous" style="margin: 10px;">[마지막 페이지]</a>
				</li>
			</ul>
		</div>
		<!--  </div> 검색창 아래 게시판 위 div-->
	</div>
</div>


</div>
</div>

<!-- Modal -->
<!-- <form action="../room/insertRoom.do" method="post"> -->
<!-- 	<div class="modal fade" id="groupCreate" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"> -->
<!-- 		<div class="modal-dialog"> -->
<!-- 			<div class="modal-content"> -->
<!-- 				<div class="modal-header"> -->
<!-- 					<h5 class="modal-title" id="staticBackdropLabel">그룹 생성</h5> -->
<!-- 				</div> -->
<!-- 				<div class="modal-body"> -->
<!-- 					<div class="input-group mb-3"> -->
<!-- 						<span class="input-group-text" id="inputGroup-sizing-default">그룹 제목</span>  -->
<!-- 						<input type="text" class="form-control" name="roomTitle" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="modal-footer"> -->
<!-- 					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button> -->
<!-- 					<button type="submit" class="btn btn-primary">확인</button> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </form> -->

<!-- End Content -->

<section class="container py-5"></section>

<!-- Start Footer -->
<%@include file="/footer.jsp"%>

<!-- End Footer -->

<!-- Bootstrap -->
<script src="<%=application.getContextPath()%>/assets/js/bootstrap.bundle.min.js"></script>
<!-- Templatemo -->
<script src="<%=application.getContextPath()%>/assets/js/templatemo.js"></script>
<!-- Custom -->
<script src="<%=application.getContextPath()%>/assets/js/custom.js"></script>
<script src="<%=application.getContextPath()%>/assets/js/sidemain.js"></script>


</body>

</html>