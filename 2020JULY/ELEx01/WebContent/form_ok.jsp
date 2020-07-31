<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
아이디 : <%= request.getParameter("id") %><br>
아이디 : ${param.id } <br>
비밀번호 : <%= request.getParameter("password") %><br>
비밀번호 : ${param.password } <br>
1번 선택 : ${paramValues.language[0] }<br>
2번 선택 : ${paramValues.language[1] }<br>
3번 선택 : ${paramValues.language[2] }<br>
