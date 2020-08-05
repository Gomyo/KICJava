<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('gbtn').onclick = function() {
			var startDan = document.gfrm.startDan.value.trim();
			var endDan = document.gfrm.endDan.value.trim();
			if (startDan < 1 || startDan == '') {
				alert('너무 작은 숫자를 입력하셨습니다.');
				return false
			};
			if (endDan > 9 || endDan == '') {
				alert('너무 큰 숫자를 입력하셨습니다.');
				return false
			};
			document.gfrm.submit();
		}
	}
</script>
</head>
<body>
<form action="./guguservlet01" method="post" name="gfrm">
시작단 <input type="text" name="startDan"/>
끝단 <input type="text" name="endDan" />
<input type="button" id="gbtn" value="계산"/>
</form>
<hr/>
<c:if test="${not empty guguResult}">
	${guguResult}
</c:if>
</body>
</html>