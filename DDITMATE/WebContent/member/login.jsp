<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!--     Load Require CSS -->
<link href="<%=application.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet">
<!--     Font CSS -->
<link href="<%=application.getContextPath()%>/assets/css/boxicon.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap" rel="stylesheet">
<!--     Load Tempalte CSS -->
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/templatemo.css">
<!--     Custom CSS -->
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/login.css">
<!-- 자바스크립트 이벤트 연결 -->
<%-- <script src="<%=application.getContextPath()%>/assets/js/login.js"></script> --%>
<!-- 경고창 꾸며주는거 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<%
	System.out.println("세션확인: " + session.getAttribute("memId"));
%>

</head>
<body>

	<%
	String msg = (String) session.getAttribute("msg");
	String text = (String) session.getAttribute("text");
	String icon = (String) session.getAttribute("icon");
	if (msg != null) {
	%>
	<script>
		swal({
			title : "<%=msg%>",
			text : "<%=text%>",
			icon : "<%=icon%>",
			button : "확인",
		});
	</script>
	<%
		session.invalidate();
	}
	%>
	<!-- 로그인 페이지 -->
	<form action="<%=application.getContextPath()%>/member/login.do" method="post" onsubmit="return validateForm(this);">
		<div class="sidenav">
			<div class="login-main-text">
				<h2>
					DDIT MATE<br> <br> Welcome

				</h2>
				<p>Login or register from here to access.</p>
			</div>
		</div>
		<div class="main">
			<div class="col-md-6 col-sm-12">
				<div class="login-form">
				<div>
					<img src="<%=application.getContextPath()%>/assets/img/DDITMATE-logo.png">
				</div>
				<div class="col-md-99"></div>
					<div>
						<div class="form-group">
							<label>User ID</label> <input type="text" class="form-control" name="memId" placeholder="User Name">
						</div>
						<div class="form-group">
							<label>Password</label> <input type="password" class="form-control" name="memPw" placeholder="Password">
						</div>
						<br>
						<button type="submit" class="btn btn-black">로그인</button>
						<a href="<%=application.getContextPath()%>/member/insert.do"><button type="button" class="btn btn-secondary">회원가입</button></a>
					</div>
				</div>
			</div>
		</div>
	</form>

	<script type="text/javascript">
		function validateForm(form) {
			if (!form.memId.value) {
				swal("아이디를 입력하세요.", "", "warning");
				return false;
			}
			if (form.memPw.value == "") {
				swal("패스워드를 입력하세요.", "", "warning");
				return false;
			}
		}
	</script>
</body>
</html>