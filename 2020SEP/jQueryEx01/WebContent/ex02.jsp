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
		// css('속성', 값)
		// $('*').css('color', 'red');
		/* $('*').css(function() {
			color: 'blue';
		}); */
		
		// tag
		// $('h1').css('color', 'red');

		// class
		// $('.c1').css('color', 'red');
		
		//id
		$('#i1').css('color', 'red');
	});
</script>
</head>
<body>
<h1 class="c1" id="i1">Hello jQuery 1</h1>
<h2 class="c1" id="i2">Hello jQuery 2</h2>
<h1 class="c2" id="i3">Hello jQuery 3</h1>
<h2 class="c2" id="i4">Hello jQuery 4</h2>
</body>
</html>