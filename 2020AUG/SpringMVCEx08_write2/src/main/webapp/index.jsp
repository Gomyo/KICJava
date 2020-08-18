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
	데이타 <input type="text" name="data1"/>
	<input type="submit" value="전송"/>
</form>

<form action="./write_ok.do" method="post">
	데이타 <input type="text" name="data2"/>
	<input type="submit" value="전송"/>
</form>
<!-- <a href="./write.do">write.do</a> -->
<!-- <a href="./write_ok.do">write_ok.do</a> -->

</body>
</html>