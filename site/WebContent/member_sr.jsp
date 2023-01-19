<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="vo.MemberVO"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//넘어오는 데이터 받기
	/*
	mem_id=a002
	&mem_pass=Aa002!%40%23
	&mem_name=%EB%82%98%EB%8A%94%EC%97%90%EC%9D%B4
	&mem_bir=2023-01-02&mem_hp=02-1234-1234
	&mem_mail=a002%40google.go.kr
	&mem_add1=06035
	&mem_add1=%EC%84%9C%EC%9A%B8%20%EA%B0%95%EB%82%A8%EA%B5%AC%20%EA%B0%80%EB%A1%9C%EC%88%98%EA%B8%B8%205
	&mem_add2=582-7
	
	key를 이용해 getParameter()로 데이터를 각각 받아야 했지만
	더 편리하게 데이터를 받아주는 라이브러리 - beanutils를 이용한다.
	-주의할 점은 매핑되는 하목의 이름을 동일하게 지정해야 한다.
	 (form의 name속성과 vo의 필드명이 일치해야함)
	*/
	
	MemberVO vo = new MemberVO();

	BeanUtils.populate(vo, request.getParameterMap());
	
// 	String uId = request.getParameter("uId");
// 	System.out.print("넘어온 data >>" + uId);
	
	//JDBC방식으로 DB연결
	
	//드라이버 로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");

	//객체생성
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "sr94", "java");	
	
	//db연결 객체 생성
	Statement stmt = conn.createStatement();
	
	//sql조회 후 결과 데이터 받기
	String sql = "insert into member (" +
			"mem_id, mem_pass, mem_name, mem_bir," +
			"mem_zip, mem_add1, mem_add2, mem_hp, mem_mail" +
			") values(" +
				"'" + vo.getMem_id() + "'," +
				"'" + vo.getMem_pass() + "'," +
				"'" + vo.getMem_name() + "'," +
				"'" + vo.getMem_bir() + "'," +
				"'" + vo.getMem_zip() + "'," +
				"'" + vo.getMem_add1() + "'," +
				"'" + vo.getMem_add2() + "'," +
				"'" + vo.getMem_hp() + "'," +
				"'" + vo.getMem_mail() + "')";
	
	 //SQL 문장 실행 후, 변경된 row 수 int type 리턴
	int rst = stmt.executeUpdate(sql);
%>
<%=rst %>


