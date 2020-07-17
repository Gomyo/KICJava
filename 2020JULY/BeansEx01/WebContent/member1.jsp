<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	// 이렇게 하나하나 인스턴스화를 할 필요가 없다.
	// MemberTO to = new MemberTO();
%>
	<jsp:useBean id="to" class="pack1.MemberTO"/>
<%
	/* to.setId(request.getParameter("id"));
	to.setPassword(request .getParameter("password")); */
%>
	<jsp:setProperty name="to" property="id" value='<%= request.getParameter("id") %>'/>
	<jsp:setProperty name="to" property="password" value='<%= request.getParameter("password") %>'/>
<%
	/* out.println(to.getId() + "<br/>");
	out.println(to.getPassword() + "<br/>"); */
%>
	<jsp:getProperty name="to" property="id"/><br/>
	<jsp:getProperty name="to" property="password"/>