<%@page import="model1.BoardTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BoardTO to = new BoardTO();
	to.setSubject("제모옥");
	to.setWriter("자악성자아");
	
// 	pageContext.setAttribute("to", to);
	request.setAttribute("to", to);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println(to.getSubject());
	out.println(to.getWriter());
%>
${to.subject}<br> 
${to.writer }<br>
</body>
</html>