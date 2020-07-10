<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('btn').onclick = function() {
			// alert('click');
			var dong = document.getElementById('dong').value;
			if (dong.length < 2) {
				alert('2자 이상 입력');
				return false;
			}
			document.frm.submit();
		};
	};
</script>
</head>
<body>
<form action="zipcode01_ok.jsp" method="post" name="frm">
	<input type="text" name="dong" id="dong" size="40" placeholder="동이름 입력"/>
	<input type="button" id="btn" value="우편번호검색"/>
</form>
</body>
</html>