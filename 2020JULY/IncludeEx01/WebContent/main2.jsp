<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("시작<br/>");
	String data = "Hello Include";
%>
	<%@ include file="sub2.jspf" %>
<% 
	out.println("끝<br/>");
%>
</body>
</html>