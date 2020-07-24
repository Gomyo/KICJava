<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.*" %>
<%
// if(session.getAttribute("s_id") == null) {
// 	out.println("<script type='text/javascript'>");
// 	out.println("alert('로그인 해야 합니다.');");
// 	out.println("location.href='./board_list1.jsp';");
// 	out.println("</script>");
// } 	else {
	BoardDTO dto = new BoardDTO();
	BoardDAO dao = new BoardDAO();
	
	String seq = request.getParameter("seq");
	String password = request.getParameter("password");
	String cpage = request.getParameter("cpage");
	System.out.println(seq);
	System.out.println(password);
	System.out.println(cpage);
	
	dto.setSeq(seq);
	dto.setPassword(password);
	int flag = dao.boardDeleteOk(dto);

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글 삭제에 성공했습니다.');");
		out.println("location.href='./board_list1.jsp?cpage=" + cpage + "';");	
	} else if (flag == 1){
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글삭제에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>