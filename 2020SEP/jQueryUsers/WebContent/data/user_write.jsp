<%@page import="model1.*"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	request.setCharacterEncoding("utf-8");
	
	UserTO to = new UserTO();
	
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	UserDAO dao = new UserDAO();
	int flag = dao.userWriteOk(to);
%>