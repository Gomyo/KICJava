<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./write_ok.do" method="get">
	데이타 <input type="text" name="data"/>
	<input type="submit" value="전송"/>
</form>

<form action="./write_ok.do" method="post">
	데이타 <input type="text" name="data"/>
	<input type="submit" value="전송"/>
</form>

<form action="./zipcode.do" method="post">
	동 <input type="text" name="dong"/>
	<input type="submit" value="전송"/>
</form>

</body>
</html>