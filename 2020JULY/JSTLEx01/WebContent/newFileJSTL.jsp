<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	BoardTO to1 = new BoardTO();
	to1.setSubject("제목1");	
	to1.setWriter("작성자1");	
	
	BoardTO to2 = new BoardTO();
	to2.setSubject("제목2");	
	to2.setWriter("작성자2");

	HashMap<String, BoardTO> lists = new HashMap<String, BoardTO>();
	lists.put("to1", to1);
	lists.put("to2", to2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="d" items="<%= lists %>">
	${ d.key }
	${ d.value.subject }
	${ d.value.writer }
</c:forEach>

<%
	for (String key : lists.keySet()) {
		out.println(key);
		out.println(lists.get(key).getSubject());
		out.println(lists.get(key).getWriter());
	}
%>
</body>
</html>