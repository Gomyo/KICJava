<%@page import="model1.ZipcodeTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	ArrayList<ZipcodeTO> lists
		= (ArrayList<ZipcodeTO>)request.getAttribute("lists");
	
	String egg = (String)request.getAttribute("egg");
	
	StringBuffer sbHtml = new StringBuffer();
	
	if ( lists != null) {
		
		sbHtml.append("<table border='1' width='800'>");
		for (ZipcodeTO to : lists) {
			sbHtml.append("<tr>");
			sbHtml.append("<td>"+to.getZipcode()+"</td>");
			sbHtml.append("<td>"+to.getSido()+"</td>");
			sbHtml.append("<td>"+to.getGugun()+"</td>");
			sbHtml.append("<td>"+to.getDong()+"</td>");
			sbHtml.append("<td>"+to.getBunji()+"</td>");
			sbHtml.append("<td>"+to.getRi()+"</td>");
			
			sbHtml.append("</tr>");
		}
		sbHtml.append("</table>");
	} else {
		sbHtml.append(egg);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= sbHtml %>
</body>
</html>