<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var checkfrm = function() {
		if(document.frm.data1.value.trim()=='') {
			alert('값을 입력하세요');
			return false;
		}
	};
</script>
</head>
<body>

<form action="form_ok.jsp" method="post" name="frm" onsubmit="return checkfrm()">
데이터1<input type="text" name="data1">
<input type="submit" value="전송"/>
</form>
</body>
</html>