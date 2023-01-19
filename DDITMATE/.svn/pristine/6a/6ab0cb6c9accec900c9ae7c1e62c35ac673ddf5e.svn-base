<%@page import="mail.vo.MailVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/header.jsp"%>	
<%
// 	String memId = (String)session.getAttribute("memId");
	MailVO mav = (MailVO)request.getAttribute("mav");
	int mailNo = Integer.parseInt(request.getParameter("mailNo"));

%>

<form action="./mailDetail.do" method="get">
<!-- <form action="/mail/mailSend.do" method="post"> -->
<!-- 메일 상세보기 폼 -->
  <div class="mb-3" style="border: 1px;">
	<input type="hidden" value="<%=mailNo %>">
<!-- 	<input type="" name="mailSender"> -->
	<div class="mb-3" style="padding-top: 30px; padding-left: 30px; padding-right: 30px;">
	
	  <label class="form-label">보낸사람</label>
	  <input type="text" class="form-control" value="<%=mav.getMailSender() %>" style="width: 50%;">
	  
	  <label class="form-label" style="padding-top:5px;">받는사람</label>
	  <input type="text" class="form-control" value="<%=mav.getMailReceiver() %>" style="width: 50%;">
	  
	</div>
	<div class="mb-3" style="padding-left: 30px; padding-right: 30px;">
	
	</div>
	<input type="hidden" value="<%=mav.getMailDate() %>">
	
	<div class="mb-3" style="padding-left: 30px; padding-right: 30px;" >
	  <textarea class="form-control" rows="7" style="width:100%"><%=mav.getMailCon() %></textarea>
	</div>
	<div style="padding-left: 70%;">
		<input type="button" id="test" class="btn btn-primary" value="답장" onclick="f_winOpen3()">
		<input type="button" class="btn btn-primary" value="닫기" onclick="window.close()">
	</div>
</div>
</form>	

<script>

var v_win1;
function f_winOpen3(){
    v_win1 = open("/DDITMATE/mail/reMail.do?mailSender=<%=mav.getMailSender()%>","winNew1","width=500, height=500, top=100, left=100");
}



</script>
        
        
        
<!--         <div class="mb-3"> -->
<!--             <label class="form-label">보낸사람: </label> -->
<!--             <input type="text" class="form-control" placeholder=""> -->
<!--           </div> -->
<!--         <div class="mb-3"> -->
<!--             <label class="form-label">받는사람</label> -->
<!--             <input type="text" class="form-control" id="exampleFormControlInput1" placeholder=""> -->
<!--           </div> -->

