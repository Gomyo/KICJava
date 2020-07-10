<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var checkfrm = function() {
		if (document.frm.year.value.trim() == '' || document.frm.month.value.trim() == '') {
			alert('년과 월을 모두 입력하세요');
			return false;
		}
	};
</script>
</head>
<body>
<form action="calendarM.jsp" method="post" name="frm" onsubmit="return checkfrm()">
<input type="text" name="year">
<input type="text" name="month">
<input type="submit" value="달려억">
</form>
<%
	String stryear = request.getParameter("year");
	String strmonth = request.getParameter("month");
	
	/* int year = 2020;
	int month = 1; */
	
	int START_DAY_OF_WEEK = 0;
	int END_DAY_OF_WEEK = 0;
	int END_DAY = 0;
	
	Calendar sDay = Calendar.getInstance();
	Calendar eDay = Calendar.getInstance();
	
	if (stryear != null && strmonth != null) {
		int year = Integer.parseInt(stryear);
		int month = Integer.parseInt(strmonth);
		
		sDay.set(year,month-1,1);
		eDay.set(year,month,1-1);
		
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		END_DAY_OF_WEEK = eDay.get(Calendar.DAY_OF_WEEK);
		END_DAY = eDay.get(Calendar.DATE);
		
		out.println("<table border='1' black width='200'>");
		out.print("<td colspan=7>"+year+"년"+month+"월"+"</td>");
		String[] weekdays = new String[]{"SU","MO","TU"};
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
	}
	
%>
</body>
</html>