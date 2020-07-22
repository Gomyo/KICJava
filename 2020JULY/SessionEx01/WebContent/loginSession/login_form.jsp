<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('logbtn').onclick = function() {
			if (document.logfrm.id.value.trim() == '') {
				alert('아이디를 입력해야 함');
				return false;
			}
			if (document.logfrm.password.value.trim() == '') {
				alert('비번을 입력해야 함');
				return false;
			}
			document.logfrm.submit();
		}
	}
</script>
</head>
<body>
<form action="./login_ok.jsp" method="post" name="logfrm">
아디<input type="text" name="id"/>
비번<input type="password" name="password"/>
<input type="button" value="로그인" id="logbtn"/>
</form>
</body>
</html>