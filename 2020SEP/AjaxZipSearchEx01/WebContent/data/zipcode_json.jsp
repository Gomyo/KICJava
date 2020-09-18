<%@page import="java.util.ArrayList"%>
<%@page import="model1.ZipcodeTO"%>
<%@page import="model1.ZipcodeDAO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>

<%	
	request.setCharacterEncoding("utf-8");
	String strDong = request.getParameter("dong"); // 이렇게 해 두면, zipcode_json.jsp?dong=입력값으로 검색하게 된다!
	
	JSONArray jsonArray = new JSONArray();
	
	ZipcodeTO pto = new ZipcodeTO();
	pto.setDong(strDong);
	
	ZipcodeDAO dao = new ZipcodeDAO();
	ArrayList<ZipcodeTO> lists = dao.allZipcode(pto);
	
	for (ZipcodeTO to : lists) {
		JSONObject obj = new JSONObject();
		
		obj.put("zipcode", to.getZipcode());
		obj.put("sido", to.getSido());
		obj.put("gugun", to.getGugun());
		obj.put("dong", to.getDong());
		obj.put("ri", to.getRi());
		obj.put("bunji", to.getBunji());
		
		jsonArray.add(obj);
	}
	out.println(jsonArray);
%>