<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="col-sm-8">
	  <h4>회원가입</h4>
	  <hr>
	  <form class="form-horizontal" method="post" onsubmit="return valid()">
	    <div class="form-group">
	      <label for="id" class="control-label col-sm-2">아이디</label>
	      <span class="sp"></span>
	      <div class="col-sm-4">
	        <input type="text" class="form-control" id="id" 
	        	placeholder="Enter id" name="mem_id" required pattern="[a-zA-Z][a-zA-Z0-9]{3,7}"> <!-- required : 필수 입력 항목이라는 표시 -->
	      </div>
	      <div class="col-sm-6" style="text-align: left;">
            <button type="button" class="btn btn-success btn-sm" id="idChk">중복검사</button>
            <span id="disp"></span>
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label for="pass" class="control-label col-sm-2">비밀번호</label>
	      <div class="col-sm-4">
	        <input type="password" class="form-control" id="pass" name="mem_pass" 
	        required pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()_\+|]).{8,}">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label for="name" class="control-label col-sm-2">이름</label>
	      <span class="sp"></span>
	      <div class="col-sm-4">
	        <input type="text" class="form-control" id="name" name="mem_name" 
	        required pattern="[가-힣]{2,8}">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label for="bir" class="control-label col-sm-2">생년월일</label>
	      <div class="col-sm-4">
	        <input type="date" class="form-control" id="bir" name="mem_bir">
	        <span class="sp"></span>
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label for="hp" class="control-label col-sm-2">연락처</label>
	      <div class="col-sm-4">
	        <input type="text" class="form-control" id="hp" name="mem_hp" placeholder="010-0000-0000" 
	        required pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}">
	      </div>
	      <span class="sp"></span>
	    </div>
	    
	    <div class="form-group">
	      <label for="mail" class="control-label col-sm-2">이메일</label>
	      <div class="col-sm-4">
	        <input type="email" class="form-control" id="mail" name="mem_mail" 
	        required pattern="[0-9a-zA-z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}">
	      </div>
	      <span class="sp"></span>
	    </div>
	    
	    <div class="form-group">
	      <label for="add1" class="control-label col-sm-2">우편번호</label>
	      <div class="col-sm-4">
	        <input type="text" class="form-control" id="postAddr" name="mem_zip">
	      </div>
	      <div class="col-sm-2">
	        <button type="button" id="addrBtn" class="btn btn-info btn-sm">주소검색</button>
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label for="add1" class="control-label col-sm-2">주소</label>
	      <div class="col-sm-6">
	        <input type="text" class="form-control" id="addr1" name="mem_add1" required>
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label for="add2" class="control-label col-sm-2">상세주소</label>
	      <div class="col-sm-6">
	        <input type="text" class="form-control" id="addr2" name="mem_add2" required>
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <div class="col-sm-offset-2 col-sm-6">
	        <button class="btn btn-default">가입하기</button>
	        <span id="joinspan"></span>
	      </div>
	    </div>
	  </form>
	</div>
	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.serializeJSON/3.2.1/jquery.serializejson.min.js" integrity="sha512-SdWDXwOhhVS/wWMRlwz3wZu3O5e4lm2/vKK3oD0E5slvGFg/swCYyZmts7+6si8WeJYIUsTrT3KZWWCknSopjg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>

//   $('#idChk').on('click',function(){} //버튼을 클릭했을 떄
  $('#id').on('keyup',function(){  //버튼 없이 텍스트 박스에 키를 올렸을 때 결과가 리턴
  	  
	  //id value 가져오기
  	  let v_idVal = $('#id').val();
	  
  	  //아이디 입력 창에 공백제거 (공백만 넣었을 때(아이디를 입력하지 않았을 때)는 결과가 출력되지 않음)
  	  if(v_idVal.trim().length == 0) return;
  	  
	  //jquery ajax
	 	$.ajax({
	 		type : 'post',
	 		url: './idCheck.jsp',			  //'jsp생성예장',
	 		data: {'uId':v_idVal},            //'id정보(value)',
	 		success:function(aaa){
	 			console.log(aaa);
	 			//id=disp라는 span영역에 msg출력하고 css()로 꾸며주기
	 			if(aaa.rst == "ok"){
		 			$('#disp').html(aaa.msg).css('color', 'green');
				}else{
		 			$('#disp').html(aaa.msg).css('color', 'red');
				}
	 		},
	 		error:function(xhr){
	 			alert("상태:" + xhr.status);
	 		},
	 		dataType:'json'
	 	});
  });
  

	//주소찾기 API사용 -daum
	$('#addrBtn').on('click', sample4_execDaumPostcode);

	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							xtraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('postAddr').value = data.zonecode;
						document.getElementById("addr1").value = roadAddr; //지번
// 						document.getElementById("addr2").value = data.jibunAddress; //도로명

						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
// 						if (roadAddr !== '') {
// 							document.getElementById("sample4_extraAddress").value = extraRoadAddr;
// 						} else {
// 							document.getElementById("sample4_extraAddress").value = '';
// 						}

						var guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';
							guideTextBox.style.display = 'block';

						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}
					}
				}).open();
		daum.Postcode.close();
	}
	
	function valid(){
		
// 	alert("시리얼라이즈");	
	
	//submit이벤트 실행되면서 화면전환되는 기본기능을 막아주기
	event.preventDefault();
	
	//자바스크립트 자체 제공 - serialize()
	//form의 모든 필드를 하느의 문자열로 합치고 key와 value로 이루어진 한쌍을 &로 구분하는 urlencode형식으로 만듦
// 	let data = $('form').serialize(); 		//mem_id=a002&mem_pass=asdfdg...
// 	let data = $('form').serializeArray();  //(gson이용) object배열의 형태-json[{name: 'mem_id', value: 'a111'}, {...}, {...}, {...}, {...}]
	let data = $('form').serializeJSON();  //json형태 {mem_id: 'a003', mem_pass: 'Aa003!@#', ...}
	console.log(data);		
	
	//ajax
	$.ajax({
		type: 'post', //method
// 		url:'member_sr.jsp',
// 		url:'member_sr_arr.jsp', //gson사용하는 방식 -> ????? 이건 뭐지 왜쓰지
		url:'member_sr_json.jsp', //json
		//자바스크립트 ajax사용시 post메소드로 data를 넘길 떄는 content-type설정이 꼭 필요 
		//			=> 안해주면 plain/text로 인식해서 어느부분이 key이고 value인지 인식하지 못한다.
		//jQuery ajax사용시 content-type이 default => urlendoded형식으로 지정해줌 => 자동으로 형태 변형해줌(like mem_id=a00123..)
		data: JSON.stringify(data), //위에서 만들어준 변수 사용(data)
		
		success:function(result){
			console.log(result);
			if(result == 1){
				alert("가입 성공");
				location.href="./login.html";
// 				$('#joinspan').html("성공!!").css({'color':'green', 'font-weight':'bold'});
			}else{
				console.log("가입실패");
				$('#joinspan').html("실패!!").css({'color':'red', 'font-weight':'bold'})
				
			}
		},
		error:function(xhr){
			alert("상태" + xhr.status);
		},
		dataType: 'text' //응답데이터의 형식 지정
	});
	}
	
</script>	
</body>
</html>