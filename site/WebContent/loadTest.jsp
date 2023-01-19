<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String uId = request.getParameter("userId");
	String uPw = request.getParameter("userPw");
	
	System.out.print("넘어온 data >>" + uId + uPw);
	
	//JDBC로 응답데이터 만들기
	//실제 회원인지 아닌지 확인을 해서 응답결과에 따른 페이지 만들기
	
	//1. 연결할 DB가 설치되어 있어야 한다. (수업에서는 Oracle사용)
	
	//2. 자바와 DB를 연결하기 위한 라이브러리가 필요하다.(ojdbc.jar)

	//3. Class.forName()을 이용해 드라이버 로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	//4. DriverManager를 이용해 Connection객체 생성	
	//DriverManager.getConnection(url, user, password);
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "sr94", "java");	

	//5. sql구문 실행을 위한 Statement객체 생성
	Statement stmt = conn.createStatement();
	
	//String sql = "회원조회 sql문 작성";
	String sql = "select mem_id from member" 
				+ " where mem_Id = '"+ uId +"'" 
			    + " and mem_pass = '"+ uPw +"'";
	ResultSet rs = stmt.executeQuery(sql);
	//ResultSet에 데이터가 있는지 없는지 .next()를 이용해 boolean으로 리턴 받음
	if(rs.next()){
		//JSON데이터로 결과 있음 코드를 반환하기
		//{"":""}는 문자열이기 때문에 자바스크립트 릿 영역 안에서는 오류가 발생함
%>
		{"rst" : "ok"} 
<%	
}else{
		//JSON데이터로 결과 없음 코드를 반환하기
%>
		{"rst" : "fail"}
<%		
	}
%>