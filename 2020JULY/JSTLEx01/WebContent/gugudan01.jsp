<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuGuGuGuGuGu</title>
</head>
<body>

<table border='1' width='800'>
	<c:forEach var='i' begin='0' end='9' step='1'>
		<tr>
			<c:forEach var='j' begin='0' end='9' step='1'>
				<c:choose>
					<c:when test="${i==0 && j== 0 }">
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</c:when>
					<c:when test="${ i == 0 }">
						<td align="center"> X ${ j }</td>
					</c:when>
					<c:when test="${ j == 0 }">
						<td align="center"> ${ i } 단 </td>
					</c:when>
					<c:otherwise>
						<td align="center"> ${ i } X ${ j } = ${ i * j }</td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</c:forEach>
</table>

</body>
</html>