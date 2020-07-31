<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Enumeration e = request.getHeaderNames();
	while(e.hasMoreElements()) {
		String headerName = (String)e.nextElement();
		String headerValue = request.getHeader(headerName);
		
		out.println(headerName+":"+headerValue + "<br>");
	}
	out.println(request.getHeader("user-agent"));
%>
<hr />
${header['host']}<br>
${header['user-agent']}<br>
${header['host']}<br>

${pageContext.request.remoteAddr}