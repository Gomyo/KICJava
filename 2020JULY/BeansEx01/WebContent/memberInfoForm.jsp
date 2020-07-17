<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="memberInfo" class="pack1.memberInfo"/>
	<jsp:setProperty name="memberInfo" property="*"/>
	<jsp:setProperty name="memberInfo" property="password" value='<%=memberInfo.getPassword() %>'/>
<!DOCTYPE html>
<html>
<head>
<title>가입</title>
</head>
<body>
<table width="400" border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>아이디</td>
		<td><jsp:getProperty name="memberInfo" property="id"/></td>
		<td>암호</td>
		<td><jsp:getProperty name="memberInfo" property="password"/></td>
		<td>이름</td>
		<td><jsp:getProperty name="memberInfo" property="name"/></td>
		<td>이메일</td>
		<td><jsp:getProperty name="memberInfo" property="email"/></td>
		<td>회원가입 시간</td>
		<td><jsp:getProperty name="memberInfo" property="registerDate"/></td>
	</tr>
</table>
</body>
</html>