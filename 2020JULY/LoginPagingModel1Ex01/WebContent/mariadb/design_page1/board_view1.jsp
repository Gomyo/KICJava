<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="pageModel1.BoardDAO" %>
<%@ page import="pageModel1.BoardDTO" %>
<%
	request.setCharacterEncoding("UTF-8");

	if (session.getAttribute("s_writer") == null || session.getAttribute("s_grade") == null) {
		out.println("<script type='text/javascript'>");
		out.println("alert('로그인을 해야지 어디서 꼼수를!');");
		out.println("history.back();");
		out.println("</script>");
	}
	
	String seq = request.getParameter( "seq" );
	String cpage = request.getParameter("cpage");
	
	BoardDTO dto = new BoardDTO();
	dto.setSeq(seq);
	dto.setCpage(cpage);
	
	BoardDAO dao = new BoardDAO();
	dto = dao.boardView(dto);
	
	String subject = dto.getSubject();
	String writer = dto.getWriter();
	String mail = dto.getMail();
	String hit = dto.getHit();
	String wdate = dto.getWdate();
	String wip = dto.getWip();
	String emot = dto.getEmot();
	String content = dto.getContent();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/board_view.css">
</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
	<h3>게시판</h3>
	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>
</div>
<div class="con_txt">
	<div class="contents_sub">
		<!--게시판-->
		<div class="board_view">
			<table>
			<tr>
				<th width="10%">제목</th>
				<td width="60%"><img src="../../images/emoticon/emot<%=emot %>.png" width="25" /><%= subject %></td>
				<th width="10%">등록일</th>
				<td width="20%"><%= wdate %></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><%= writer %>(<%= mail %>)(<%= wip %>)</td>
				<th>조회</th>
				<td><%= hit %></td>
			</tr>
			<tr>
				<td colspan="4" height="200" valign="top" style="padding: 20px; line-height: 160%"><%= content %></td>
			</tr>
			</table>
		</div>

		<div class="btn_area">
			<div class="align_left">
				<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_list1.jsp?cpage=<%= cpage %>'" />
			</div>
			<div class="align_right">
				<input type="button" value="수정" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_modify1.jsp?cpage=<%= cpage %>&seq=<%=seq %>'" />
				<input type="button" value="삭제" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_delete1.jsp?cpage=<%= cpage %>&seq=<%=seq %>'" />
				<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='board_write1.jsp?cpage=<%= cpage %>'" />
			</div>
		</div>	
		<!--//게시판-->
	</div>
</div>
<!-- 하단 디자인 -->

</body>
</html>
