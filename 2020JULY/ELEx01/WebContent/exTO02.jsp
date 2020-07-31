<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model1.BoardTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BoardTO to1 = new BoardTO();
	to1.setSubject("제모옥1");
	to1.setWriter("자악성자아1");
	
	BoardTO to2 = new BoardTO();
	to2.setSubject("제모옥2");
	to2.setWriter("자악성자아2");
	
	BoardTO to3 = new BoardTO();
	to3.setSubject("제모옥3");
	to3.setWriter("자악성자아3");
	// list
	BoardTO[] list = {to1,to2,to3};
	// ArrayList
	ArrayList<BoardTO> lists = new ArrayList();
	lists.add(to1);
	lists.add(to2);
	lists.add(to3);
	// HashMap
	HashMap<String, BoardTO> hashmap = new HashMap();
	hashmap.put("to1",to1);
	hashmap.put("to2",to2);
	hashmap.put("to3",to3);
	
// 	pageContext.setAttribute("to", to);
	request.setAttribute("list", list);
	request.setAttribute("lists", lists);
	request.setAttribute("hashmap", hashmap);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${list[0].subject} <br> 
${list[0].writer} <br> 
${list[1].subject} <br> 
${list[1].writer} <br> 
<hr/>
${lists[0].subject} <br> 
${lists[0].writer} <br> 
${lists[1].subject} <br> 
${lists[1].writer} <br> 
<hr/>
${hashmap.to1.subject} <br> 
${hashmap.to1.writer} <br> 
${hashmap.to2.subject} <br> 
${hashmap.to2.writer} <br> 
</body>
</html>