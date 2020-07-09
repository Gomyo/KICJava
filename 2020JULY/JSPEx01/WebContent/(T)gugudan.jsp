<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var checkfrm = function() {
		if( document.frm.startdan.value.trim() == '' || 
				document.frm.enddan.value.trim() == '') {
			alert( '값을 입력주세요' );
			return false;			
		}
		
		var startDan = parseInt(document.frm.startdan.value); 
		var endDan = parseInt(document.frm.enddan.value);
		
		if( startDan > endDan ) {
			alert( '시작단의 값이 큽니다.' );
			return false;
		}
	};
</script>
</head>
<body>

<form action="./gugudan_ok.jsp" method="post" name="frm" onsubmit="return checkfrm()">
시작단 : <input type="text" name="startdan" />
-
끝단 : <input type="text" name="enddan" />
<input type="submit" value="구구단 출력" />

</body>
</html>