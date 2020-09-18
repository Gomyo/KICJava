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
		document.getElementById('btn1').onclick = function() {
			console.log('1');
			var request = new XMLHttpRequest();
			// false - 동기방식 . scanf처럼 살짝 기다려줌.
			// true - 비동기방식
			request.open( 'get', './data/csv.jsp', false);
			console.log('2');
			request.send();
			console.log('3');
			
			// 동기화하면 여기서 결과가 나올때까지 기다려주는 약간의 wait가 걸림
			
			// 콘솔이 아니라 정확한 출력을 위해 dom 사용
			console.log(request.responseText);
			document.getElementById('result').innerHTML = request.responseText;
			console.log('4');
		};
		document.getElementById('btn2').onclick = function() {
			console.log('1');
			var request = new XMLHttpRequest();
			
			request.onreadystatechange = function() {
				console.log("0 : " + request.readyState); // 선언할 때 한번 뜨고, 4번이 실행되고 한번 더 뜬다.
				if (request.readyState == 4) {
					// 완전히 정상
					if (request.status == 200) {
						alert('정상');
						console.log(request.responseText);
						document.getElementById('result').innerHTML = request.responseText;	
					} else {
						// 서버에서 오류
						alert('잘못된 요청입니다.');
					}
				}
			}
			// false - 동기방식 . scanf처럼 살짝 기다려줌.
			// true - 비동기방식
			request.open( 'get', './data/csv.jsp', true);
			console.log('2');
			request.send();
			console.log('3');
			
			// 비동기화는 결과가 나오기 전에 그냥 지나가버림
			console.log(request.responseText);
			// 콘솔이 아니라 정확한 출력을 위해 dom 사용
			document.getElementById('result').innerHTML = request.responseText;
			console.log('4');
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