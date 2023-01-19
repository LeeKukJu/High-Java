<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

<%	String memId = (String)session.getAttribute("memId"); 
	System.out.println("로그인 아이디: " + memId);
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
                        <p class="banner-body text-muted py-3 mx-0 px-0">2023.01.24 화요일 대체공휴일로 학원 개방하지 않습니다. </p>
                     </div>
                  </div>

               </div>
               <div class="carousel-item">
                  <div class="py-5 row d-flex align-items-center">
                    <div
                        class="banner-content col-lg-8 col-8 offset-2 m-lg-auto text-left py-5 pb-5">
                        <h1
                           class="banner-heading h1 text-secondary display-3 mb-0 pb-3 mx-0 px-0 light-300">
                          		국민취업지원제도</h1>
                        <a class="banner-button btn rounded-pill btn-outline-primary btn-lg px-4"
                           href="https://www.kua.go.kr/uaptm010/selectMain.do" target="_blank" role="button">국민 취업 지원제도 사이트 바로가기</a>
                        <p class="banner-body text-muted py-3">개발원 수료중에도 신청할 수 있어요!</p>
                     </div>
                  </div>

               </div>
               <div class="carousel-item">

                  <div class="py-5 row d-flex align-items-center">
                     <div
                        class="banner-content col-lg-8 col-8 offset-2 m-lg-auto text-left py-5 pb-5">
                        <h1
                           class="banner-heading h1 text-secondary display-3 mb-0 pb-3 mx-0 px-0 light-300">
                          		대덕인재개발원 홈페이지</h1>
<!--                         <p class="banner-body text-muted py-3">개발원 수료중에도 신청할 수 있어요!</p> -->
                        <a class="banner-button btn rounded-pill btn-outline-primary btn-lg px-4"
                           href="https://www.ddit.or.kr/" target="_blank" role="button">대덕인재개발원 홈페이지 바로가기</a>
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

<div style="margin-left:100px">
<a href="https://www.jobkorea.co.kr/recruit/joblist?menucode=duty"><img alt="이미지1" src="assets/img/001.jpg" width="31%" style="padding:50px"></a>
<img alt="이미지2" src="assets/img/002.jpg" width="31%" style="padding:50px">
<img alt="이미지3" src="assets/img/003.jpg" width="31%" style="padding:50px">
</div>

<!-- End Recent Work -->

<%@include file="footer.jsp" %>

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