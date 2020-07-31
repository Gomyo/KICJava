<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 보존시간이 다름
	pageContext.setAttribute("name1", "길동");
	request.setAttribute("name2", "김선달");
	session.setAttribute("name3", "허준");
	application.setAttribute("name4", "이순신");
	
	pageContext.setAttribute("name", "길동");
	request.setAttribute("name", "김선달");
	session.setAttribute("name", "허준");
	application.setAttribute("name", "이순신");
%>
이름 : ${ name1 } <br>
이름 : ${ name2 } <br>
이름 : ${ name3 } <br>
이름 : ${ name4 } <br>

이름 : ${ pageScope.name } <br>
이름 : ${ requestScope.name } <br>
이름 : ${ sessionScope.name } <br>
이름 : ${ applicationScope.name } <br>