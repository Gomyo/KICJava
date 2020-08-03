<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%@ page import="java.util.ArrayList" %>
<%
	BoardTO to1 = new BoardTO();
	to1.setSubject("제목1");	
	to1.setWriter("작성자1");	
	
	BoardTO to2 = new BoardTO();
	to2.setSubject("제목2");	
	to2.setWriter("작성자2");
	
	ArrayList<BoardTO> lists = new ArrayList<BoardTO>();
	lists.add(to1);
	lists.add(to2);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(BoardTO to : lists) {
		out.println(to.getSubject() + ':' + to.getWriter() + "<br>");
	}
%>
</body>
</html>