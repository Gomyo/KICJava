<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./controller" method="post">
<input type="hidden" name="action" value="view1"/>
<input type="hidden" name="action" value="view2"/>
data1 <input type="text" name="data1"/>
data2 <input type="text" name="data2"/>
<input type="submit" name="전송"/>
</form>
</body>
</html>