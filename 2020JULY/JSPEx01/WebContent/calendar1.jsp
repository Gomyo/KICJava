<%@page import="java.util.Calendar"%>
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
	int year = 2020;
	int month = 1;
	
	int START_DAY_OF_WEEK = 0;
	int END_DAY_OF_WEEK = 0;
	int END_DAY = 0;
	
	Calendar sDay = Calendar.getInstance();
	Calendar eDay = Calendar.getInstance();
	
	sDay.set(year,month-1,1);
	eDay.set(year,month,1-1);
	
	START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
	END_DAY_OF_WEEK = eDay.get(Calendar.DAY_OF_WEEK);
	END_DAY = eDay.get(Calendar.DATE);
	
	out.println("<table border=1px black width=200>");
	out.print("<td colspan=7>"+year+"년"+month+"월"+"</td>");
	out.print("<tr><td> SU</td> <td>MO</td> <td>TU</td> <td>WE</td> <td>TH</td><td>FR</td><td>SA</td></tr>");
	for (int i=1; i<START_DAY_OF_WEEK; i++) {
		out.print("<td></td>");
	}
	for (int i=1, n=START_DAY_OF_WEEK; i<=END_DAY; i++,n++) {
		out.print("<td>"+i+"</td>");
		if (n%7 == 0) out.println("<tr></tr>");
	}
	for (int i=END_DAY_OF_WEEK; i<=6; i++) {
		out.print("&nbsp;");
	}
	out.println("</table>");
%>
</body>
</html>