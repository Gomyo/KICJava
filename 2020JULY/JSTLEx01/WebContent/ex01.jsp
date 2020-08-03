<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("data","browser4");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
출력 : <%="browser1" %><br>
출력2 : ${ "browser2" }<br>
출력3 : <c:out value="browser3"></c:out>
출력4 : <% pageContext.getAttribute("data"); %>
</body>
</html>