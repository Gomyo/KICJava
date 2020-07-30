<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%@ page import="model1.BoardDAO" %>
<%
	request.setCharacterEncoding( "utf-8" );
	
	BoardTO dto = new BoardTO();
	BoardDAO dao = new BoardDAO();
	
	String seq = request.getParameter("seq");
	String password = request.getParameter("password");
	
	dto.setSeq(seq);
	dto.setPassword(password);
	int flag = dao.boardDeleteOk(dto);
	
	out.println( "<script type='text/javascript'>" );
	if( flag == 0 ) {
		out.println( "alert( '글삭제에 성공했습니다.' );" );
		out.println( "location.href='./board_list1.jsp';" );
	} else if( flag == 1 ) {
		out.println( "alert( '비밀번호가 잘못되었습니다.' );" );
		out.println( "history.back();" );
	} else {
		out.println( "alert( '글삭제에 실패했습니다.' );" );
		out.println( "history.back();" );
	}
	out.println( "</script>'" );
%>



