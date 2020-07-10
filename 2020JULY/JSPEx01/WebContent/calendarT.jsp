<%@page import="java.awt.Color"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String stryear = request.getParameter("year");
	String strmonth = request.getParameter("month");
%>
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
<form action="calendarT.jsp" method="post" name="frm" onsubmit="return checkfrm()">
<select name="year">
	<option value="2019">2019</option>
	<option value="2020" selected>2020</option>
	<option value="2021">2021</option>
</select>
<select name="month">
	<option value="1">1월</option>
	<option value="2">2월</option>
	<option value="3">3월</option>
	<option value="4">4월</option>
	<option value="5">5월</option>
	<option value="6">6월</option>
	<option value="7" selected>7월</option>
	<option value="8">8월</option>
	<option value="9">9월</option>
	<option value="10">10월</option>
	<option value="11">11월</option>
	<option value="12">12월</option>
</select>
<input type="submit" value="달려억">
</form>
<%
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
		
		out.println("<table border='1' black width='400'>");
		out.print("<td colspan=7 align='center'>"+year+"년"+month+"월"+"</td>");
		String[] weekdays = new String[]{"SU","MO","TU"};
		out.print("<tr><td style='color:red'> SU</td> <td>MO</td> <td>TU</td> <td>WE</td> <td>TH</td><td>FR</td><td style='color:blue'>SA</td></tr>");
		for (int i=1; i<START_DAY_OF_WEEK; i++) {
			out.print("<td></td>");
		}
		for (int i=1, n=START_DAY_OF_WEEK; i<=END_DAY; i++,n++) {
			if (n%7 == 1) {
				out.println("<td style='color:red'>"+i+"</td>");
			} else if (n%7 == 0) {
				out.println("<td style='color:blue'>"+i+"</td>");
			} else {
				out.print("<td>"+i+"</td>");
			}
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