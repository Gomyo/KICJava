<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ch9.Cookies" %>
<%
	response.addCookie(Cookies.createCookie("name", "최준원"));
	response.addCookie(Cookies.createCookie("id", "madvirus", "/chap09", -1));
	
	out.println(Cookies.createCookie("name", "최준원"));
	out.println(Cookies.createCookie("id", "madvirus", "/chap09", -1));
%>
<html>
<head>
<meta charset="UTF-8">
<title>Cookies 사용 예</title>
</head>
<body>
Cookies를 사용하여 쿠키 생성
</body>
</html>