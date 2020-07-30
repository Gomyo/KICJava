<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%@ page import="model1.BoardDAO" %>
<%@ page import="java.util.ArrayList" %>
<%
	BoardDAO dao = new BoardDAO();
	ArrayList<BoardTO> lists = dao.boardList();
	StringBuffer strHtml = new StringBuffer();
	
	int totalRecord = lists.size();
	
	for (BoardTO dto : lists) {
		String seq = dto.getSeq();
		String subject = dto.getSubject();
		int wgap = dto.getWgap();
		String writer = dto.getWriter();
		String hit = dto.getHit();
		String wdate = dto.getWdate();
		
		strHtml.append("<tr>");
		strHtml.append("<td>&nbsp;</td>");
		strHtml.append("<td>" + seq + "</td>");
		strHtml.append("<td class='left'>");
		strHtml.append("	<a href='board_view1.jsp?seq=" + seq + "'>" + subject + "</a>");
		if (wgap == 0) {
		strHtml.append("	&nbsp;<img src='../../images/icon_hot.gif' alt='HOT'>");
		}
		strHtml.append("</td>");
		strHtml.append("<td>" + writer + "</td>");
		strHtml.append("<td>" + wdate + "</td>");
		strHtml.append("<td>" + hit + "</td>");
		strHtml.append("<td>&nbsp;</td>");
		strHtml.append("</tr>");
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/board_list.css">
</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
	<h3>게시판</h3>
	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>
</div>
<div class="con_txt">
	<div class="contents_sub">
		<div class="board_top">
			<div class="bold">총 <span class="txt_orange">1</span>건</div>
		</div>

		<!--게시판-->
		<div class="board">
			<table>
			<tr>
				<th width="3%">&nbsp;</th>
				<th width="5%">번호</th>
				<th>제목</th>
				<th width="10%">글쓴이</th>
				<th width="17%">등록일</th>
				<th width="5%">조회</th>
				<th width="3%">&nbsp;</th>
			</tr>
			<!-- 게시글 시작 -->
				<%=strHtml %>
			<!-- 게시글 끝 -->
			</table>
		</div>	
		<!--//게시판-->

		<div class="align_right">
			<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='board_write1.jsp'" />
		</div>
	</div>
</div>
<!--//하단 디자인 -->

</body>
</html>
