<%-- <%@page import="board.vo.BoardVO"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%@include file="/memberSide.jsp" %>

      <div id="work_banner" class="banner-wrapper bg-light w-100 py-5">
         <div class="banner-vertical-center-work container text-light d-flex justify-content-center align-items-center py-5 p-0">
            <div class="banner-content col-lg-8 col-12 m-lg-auto text-center">
               <h1 class="banner-heading h2 display-3 pb-5 semi-bold-600 typo-space-line-center">이곳은 게시판 배너 입니다</h1>
            </div>
         </div>
      </div>

      <div class="container-lg py-5">
         <div class="container">
            <!--          <div class="row"> -->
            <div class="col-lg-6 mx-auto my-4 p-3">
               <form action="#" method="get">
                  <div class="input-group py-3">

                     <input type="text" class="form-control form-control-lg rounded-pill rounded-end" 
                        placeholder="검색할 내용을 입력하세요">
                     <button class="btn btn-secondary text-white btn-lg rounded-pill rounded-start px-lg-4" type="submit"
                     style="z-index:5">
						검색
					 </button>
                  </div>
               </form>
            </div>
         </div>
<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////배너, 검색 끝 -->

<!-- /////////////////////////////////////////////////게시판 테이블 시작///////////////////////////////////////////////////////////////////////////// -->


         <div class="row px-lg-3">
<!--    검색창 아래 게시판 위 div         <div class="container mt-3"> -->
               <div class="card">
               
                  <div class="card-header">
                     	<a class="btn btn-primary float-start" href="#">
                     	<!-- 그룹 생성 버튼을 누르면 알러트 창으로 그룹코드가 전송되었습니다. 뜨고 쪽지함으로 코드가 전송됨 -->
							그룹생성
                     	</a>

                     	<a class="btn btn-primary float" style="margin-left:15px" id="btnOpen">
                     	<!-- 그룹참가 버튼을 누르면 모달창으로 코드를 입력하는 화면이 뜨고 코드가 일치하는 경우 그룹 페이지로 이동, 일치하지 않으면 일치하지 않는다는 문구가 뜸 -->
							그룹참가
                    	</a>
                    	<div id='modal' style="z-index : 1; background-color: rgba(0,0,0,.3); position:fixed; left:0;
										top: 0; width:100%; height:100%; display : none;">
							<div id='content' style="border-radius: 11px; width:400px; margin:500px auto; padding:20px;
											   position: relative; background-color:#fff;">
								<input type='button' value='X' class="close" id='btnClose'
									style="position:absolute; top:4px; right:4px; font-size:20px; border:0;
    										background-color: #fff;"/>
								<label>그룹 참가 코드를 입력하세요</label><br/>
								<input type='password' id='pwd' value='1234' style="width:270px"/>
								<input type='button' class="btn btn-primary" value='제출' id='btnCheck' style="margin-left:20px;" />
							</div>
						</div>

                     	<a class="btn btn-primary float-end" href="/middle/boardWrite.jsp">
                     		<i class="fas fa-edit"></i>
							글쓰기
                     	</a>
                  </div>
                  
                  <div class="card-body">
                     <div class="container mt-3">
                        <table class="table table-striped">
                           <thead>
                              <tr>
                                 <th style="background-color: #eeeeee; text-align: center;">번호</th>
                                 <th style="background-color: #eeeeee; text-align: center;">제목</th>
                                 <th style="background-color: #eeeeee; text-align: center;">작성자</th>
                                 <th style="background-color: #eeeeee; text-align: center;">작성일</th>
                                 <th style="background-color: #eeeeee; text-align: center;">조회수</th>
                                 <th style="background-color: #eeeeee; text-align: center;">추천수</th>
                              </tr>
                           </thead>
                           
                           <tbody>
<%--                            	<% --%>
<!-- // 								List<BoardVO> list = (List<BoardVO>)request.getAttribute("list"); -->
<!-- // 								if(list != null){ -->
<!-- // 								//목록정보 있을 때 -->
<!-- // 								for(int i=0; i<list.size(); i++){ -->
<%-- 							%> --%>
<!--                               <tr style="text-align: center;"> -->
<%--                                  <td><%=list.get(i).getboNo() %></td> --%>
<!--                                  <td> -->
<%-- 									<a data-toggle="collapse" href="#collapse<%=i%>"><%=list.get(i).getBoTitle() %></a> --%>
<!-- 								</td> -->
<%--                                  <td><%=list.get(i).getMemId() %></td> --%>
<%--                                  <td><%=list.get(i).getBoWriteDate() %></td> --%>
<%--                                  <td><%=list.get(i).getBoClickNum() %></td> --%>
<%--                                  <td><%=list.get(i).getBoLikeNum() %></td> --%>
<!--                               </tr> -->
                              
                              <tr style="text-align: center;">
                                 <td>1</td>
                                 <td><a href="/middle/boardDetail.jsp">안녕하세요dddddddddddddddddddddddddddddd</a></td>
                                 <td>가나</td>
                                 <td>2023.01.03</td>
                                 <td></td>
                                 <td></td>
                              </tr>
                           </tbody>
                        </table>
                     </div>
                  </div>
                  <div class="card-footer"></div>

               </div>
               <!-- 페이징 영역 -->
<!-- 			<div id="pageList" class="float-center" style="margin:20px; margin-left:40%; float-center"> -->
			<div id="pageList" class="float-center" style="display: flex; justify-content: center; margin-top: 25px;">
				<ul style="float: left;">
					<li><a href="#" id="previous" style="margin:10px;"> < </a></li>
				</ul>
				
 					<ul class="pagination pager">
 						<li class="active"><a href="#" style="margin:10px;">1</a></li>
 						<li class="active"><a href="#" style="margin:10px;">2</a></li>
 						<li class="active"><a href="#" style="margin:10px;">3</a></li>
 						<li class="active"><a href="#" style="margin:10px;">4</a></li>
 						<li class="active"><a href="#" style="margin:10px;">5</a></li>
 					</ul>
 		
				<ul style="float: left;">
					<li><a href="#" class="next" style="margin:10px;"> > </a></li>
				</ul>
 					
			</div>
			<!-- 페이징 영역 -->	
            </div> <!-- 검색창 아래 게시판 위 div -->
         </div>
   

      <!-- End Content -->


      <section class="container py-5">

      </section>

<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

<%@include file="/footer.jsp" %>

      <!-- Bootstrap -->
      <script src="assets/js/bootstrap.bundle.min.js"></script>
      <!-- Templatemo -->
      <script src="assets/js/templatemo.js"></script>
      <!-- Custom -->
      <script src="assets/js/custom.js"></script>

<!-- ///////////////그룹 참가버튼 모달창 스크립트 영역 ///////////////////////////////////////////////////////////////////////////-->
<script>
	var btnOpen = document.getElementById('btnOpen');
	var btnCheck = document.getElementById('btnCheck');
	var btnClose = document.getElementById('btnClose');

	// modal 창을 감춤
	var closeRtn = function() {
		var modal = document.getElementById('modal');
		modal.style.display = 'none';
	}

	// modal 창을 보여줌
	btnOpen.onclick = function() {
		var modal = document.getElementById('modal');
		modal.style.display = 'block';
	}

	btnCheck.onclick = closeRtn;
	btnClose.onclick = closeRtn;
</script>

</body>

   </html>