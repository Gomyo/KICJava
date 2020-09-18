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
		// 첫번째 데이터만 접근됨
	    /* var src =$('img').attr('src');
	    console.log(src); */
	    // 이런 형식을로 접근해야됨
	    $('img').each(function() {
	    	 // console.log($(this).attr('src'));
		});
		// 태그 전체를 가져옴
		/*  $('img').attr('src', function() {
	    	 console.log(this);
		}); */
		$('img').attr({
	    	 width: 100
		});
	});
</script>
</head>
<body>
	<img src="./images/Chrysanthemum.jpg" width="150" />
	<img src="./images/Desert.jpg" width="150" />
	<img src="./images/Hydrangeas.jpg" width="150" />
	<img src="./images/Jellyfish.jpg" width="150" />
	<img src="./images/Koala.jpg" width="150" />
	<img src="./images/Lighthouse.jpg" width="150" />
	<img src="./images/Penguins.jpg" width="150" />
	<img src="./images/Tulips.jpg" width="150" />
</body>
</html>