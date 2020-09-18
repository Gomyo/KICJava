<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="albummodel1.*" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>

<%
	request.setCharacterEncoding( "utf-8" );
	String seq = request.getParameter("pseq");
	
	CommentTO cto = new CommentTO();
	cto.setPseq(seq);
	
	CommentDAO cdao = new CommentDAO();
	ArrayList<CommentTO> lists = cdao.commentList(cto);
	
	JSONArray jsonArray = new JSONArray();
	
	for (CommentTO to : lists) {
		JSONObject obj = new JSONObject();
		
		obj.put("cseq", to.getSeq());
		obj.put("cwriter", to.getWriter());
		obj.put("ccontent", to.getContent());
		obj.put("cwdate", to.getWdate());
		
		jsonArray.add(obj);
	}
	out.println(jsonArray);
%>