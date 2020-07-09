<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String html = "";
	html += "<!DOCTYPE html>";
	html += "<html>";
	html += "<head>";
	html += "<meta charset=\"utf-8\">";
	html += "<title>Insert title here</title>";
	html += "</head>";
	html += "<body>";
	html += "<b>Hello JSP</b>";
	html += "</body>";
	html += "</html>";
%>s
<%= html %>
	<!-- out.println(html); -->
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello JSP
<%
	// debugging
	// console log
	System.out.println("Hello JSP");
	out.println("<b>Hello JSP</b>");
	
%>
</body>
</html>
-->