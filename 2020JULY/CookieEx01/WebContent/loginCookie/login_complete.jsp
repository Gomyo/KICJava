<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	int flag = 1;
	Cookie[] cookies = request.getCookies();
	if( cookies != null && cookies.length > 0 ) {
		//쿠키 있음
		for (int i=0; i<cookies.length; i++) {
			if (cookies[i].getName().equals("c_id")) {
				//정상데이터
				flag = 0;
				break;
			};
		}
	}
	if (flag == 0) {
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
	로그인 성공
	<input type="button" id="loutbtn" value="	로그아웃" />
</body>
</html>
<%
	} else {
		out.println("<script type='text/javascript'>");
		out.println("alert('로그인에 실패했습니다.');");
		out.println("location.href='./login_form.jsp';");
		out.println("</script>");
}
%>
