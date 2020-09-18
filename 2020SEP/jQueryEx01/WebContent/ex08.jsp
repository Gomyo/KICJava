<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.high-light { background-color: yellow; }
	
	
	.high-light-0 { background-color: yellow; }
	.high-light-1 { background-color: red; }
	.high-light-2 { background-color: blue; }
	.high-light-3 { background-color: green; }
	.high-light-4 { background-color: magenta; }
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		// $('h2').addClass('high-light');
	    $('h2').each(function(index, item) {
	    	$(this).addClass('high-light-' + index);
		});
	});
</script>
</head>
<body>
<h2>item - 1</h2>
<h2>item - 2</h2>
<h2>item - 3</h2>
<h2>item - 4</h2>
<h2>item - 5</h2>
</body>
</html>