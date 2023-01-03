<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>메인 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
	<h2>로그인 페이지</h2>
	<%
		if (session.getAttribute("memId") == null) { // 로그인 상태 확인
		// 로그아웃 상태
	%>
	<script>
		function validateForm(form) {
			if (!form.memId.value) {
				alert("아이디를 입력하세요.");
				return false;
			}
			if (form.memPw.value == "") {
				alert("패스워드를 입력하세요.");
				return false;
			}
		}
	</script>
	<form action="#" method="post" name="loginFrm"
		onsubmit="return validateForm(this);">
		아이디 : <input type="text" name="memId" /><br /> 
		패스워드 : <input	type="password" name="memPw" /><br /> 
		<input type="submit" value="로그인하기" />
	</form>
	
	<a href="#">회원가입</a>
	<%
		} else { // 로그인된 상태
	%>
	<%=session.getAttribute("memName")%>
	회원님, 로그인하셨습니다.
	<br />
	<a href="#">[로그아웃]</a>
	<%
		}
	%>
</body>
</html>




