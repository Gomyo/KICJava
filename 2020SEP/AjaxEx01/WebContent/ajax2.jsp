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
		document.getElementById('btn2').onclick = function() {
			console.log('1');
			var request = new XMLHttpRequest();
			
			request.onreadystatechange = function() {
				console.log("0 : " + request.readyState);
				if (request.readyState == 4) {
					if (request.status == 200) {
						// csv
						// xml
						// json
						var data = request.responseText.trim();
						var rowDatas = data.split("\n");
						
						var result = '<table border="1" width="800">';
						for (var i=0; i<rowDatas.length; i++) {
							var colDatas = rowDatas[i].split(",");
							result += '<tr>';
							result += '<td>' + colDatas[0] + '</td>';
							result += '<td>' + colDatas[1] + '</td>';
							result += '<td>' + colDatas[2] + '</td>';
							result += '<td>' + colDatas[3] + '</td>';
							result += '</tr>';
						}
						result += '</table>';
						
						// 마지막으로 div id = result에 넣어줌
						document.getElementById('result').innerHTML = result;
						
					} else {
						alert('잘못된 요청입니다.');
					}
				}
			}
			request.open( 'get', './data/csv.jsp', true);
			request.send();
		};
	};
</script>
</head>
<body>

<button id="btn1">동기화 요청하기</button>
<button id="btn2">비동기화 요청하기</button>


<br><hr/><br>
<div id="result">
</div>

</body>
</html>