<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
	   var h1 = '<h1>Header1</h1>'
	   var h2 = '<h2>Header2</h2>'
	   
	   // 문서 객체를 추가합니다.
	   $('body').append(h1, h2, h1, h2);
	});
</script>
</head>
<body>

</body>
</html>