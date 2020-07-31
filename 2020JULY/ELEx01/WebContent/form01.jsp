<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="form_ok.jsp" method="post">
아이디 : <input type="text" name="id"/>
비밀번호 : <input type="password" name="password"/>
선택 :
<input type="checkbox" name="language" value="c"> C언어 &nbsp;&nbsp;
<input type="checkbox" name="language" value="c++"> C++언어 &nbsp;&nbsp;
<input type="checkbox" name="language" value="c#"> C#언어 &nbsp;&nbsp;
<input type="submit" value="전송" />
</form>
</body>
</html>