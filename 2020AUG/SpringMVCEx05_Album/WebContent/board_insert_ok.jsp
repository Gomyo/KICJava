<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<%
	// 인코딩
	request.setCharacterEncoding("UTF-8");
	// 메일은 받지 않는 경우의 예외 처리를 해 줘야 함
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	int flag = 0;
	// 데이터 100개 넣기
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
		conn = dataSource.getConnection();
		
		// 아래 두줄은 for문에 넣으면 안되지.
		String sql = "insert into album_board1 values(0,?,?,?,?,?,?,?,0,0,?,now())";
		pstmt = conn.prepareStatement(sql);
		for (int i=1; i<=15; i++){
				pstmt.setString(1, "제목"+i);		
				pstmt.setString(2, "이름");		
				pstmt.setString(3, "naver@naver.com");
				pstmt.setString(4, "123");		
				pstmt.setString(5, "내용"+i);
				pstmt.setString(6, null);
				pstmt.setLong(7, 0);
				pstmt.setString(8, "000.000.000.000");	
				pstmt.executeUpdate();
			}
		
	} catch (NamingException e) {
		System.out.println("[write에러] : "+e.getMessage());
	} catch (SQLException e) { 
		System.out.println("[write에러] : "+e.getMessage());
	} finally {
		if (conn != null) conn.close();
		if (pstmt != null) pstmt.close();
	}
%>