<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<BoardTO> lists = (ArrayList<BoardTO>)request.getAttribute("lists");
	int totalRecord = lists.size();
	
	StringBuffer strHtml = new StringBuffer();	

	for (BoardTO to : lists) {		
		String seq = to.getSeq();
		String subject =to.getSubject();
		String writer = to.getWriter();
		String wdate = to.getWdate();
		String hit = to.getHit();
		int wgap = to.getWgap();

		strHtml.append("<tr>");
		strHtml.append("<td>&nbsp;</td>");
		strHtml.append("<td>" + seq + "</td>");
		strHtml.append("<td class='left'>");
		strHtml.append("<a href='./view.do?seq=" + seq + "'>" + subject + "</a>");
		if( wgap == 0 ) {
			strHtml.append("&nbsp;<img src='../images/icon_hot.gif' alt='HOT'>");
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
<title>SimpleModel1Ex01</title>
<link rel="stylesheet" type="text/css" href="./css/board_list.css">
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
			<div class="bold">총 <span class="txt_orange"><%=totalRecord%></span>건</div>
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
			<!-- 게시글 시작-->
			<%= strHtml %>
			<!-- 게시글 끝 -->
			</table>
		</div>	
		<!--//게시판-->

		<div class="align_right">
			<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='./write.do'" />
		</div>
	</div>
</div>
<!--//하단 디자인 -->

</body>
</html>
