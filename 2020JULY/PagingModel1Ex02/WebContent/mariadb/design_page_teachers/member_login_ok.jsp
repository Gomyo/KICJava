<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teachers.*" %>
<%
	request.setCharacterEncoding("utf-8");

	MemberTO to = new MemberTO();
	
	to.setId(request.getParameter("id"));
	to.setPassword(request.getParameter("password"));
	
	MemberDAO dao = new MemberDAO();
	
	boolean flag = dao.checkLogin(to);
	
	out.println("<script type='text/javascript'>");
	if (flag) {
		session.setAttribute("s_id", to.getId());
		session.setAttribute("s_time", new java.util.Date());
		
		out.println("alert('로그인에 성공했습니다.');");
		out.println("location.href='./board_list1.jsp';");	
	} else {
		out.println("alert('로그인에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>
