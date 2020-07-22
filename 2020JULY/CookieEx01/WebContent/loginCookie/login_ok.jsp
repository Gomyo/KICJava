<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>

<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	String validId = "gomyo";
	String validPw = "12345";
	
	int flag = 2;
	int result = 0;

	if (id.equals(validId) && password.equals(validPw)) {
		flag = 0;
		
		Cookie cookie1 = new Cookie("c_id",id);
		Cookie cookie2 = new Cookie("c_grade","SS등급");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
	} else {
		out.println("회원 정보가 없습니다.");
	}
		
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('로그인에 성공했습니다.');");
		out.println("location.href='./login_complete.jsp';");	
	} else {
		out.println("alert('로그인에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>