<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.*" %>
<%	
	String cSeq = request.getParameter("cSeq");
	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");
	
	System.out.println(cSeq);
	System.out.println(seq);
	System.out.println(cpage);
	
	CommentDAO cdao = new CommentDAO();
	
	int flag = 0;
	
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