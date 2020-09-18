<%@page import="org.json.simple.JSONObject"%>
<%@page import="model1.BoardTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	JSONArray jsonArray = new JSONArray();
	
	int flag = 0;
	ArrayList<BoardTO> lists = (ArrayList<BoardTO>)request.getAttribute("boardLists");
	
	for (BoardTO to : lists) {
		JSONObject obj = new JSONObject();
		
		obj.put("seq", to.getSeq());
		obj.put("subject", to.getSubject());
		obj.put("writer", to.getWriter());
		obj.put("mail", to.getMail());
		obj.put("password", to.getPassword());
		obj.put("content", to.getContent());
		
		jsonArray.add(obj);
	}
	JSONObject result = new JSONObject();
	result.put("flag", flag);
	result.put("data", jsonArray);
	
	out.println(result);
%>