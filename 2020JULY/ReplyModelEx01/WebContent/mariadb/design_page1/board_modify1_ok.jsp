<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pageModel1.BoardDAO" %>
<%@ page import="pageModel1.BoardDTO" %>

<%
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");
	String password = request.getParameter("password");
	String subject = request.getParameter("subject");
	String mail = "";
	if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")){
		mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");	
	}
	String content = request.getParameter("content");
	String emot = request.getParameter("emot");
	emot = emot.substring(4);
	BoardDTO dto = new BoardDTO();
	dto.setSeq(request.getParameter( "seq" ));
	BoardDAO dao = new BoardDAO();
	
	dto.setEmot(emot);
	dto.setSeq(seq);
	dto.setSubject(subject);
	dto.setMail(mail);
	dto.setPassword(password);
	dto.setContent(content);
	
	int flag = dao.boardModifyOk(dto);
	
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글 수정에 성공했습니다.');");
		out.println("location.href='./board_view1.jsp?cpage="+ cpage +"&seq="+seq+"';");	
	} else if (flag == 1){
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글 수정에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>