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
		$('h3').filter(function (index) {
			//  검사구문 / 밑의 구문이 참이면 밑의 구문을 실행
			return index % 3 == 0;
		}).css({
			backgroundColor : 'black',
			color: 'white'
		});
	});
</script>
</head>
<body>
	<h3>Header-0</h3>
	<h3>Header-1</h3>
	<h3>Header-2</h3>
	<h3>Header-3</h3>
	<h3>Header-4</h3>
	<h3>Header-5</h3>
</body>
</html>