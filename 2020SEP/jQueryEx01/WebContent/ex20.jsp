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
		// 둘의 지우는 용도가 다름
		// remove는 통째로 날림
		// empty는 내부 객체만 비우고 div는 살아남음
		document.getElementById('btn1').onclick = function() {
			$('div').remove();
		};
		document.getElementById('btn2').onclick = function() {
			$('div').empty();
		};
		document.getElementById('btn3').onclick = function() {
			// $('h3').first().remove();
			$('h3').eq(1).remove();
		};
	});
</script>
</head>
<body>
	<button id="btn1">제거1</button>
	<button id="btn2">제거2</button>
	<button id="btn3">제거3</button>
	
	<br /><hr /><br />
	
	<div>
		<h3>Header 1</h3>
		<h3>Header 2</h3>
		<h3>Header 3</h3>
	</div>
</body>
</html>