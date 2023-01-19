<%@page import="vo.BoardVO"%>
<%@page import="vo.BoardVO1"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.pager{
	float: left;
}
#pageList{
	display: flex;
	justify-content: center;
}
</style>
</head>
<body>
	<div class="col-sm-8 text-left">
		<!-- 글쓰기 영역 -->
		<div>
		<%
			List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
			if(list != null){
			//목록정보 있을 때
			for(int i=0; i<list.size(); i++){
		%>
		<!-- bootstrap accordion 코드 복사해옴 -->
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse<%=i%>"><%=list.get(i).getSubject() %></a>
					</h4>
				</div>
				<div id="collapse<%=i%>" class="panel-collapse collapse">
				<!-- collapse 옆에 in이 붙어있으면 처음에 내용이 보이지 않는 상태로 보여짐 -->
					<div class="panel-body"><%=list.get(i).getContent() %></div>
				</div>
			</div>
		</div>
		<!-- bootstrap accordion 코드 복사해옴 -->
		<%	
			} //for문 end
			
		%>
			
			<!-- 페이징 영역 -->
			<div id="pageList">
				<ul class="pager">
 				 	<li class="previous"><a href="#">Previous</a></li>
 				</ul> 
 				
 				<!-- pagination -->
 				<ul class="pagination pager">
 				<%
 					int sPage = (int)request.getAttribute("sPage");
 					int ePage = (int)request.getAttribute("ePage");
 					int cPage = (int)request.getAttribute("cPage");
 					int ttPage = (int)request.getAttribute("ttPage");
 					
 					for(int i=sPage; i<=ePage; i++){
 						//선택된 페이지 번호 활성화하기
 						if(i == cPage){
 				%>
 					<li class="active"><a href="#"><%=i %></a></li>
 				
 				<%		}else{
 				%>	
 					<li><a href="#"><%=i %></a></li>
 				<% 	
 						} //else end
 					} //for문 end
 				%>
 				</ul>
 					
 				<ul class="pager">
  					<li class="next"><a href="#">Next</a></li>
				</ul>
			</div>
			<!-- 페이징 영역 -->	
			
			
		<%	
		}else{
			//목록정보 없을 때
		%>
		<!-- bootstrap accordion 코드 복사해옴 -->
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse1">제목없음</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse in">
					<div class="panel-body">내용없음</div>
				</div>
			</div>
		</div>
		<!-- bootstrap accordion 코드 복사해옴 -->
		<%
		}
		%>
		</div>
		

			
		</div>
		
<script>
//페이지 번호 클릭 이벤트
$('.pagination li').on('click', function(){
// 	alert($(this).text());
	location.href = "/site/Main?page=" + $(this).text();
});

//이전,다음 버튼 클릭 이벤트
let currentPage="";
//1.다음버튼
$('.next').on('click', function(){ 
	//현재페이지 == 전체 페이지 수 비교하고 같지 않을 떄 
	//+1한 페이지 정보를 Main(페이지처리)서블릿으로 전달
	if(<%=request.getAttribute("cPage")%> == <%=request.getAttribute("ttPage")%>){
		currentPage = <%=request.getAttribute("cPage")%>
		
	}else{
		//currentPage+1 => 서블릿으로 전달하기
		currentPage = <%=request.getAttribute("cPage")%> +1
	}
	location.href="/site/Main?page=" + currentPage;
});

//2.이전버튼
$('.previous').on('click',function(){
	if(<%=request.getAttribute("cPage")%> == <%=request.getAttribute("sPage")%>){
		currentPage = <%=request.getAttribute("cPage")%>
	}else{
		currentPage = <%=request.getAttribute("cPage")%> -1
	}
	location.href="/site/Main?page=" + currentPage;
});
</script>		
</body>
</html>