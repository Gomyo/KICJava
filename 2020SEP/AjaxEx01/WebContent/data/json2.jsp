<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>

<%
	JSONArray jsonArray = new JSONArray();
	
	JSONObject obj1 = new JSONObject();
	obj1.put("name", "모던 웹 어쩌구~");
	obj1.put("publisher", "한빛미디어");
	obj1.put("author", "윤현승");
	obj1.put("price", "10000 원");
	
	jsonArray.add(obj1);
	
	out.println(jsonArray);
%>