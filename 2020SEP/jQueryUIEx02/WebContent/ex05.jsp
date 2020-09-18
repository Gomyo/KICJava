<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/start/jquery-ui.css" />
<style type="text/css">
	body { font-size: 80%; }
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
	    $('#progressbar').progressbar({
	    	value: 50
	    });
	    
	    $('#btn1').button().on('click', function() {
	    	// get
			var value = $('#progressbar').progressbar('value');
			console.log(value);
			
			// set
			$('#progressbar').progressbar('value', 80);
		});
	});
</script>
</head>
<body>
<button id="btn1">값 가져오기</button>
<br /><hr /><br />
<div id="progressbar"></div>
</body>
</html>