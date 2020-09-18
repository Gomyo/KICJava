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
			
			var dong = document.getElementById('dong').value.trim();
			
			if (dong.length < 2) {
				alert('동이름을 2자 이상 입력하셔야 합니다.');
			} else {
				alert(dong+'동 우편번호를 검색합니다.');
			}
			
			var request = new XMLHttpRequest();
			
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200) {
						var data = request.responseText.trim();
						
						// 객체화
// 						var json = eval('(' + data + ')');
						// [{}] 형태로 되어있기에 아래대로 해도 가능
// 						var json = eval(data);
						// 다만, 정보를 eval로 변환할 경우 빠르기는 하지만 단순히 스트링을 그대로 실행하는 것이기 때문에,
						// 리턴값으로 자바스크립트 명령문이 온다면 그대로 실행을 시켜버려 보안이슈가 발생할 수 있다.
						// 이 경우, 리턴받은 소스를 무조건 실행하기에는 보안적으로 불안하다.
						// Json.org에서 제공하는 JSON parser를 사용하면 오로지 json 텍스트의 경우만 받아들이고 다른 경우는 SyntaxError를 출력한다.
						var json = JSON.parse(data);
						console.log(json);
						
						var result = '<table border="1" width="1000">';
							
						for (var i=0; i<json.length; i++) {
							result += "<tr>";

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
			request.open( 'get', './data/zipcode_json.jsp?dong=' + encodeURIComponent(dong) , true);
			request.send();
		};
	};
</script>
</head>
<body>

<input type="text" id="dong" size="30" maxlength="10" placeholder="동 이름 입력"/>
<button id="btn">주소 검색하기</button>

<br><hr/><br>
<div id="result">
</div>

</body>
</html>