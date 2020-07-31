<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.*" %>
<%
	BoardTO to = new BoardTO();
	to.setSubject("제목1");
	to.setWriter("작성자1");
	
	BoardListTO listTO = new BoardListTO();
	listTO.setSeq("1");
	listTO.setBoardTO(to);
	
	ArrayList<BoardListTO> lists = new ArrayList();
	lists.add(listTO);
	
	pageContext.setAttribute("lists", lists);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${lists[0].listTO.subject } --%>
<%-- ${lists[0].listTO.writer } --%>
${lists[0].seq}
${lists[0].boardTO.subject}
${lists[0].boardTO.writer}
</body>
</html>