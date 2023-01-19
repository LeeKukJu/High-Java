<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>SideBar sub menus</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<!-- CSS -->
<link rel="stylesheet" href="/DDITMATE/assets/css/sidemain_style.css">
</head>

<body id="body-pd">
	<div class="l-navbar" id="navbar">
		<nav class="nav">
			<div>
				<div class="nav__brand">
					<ion-icon name="menu-outline" class="nav__toggle" id="nav-toggle">
					</ion-icon>


					<!-- profile box -->
					<img class="nav_profile" src="/DDITMATE/assets/img/manager_icon.png" style="height: 166px;"  alt="프사없음">
					<p style="margin: 10px;text-align: center;">관리자</p>
					<p></p>
					<!-- profile box -->
				</div>

				<div class="nav__list" style="width:200px;">
					<a href="/DDITMATE/manager/memList.do" class="nav__link">
						<ion-icon name="people-outline" class="nav__icon"></ion-icon> 
						<span class="nav_name">회원 관리</span>
					</a>

					<div href="#" class="nav__link custom-collapse active">
						<ion-icon name="folder-outline" class="nav__icon"></ion-icon>
						<span class="nav_name">신고 게시글</span>
						
						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>
						<ul class="collapse__menu" style="width:200px">
							<a href="/DDITMATE/blame/blame.do" class="collapse__sublink">신고게시글</a><br>
							<a href="/DDITMATE//blame/mentBlame.do" class="collapse__sublink">신고 댓글</a><br>
						</ul>
					</div>

					<a href="/DDITMATE/mail/mailReceiveList.do" class="nav__link"> 
					<ion-icon name="chatbubbles-outline" class="nav__icon"></ion-icon> 
					<span class="nav_name">문의사항관리</span>
					</a>


				
				<a href="<%=application.getContextPath()%>/logout.do" class="nav__link"> 
				<ion-icon name="log-out-outline" class="nav__icon"></ion-icon> 
				<span class="nav_name">로그아웃</span>
				</a>
				</div>
			</div>
		</nav>
	</div>

	<!-- IONICONS -->
	<script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
	<!-- JS -->
	<script src="<%=application.getContextPath()%>/assets/js/sidemain.js"></script>
</body>
</html>
