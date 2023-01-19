<%@page import="calendar.vo.CalendarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String roomCode = (String) request.getAttribute("roomCode");
%>
<%
	String calMemo = "일정";
%>
<!-- calList를 쓰기위함 -->
<%List<CalendarVO> calList = (List<CalendarVO>) request.getAttribute("calList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<title>모임방 캘린더</title>

<style>
	html, body {
		margin: 0;
		padding: 0;
		font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
		font-size: 14px;
	}
	
	#calendar {
		max-width: 1100px;
		margin: 40px auto;
	}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js'></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>


<script>
	$(document).ready(function(){
		//일정등록버튼임
		$("#btnAdd").on("click", function(){
			
			//console.log('eee');
			 /* calendar.addEvent({
		           title: $('#title').val(),
		           start: $('#start').val(),
//		           end: $('#end').val(),
		           //allDay: event.allDay
		         }); */
			
			 console.log("data", $("#frm1").serialize());
			// 등록작업 시작... //ajax는  내부 데이터로 가는것임
			
		 	$.ajax({
// 	          url: "./calendar/checkNo.jsp",
			//InsertCalendarController.java의 url임
	          url: "<%=request.getContextPath() %>/calendar/insert.do",
	          type: "POST",
	        //모달의 idsms frm1
	          data: $("#frm1").serialize(),
	          dataType: "json", // dataType을 명시해주면 response데이터를 해당 타입으로 컨버전 해준다.(json | xml) , 기본값은 text
	          success : function(result, status){
	       
	        	  //InsertCalendarController.java에서 성공인지 실패인지 표시 해야함.
	        	  console.log("result", result);
// 	          	console.log(result, status);
	          	
	          	//종일:
	          	//성공했다고 출력하고
	          	//window.location.href="/현재창"
	          	
	          	
	        	//출력위치 셀렉터를 잡고 반환된 정보를 넣어주기..... 	
	        	  console.log("ddd111");
	        	  
	        	  var obj = new Object();
	        	  obj.id = result.calNo;
	        	  obj.title = $("input[name=calTitle]").val();
	        	  obj.start = $("input[name=calStart]").val();
	        	  obj.end = $("input[name=calEnd]").val();
	        	  
	        	  
	        	  calendar.addEvent(obj);
	        	  
	          
	          },
	          error : function(xhr, status, error){
	  			console.log(status, error);
	          }
	      });
			// 등록 후 창닫기
			$("#btnClose").trigger("click");
		}); 
		
//	});
	
	
////////////////////////////////////////////////////////////////////////////////////
	
	
	<%-- //일정수정버튼임
			$("#btnModify").on("click", function(){
			
			 console.log("data", $("#frm1").serialize());
			// 등록작업 시작... //ajax는  내부 데이터로 가는것임
			
		 	$.ajax({
// 	          url: "./calendar/checkNo.jsp",
			//InsertCalendarController.java의 url임
	          url: "<%=request.getContextPath() %>/calendar/calendar.do",
	          type: "POST",
	        //모달의 idsms frm1
	          data: $("#frm1").serialize(),
	          dataType: "json", // dataType을 명시해주면 response데이터를 해당 타입으로 컨버전 해준다.(json | xml) , 기본값은 text
	          success : function(result, status){
	       
	        	 //InsertCalendarController.java에서 성공인지 실패인지 표시 해야함.
	        	console.log("result", result);
// 	          	console.log(result, status);
	          	
	          	//종일:
	          	//성공했다고 출력하고
	          	//window.location.href="/현재창"
	          	
	          	
	        	//출력위치 셀렉터를 잡고 반환된 정보를 넣어주기..... 	
	        	  
	        	  var obj = new Object();
	        	  obj.title = $("input[name=calTitle]").val();
	        	  obj.start = $("input[name=calStart]").val();
	        	  obj.end = $("input[name=calEnd]").val();
	        	  
	        	  
	        	  calendar.addEvent(obj);
	        	  
	                
	                console.log("콘솔나오니2");
	          	
	          
	          },
	          error : function(xhr, status, error){
	  			console.log(status, error);
	          }
	      });
			// 등록 후 창닫기
			$("#btnClose").trigger("click");
		}); --%>
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////		
});	
	
	
</script>

