<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
    crossorigin="anonymous">
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>
  <link href="assets/css/join.css" rel="stylesheet" type="text/css" />
  <script src="assets/js/join.js"></script>
</head>

<body>

  <div class="container-fluid text-center">
    <div class="row"> 
      <div class="col" ><img src="assets/img/DDITMATE-logo.png"></div> 
    </div>
    <div class="row">
      <div class="col-3 side"></div>
      <div class="col-6">
        <form action="#" method="POST" class="joinForm" enctype="multipart/form-data"
          onsubmit="DoJoinForm__submit(this); return false;">

          <h2>회원가입</h2>
          <div class="textForm">
            <input name="memId" type="text" class="id"
               required pattern="[a-zA-Z][a-zA-Z0-9]{3,7}" placeholder="아이디">
            </input>
          </div>
          <div class="textForm">
            <input name="memPw" type="password" class="pw" required placeholder="비밀번호">
          </div>
          <div class="textForm">
          <span id="errorMessage" class="error"></span>
            <input name="memPwConfirm" type="password" class="pw"
              placeholder="비밀번호 확인" onkeyup="checkPasswordMatch()">
          </div>
          <div class="textForm">
            <input name="memName" type="text" class="name" placeholder="이름">
          </div>
          <div class="textForm">
            <input name="memEmail" type="email" class="email" placeholder="이메일"
            required pattern="[0-9a-zA-z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}">
          </div>
          <div class="textForm">
            <label for="birthDate">생년월일 &nbsp; </label>
            <input name="memBirth" type="date" class="birth" id="birthDate"
              placeholder="생년월일">
          </div>
          <div class="textForm">
            <input name="memTel" type="tel" class="tel" placeholder="전화번호"
            required pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}">
          </div>
          <div class="textForm">
            <label for="classDate">개강일 &nbsp; </label>
            <input name="memDate" type="date" class="classDate" id="classDate"
              placeholder="개강일">
          </div>
          <div class="textForm">
            <input name="memNick" type="text" class="nickname"
              placeholder="닉네임">
          </div>
          <div class="mb-3">
            <label for="exampleFormControlTextarea1"
              class="form-label">소개글</label>
            <textarea name="memIntro" class="form-control"
              id="exampleFormControlTextarea1" rows="3"></textarea>
          </div>
          <div class="mb-3">
            <label for="formFile" class="form-label">프로필 사진</label>
            <input name="memPic" class="form-control" type="file" id="formFile">
          </div>
          <input type="submit" class="btn" value="회 원 가 입">
        </form>
      </div>
      <div class="col-3 side"></div>
    </div>
  </div>
  </div>
  
</body>

</html>