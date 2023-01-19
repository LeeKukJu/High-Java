<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@include file="/manager/managerHeader.jsp" %>
<%@include file="/manager/managerSide.jsp" %>

<%	String memId = (String)session.getAttribute("memId"); 
	System.out.println("로그인 아이디: " + memId);
%>

<!-- Start Banner Hero -->
   <div class="banner-wrapper bg-light">
      <div id="index_banner"
         class="banner-vertical-center-index container-fluid pt-5">

         <!-- Start slider -->
         <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
            <ol class="carousel-indicators">
               <li data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="0" class="active">
               </li>
               <li data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="1">
               </li>
               <li data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="2">
               </li>
            </ol>
            <div class="carousel-inner">
               <div class="carousel-item active">

                  <div class="py-5 row d-flex align-items-center">
                     <div
                        class="banner-content col-lg-8 col-8 offset-2 m-lg-auto text-left py-5 pb-5">
                        <h1 class="banner-heading h1 text-secondary display-3 mb-0 pb-5 mx-0 px-0 light-300 typo-space-line">
                           DDIT MATE <strong>공지사항</strong> <br>
                        </h1>
                        <p class="banner-body text-muted py-3 mx-0 px-0"></p>
                     </div>
                  </div>

               </div>
               <div class="carousel-item">
                  <div class="py-5 row d-flex align-items-center">
                     <div class="banner-content col-lg-8 col-8 offset-2 m-lg-auto text-left py-5 pb-5">
                        <h1 class="banner-heading h1 text-secondary display-3 mb-0 pb-3 mx-0 px-0 light-300">
                           진행중인 공모전
                        </h1>
                        <p class="banner-body text-muted py-3">You are not allowed
                           to re-distribute this Purple Buzz HTML template as a
                           downloadable ZIP file on any kind of Free CSS collection
                           websites. This is strongly prohibited. Please contact
                           TemplateMo for more information.
                        </p>
                        <a class="banner-button btn rounded-pill btn-outline-primary btn-lg px-4"
                           href="#" role="button">Get Started
                        </a>
                     </div>
                  </div>

               </div>
               <div class="carousel-item">

                  <div class="py-5 row d-flex align-items-center">
                     <div
                        class="banner-content col-lg-8 col-8 offset-2 m-lg-auto text-left py-5 pb-5">
                        <h1
                           class="banner-heading h1 text-secondary display-3 mb-0 pb-3 mx-0 px-0 light-300">
                           취업정보 배너</h1>
                        <p class="banner-body text-muted py-3">Ut enim ad minim
                           veniam, quis nostrud exercitation ullamco laboris nisi ut
                           aliquip ex ea commodo consequat. Duis aute irure dolor in
                           reprehenderit in voluptate velit esse cillum dolore eu fugiat
                           nulla pariatur. Excepteur sint occaecat.</p>
                        <a
                           class="banner-button btn rounded-pill btn-outline-primary btn-lg px-4"
                           href="#" role="button">Get Started</a>
                     </div>
                  </div>

               </div>
            </div>
            <a class="carousel-control-prev text-decoration-none"
               href="#carouselExampleIndicators" role="button"
               data-bs-slide="prev"> <i class='bx bx-chevron-left'></i> 
               <span class="visually-hidden">Previous</span>
            </a> 
            <a class="carousel-control-next text-decoration-none"
               href="#carouselExampleIndicators" role="button"
               data-bs-slide="next"> 
               <i class='bx bx-chevron-right'></i> 
               <span class="visually-hidden">Next</span>
            </a>
         </div>
         <!-- End slider -->

      </div>
   </div>
   <!-- End Banner Hero -->



<!-- Start Recent Work -->
<div style="padding:30px"></div>
<section class="py-5 mb-5" style="height: 500px;">
<div style="border-radius:10px; float:left; margin:20px; padding:15px; width:30%; background-color:#eeee">
	<div class="list-title-box">
		<div class="list-title">
			<h3>스터디프로젝트</h3>
		</div>
		<hr>
	</div>
		<table class="table table-striped">
		<caption>
			<a href="/middle/studyProject.jsp">더보기></a>
		</caption>
		<colgroup>
			<col>
			<col width=50>
		</colgroup>
		<tbody>
				<tr>
				<td><a href="#">제목1</a></td>
				</tr>
				<tr>
				<td><a href="#">제목2</a></td>
				</tr>
				<tr>
				<td><a href="#">제목3</a></td>
				</tr>
				<tr>
				<td><a href="#">제목4</a></td>
				</tr>
				<tr>
				<td><a href="#">제목5</a></td>
				</tr>
			
		</tbody>
		</table>
</div>
<div style="border-radius:10px; float:left; margin:20px; padding:15px; width:30%; background-color:#eeee">
	<div class="list-title-box">
		<div class="list-title">
			<h3>질문게시판</h3>
		</div>
		<hr>
	</div>
		<table class="table table-striped">
		<caption>
			<a href="#">더보기></a>
		</caption>
		<colgroup>
			<col>
			<col width=50>
		</colgroup>
		<tbody>
				<tr>
				<td>제목1</td>
				</tr>
				<tr>
				<td>제목2</td>
				</tr>
				<tr>
				<td>제목3</td>
				</tr>
				<tr>
				<td>제목4</td>
				</tr>
				<tr>
				<td>제목5</td>
				</tr>
			
		</tbody>
		</table>
	</div>
<div style="border-radius:10px; float:left; margin:20px; padding:15px; width:30%; background-color:#eeee">
	<div class="list-title-box">
		<div class="list-title">
			<h3>자유게시판</h3>
		</div>
		<hr>
	</div>
		<table class="table table-striped">
		<caption>
			<a href="#">더보기></a>
		</caption>
		<colgroup>
			<col>
			<col width=50>
		</colgroup>
		<tbody>
				<tr>
				<td>제목1</td>
				</tr>
				<tr>
				<td>제목2</td>
				</tr>
				<tr>
				<td>제목3</td>
				</tr>
				<tr>
				<td>제목4</td>
				</tr>
				<tr>
				<td>제목5</td>
				</tr>
			
		</tbody>
		</table>
	</div>

</section>
<!-- End Recent Work -->

<%@include file="/footer.jsp" %>

<!-- Page Script -->
<script>
	$(window).load(function() {
		// init Isotope
		var $projects = $('.projects').isotope({
			itemSelector : '.project',
			layoutMode : 'fitRows'
		});
		$(".filter-btn").click(function() {
			var data_filter = $(this).attr("data-filter");
			$projects.isotope({
				filter : data_filter
			});
			$(".filter-btn").removeClass("active");
			$(".filter-btn").removeClass("shadow");
			$(this).addClass("active");
			$(this).addClass("shadow");
			return false;
		});
	});
</script>
   <!-- Templatemo -->
   <script src="assets/js/templatemo.js"></script>
   <!-- Custom -->
   <script src="assets/js/custom.js"></script>

</body>

</html>