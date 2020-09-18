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
		// $('input[type="text"]').css('background-color', 'red');
	    // $('input[type^="te"]').css('background-color', 'blue');
		$('input:text').css('background-color', 'yellow');
	});
</script>
</head>
<body>

<input type="text" size="30" /><br /><br />
<input type="text" size="30" /><br /><br />

</body>
</html>