<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<form action="gugudan2function.jsp" method="post" name="frm" onsubmit="return checkfrm()">
시작단<input type="text" name="startDan">
끝단<input type="text" name="endDan">
<input type="submit" value="구구단 시작">
</form>
</body>
</html>