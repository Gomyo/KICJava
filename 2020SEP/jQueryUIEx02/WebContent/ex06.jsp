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
		});
	    $('#mbtn').button().on('click', function() {
	    	// get
			var value = $('#progressbar').progressbar('value');
			
			$('#progressbar').progressbar('value', value-5);
			console.log(value-5);
		});
	    $('#pbtn').button().on('click', function() {
	    	// get
			var value = $('#progressbar').progressbar('value');
			
			$('#progressbar').progressbar('value', value+5);
			console.log(value+5);
		});
	});
</script>
</head>
<body>
<button id="btn1">값 가져오기</button>
<button id="mbtn">감소</button>
<button id="pbtn">증가</button>
<br /><hr /><br />
<div id="progressbar"></div>
</body>
</html>