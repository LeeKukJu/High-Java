<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Templatemo -->
<script src="<%=request.getContextPath()%>assets/js/templatemo.js"></script>
<!-- Custom -->
<script src="<%=request.getContextPath()%>assets/js/custom.js"></script>


<!-- Start Footer -->
<footer class="bg-secondary pt-4" style="height: 220px; clear: left;">
	
		<div class="container" style="margin-left: 100px">
			<div class="row py-4" style="width: 128%;">

				<div class="col-lg-3 col-12 align-left">
					<a class="navbar-brand" href="index.html"> <i
						class='bx bx-buildings bx-sm text-light'></i> <span
						class="text-light h5">DDIT</span> <span
						class="text-light h5 semi-bold-600">MATE</span>
					</a>
					<p class="text-light my-lg-4 my-2">대덕인재개발원 커뮤니티</p>
				</div>

				<div class="col-lg-3 col-md-4 my-sm-0 mt-4"></div>

				<div class="col-lg-3 col-md-4 my-sm-0 mt-4"></div>

				<!--//////////////////////////// 문의하기 모달 시작//////////////////////////////////////-->
				<div class="col-lg-3 col-md-4 my-sm-0 mt-4">
					<!-- 				<h2 class="h4 pb-lg-3 text-light light-300">문의하기</h2> -->
					<a class="nav-link" onclick="f_winOpen4()" style="cursor:pointer;"><h4> 문의하기</h4></a>
<!-- 					<div id='modal' -->
<!-- 						style="z-index: 1; background-color: rgba(0, 0, 0, .70); position: fixed; left: 0; top: 0; width: 100%; height: 100%; display: none;"> -->
<!-- 						<div id='content' -->
<!-- 							style="border-radius: 11px; width: 400px; margin: 500px auto; padding: 20px; position: relative; background-color: #fff;"> -->
<!-- 							<input type='button' value='X' class="close" id='btnClose' -->
<!-- 								style="position: absolute; top: 4px; right: 4px; font-size: 20px; border: 0; background-color: #fff;" /> -->
<!-- 							<label>문의사항을 입력해주세요</label><br /> -->
<!-- 							<textarea name="question" class="form-control" autofocus -->
<!-- 								style="height: 200px;"></textarea> -->
<!-- 							<input type='button' class="btn btn-primary" value='제출' -->
<!-- 								id='btnCheck' style="margin-left: 300px;" /> -->
<!-- 						</div> -->
<!-- 					</div> -->
						
				<ul class="list-unstyled text-light light-300">
					<li class="pb-2"><i class='bx-fw bx bx-phone bx-xs'></i><a
						class="text-decoration-none text-light py-1"
						href="tel:010-020-0340">010-020-0340</a></li>
					<li class="pb-2"><i class='bx-fw bx bx-mail-send bx-xs'></i><a
						class="text-decoration-none text-light py-1"
						href="mailto:info@company.com">DDITMATE@company.com</a></li>
				</ul>
				</div>
				<!--//////////////////////////////////문의하기 모달 끝/////////////////////////////////// -->

			</div>
				<script>
// 					var btnOpen = document.getElementById('btnOpen');
// 					var btnCheck = document.getElementById('btnCheck');
// 					var btnClose = document.getElementById('btnClose');

// 					// modal 창을 감춤
// 					var closeRtn = function() {
// 						var modal = document.getElementById('modal');
// 						modal.style.display = 'none';
// 					}

// 					// modal 창을 보여줌
// 					btnOpen.onclick = function() {
// 						var modal = document.getElementById('modal');
// 						modal.style.display = 'block';
// 					}

// 					btnCheck.onclick = closeRtn;
// 					btnClose.onclick = closeRtn;
				</script>
		</div>
	

	<div class="w-100 bg-primary py-3"
		style="height: 50px; padding-bottom: 1rem">
		<div class="container">
			<div class="row pt-2" style="margin: -14px;">
				<div class="col-lg-6 col-sm-12">
					<p class="text-lg-start text-center text-light light-300">
						©Copyright 2023 DDITMATE. All Rights Reserved.</p>
				</div>
				<div class="col-lg-6 col-sm-12">
					<p class="text-lg-end text-center text-light light-300">
						Designed by <a rel="sponsored"
							class="text-decoration-none text-light"
							href="https://templatemo.com/" target="_blank"><strong>DDITMATE</strong></a>
					</p>
				</div>
			</div>
		</div>
	</div>


<script >
var v_win1;
function f_winOpen4(){
    v_win1 = open("/DDITMATE/mail/mailQnA.do","winNew3","width=500, height=500, top=100, left=100"); 
}





</script>
</footer>
<!-- End Footer -->