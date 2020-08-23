<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="albummodel1.BoardDAO" %>
<%@ page import="albummodel1.BoardTO" %>

<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.io.File" %>

<%
	int flag = (Integer)request.getAttribute( "flag" );
	String cpage = (String)request.getAttribute("cpage");
	String seq = (String)request.getAttribute("seq");
	
	out.println( "<script type='text/javascript'>" );
	if( flag == 0 ) {
		out.println( "alert('글수정에 성공했습니다.')" );
		out.println( "location.href='view.do?cpage=" + cpage + "&seq=" + seq + "'" );
	} else if( flag == 1 ) {
		out.println( "alert('비밀번호가 틀립니다.')" );
		out.println( "history.back()" );
	} else {
		out.println( "alert('글수정에 실패했습니다.')" );
		out.println( "history.back()" );	
	}
	out.println( "</script>" );
%>    