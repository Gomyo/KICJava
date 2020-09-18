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
	    $('h1').eq(0).css('background', 'Gray').add('h2').css('float', 'left');
	});
</script>
</head>
<body>
	<div>
		<h1>Header-0</h1>
		<h2>Header-1</h2>
		<h1>Header-2</h1>
		<h2>Header-3</h2>
		<h1>Header-4</h1>
	</div>
</body>
</html>