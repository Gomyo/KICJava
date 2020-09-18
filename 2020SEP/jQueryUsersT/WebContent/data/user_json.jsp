<%@page import="java.util.ArrayList"%>
<%@page import="model1.*"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
   
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>

<%	
	request.setCharacterEncoding("utf-8");
	
	JSONArray jsonArray = new JSONArray();
	
	UserDAO dao = new UserDAO();
	
	int flag = 0;
	
	ArrayList<UserTO> lists = dao.allUserInfo();
	
	for (UserTO to : lists) {
		JSONObject obj = new JSONObject();
		
		obj.put("seq", to.getSeq());
		obj.put("name", to.getName());
		obj.put("email", to.getEmail());
		obj.put("password", to.getPassword());
		
		jsonArray.add(obj);
	}
	out.println(jsonArray);
%>