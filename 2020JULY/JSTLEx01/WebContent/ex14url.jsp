<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="url1" value="./list.do"/>
${url1} <br>
<c:url var="url2" value="https://search.daum.net/search">
		<c:param name="w" value="tot"/>
		<c:param name="q" value="사타워즈"/>
</c:url>
${url2} <br>
<c:url var="url3" value="https://search.naver.com/search.naver">
		<c:param name="sm" value="top_hty"/>
		<c:param name="query" value="네이버 커리어"/>
</c:url>
<c:redirect url="${url3 }"/>