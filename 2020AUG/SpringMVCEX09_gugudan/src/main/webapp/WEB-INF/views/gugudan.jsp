<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	StringBuffer guguResult = (StringBuffer)request.getAttribute("guguResult");
%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
<script type="text/javascript">
	var checkfrm = function() {
		var startDan = parseInt(document.gfrm.startDan.value);
		var endDan = parseInt(document.gfrm.endDan.value);
		
		if (startDan > endDan) {
			alert("시작단이 더 큼 멍청아");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="./gugudan.do" method="get" name="gfrm" onsubmit="return checkfrm()">
		시작단<input type="text" name="startDan"/>
		끝단<input type="text" name="endDan"/>
		<input type="submit" value="계산"/>
	</form>
<hr/>
<%= guguResult %>
</body>
</html>
