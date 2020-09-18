<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="./css/base/jquery-ui.css" /> -->
<link rel="stylesheet" href="./css/ui-lightness/jquery-ui.css" />
<style type="text/css">
	body { font-size: 80%; }
</style>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
	    $('#btn1').button().on('click', function() {
			alert('btn1');
		});
	    $('#btn2').button().on('click', function() {
			alert('btn2');
		});
	    $('input[type="submit"]').button().on('click', function(e) {
			alert('submit');
			// 기본적인 전송기능 제거
			e.preventDefault();
		});
	    $('a').button().on('click', function(e) {
			alert('www.naver.com');
			// 기본적인 전송기능 제거
			e.preventDefault();
		});
	});
</script>
</head>
<body>
<button id="btn1">버튼1</button><br /><br />
<button id="btn2">버튼2</button><br /><br />

<form action="test.jsp" method="get">
	<input type="submit" value="내용 전송" /><br /><br />
</form>

<a href="www.naver.com">버튼3</a><br /><br />
</body>
</html>