<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/base/jquery-ui.css" />
<style type="text/css">
	body { font-size: 80%; }
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
	    $('#slider').slider({
	    	// orientation: 'vertical'
	    	value: 50,
	    	min: 0,
	    	max: 255,
	    	// change
	    	slide: function() {
				console.log($(this).slider('value'));
			}
	    });
	});
</script>
</head>
<body>
	<div id="slider"></div>
</body>
</html>