</head>
<body>
	<div id='calendar'></div>
	
	<!-- Button trigger modal -->
<button  id="btnModal" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" style="display:none;">
  Launch demo modal
</button>

<!-- Modal start -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	<form name="frm1" id="frm1" action="<%=request.getContextPath() %>/calendar/insert.do" method="post">
        		 <div class="form-group">
        			<label for="title">title</label>
        			
        			<input type="hidden" name="roomCode" value="<%=roomCode%>">
        			<input type="hidden" name="calMemo" value="<%=calMemo%>">
        			<input id="title"  class="form-control"  name="calTitle">
				  </div>
				   <div class="form-group">
	        			<label for="start">startTime</label>
	        			<input id="start" type="datetime-local"  class="form-control" name="calStart">
				   </div>
				    <div class="form-group">
	        			<label for="end">endTime</label>
	        			<input id="end" type="datetime-local"  class="form-control" name="calEnd">	
				    </div>	  
        	</form>
      </div>
      <div class="modal-footer">
      
      
        <button id="btnClose" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button id="btnAdd" type="button" class="btn btn-primary">일정 등록</button>
        
        <!-- 일정수정 버튼 추가 -->
<!--         <button id="btnModify" type="button" class="btn btn-primary">일정 수정</button> -->
        
      </div>
    </div>
  </div>
</div>
<!-- Modal end -->



