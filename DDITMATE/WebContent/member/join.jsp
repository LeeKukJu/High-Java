<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/join.css">


</head>

<body>
	<main>
		<form action="./insert.do" method="POST" class="joinForm"
			enctype="multipart/form-data" >

			<div class="formBox">

				<h2>회원가입</h2>
				<h5>아이디는 영문+숫자 조합(4~10글자),<br>
					비밀번호는 영문 대소문자와 숫자 특수문자(!@#$%^&*()_+|)를 <br>
					모두 포함하여 8자리 이상으로 입력해주세요</h5>
				<div class="textForm">
					<input name="memId" type="text" class="id" id="id"
						enctype="multipart/form-data" required placeholder="아이디" required pattern="^[a-zA-Z][0-9a-zA-Z]{4,10}$">
				</div>
					<div class="col-sm-6";>
					<span id="disp"></span>
	  			    </div>
					</input>
				<div class="textForm">
					<input name="memPw" type="password" class="pw" required
						placeholder="비밀번호" required pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()_+|]).{8,}">
				</div>
				<div class="textForm">

					<input name="memPwConfirm" type="password" class="pw"
						placeholder="비밀번호 확인" required onkeyup="checkPasswordMatch()">
				</div>
				<span id="errorMessage" class="error"></span>
				<div class="textForm">
					<input name="memName" type="text" class="name" required
						placeholder="이름">
				</div>
				<div class="textForm">
					<input name="memEmail" type="email" class="email" placeholder="이메일"
						required pattern="[0-9a-zA-z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}">
				</div>
				<div class="textForm">
					<label for="birthDate"><a id="tab">생년월일&nbsp;</a></label> <input
						name="memBirth" type="date" class="birth" id="birthDate" required
						placeholder="생년월일">
				</div>
				<div class="textForm">
					<input name="memTel" type="tel" class="tel"
						placeholder="전화번호 010-0000-0000" required
						pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}">
				</div>
				<div class="textForm">
					<label for="classDate"><a id="tab2">개강일&nbsp;</a></label> <input
						style="margin-bottom: 5.5px;" ; name="memDate" type="date"
						class="classDate" id="classDate" required placeholder="개강일">
				</div>
				<div class="textForm">
					<input name="memNick" type="text" class="nickname" id="nickname" required
						placeholder="닉네임">
				</div>
					<div class="col-sm-6";>
					<span id="dis"></span>
	  			    </div>

				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">소개글</label>
					<textarea name="memIntro" class="form-control"
						id="exampleFormControlTextarea1" rows="5"></textarea>
				</div>
				<div class="filebox">
					<input class="upload-name" value="첨부파일" placeholder="첨부파일">
					<label for="formFile" class="form-label">프로필 사진</label> <input
						name="memPic" type="file" id="formFile">
				</div>
				
				<br> <input type="submit" class="btn" value="회 원 가 입">

			</div>


		</form>
	</main>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	$('#id').on('keyup',function(){
		  
		  //id value 가져오기
		  let v_idVal = $('#id').val();
		              
		  //공백제거
		  if(v_idVal.trim().length == 0) return;
		  
		  //jquery ajax
		  $.ajax({
			  type: 'post',
			  url: './idCheck.jsp',
			  data: {'uId':v_idVal},
			  success:function(aaa){
				  //console.log(aaa);
				  //id=disp라는 span영역에 msg출력하고 css()로 꾸며주기..
				  if(aaa.rst == "ok"){
					  $('#disp').html(aaa.msg).css('color','green');
				  }else{
					  $('#disp').html(aaa.msg).css('color','red');
				  }
			  },
			  error:function(xhr){
				  alert("상태:" + xhr.status);
			  },
			  dataType:'json'
		  });
	  });
	</script>

	
	<script>
	$('#nickname').on('keyup',function(){
		  
		  //id value 가져오기
		  let v_nickVal = $('#nickname').val();
		              
		  //공백제거
		  if(v_nickVal.trim().length == 0) return;
		  
		  //jquery ajax
		  $.ajax({
			  type: 'post',
			  url: './nickCheck.jsp',
			  data: {'uNick':v_nickVal},
			  success:function(aaa){
				  
				  if(aaa.rst == "ok"){
					  $('#dis').html(aaa.msg).css('color','green');
				  }else{
					  $('#dis').html(aaa.msg).css('color','red');
				  }
			  },
			  error:function(xhr){
				  alert("상태:" + xhr.status);
			  },
			  dataType:'json'
		  });
	  });
	</script>
		<script>
	
		function checkPasswordMatch() {
			var password = document.getElementsByName("memPw")[0].value;
			var confirmPassword = document.getElementsByName("memPwConfirm")[0].value;
			if (password != confirmPassword) {
				document.getElementById("errorMessage").innerHTML = "비밀번호가 일치하지 않습니다!";
			} else {
				document.getElementById("errorMessage").innerHTML = "";
			}
		}
		$("#formFile").on('change', function() {
			var fileName = $("#formFile").val();
			$(".upload-name").val(fileName);
		});
		
		
	</script>
</body>

</html>