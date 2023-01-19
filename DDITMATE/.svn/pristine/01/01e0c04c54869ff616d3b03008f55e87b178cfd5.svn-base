<%@page import="mail.vo.MailVO"%>
<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/header.jsp"%>

<%
   String memId = (String) session.getAttribute("memId");
   System.out.println("로그인 아이디: " + memId);
   List<MailVO> mailList = (List<MailVO>) request.getAttribute("mailList"); // 받은 메세지함
   String mailBox = (String) request.getAttribute("mailBox");
   
   
   System.out.println("jsp로 넘어온 mailBox: " + mailBox);
%>

<% 
   if(memId.equals("admin")){
%>      
   <%@include file="/manager/managerSide.jsp" %>
<%
   }else {
%>
   <%@include file="/memberSide.jsp" %>
<%   
   }
%>

<style>
.msgdesign {
   padding: 5%;
   margin: 5%;
}
</style>

<!-- <form action="./mailDelete.do" method="post" class="mailList"> --> 
   
    <div id="work_banner" class="banner-wrapper bg-light w-100 py-5" style="
    height: 340px";>
      <div class="banner-vertical-center-work container text-light d-flex justify-content-center align-items-center py-5 p-0">
      <div class="banner-content col-lg-8 col-12 m-lg=auto text-center">      
      <div style="text-align: center;">
      <img src="../assets/img/email.png" style="width:140px; height:140px;">
      <%
         if(memId.equals("admin")){
      %>
         <h1 class="banner-heading h2 display-3 pb-5 semi-bold-600">문의사항관리</h1>
      <%
         }else{
      %>
         <h1 class="banner-heading h2 display-3 pb-5 semi-bold-600">나의 쪽지함</h1>
      <%      
         }
      %>
      </div>
      </div>
      </div>
      </div>
   <div class=msgdesign style="margin-top:0px;">
      <div class="row px-lg-3">
         <!--    <div class="container mt-3"> -->

         <div class="card text-center">
            <div class="card-header" style="height: 62px;">
               <ul class="nav nav-tabs card-header-tabs">
               <%
                  if(memId.equals("admin")){
               %>
                  <li class="nav-item">
                     <a class="nav-link" aria-current="true" href="<%=application.getContextPath()%>/mail/mailReceiveList.do?mailbox=receive">문의사항</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" href="<%=application.getContextPath()%>/mail/mailSendList.do?mailbox=send">답변완료</a>
                  </li>
               <%
                  }else{
               %>
                  <li class="nav-item">
                     <a class="nav-link" aria-current="true" href="<%=application.getContextPath()%>/mail/mailReceiveList.do?mailbox=receive">받은쪽지함</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" href="<%=application.getContextPath()%>/mail/mailSendList.do?mailbox=send">보낸쪽지함</a>
                  </li>
               <%      
                  }
               %>

               </ul>
            </div>
            <div class="card-body">
               <table class="table">
               <thead>
                  <tr>
                     <th scope="col">내용</th>
                     <%if(mailBox.equals("send")){
                     %>
                     <th scope="col">보낸사람</th>
                     <%
                     }else{
                     %>
                     <th scope="col">받는사람</th>
                     <%
                     }
                     %>
                     <th scope="col">날짜</th>
                     <th scope="col">삭제</th>
                  </tr>
                  </thead>
                  <tbody>
                  <%
                  int mailSize = mailList.size();
                  if (mailSize > 0) {
                     for(int i = 0; i < mailSize; i++) {
                  %>
                  <tr>
                     <td><a class="nav-link" onclick="f_winOpen2(<%=mailList.get(i).getMailNo()%>)" style="cursor:pointer;"><%=mailList.get(i).getMailCon()%></td></a>
                     <td>
                     <%if(mailBox.equals("send")){
                     %>
                        <%=mailList.get(i).getMailSender()%>
                     <%
                     }else{
                     %>
                        <%=mailList.get(i).getMailReceiver()%>
                     <%
                     }
                     %>   
                     </td>
                     <td><%=mailList.get(i).getMailDate()%></td>
                     
                     <td>
                        <a href="<%=request.getContextPath()%>/mail/mailDelete.do?mailNo=<%=mailList.get(i).getMailNo() %>"><input type="button" id="delMail" class="btn btn-primary" value="삭제"></a>
                     </td>
                  
                  </tr>
                  <%
                     } //for문
                  } else {
                  %>
                  <tr>
                  <%
                     if(memId.equals("admin")){
                  %>
                     <td>문의사항이 없습니다.</td>
                  
                  <%
                     }else{
                  %>
                     <td>쪽지함이 텅 비었습니다.</td>
                  <%
                     }
                  %>
                  </tr>

                  <%
                     } //if문 닫기
                  %>
                  </tbody>
               </table>

            </div>
         </div>

      </div>
      <div class="col" style="padding-top: 10px; padding-left:5px; padding-right:5px;">
                  <%
         if(memId.equals("admin")){
      %>
               <a href="/DDITMATE/main.jsp">
                  <button type="button" class="btn btn-outline-primary" style="float:left;">뒤로가기</button></a>
<!--          <input type="button" id="test" class="btn btn-primary" value="답변하기" onclick="f_winOpen1()" style="float:right;"> -->
      <%
         }else{
      %>
               <a href="/DDITMATE/main.jsp">
                  <button type="button" class="btn btn-outline-primary" style="float:left;">뒤로가기</button></a>
         <input type="button" id="test" class="btn btn-primary" value="쪽지보내기" onclick="f_winOpen1()" style="float:right;">
      <%      
         }
      %>
      </div>
<!--                <a href="/DDITMATE/mailSend.jsp"> -->
               
<!--                <input type="button" id="test" class="btn btn-primary" value="쪽지보내기"></a> -->
   </div>


<%@include file="/footer.jsp" %>   
<script>

var v_win1;
var v_win2;
function f_winOpen1(){
    v_win1 = open("/DDITMATE/mail/mailSend.do","winNew1","width=500, height=500, top=100, left=100"); 
}
function f_winOpen2(mailNo){
    v_win2 = open("/DDITMATE/mail/mailDetail.do?mailNo="+ mailNo,"winNew2","width=500, height=500, top=100, left=100"); 
}

function reload(){
   location.reload();
}


// function f_winClose1(){
//    v_win.close();
// }
// function f_winClose2(){
//    v_win.close();
// }

$('#delMail').on('click',function(){
   let conf = confirm("정말로 삭제하시겠습니까?");
   if(conf == true){
      alert("삭제가 완료되었습니다.");
      return true;
   }else{
      return false;
   }
});

   
</script>   

<!--  </form>  -->
<!-- </div> -->