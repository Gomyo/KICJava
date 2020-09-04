<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('zbtn').onclick = function() {
			if (document.frm.dong.value.trim().length < 2) {
				alert('두 글자 이상 입력하셔야 합니다.');
				return false;
			}
			document.frm.submit();
		}
	}
</script>
</head>
<body>
<form action="./zipcode.do" method="post" name="frm">
		동입력<input type="text" name="dong" size="40" maxlength="5" placeholder="박성훈바보 입력" onkeydown="if (event.keyCode == 13) {return false;}"/>
		<input type="button" id="zbtn" value="출력"/>
	</form>
<br><hr/><br>
</body>
</html>