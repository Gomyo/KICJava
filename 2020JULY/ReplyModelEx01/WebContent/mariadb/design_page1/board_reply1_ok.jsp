<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="pageModel1.BoardDAO" %>
<%@ page import="pageModel1.BoardDTO" %>

<%
	request.setCharacterEncoding("UTF-8");
	String cpage = request.getParameter("cpage");
	String seq = request.getParameter("seq");
	
	BoardDTO dto = new BoardDTO();
	dto.setCpage(cpage);
	dto.setSeq(seq);
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
	
	int flag = dao.boardReplyOk(dto);
	
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('답글쓰기에 성공했습니다.');");
		out.println("location.href='./board_list1.jsp?cpage"+cpage+"&seq="+seq+"';");
	} else {
		out.println("alert('답글쓰기에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>