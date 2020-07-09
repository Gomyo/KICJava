<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String startdan = request.getParameter("startdan");
	String enddan = request.getParameter("enddan");
	System.out.println( startdan );
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		border-collapse: collapse;
		width: 800px;
	}

	table, td {
		border: 1px solid black;
	}
</style>
<script type="text/javascript">
	var checkfrm = function() {
		if( document.frm.startdan.value.trim() == '' || 
				document.frm.enddan.value.trim() == '') {
			alert( '값을 입력주세요' );
			return false;			
		}
		
		// 문자열 -> 숫자
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

<form action="./gugudan02.jsp" method="post" name="frm" onsubmit="return checkfrm()">
시작단 : <input type="text" name="startdan" />
-
끝단 : <input type="text" name="enddan" />
<input type="submit" value="구구단 출력" />
</form>

<br /><hr /><br />

<%
	if( startdan == null || enddan == null ) {
	} else {
		int iStartdan = Integer.parseInt( startdan );
		int iEnddan = Integer.parseInt( enddan );
	
		out.println( "<table>" );
		for( int i=iStartdan ; i<=iEnddan ; i++ ) {
			out.println( "<tr>" );
			for( int j=1 ; j<=9 ; j++ ) {
				out.println( "<td>" + i + " X " + j + " = " + (i*j)+ "</td>" );
			}
			out.println( "</tr>" );
		}
		out.println( "</table>" );
	}
%>

</body>
</html>