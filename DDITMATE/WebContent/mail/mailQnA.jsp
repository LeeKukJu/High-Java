<%@page import="mail.vo.MailVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/header.jsp"%>    

<%
	String memId = (String)session.getAttribute("memId");
	MailVO mav = (MailVO) request.getAttribute("mav");
	
%>
<!-- 메일 전송하기 폼 -->
<!-- <form action="./mailQnA.do" id="qnaForm" method="post"> -->

<!--   <div class="mb-3" style="border: 1px;"> -->
<!-- 	<input type="hidden" name="mailNo"> -->
<!-- 	  <input type="hidden" name="mailSender"> -->

<!-- 	<div class="mb-3" style="padding-top: 30px; padding-left: 30px; padding-right: 30px;"> -->
	
<!-- 	  <label class="form-label" style="padding-top:5px;">받는사람</label> -->
<!-- 	  <input type="text" readonly class="form-control-plaintext" name="mailReceiver" style="width: 50%;"> -->
<%-- <%-- value="<%=mav.getMailReceiver() %>"  --%>
	  
	  
<!-- 	</div> -->
	
<!-- 	<input type="hidden" name="mailDate"> -->
<!-- 	<div class="mb-3" style="padding-left: 30px; padding-right: 30px;" > -->
<!-- 	  <textarea class="form-control" name="mailCon" rows="7" placeholder="내용을 입력하세요." style="width:100%"></textarea> -->
<!-- 	</div> -->
<!-- 	<div style="padding-left: 80%;"> -->
<!-- 		<button type="button" id="qnaMail" class="btn btn-primary">전송</button> -->
<!-- 	</div> -->
	  
<!-- 	</div> -->
	
<!-- </form> -->
<!-- <textarea id="send_text" cols="50" rows="30" placeholder="내용을 입력하세요"></textarea> -->

<form action="./mailQnA.do" id="qnaForm" method="post">
<!-- <form action="/mail/mailSend.do" method="post"> -->
<!-- 메일 전송하기 폼 -->

  <div class="mb-3" style="border: 1px;">
  <div style="text-align:center;padding-top:25px;">
  	<h3>문의사항을 작성해주세요</h3>
  </div>
	<input type="hidden" name="mailNo">
	<input type="hidden" name="mailSender">
<!-- 	<div class="mb-3" style="padding-top: 10px; padding-left: 30px; padding-right: 30px;"> -->
	
<!-- 	  <label class="form-label">받는사람</label> -->
	  <input type="hidden" name="mailReceiver" style="width: 50%;">
	  
<!-- 	</div> -->
	<input type="hidden" name="mailDate">
	
	<div class="mb-3" style="padding-top: 10px; padding-left: 30px; padding-right: 30px;" >
	  <textarea class="form-control" name="mailCon" rows="7" placeholder="내용을 입력하세요." style="width:100%"></textarea>
	</div>
	<div style="padding-left: 80%;">
		<button type="button" id="qnaMail" class="btn btn-primary">전송</button>
	</div>
</div>
</form>
<!-- <textarea id="send_text" cols="50" rows="30" placeholder="내용을 입력하세요"></textarea> -->

<script>



$('#qnaMail').on('click',function(){

	$.ajax({
		type: 'post', //method
		url:'./mailQnA.do', //json
		data: $("#qnaForm").serialize(), //위에서 만들어준 변수 사용(data)
		
		success:function(result){
			console.log(result);
			self.close();
			alert("문의사항이 등록되었습니다.");			
		},
		error:function(xhr){
			alert("상태" + xhr.status);
		},
		dataType: 'json' //응답데이터의 형식 지정
	});
	
}); 



</script>