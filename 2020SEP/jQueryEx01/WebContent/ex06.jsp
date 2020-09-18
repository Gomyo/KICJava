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
	  var array = [
		  {name: 'daum', link: 'https://www.daum.net'},
		  {name: 'naver', link: 'https://www.naver.com'},
		  {name: 'google', link: 'https://www.google.com'}
	  ];
	  
	  var object = {
		  name: '홍길동',
		  region: '서울특별시 강남구',
		  part: '베이스'
	  }
	  
	  console.log(array);
	  
	  for(var i=0; i<array.length; i++) {
		  /* console.log(array[i].name);
		  console.log(array[i].link); */
	  }
	  
	  for(var i in array) {
		  /* console.log(array[i].name);
		  console.log(array[i].link); */
	  }
	  
	  // 객체 내부의 메서드
		array.forEach(function(item) {
			/* console.log(item.name + '/' + item.link); */
		});
	  
	  // jQuery
		$.each(array, function(index, item) {
			// console.log(item.name + '/' + item.link);
		});
	  
		$.each(object, function(key, value) {
			console.log(key + '/' + value);
		});
	});
</script>
</head>
<body>

</body>
</html>