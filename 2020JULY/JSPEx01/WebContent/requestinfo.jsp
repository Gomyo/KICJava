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
	클라이언트IP = <%= request.getRemoteAddr() %> <br>
	요청정보길이 = <%= request.getContentLength() %> <br>
	요청정보 인코딩 = <%= request.getCharacterEncoding() %> <br>
	요청정보 타입 = <%= request.getContentType() %> <br>
	요청정보 프로토콜 = <%= request.getContentType() %> <br>
	요청정보 전송방식 = <%= request.getMethod() %> <br>
	요청 URI = <%= request.getContextPath() %> <br>
	컨텍스트 경로 = <%= request.getServerName() %> <br>
	서버포트 = <%= request.getServerPort() %> <br>
	
	헤더 목록 출력
	<%
		Enumeration headerEnum = request.getHeaderNames();
		while(headerEnum.hasMoreElements()) {
			String headerName = (String)headerEnum.nextElement();
			String headerValue = request.getHeader(headerName);
	%>
	<%= headerName %> = <%= headerValue %> <br> 
	<%
	}
	%>
</body>
</html>