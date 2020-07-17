<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("시작<br/>");
	String data = "Hello Include"; // 이 데이터가 value에 들어감
	// 메서드에 파라미터 넘기듯 sub1.jsp에 data를 String data를 넘김
%>
	<jsp:include page="sub1.jsp">
		<jsp:param name="data" value="<%= data %>"/>
	</jsp:include>
<%
	out.println("끝<br/>");
%>

</body>
</html>