<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="false" %>
<%
	out.println("버퍼크기 : "+out.getBufferSize()+"<br>");
	out.println("남은버퍼 : "+out.getRemaining()+"<br>");

	for (int i=1; i<1000; i++) {
		out.println(i+"hello jsp<br>");
	}
%>