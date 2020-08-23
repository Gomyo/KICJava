<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="albummodel1.*" %>
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
		out.println("alert('댓글 삭제에 성공했습니다.');");
		out.println("location.href='../board/view.do?cpage="+ cpage + "&seq=" + seq + "';");	
	} else {
		out.println("alert('댓글 삭제에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>