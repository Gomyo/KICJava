<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="albummodel1.CommentDAO" %>
<%@ page import="albummodel1.CommentTO" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%
	request.setCharacterEncoding( "utf-8" );
	
	String pseq =  request.getParameter( "pseq" );
	
	CommentTO cto = new CommentTO();
	cto.setPseq( request.getParameter( "pseq" ) );		
	cto.setWriter( request.getParameter( "writer" ) );
	cto.setPassword( request.getParameter( "password" ) );
	cto.setContent( request.getParameter( "content" ) );
	CommentDAO cdao = new CommentDAO();
	int flag = cdao.commentWriteOk( cto );
	
	JSONObject obj = new JSONObject();
	obj.put("flag", flag);
	
	out.println(obj);
%>