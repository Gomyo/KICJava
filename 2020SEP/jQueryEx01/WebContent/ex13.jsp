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
		$('h3')
		.css('background-color', 'orange')
		.filter(':even')
		.css('color', 'red')
		// 탐색 종료 / 지금까지 필터링 한걸 지우고 다시 필터링 한다.
		.end()
		.filter(':odd')
		.css('color','white');
	});
</script>
</head>
<body>
	<h3>Header-0</h3>
	<h3>Header-1</h3>
	<h3>Header-2</h3>
	<h3>Header-3</h3>
	<h3>Header-4</h3>
	<h3>Header-5</h3>
</body>
</html>