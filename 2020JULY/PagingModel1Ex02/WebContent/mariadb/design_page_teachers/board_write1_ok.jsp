<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="pageModel1.BoardDAO" %>
<%@ page import="pageModel1.BoardDTO" %>

<%
if(session.getAttribute("s_id") == null) {
	out.println("<script type='text/javascript'>");
	out.println("alert('로그인 해야 합니다.');");
	out.println("location.href='./board_list1.jsp';");
	out.println("</script>");
} 	else {
	request.setCharacterEncoding("UTF-8");
	BoardDTO dto = new BoardDTO();
	dto.setSubject(request.getParameter("subject"));
	dto.setWriter(request.getParameter("writer"));
	dto.setMail("");
	if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
		dto.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
	}
	dto.setPassword(request.getParameter("password"));
	dto.setContent(request.getParameter("content"));
	dto.setEmot(request.getParameter("emot").substring(4));
	dto.setWip(request.getRemoteAddr());
	
	BoardDAO dao = new BoardDAO();
	int flag = dao.boardWriteOk(dto);
	
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글쓰기에 성공했습니다.');");
		out.println("location.href='./board_list1.jsp';");
	} else {
		out.println("alert('글쓰기에 실패했습니다.');");
		out.println("history.back();");
	}
	
	out.println("</script>");
}
%>