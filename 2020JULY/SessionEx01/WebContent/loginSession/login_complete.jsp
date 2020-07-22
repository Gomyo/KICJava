<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	if(session.getAttribute("s_id") == null || session.getAttribute("s_grade") == null) {
		//로그인 안한 상태
		out.println("<script type='text/javascript'>");
		out.println("alert('로그인에 실패했습니다.');");
		out.println("location.href='./login_form.jsp';");
		out.println("</script>");
	}
	
	else {
		//로그인 한 상태
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('loutbtn').onclick = function() {
			location.href = './logout_ok.jsp';
		}
	}
</script>
</head>
<body>
아이디 :
	<%=(String) session.getAttribute("s_id")%>
	등급 :
	<%=(String) session.getAttribute("s_grade")%>
<input type="button" id="loutbtn" value="로그아웃"/>
</body>
</html>