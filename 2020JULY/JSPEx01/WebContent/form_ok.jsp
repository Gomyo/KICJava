<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String data1 = request.getParameter("data1");
	String data2 = request.getParameter("data2");
	String pw = request.getParameter("pw");
	String sel = request.getParameter("sel");
	
	out.println( "데이터 :"+data1+"<br>");
	out.println( "데이터 :"+data2+"<br>");
	out.println( "비밀버노"+pw+"<br>");
	out.println( "과일 :"+sel+"<br>");
%>