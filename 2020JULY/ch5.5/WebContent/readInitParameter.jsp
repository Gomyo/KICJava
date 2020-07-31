<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
초기화 파라미터 목록:
<ul>
<%
	Enumeration<String> initParamEnum = application.getInitParameterNames();
		while (initParamEnum.hasMoreElements()) {
			String initParamName = initParamEnum.nextElement();
%>

<li> <%= initParamName %> =
	<%= application.getInitParameter(initParamName) %>
	<%
	}
	%></li>
<li>
	서버정보 : <%= application.getServerInfo() %> <br>
</li>
	서블릿 규약 메이저 버전: <%= application.getMajorVersion() %> <br>
서블릿 규약 마이너 버전: <%= application.getMinorVersion() %>
	
</ul>

</body>
</html>