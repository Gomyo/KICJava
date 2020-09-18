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
	    var object = {
	    	name: '홍길동'
	    };
	    
	    console.log(object);
	    
	    // 동적추가
	    object.region1 = '종로구';
	    object.part1 = '리더';
	    
	    console.log(object);
	    
	    $.extend(object, {
	    	region2: '강남구',
	    	part2: '베이스'
	    },
	    {
	    	region3: '서초구',
	    	part3: '세컨드'
	    }
	    );
	    
	    console.log(object);
	});
</script>
</head>
<body>

</body>
</html>