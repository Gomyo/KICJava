<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie1 = new Cookie("c_id","");
	Cookie cookie2 = new Cookie("c_grade","");
	cookie1.setMaxAge(0);
	cookie2.setMaxAge(0);

	out.println("<script type='text/javascript'>");
	out.println("alert('로그아웃되었습니다.');");
	out.println("location.href='./login_form.jsp';");
	out.println("</script>");
%>