<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="vo.MemberVO"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BufferedReader rd = request.getReader();
	String jsonData = rd.readLine();    //Object
	
	JsonParser jp = new JsonParser();
	JsonObject jsonObj = (JsonObject)jp.parse(jsonData);
	
	Map<String, Object> map = new HashMap<>(); 
	MemberVO vo = new MemberVO();
	
	Iterator<String> itr = jsonObj.keySet().iterator();
	//hasNext() - 요소의 존재 확인하기
	while(itr.hasNext()){
		String key = itr.next();	//항목받기
		//key정보를 이용해 value꺼내기
		String value = jsonObj.get(key).getAsString();
		
		map.put(key, value);
	
	}
	BeanUtils.populate(vo, map);
	
	//드라이버로딩 > 객체생성 > db접근 > sql값 받아오기
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "sr94", "java");
	String sql = " insert into member(" +
				 " mem_id, mem_pass, mem_name, mem_bir," +
				 " mem_zip, mem_add1, mem_add2, mem_hp, mem_mail"+
				 " ) values(?,?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, vo.getMem_id());
	pstmt.setString(2, vo.getMem_pass());
	pstmt.setString(3, vo.getMem_name());
	pstmt.setString(4, vo.getMem_bir());
	pstmt.setString(5, vo.getMem_zip());
	pstmt.setString(6, vo.getMem_add1());
	pstmt.setString(7, vo.getMem_add2());
	pstmt.setString(8, vo.getMem_hp());
	pstmt.setString(9, vo.getMem_mail());
	int rst = pstmt.executeUpdate();
	
%>
<%=rst %>
