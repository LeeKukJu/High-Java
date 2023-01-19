<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDITMATE</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="assets/img/DDITMATE-icon.png">
<link rel="shortcut icon" type="image/x-icon" href="assets/img/DDITMATE-icon.png">
<link href="<%=application.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet">
<!-- ////////////////////////header CSS 영역///////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- Font CSS -->
<link href="<%=application.getContextPath()%>/assets/css/boxicon.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap" rel="stylesheet">
<!-- Load Tempalte CSS -->
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/templatemo.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/custom.css">
<!-- ////////////////////////header CSS 영역///////////////////////////////////////////////////////////////////////////////////////////// -->

<!-- //////////////JDOCS : summernote 사용하기 위해서 있어야해요!! 지우지 말아주세요!! 또 지우면 지운사람이 서머노트 구현하기 !!!!//////////////-->
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>

<!-- <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script> -->
<!-- <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet"> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script> -->
<script src="<%=application.getContextPath()%>/assets/js/summernote-lite.js"></script>
<script src="<%=application.getContextPath()%>/assets/js/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/summernote-lite.min.css">

<!-- //////////////JDOCS : summernote 사용하기 위해서 있어야해요!! 지우지 말아주세요!! 또 지우면 지운사람이 서머노트 구현하기 !!!!//////////////-->
<!-- 경고창 꾸며주는거 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>

<body>
	<script>
		function chatWinOpen() {
			window.open("/DDITMATE/webSocketGroupMutiChatting.jsp", "","width=825,height=600");
		}
	</script>
	<!-- Header -->
	<nav id="main_nav" class="navbar navbar-expand-lg navbar-light bg-white shadow">
		<div class="container d-flex justify-content-between align-items-center">
			<a class="navbar-brand h1" href="<%=application.getContextPath()%>/main.jsp">
				<i class='bx bx-buildings bx-sm text-dark'></i>
				<img src="<%=application.getContextPath()%>/assets/img/DDITMATE-logo.png" width=180px>
				<!--                 <span class="text-dark h4">DDIT</span> <span class="text-primary h4">MATE</span> -->
			</a>
			<button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-toggler-success" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="navbar-toggler-success">
				<div class="flex-fill mx-xl-5 mb-2">
					<ul class="nav navbar-nav d-flex justify-content-between mx-xl-5 text-center text-dark">
						<!--                         <li class="nav-item"> -->
						<%--                             <a class="nav-link btn-outline-primary rounded-pill px-3" href="<%=application.getContextPath()%>/main.jsp">Home</a> --%>
						<!--                         </li> -->
						<li class="nav-item">
							<a class="nav-link btn-outline-primary rounded-pill px-3" href="<%=application.getContextPath()%>/board/listBoard.do?cateCode=s001">스터디/프로젝트</a>
						</li>
						<li class="nav-item">
							<a class="nav-link btn-outline-primary rounded-pill px-3" href="<%=application.getContextPath()%>/board/listBoard.do?cateCode=q001">질문게시판</a>
						</li>
						<li class="nav-item">
							<a class="nav-link btn-outline-primary rounded-pill px-3" href="<%=application.getContextPath()%>/board/listBoard.do?cateCode=f">자유게시판</a>
						</li>
						<li class="nav-item">
							<a class="nav-link btn-outline-primary rounded-pill px-3" href="<%=application.getContextPath()%>/board/listBoard.do?cateCode=j001">취업정보</a>
						</li>
					</ul>
				</div>
				<div class="navbar align-self-center d-flex">
					<a class="nav-link" type="button" href="#" onclick="chatWinOpen();">
							<i class='bx bx-message-rounded bx-sm bx-tada-hover text-primary'></i>
					</a>
					<a class="nav-link" href="<%=application.getContextPath()%>//member/memCheck.do">
						<i class='bx bx-user-circle bx-sm text-primary'></i>
					</a>
					<a class="nav-link" href="<%=application.getContextPath()%>/logout.do">
						<i class='bx bx-log-out bx-sm text-primary'></i>
					</a>
				</div>
			</div>
		</div>
	</nav>