<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Membership Form</title>
<style>
	.error {
		color: red;
	}
</style>
</head>
<body>
	<form action="insert.do" method="POST" class="joinForm" enctype="multipart/form-data"
          onsubmit="">

          <h2>회원가입</h2>
          <div class="textForm">
            <input name="memId" type="text" class="id"
              enctype="multipart/form-data" required  placeholder="아이디">
            </input>
          </div>
          <div class="textForm">
            <input name="memPw" type="password" class="pw" required placeholder="비밀번호">
          </div>
          <div class="textForm">
          
            <input name="memPwConfirm" type="password" class="pw"
              placeholder="비밀번호 확인" required onkeyup="checkPasswordMatch()"> <span id="errorMessage" class="error"></span>
          </div>
          <div class="textForm">
            <input name="memName" type="text" class="name" required placeholder="이름">
          </div>
          <div class="textForm">
            <input name="memEmail" type="email" class="email" placeholder="이메일"
            required pattern="[0-9a-zA-z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}">
          </div>
          <div class="textForm">
            <label for="birthDate">생년월일 &nbsp; </label>
            <input name="memBirth" type="date" class="birth" id="birthDate"
              required placeholder="생년월일">
          </div>
          <div class="textForm">
            <input name="memTel" type="tel" class="tel" placeholder="전화번호"
            required pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}">
          </div>
          <div class="textForm">
            <label for="classDate">개강일 &nbsp; </label>
            <input name="memDate" type="date" class="classDate" id="classDate"
              required placeholder="개강일">
          </div>
          <div class="textForm">
            <input name="memNick" type="text" class="nickname"
              required placeholder="닉네임">
          </div>
          <div class="mb-3">
            <label for="exampleFormControlTextarea1"
              class="form-label">소개글</label>
            <textarea name="memIntro" class="form-control"
              id="exampleFormControlTextarea1" rows="5"></textarea>
          </div>
          <div class="mb-3">
            <label for="formFile" class="form-label">프로필 사진</label>
            <input name="memPic" class="form-control" type="file" id="formFile" >
          </div>
          <input type="submit" class="btn" value="회 원 가 입">
        </form>
	<script>
		function checkPasswordMatch() {
			var password = document.getElementsByName("memPw")[0].value;
			var confirmPassword = document.getElementsByName("memPwConfirm")[0].value;
			if (password != confirmPassword) {
				document.getElementById("errorMessage").innerHTML = "비밀번호 다름!";
			} else {
				document.getElementById("errorMessage").innerHTML = "";
			}
		}
	</script>
</body>
</html>
