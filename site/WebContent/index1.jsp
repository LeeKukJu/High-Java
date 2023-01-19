<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="./includ/header.jsp" %>
  
<%@include file="./includ/aside1.jsp" %>

<%
	String joinCd = (String)request.getAttribute("joinCode");
	if(joinCd == "yes"){
		//회원가입페이지
%>
		<%@include file="join.jsp" %>
<%		
	}else{
		//기존페이지
%>		
	조인코드[<%=request.getAttribute("joinCode") %>]
	로그인코드[<%=session.getAttribute("loginCode") %>]
	
	<%@include file="board.jsp" %>
<!-- 		<!--     본문시작 -->
<!-- 	    <div class="col-sm-8 text-left">  -->
<!-- 	      <h1>Welcome</h1> -->
<!-- 	      <p>Main Page</p> -->
<!-- 	      <hr> -->
<!-- 	      <h3>Test</h3> -->
<!-- 	      <p>Lorem ipsum...</p> -->
<!-- 	    </div> -->
<!-- 	<!--     본문끝 -->
<%	
	}
%>

    
<%@include file="./includ/aside2.jsp" %>

<%@include file="./includ/footer.jsp" %>

</body>
</html>