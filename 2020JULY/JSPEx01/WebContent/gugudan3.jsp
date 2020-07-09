<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String start = request.getParameter("startDan");
	String end = request.getParameter("endDan");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var checkfrm = function() {
		if (document.frm.startDan.value.trim() == '' || document.frm.endDan.value.trim() == '') {
			alert('시작값과 끝값을 모두 입력하세요');
			return false;
		}
		var start = parseInt(document.frm.startDan.value);
		var end = parseInt( document.frm.endDan.value);
		
		if (start > end) {
			alert('시작단이 더 높아요! 캇트!');
			return false;
		}
	};
</script>
</head>
<body>
<form action="gugudan3.jsp" method="post" name="frm" onsubmit="return checkfrm()">
시작단<input type="text" name="startDan">
끝단<input type="text" name="endDan">
<input type="submit" value="구구단 시작">

<%	
	if (start != null && end !=null) {
		int iStartdan = Integer.parseInt( start );
		int iEnddan = Integer.parseInt( end );
		
		out.println("<table border=1px>");
		for (int i=iStartdan; i <= iEnddan; i++) {
			out.println("<tr>");
			for (int j = 1; j <= 9; j++) {
				out.println("<td>" + i + "X" + j + "=" + (i * j) + "</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");		
	}
%>
</form>
</body>
</html>