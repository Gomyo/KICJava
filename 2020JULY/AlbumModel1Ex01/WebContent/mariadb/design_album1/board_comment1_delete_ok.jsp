<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.*" %>
<%
	BoardDTO dto = new BoardDTO();
	BoardDAO dao = new BoardDAO();
	
	String seq = request.getParameter("seq");
	String password = request.getParameter("password");
	String cpage = request.getParameter("cpage");
	
	dto.setSeq(seq);
	dto.setPassword(password);
	int flag = dao.boardDeleteOk(dto);

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('댓글 쓰기에 성공했습니다.');");
		out.println("location.href='./board_view1.jsp?cpage="+ cpage + "&seq=" + seq + "';");	
	} else {
		out.println("alert('댓글 쓰기에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>