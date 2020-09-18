<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ajax01.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('btn').onclick = function() {
			var request = new XMLHttpRequest();
			
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200) {
// 						var data = request.responseText.trim();
						showData(request.responseText.trim());
					} else {
						alert('잘못된 요청입니다.');
					}
				}
			};
			// ubuntu mariadb 사용예제
			request.open( 'get', './data/json3.jsp', true);
			request.send();
		};
		// 데이터의 함수화
		var showData = function(data) {
			var json = eval('(' + data + ')');

			var result = '<table border="1" width="800">';
			for (var i=0; i<json.length; i++) {
				result += "<tr>";
				
				for ( var key in json[i]) {
					result += "<td>"+ json[i][key] +"</td>";
				}
					
				result += "</tr>";
			}
			result += '</table>';
			document.getElementById('result').innerHTML = result;
		};
	};
</script>
</head>
<body>

<button id="btn">동기화 요청하기</button>


<br><hr/><br>
<div id="result">
</div>

</body>
</html>