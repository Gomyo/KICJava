<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@page import="javax.sql.DataSource" %>    

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String html = "";
	try {
		// JNDI 자바 네이밍 디렉토리 인터페이스 - connection pooling
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		// 컨텍스트 네임을 찾고
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb");
		// 데이터 타입을 리턴
		conn = dataSource.getConnection();
		
		String sql = "insert into dept values (?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,"80");
		pstmt.setString(2,"연구");
		pstmt.setString(3,"서울");
		
		// 영향받은 행수
		int result = pstmt.executeUpdate();
		html = result + " 행이 입력되었습니다.";
		
		
	} catch (NamingException e) {
		System.out.println("[에러] : "+e.getMessage());
	} catch (SQLException e) {
		System.out.println("[에러] : "+e.getMessage());
	} finally {
		if(conn != null) conn.close();
		if(pstmt != null) pstmt.close();
	}
%>
<!-- 위의 코드는 Context.xml을 가져오기 위한 import -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= html %>
</body>
</html>