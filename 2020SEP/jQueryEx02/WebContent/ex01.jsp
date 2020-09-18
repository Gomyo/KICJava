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
	    $('#btn').on('click', function() {
			$.ajax({
				// url: './data/csv.jsp',
				url: './data/json.jsp',
				type: 'get',
				// dataType: 'text',
				dataType: 'json',
				success: function(data) {
					console.log(data);
					// $('#result').html(data);
				},
				error: function(e) {
					colsole.log('[에러] ' + e.status);
					colsole.log('[에러] ' + e.responseText);
				}
				
			});
		});
	});
</script>
</head>
<body>
<button id="btn">요청하기</button>
<br /><hr /><br />
<div id="result"></div>
</body>
</html>