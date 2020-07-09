<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	

	int start = Integer.parseInt(request.getParameter("startDan"));
	int end = Integer.parseInt(request.getParameter("endDan"));

	out.println("<table border=1px>");
for (int i=start; i <= end; i++) {
	out.println("<tr>");
	for (int j = 1; j <= 9; j++) {
		out.println("<td>" + i + "X" + j + "=" + (i * j) + "</td>");
	}
	out.println("</tr>");
}
out.println("</table>");
%>