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
	    var html = $('h1').html();
	    var text = $('h1').text();
	    alert(html);
	    alert(text);
	});
</script>
</head>
<body>
	<h1>Header-0</h1>
	<h1>Header-1</h1>
	<h1>Header-2</h1>
</body>
</html>