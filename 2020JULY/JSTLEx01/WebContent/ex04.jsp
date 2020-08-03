<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="to1" value="<%= new model1.BoardTO() %>"/>
<c:set target="${ to1 }" property="subject" value="제목1"/>
<c:set target="${ to1 }" property="writer" value="작성자1"/>

<c:set var="to2" value="<%= new model1.BoardTO() %>"/>
<c:set target="${ to2 }" property="subject" value="제목2"/>
<c:set target="${ to2 }" property="writer" value="작성자2"/>

<c:set var="hm" value="<%= new java.util.HashMap<>() %>"/>
<c:set target="${ hm }" property="to1" value="${ to1 }"/>
<c:set target="${ hm }" property="to2" value="${ to1 }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제목 : ${ to1.subject } <br>
작성자 : ${to1.writer } <br>
제목 : ${ to2.subject } <br>
작성자 : ${to2.writer } <br>
제목 : ${ hm.to1.subject } <br>
작성자 : ${hm.to1.writer } <br>
</body>
</html>