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
	    $('h2').each(function(index, item) {
	    	// 배열에서 접근한다.
			// console.log(item);
	    	// console.log(index + ' ' + item.innerHTML);
	    	// 위의 item과 같음 this는 읽고있는 자기자신을 의미
	    	console.log(this);
		});
	});
</script>
</head>
<body>
<h2>item - 1</h2>
<h2>item - 2</h2>
<h2>item - 3</h2>
<h2>item - 4</h2>
<h2>item - 5</h2>
</body>
</html>