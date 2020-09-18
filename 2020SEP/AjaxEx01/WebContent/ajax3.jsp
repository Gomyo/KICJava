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
						// text
// 						console.log(request.responseText);
						// Xml -> 객체로
// 						console.log(request.responseXML);
						
						var data = request.responseXML;
						/*
						var names = data.getElementsByTagName('name');
						console.log(names);
						// 배열
						console.log("갯수 : " + names.length);
						console.log(names[0]);
						console.log(names[0].childNodes[0].nodeValue); // 노드의 값 뽑아내기
						*/
						
						// name 데이터 전체 가져오기
						var names = data.getElementsByTagName('name');
						var prices = data.getElementsByTagName('price');
						
						for (var i=0; i<names.length; i++) {
							var name = names[i].childNodes[0].nodeValue;
							var price = prices[i].childNodes[0].nodeValue;
							
							console.log(name);
							console.log(price);
						}
					} else {
						alert('잘못된 요청입니다.');
					}
				}
			}
			request.open( 'get', './data/xml2.jsp', true);
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