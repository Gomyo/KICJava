<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이제부터 파일 업로드 할거임! -->
<form action="./form1_ok.jsp" method="post" enctype="multipart/form-data">
아이디 <input type="text" name="id"/><br>
file 1 <input type="file" name="upload1"/>
<br><hr/><br/>
<input type="submit" value="전송"/>
</form>
</body>
</html>