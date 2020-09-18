<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject"%>

<% 
	JSONArray jsonArray = new JSONArray();
	JSONObject obj1 = new JSONObject();
	JSONObject obj2 = new JSONObject();
	JSONObject obj3 = new JSONObject();
	JSONObject obj4 = new JSONObject();
        
	obj1.put("name", "모던 웰 디자인을 위한 HTML5 + CSS3 입문");
	obj1.put("publisher", "한빛미디어");
	obj1.put("author", "윤인성");
	obj1.put("price", "30000 원");
	
	obj2.put("name", "모던 웹을 위한 JavaScript + jQuery 입문");
	obj2.put("publisher", "한빛미디어");
	obj2.put("author", "윤인성");
	obj2.put("price", "32000 원");
	
	obj3.put("name", "모던 웹을 위한 node.j 5 프로그래밍");
	obj3.put("publisher", "한빛미디어");
	obj3.put("author", "윤인성");
	obj3.put("price", "22000 원");
	
	obj4.put("name", "모던 웹을 위한 HTML5 프로그래밍");
	obj4.put("publisher", "한빛미디어");
	obj4.put("author", "윤인성");
	obj4.put("price", "30000 원");
	
	jsonArray.add(obj1);
	jsonArray.add(obj2);
	jsonArray.add(obj3);
	jsonArray.add(obj4);
	
	out.println(jsonArray);
%>