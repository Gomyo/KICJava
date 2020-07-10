<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var checkfrm = function() {
		if (document.frm.dong.value.trim().length < 2) {
			alert('두 글자 이상 입력하세요');
			return false;
		}
	};
</script>
</head>
<body>
<form action="zipsearch_result.jsp" method="post" name="frm" onsubmit="return checkfrm()">
<input type="text" name="dong">
<input type="submit" value="우편번호 검색">
</form>
</body>
</html>