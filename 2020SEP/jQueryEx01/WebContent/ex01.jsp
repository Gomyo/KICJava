<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="./js/jquery-3.5.1.js"></script> -->
<!-- <script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	//$는 jQuery 만의 특수
	// jQuery = window.$ = $
	// $(선택자) - html을 선택하는 부분(selector)
	// $(document).ready(function() {
	jQuery(document).ready(function() {
	    // 해야될 내용 기술
	    console.log('Hello jQuery');
	});
	
	$(function() {
		console.log('Hello jQuery2');
	})
</script>
</head>
<body>

</body>
</html>