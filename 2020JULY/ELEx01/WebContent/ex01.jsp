<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border='1' width='600'>
	<tr>
		<td></td>
		<td><%= 2 %></td>
	</tr>
	<tr>
<!-- 		무력화시키려면 역슬래시 하나  -->
		<td>\${ 2 } / \${ "2" } </td>
		<td>${ 2 } / ${ "2" }</td>
		
	</tr>
	<tr>
		<td>\${2 + 5} </td>
		<td>${2 + 5} </td>
	</tr>
	<tr>
		<td>\${2 mod 5} </td>
		<td>${2 mod 5} </td>
	</tr>
	<tr>
		<td>\${"10" + 1} </td>
		<td>${"10" + 1} </td>
	</tr>
	<tr>
		<td>\${"10" + "1"} </td>
		<td>${"10" + "1"} </td>
	</tr>
	<tr>
		<td>\${null + 1} </td>
		<td>${null + 1} </td>
	</tr>
	<tr>
		<td>\${2 < 3} </td>
		<td>${2 < 3} </td>
	</tr>
	<tr>
		<td>\${2 lt 3} </td>
		<td>${2 lt 3} </td>
	</tr>
	<tr>
		<td>\${2 gt 3} </td>
		<td>${2 gt 3} </td>
	</tr>
	<tr>
		<td>\${empty data} </td>
		<td>${empty data} </td>
	</tr>
	<tr>
		<td>\${2<3 ? "작다":"크다"} </td>
		<td>${2<3 ? "작다":"크다"} </td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td>\${"일" + 1} </td> -->
<%-- 		<td>${"일" + 1} </td> --%>
<!-- 	</tr> -->
</table>
</body>
</html>