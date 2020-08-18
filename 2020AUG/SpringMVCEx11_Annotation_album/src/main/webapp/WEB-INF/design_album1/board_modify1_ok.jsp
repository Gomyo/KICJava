<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%
	int flag = (Integer)request.getAttribute("flag");
	String seq = (String)request.getAttribute("seq");
	String cpage = (String)request.getAttribute("cpage");
	
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글 수정에 성공했습니다.');");
		out.println("location.href='view.do?cpage="+ cpage +"&seq="+seq+"';");	
	} else if (flag == 1){
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글 수정에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");

%>