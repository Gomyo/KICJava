<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btn').on('click', function() {
			// alert('click');
			
			// width 512
			// height 385
			/* $('<img />')
			.attr('src', './images/Koala.jpg')
			.attr('height', 385)
			.attr('width', 512)
			.appendTo('div'); */
			
			$('<img />', {
				src: './images/Desert.jpg',
				width: 512,
				height: 384
			})
			.appendTo('div');
		});
	});
</script>
</head>
<body>
<button id="btn">이미지 추가</button>
<br /><hr /><br />
<div></div>
</body>
</html>