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
				url: './data/json.jsp',
				type: 'get',
				dataType: 'json',
				success: function(data) {
					console.log(data.length)
					console.log(data.name)
					var result = '<table border="1" width="800">';

					for(var i = 0; i < data.length; i++) {
						result += '<tr>';
						result += '<td>' + data[i].name + '</td>';
						result += '<td>' + data[i].publisher + '</td>';
						result += '<td>' + data[i].author + '</td>';
						result += '<td>' + data[i].price + '</td>';
						result += '</tr>';
					}
					result += '</table>';
					$('#result').appendTo(result);
				},
				error: function(e) {
					colsole.log('[에러] ' + e.status);
					colsole.log('[에러] ' + e.responseText);
				}
				
			});
		});
	    
	    var showData = function(json) {
			
			var result = '<table border="1" width="800">';

				for(var i = 0; i < json.length; i++) {
					result += '<tr>';
					result += '<td>' + json[i].name + '</td>';
					result += '<td>' + json[i].publisher + '</td>';
					result += '<td>' + json[i].author + '</td>';
					result += '<td>' + json[i].price + '</td>';
					result += '</tr>';
				}
			result += '</table>';
		};
	});
</script>
</head>
<body>
<button id="btn">요청하기</button>
<br /><hr /><br />
<div id="result"></div>
</body>
</html>