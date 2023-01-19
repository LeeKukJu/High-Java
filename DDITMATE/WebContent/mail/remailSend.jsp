<%@page import="mail.vo.MailVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<%
	String memId = (String)session.getAttribute("memId");
	MailVO mav = (MailVO) request.getAttribute("mav");
	String Sender = request.getParameter("mailSender");
	
%>

<form action="./reMail.do" id="sendForm" method="post">
<!-- 답장메일보내기 폼 -->

  <div class="mb-3" style="border: 1px;">
	<input type="hidden" name="mailNo" >
	<input type="hidden" name="mailSender">
	<div class="mb-3" style="padding-top: 30px; padding-left: 30px; padding-right: 30px;">
	
	  <label class="form-label">받는사람</label>
	  <input type="text" class="form-control" name="mailReceiver" value="<%=Sender%>" style="width: 50%;">
	  
	</div>
	<input type="hidden" name="mailDate">
	
	<div class="mb-3" style="padding-left: 30px; padding-right: 30px;" >
	  <textarea class="form-control" name="mailCon" rows="7" placeholder="내용을 입력하세요." style="width:100%"></textarea>
	</div>
	<div style="padding-left: 80%;">
		<button type="button" id="sendMail" class="btn btn-primary">전송</button>
	</div>
</div>
</form>
<!-- <textarea id="send_text" cols="50" rows="30" placeholder="내용을 입력하세요"></textarea> -->

<script>

$('#sendMail').on('click',function(){

	$.ajax({
		type: 'post', //method
		url:'./reMail.do', //json
		data: $("#sendForm").serialize(), //위에서 만들어준 변수 사용(data)
		
		success:function(result){
			console.log(result);
			self.close();
			alert("쪽지가 전송되었습니다.");			
			opener.reload();
		},
		error:function(xhr){
			alert("상태" + xhr.status);
		},
		dataType: 'json' //응답데이터의 형식 지정
	});
	
}); 




</script>