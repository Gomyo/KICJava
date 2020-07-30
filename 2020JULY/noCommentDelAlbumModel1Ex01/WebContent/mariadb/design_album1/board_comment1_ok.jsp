<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.*" %>
<%
	request.setCharacterEncoding("utf-8");

	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");
	String cwriter = request.getParameter("cwriter");
	String cpassword = request.getParameter("cpassword");
	String ccontent = request.getParameter("ccontent");
	
	CommentDTO dto = new CommentDTO();
	
	dto.setSeq(seq);
	dto.setCwriter(cwriter);
	dto.setCpassword(cpassword);
	dto.setCcontent(ccontent);
	
	CommentDAO dao = new CommentDAO();
	int flag = dao.commentWriteOk(dto);
	
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