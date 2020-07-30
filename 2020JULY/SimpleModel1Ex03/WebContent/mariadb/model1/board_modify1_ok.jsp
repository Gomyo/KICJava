<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%@ page import="model1.BoardDAO" %>

<%
	request.setCharacterEncoding( "utf-8" );
	BoardTO dto = new BoardTO();
	dto.setSeq(request.getParameter( "seq" ));
	BoardDAO dao = new BoardDAO();
	
	String seq = request.getParameter("seq");
	String subject = request.getParameter( "subject" );
	String mail = "";
	if( !request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("") ) {
		mail = request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" );
	}
	String password = request.getParameter( "password" );
	String content = request.getParameter( "content" );
	
	dto.setSeq(seq);
	dto.setSubject(subject);
	dto.setMail(mail);
	dto.setPassword(password);
	dto.setContent(content);
	
	int flag = dao.boardModifyOk(dto);
	
	out.println( "<script type='text/javascript'>" );
	if( flag == 0 ) {
		out.println( "alert( '글수정에 성공했습니다.' );" );
		out.println( "location.href='./board_view1.jsp?seq=" +seq + "';" );
	} else if( flag == 1 ) {
		out.println( "alert( '비밀번호가 잘못되었습니다.' );" );
		out.println( "history.back();" );
	} else {
		out.println( "alert( '글수정에 실패했습니다.' );" );
		out.println( "history.back();" );
	}
	out.println( "</script>'" );
%>
