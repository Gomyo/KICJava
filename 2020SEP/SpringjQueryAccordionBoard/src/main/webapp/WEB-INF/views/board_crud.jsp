<%@page import="org.json.simple.JSONObject"%>
<%@page import="model1.BoardTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	JSONObject obj = new JSONObject();
	int flag =  (Integer)request.getAttribute("flag");
	
	obj.put("flag", flag);
	
	out.println(obj);
%>