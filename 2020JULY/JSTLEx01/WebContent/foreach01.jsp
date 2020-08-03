<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5" step="2">
	<c:forEach var="j" begin="1" end="10" step="2">
	Hello JSTL : <c:out value="${ i }"></c:out> / <c:out value="${ j }"></c:out> <br>
	</c:forEach>
</c:forEach> 
</body>
</html>