<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="form_ok.jsp" method="get">
데이터1 <input type="text" name="data1"/>
데이터2 <input type="text" name="data2"/>
<input type="submit" value="전송"/>
</form>

<form action="form_ok.jsp" method="post">
데이터1 <input type="text" name="data1"/>
데이터2 <input type="text" name="data2"/>
비밀번호 <input type="password" name="pw"/>
<select name="sel">
	<option value="솹">수박</option>
	<option value="딸귀이" selected>딸기</option>
	<option value="참!외로워">참외</option>
</select>
<input type="submit" value="전송"/>
</form>

<form action="viewParameter.jsp" method="post">
이름 : <input type="text" name="name" size="10"> <br>
주소 : <input type="text" name="address" size="30"> <br>
좋아하는 동물:
	<input type="checkbox" name="pet" value="dog">강아지
	<input type="checkbox" name="pet" value="horse">말
	<input type="checkbox" name="pet" value="penguin">펭귄
	<br>
<input type="submit" value="전송">
</form>

</body>
</html>