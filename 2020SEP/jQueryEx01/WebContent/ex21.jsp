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
	    /* $('#btn1').on('click', function() {
			console.log(this);
		});
	    
	    $('#btn2').on('click', function() {
			console.log(this);
		}); */
		
		/* $('button').on('click', function() {
			// console.log(this);
			console.log($(this).text());
		}); */
		$('#btn1').click( function() {
			alert('난 버튼1');
		});
		
	});
</script>
</head>
<body>
<button id="btn1">난 버튼1</button>
<button id="btn2">난 버튼2</button>
</body>
</html>