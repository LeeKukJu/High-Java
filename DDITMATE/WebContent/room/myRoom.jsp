<%@page import="room.vo.RoomMemberVO"%>
<%@page import="room.vo.RoomVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="util.pagingUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<style>
th, td {
	vertical-align: middle;
}
</style>

<%
String memId = (String) session.getAttribute("memId");
System.out.println("로그인 아이디: " + memId);
%>
<%
	if (memId.equals("admin")) {
%>
<%@include file="/manager/managerSide.jsp"%>
<%
	} else {
%>
<%@include file="/memberSide.jsp"%>
<%
	}
%>

<%
List<RoomMemberVO> roomMemberList = (List<RoomMemberVO>) request.getAttribute("roomMemberList");
int roomMaster = Integer.parseInt((String.valueOf(request.getAttribute("roomMaster"))));
%>

<div class="container-fluid" style="padding: 50px 70px 50px 100px;">
        <div class="row" style="margin: 30px 5px;">
            <div class="card" style="max-width: 90%;">
                <div class="card-header">
                	<div class="row">
                		<div class="col-6">
                    		<h4 style="margin: auto;">모임명: <%=roomMemberList.get(0).getRoomTitle() %></h4>
                		</div>
                		<div class="col-6 text-end">
                 	 		<h5 style="margin: auto;">모임 생성일: <%=roomMemberList.get(0).getRoomDate() %></h5>
                		</div>
                	</div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-3">
                            <div style="margin: 15px 1px;"><a class="btn btn-primary" href="../calendar/calendar.do?roomCode=<%=roomMemberList.get(0).getRoomCode()%>" target="_blank" role="button">모임 캘린더</a>
                            </div>
                            <div style="margin: 15px 1px;"><a class="btn btn-primary" href="roomBoard.do?cateCode=<%="r001"%>&roomCode=<%=roomMemberList.get(0).getRoomCode()%>&roomMaster=<%=roomMaster%>" role="button">모임 게시판</a>
                            </div>
                        </div>
                        <div class="col-9">
                            <table class="table table-sm table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th width="10%">이름</th>
                                        <th width="25%">전화번호</th>
                                        <th width="35%">이메일</th>
                                        <th width="20%">수강시작일</th>
                                        <th width="10%">관리</th>
                                    </tr>
                                </thead>
                                <tbody style="font-size: 15px;">
                                <%
                                int roomMemberListSize = roomMemberList.size();
                                if(roomMemberListSize > 0){
                                	for (RoomMemberVO rmv : roomMemberList){
                                %>
                                    <tr>
                                        <td><%=rmv.getMemName()%></td>
                                        <td><%=rmv.getMemTel() %></td>
                                        <td><%=rmv.getMemEmail() %></td>
                                        <td><%=rmv.getMemDate() %></td>
                                        <%
                                        if(roomMaster == 0){
                                        	if(memId.equals(rmv.getMemId())){
                                        %>
                                        <td></td>
                                        <%		
                                        	}else{
                                        %>
                                        <td><a href="deletRoomMember.do?roomCode=<%=rmv.getRoomCode()%>&memberId=<%=rmv.getMemId()%>&roomMaster=<%=roomMaster%>"><button type="button" class="msg btn btn-secondary btn-sm">강퇴</button></a></td>
                                        <%		
                                        	}
                                        }else{
                                        %>
                                        <td></td>
                                        <%
                                        }
                                        %>
                                    </tr>
                                <%		
                                	}
                                }
                                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row" style="margin-top: 30px">
<!--             <div class="card"> -->
<!--                 <div class="card-header" style="display: flex; justify-content: center; "> -->
<!--                     <h4 style="margin: auto;">모임 게시판</h4> -->
<!--                 </div> -->
<!--                 <div class="card-body"> -->
<!--                     <table class="table table-sm table-striped"> -->
<!--                         <thead> -->
<!--                             <tr> -->
<!--                                 <th>이름</th> -->
<!--                                 <th>전화번호</th> -->
<!--                                 <th>이메일</th> -->
<!--                                 <th>수강시작일</th> -->
<!--                             </tr> -->
<!--                         </thead> -->
<!--                         <tbody style="font-size: 15px;"> -->
<!--                             <tr> -->
<!--                                 <td>이국주</td> -->
<!--                                 <td>010-4454-3546</td> -->
<!--                                 <td>ckzmfk19@kakao.com</td> -->
<!--                                 <td>22/10/04</td> -->
<!--                             </tr> -->
<!--                         </tbody> -->
<!--                     </table> -->
<!--                 </div> -->
<!--             </div> -->
        </div>
    </div>
<!-- End Content -->


<section class="container py-5"></section>

<script>
$('.msg').on('click',function(){
    let modifyBo = confirm("강퇴하시겠습니까?")
    if(modifyBo == true){
       return true;
    }
    else{
       return false;
    }

});

</script>
<%@include file="/footer.jsp"%>