<script>
var calendar;
  document.addEventListener('DOMContentLoaded', function() {
	  
    var calendarEl = document.getElementById('calendar');
    
    const nowStr = new Date().toISOString().substring(0, 10); // 오늘 날짜 문자열

    calendar = new FullCalendar.Calendar(calendarEl, {
      initialView: 'dayGridMonth',
      now: nowStr,
      editable: true,
      selectable: true,
      headerToolbar: {
        left: 'addEventButton',
    	center: 'title',
      },
      
      
      
      
      eventClick: function(e) { // 일정을 클릭했을 경우...
    	  
        console.log(e.event.id);
        console.log(e.event.title);
        console.log(e.event.start);
        console.log(e.event.end);
 
        // 삭제처리하기(이벤트(일정)객체의 remove메서드 사용)
        if(confirm("'"+ e.event.title +"' 일정이 삭제되었습니다.")){
        	
        //얘만 원래있던아이
        e.event.remove(); //evnet전체리무브때문에 id값 지워지나??? 의심..
        console.log(">>>>>",e.event.id);
        var events = new Array();
        var obj = new Object();
        	obj.id = e.event.id;
        	obj.title = e.event._def.title;
        	obj.start = e.event._instance.range.start;
        	obj.end = e.event._instance.range.end;
        	events.push(obj);
        
       	console.log(events);
        }
        $(function deleteData(){
        	
        	$.ajax({
        		url: "<%=request.getContextPath()%>/calendar/delete.do",
        		method: "POST",
        		data:  {'calNo' : e.event.id},
        		dataType: "json"
        		
        		//이부분 때문에 안나옴
        		/* success : function(result, status){
        			
        	 	obj.id = $("e.event.id").val();

        	  
        	  	calendar.deleteEvent(obj); 

        		} 
        		 */
        	})
        	
              
          console.log("데이터삭제된거 맞음");
        })
/////////////////////////////////////////////////////////////////////////////////////////
<%--         $(document).ready(function(){
    		//일정등록버튼임
    		$("#btnAdd").on("click", function(){
    			 console.log("data", $("#frm1").serialize());
    			// 등록작업 시작... //ajax는  내부 데이터로 가는것임
    			
    		 	$.ajax({
//     	          url: "./calendar/checkNo.jsp",
    			//InsertCalendarController.java의 url임
    	          url: "<%=request.getContextPath() %>/calendar/insert.do",
    	          type: "POST",
    	        //모달의 idsms frm1
    	          data: $("#frm1").serialize(),
    	          dataType: "json", // dataType을 명시해주면 response데이터를 해당 타입으로 컨버전 해준다.(json | xml) , 기본값은 text
    	          success : function(result, status){
        
    	        	  //InsertCalendarController.java에서 성공인지 실패인지 표시 해야함.
    	        	  console.log("result", result);
//     	          	console.log(result, status);
    	          	
    	          	//종일:
    	          	//성공했다고 출력하고
    	          	//window.location.href="/현재창"
    	          	
    	          	
    	        	//출력위치 셀렉터를 잡고 반환된 정보를 넣어주기..... 	
    	          	 console.log("ddd111");
    	        	  calendar.addEvent({
    	                  title: '신규일정(선택됨)',
    	                  start: '2023-01-12T00:30:00',
    	                  end: '2023-01-12T00:30:00'    	                  
    	                });
    	                
    	                console.log("ddd222");
    	          
    	          },
    	          error : function(xhr, status, error){
    	  			console.log(status, error);
    	          }
    	      });
    			// 등록 후 창닫기
    			$("#btnClose").trigger("click");
    		}); 
    		
    	}); --%>
///////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        
        
        
        
 //      $("input[name=title]").val('안녕하세요.');
 //        $("#btnModal").trigger("click"); // 일정추가용 모달창 띄우기
        
      },
      
      
      
      //선택시 기존 항목 수정 예정 (근데 모달창 안뜸)
       select: function(event) {// 해당일자를 선택한 경우... 
    	  
		console.log(event.start);
		console.log(event.end);
		console.log(event.allDay);
		
		
		/* // 생성하기
		 calendar.addEvent({
           title: '신규일정(선택됨)',
           start: event.start,
           end: event.end
           //allDay: event.allDay
         });
		
		// calendar.render(); */
		
      },
      
      customButtons: {
        addEventButton: {
          text: '일정추가',
          click: function() {
        	  $("#btnModal").trigger("click"); // 일정추가용 모달창 띄우기
        	 // window.open("addSchejule.jsp");
        	  return;
  
        	var dateStr = prompt('Enter a date in YYYY-MM-DD format');
            var date = new Date(dateStr + 'T00:00:00'); // will be in local time

            if (!isNaN(date.valueOf())) { // valid?
              calendar.addEvent({
                title: '신규일정',
                start: date,
                end: end,
                allDay: true
              });
              alert('Great. Now, update your database...');
            } else {
              alert('Invalid date.');
            }
          }
        }
      }
      //////////////////////////////////리스트보이기//////////////////////////////////////
      ,events: [
   		  <%
    	  int calendarSize = calList.size();
    	  if(calendarSize > 0){
    		 int cnt = 0;
    	  	for(CalendarVO cv : calList){
    	  		if(cnt == 0){
    	  %>
    	  	{ id: '<%=cv.getCalNo()%>', start: '<%=cv.getCalStart()%>', end: '<%=cv.getCalEnd()%>', title: '<%=cv.getCalTitle()%>' }
    	  
    	  <%
    	  		}else{
    	  			
    	  %>
    	  ,{ id: '<%=cv.getCalNo()%>', start: '<%=cv.getCalStart()%>', end: '<%=cv.getCalEnd()%>', title: '<%=cv.getCalTitle()%>' }
    	  
    	  <%
    	  			
    	  		}
    	  		
    	  		cnt++;
    	  	}
    	  }  
    	  %> 
    	  
    	  /* //이런형대라고 보면 됨 for문 이용해서 만들기해야함
          { id: '2', start: '2023-01-07T15:00:00', end: '2023-01-07T22:00:00', title: '일정 2' },
          { id: '3', start: '2023-01-06', end: '2023-01-08', title: '일정 3' },
          { id: '4', start: '2023-01-07T03:00:00', end: '2023-01-17T08:00:00', title: '일정 4' },
          { id: '5', start: '2023-01-07T00:30:00', end: '2023-01-07T02:30:00', title: '일정 5' },
          { id: '6', start: '2023-01-10T00:30:00', end: '2023-01-011T02:30:00', title: '이정테스ㅡㄴㅇㄹㄴ' } */
        ]      
    });

    calendar.render(); // 캘린더 그리기
    
   //캘린더 객체를 이용한 데이터 가져오기 (getEventById 이용)
  //console.log(calendar.getEventById('3').id); 
  //console.log(calendar.getEventById('3').title); 
  //console.log(calendar.getEventById('3').start);
  });
  
  
  

</script>

</body>

</html>
