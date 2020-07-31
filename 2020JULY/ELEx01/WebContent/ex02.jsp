<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name1 = "고길동";
	pageContext.setAttribute("name2","어사박문수");
%>
이름 : ${name1} <br>
이름 : <%= pageContext.getAttribute("name2") %> <br>
이름 : ${name2} <br>