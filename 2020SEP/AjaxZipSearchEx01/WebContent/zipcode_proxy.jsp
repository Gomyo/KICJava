<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import var="data" url="http://192.168.45.129:9090/ajax01/data/zipcode_json.jsp">
	<c:param name="dong" value="${param.dong}"></c:param>
</c:import>
${data}