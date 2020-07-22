<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardDAO" %>
<%@ page import="model1.BoardDTO" %>

<%
	request.setCharacterEncoding( "utf-8" );
	// 1. 데이터를 TO에 담는다.
	BoardDTO dto = new BoardDTO();
	dto.setSubject(request.getParameter( "subject" ));
	dto.setWriter(request.getParameter( "writer" ));
	dto.setMail("");
	
	if( !request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("") ) {
		dto.setMail(request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ));
	}
	dto.setPassword(request.getParameter( "password" ));
	dto.setContent(request.getParameter( "content" ));

	dto.setWip(request.getRemoteAddr());
	
	// 2. DB와의 커넥션!
	// model1을 짤 때 jsp 속에 DB 연결과 관련된 문장이 있으면 안된다.
	BoardDAO dao = new BoardDAO();
	int flag = dao.boardWriteOk(dto);
	
	out.println( "<script type='text/javascript'>" );
	if( flag == 0 ) {
		out.println( "alert( '글쓰기에 성공했습니다.' );" );
		out.println( "location.href='./board_list1.jsp';" );
	} else {
		out.println( "alert( '글쓰기에 실패했습니다.' );" );
		out.println( "history.back();" );
	}
	out.println( "</script>'" );
%>






