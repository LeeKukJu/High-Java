<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.HashMap"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 1. serializeArray()를 통해 object Array형태의 데이터가 넘어옴
// 2. beanutils로 vo에 자동 매핑 시키기 위해 데이터 변환 처리 필요
// 3. gson 라이브러리 사용
//		java에 대한 json변환을 지원하는 라이브러리
//		java객체 => json >>> 직렬화, serializing, marshal
//		json => java객체 >>> 역직렬화, deserializing, unmarshal

	
	//버퍼를 이용한 입출력 객체로 데이터 읽어오기
	BufferedReader rd = request.getReader();
	String jsonData = rd.readLine();
	System.out.print("넘어오는 객체배열(=json) 값: " + jsonData);
	
	Map<String, Object> map = new HashMap<>();
	MemberVO vo = new MemberVO();	
	
	//역직렬화
	JsonParser jp = new JsonParser();
	JsonArray jsonArr = (JsonArray)jp.parse(jsonData);
	for(int i =0; i<jsonArr.size(); i++){
		JsonObject jsonObj = (JsonObject)jsonArr.get(i);
		String key = jsonObj.get("name").getAsString();
		String value = jsonObj.get("value").getAsString();
		map.put(key, value);
	}
	BeanUtils.populate(vo, map);
	
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
