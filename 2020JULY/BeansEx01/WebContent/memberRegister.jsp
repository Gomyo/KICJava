<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberInfoForm.jsp" method="post">
아이디<input type="text" name="id"/>
비번<input type="password" name="password"/>
이메일<input type="text" name="email"/>
이름<input type="text" name="name"/>
<input type="hidden" name="registerDate"/>
<input type="submit" value="전송"/>
</form>
</body>
</html>