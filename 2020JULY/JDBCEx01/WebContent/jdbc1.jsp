<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<%
	String url = "jdbc:mysql://localhost:3306/sample";
	String user = "root";
	String password = "123456";
	
	out.println("시작<br>");
	try {
		// 라이브러리를 제대로 찾는지 확인하기 위해 씀
		Class.forName("org.mariadb.jdbc.Driver");
		out.println("드라이버 로딩 성공<br>");
	} catch(ClassNotFoundException e) {
		out.println("[에러]"+ e.getMessage() + "<br>");
	} 
	out.println("끝<br>");
%>