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
<c:forTokens var="c" items="1,2,3,4,5" delims=",">
	${ c }<br>
</c:forTokens>

<c:set var="data" value="빨,주,노,초.파.남,보"></c:set>
<c:forTokens var="c" items="${ data }" delims=",.">
	데이터 : ${ c } <br>
</c:forTokens>

<c:set var="data" value="홍,김,고"></c:set>
<c:forTokens var="c" items="${ data }" delims=",">
	데이터 : ${ c } <br>
</c:forTokens>
</body>
</html>