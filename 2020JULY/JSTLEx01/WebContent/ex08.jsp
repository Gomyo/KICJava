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
<c:set var='intArr' value='<%= new int[] {1,2,3,4,5} %>'></c:set>
<c:out value="${ intArr[0] }"></c:out><br>
<c:out value="${ intArr[1] }"></c:out><br>
<c:out value="${ intArr[3] }"></c:out><br>

<c:forEach var="data" items="${ intArr }" begin="2" end="4" varStatus="status">
<c:out value="${ data }"/> /${ status.index } - ${ status.count } <br>
</c:forEach>

<c:set var="hm1" value="<%=new java.util.HashMap<>() %>"/>
<c:set target="${ hm1 }" property="name" value="홍길동"/>
<c:set target="${ hm1 }" property="today" value="<%=new java.util.Date() %>"/>

<c:forEach var='i' items="${ hm1 }">
	${ i.key } = ${ i.value }<br>
</c:forEach>

<c:set var="hm2" value="${ hm1 }"/>

<c:forEach var='i' items="${ hm2 }">
	${ i.key } = ${ i.value }<br>
</c:forEach>



</body>
</html>