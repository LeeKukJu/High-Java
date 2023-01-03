<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--     Load Require CSS -->
<link href="<%=application.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet">
<!--     Font CSS -->
<link href="<%=application.getContextPath() %>/assets/css/boxicon.min.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap"
	rel="stylesheet">
<!--     Load Tempalte CSS -->
<link rel="stylesheet" href="<%=application.getContextPath() %>/assets/css/templatemo.css">
<!--     Custom CSS -->
<link rel="stylesheet" href="<%=application.getContextPath() %>/assets/css/login.css">
<!-- 자바스크립트 이벤트 연결 -->
<script src="<%=application.getContextPath() %>/assets/js/login.js"></script>

</head>
<body>
	<!-- 로그인 페이지 -->
	<form action="#" method="post" onsubmit="return validateForm(this);" >
		<div class="sidenav">
			<div class="login-main-text">
				<h2>
					DDIT MATE<br>
					<br> Welcome
					
				</h2>
				<p>Login or register from here to access.</p>
			</div>
		</div>
		<div class="main">
			<div class="col-md-6 col-sm-12">
			<div>
				<img src="<%=application.getContextPath() %>/assets/img/DDITMATE-logo.png">
			</div>
				<div class="login-form">
					<form>
						<div class="form-group">
							<label>User ID</label> 
							<input type="text" class="form-control" name="memId" placeholder="User Name">
						</div>
						<div class="form-group">
							<label>Password</label> 
							<input type="password" class="form-control" name="memPw" placeholder="Password">
						</div><br>
						<button type="submit" class="btn btn-black">로그인</button>
					</form>
						<a href="insert.do"><button type="button" class="btn btn-secondary">회원가입</button></a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>