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
						var data = request.responseText.trim();
						
						// 객체화
						var json = eval('(' + data + ')');
// 						console.log(json);
						
// 						console.log(json[0]);
// 						console.log(json[0].name);
// 						console.log(json[0]['name']);

						var result = '<table border="1" width="800">';
							
						for (var i=0; i<json.length; i++) {
							result += "<tr>";
							
// 							result += "<td>"+ json[i].name +"</td>";
// 							result += "<td>"+ json[i].publisher +"</td>";
// 							result += "<td>"+ json[i].author +"</td>";
// 							result += "<td>"+ json[i].price +"</td>";
							
// 							result += "<td>"+ json[i]['name'] +"</td>";
// 							result += "<td>"+ json[i]['publisher'] +"</td>";
// 							result += "<td>"+ json[i]['author'] +"</td>";
// 							result += "<td>"+ json[i]['price'] +"</td>";

							for ( var key in json[i]) {
								result += "<td>"+ json[i][key] +"</td>";
							}
								
							result += "</tr>";
						}
						result += '</table>';
						
						document.getElementById('result').innerHTML = result;
					} else {
						alert('잘못된 요청입니다.');
					}
				}
			}
			request.open( 'get', './data/json.jsp', true);
			request.send();
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