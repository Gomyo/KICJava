<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String data = request.getParameter("data");
	out.println(data + "<br/>");
	out.println(request.getAttribute("data1"));
	out.println(request.getAttribute("data0"));
%>