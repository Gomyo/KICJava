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
	    $(document).find('.select').each(function() {
		//$(document).find('h3').each(function() {
			console.log(this.innerHTML);
		});
	});
</script>
</head>
<body>
	<h3 class="select">Header-0</h3>
	<h3>Header-1</h3>
	<h3 class="select">Header-2</h3>
	<h3>Header-3</h3>
	<h3 class="select">Header-4</h3>
	<h3>Header-5</h3>
</body>
</html>