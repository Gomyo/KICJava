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
		$('h1').click(function() {
			//출력합니다.
		    $(this).html('click');
			alert('이벤트가 발생했습니다.');
		
			//이벤트를 제거합니다.
			$(this).off();
		});
	});
</script>
</head>
<body>
	<h1>Header-0</h1>
	<h1>Header-1</h1>
	<h1>Header-2</h1>
</body>
</html>