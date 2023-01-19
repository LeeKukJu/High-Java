<%@page import="java.io.File"%>
<%@page import="member.vo.PictureVO"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@include file="header.jsp"%>
<%
	String memId = (String) session.getAttribute("memId");
	System.out.println("로그인 아이디: " + memId);
	MemberVO mv = (MemberVO) request.getAttribute("mv");
	PictureVO pv = (PictureVO) request.getAttribute("pv");
	
%>
<% 
	if(memId.equals("admin")){
%>		
	<%@include file="/manager/managerSide.jsp" %>
<%
	}else {
%>
	<%@include file="memberSide.jsp" %>
<%	
	}
%>


<!-- ////////////////////////////////////////////본문///////////////////////////////////////////////////// -->
<!-- Start Contact -->
<form action="./updateProfile.do" method="post" class="changeForm" enctype="multipart/form-data" >
	<section class="container py-5">
		<div class="container bootstrap snippets bootdey">
			<h1 class="text-primary">내 프로필</h1>
			<hr>
			<div class="row">
				<!-- left column -->
				<div class="col-md-3">
					<table border="1" style="width: 300px; height: 300px; table-layout: fixed;">
						<tbody>
							<tr style="height: 260px;">
								<td id="image_container" class="profileImg">
								<%if(pv == null){
								%>
								<img src="https://bootdey.com/img/Content/avatar/avatar7.png" class="avatar img-circle img-thumbnail" alt="avatar">
								<%
								}else{
								%>
								<img src="/DDITMATE/member_pic/<%=pv.getSavePic() %>" class="avatar img-circle img-thumbnail" alt="프사없음" style="padding: 0;">
								<%
								}
								%>
								</td>
							</tr>
							<tr>
								<td align="center">프로필 사진</td>
							</tr>
							<tr>
								<td>
									<input type="file" name="uploadImg" id="image" accept="image/*" />
								</td>
							</tr>
						</tbody>
					</table>
					<!-- 					//////////////////////////////// -->
<!-- 					<div class="text-center"> -->
<!-- 												<img src="https://bootdey.com/img/Content/avatar/avatar7.png" class="avatar img-circle img-thumbnail" alt="avatar"> -->
<!-- 						<div id="image_container"></div> -->
<!-- 						<h6>프로필 사진</h6> -->

<!-- 						<input type="file" id="image" accept="image/*" onchange="setThumbnail(event);" class="form-control" /> -->
<!-- 					</div> -->
				</div>

				<!-- edit form column -->
				<div class="col-md-9 personal-info">

					<h3>프로필 수정</h3>

					<div class="form-horizontal" role="form">
						<div class="form-group">

							<label class="col-lg-3 control-label">닉네임 변경</label>
							<div class="col-lg-8">
								<input name="memNick" class="form-control" type="text" id="nickname" placeholder="닉네임을 입력하세요" value="<%=mv.getMemNick()%>">
							</div>
							<div class="col-sm-6";>
							<span id="dis"></span>
	  			    		</div>
							
						</div>
						<div class="form-group">
							<label class="col-lg-8 control-label">소개글 변경</label>
							<div class="col-lg-8">

								<textarea name="memIntro" class="form-control" autofocus placeholder="소개글을 입력하세요..." style="height: 200px;"><%=mv.getMemIntro()%></textarea>
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary" id="updatePro" style="left: 600px; top: 10px; position: relative;">수정</button>
							<div class="col-lg-8">
								<div class="ui-select"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
	</section>
</form>
<!-- End Contact -->
<script src="<%=application.getContextPath()%>/assets/js/sidemain.js"></script>
<script>
// 	function setThumbnail(event) {
// 		var reader = new FileReader();

// 		reader.onload = function(event) {
// 			var img = document.createElement("img");
// 			img.setAttribute("src", event.target.result);
// 			document.querySelector("div#image_container").appendChild(img);
// 		};

// 		reader.readAsDataURL(event.target.files[0]);
// 	}

$('#updatePro').on('click',function(){
		alert("프로필 수정이 완료되었습니다.");
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
			  url: '/DDITMATE/member/nickCheck.jsp',
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

<%@include file="/footer.jsp"%>