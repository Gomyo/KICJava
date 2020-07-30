<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="model1.*" %>
	
<%	
	request.setCharacterEncoding("utf-8");
	int cpage = 1;
	if (request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) {
		cpage = Integer.parseInt(request.getParameter("cpage"));
	} else {
		cpage = 1;
	} 
	
	BoardListDTO listDTO = new BoardListDTO();
	listDTO.setCpage(cpage);
	
	BoardDAO dao = new BoardDAO();
	listDTO = dao.boardList(listDTO);
	
	int totalRecord = listDTO.getTotalRecord();
	int totalPage = listDTO.getTotalPage();
	int blockPerPage = listDTO.getBlockPerPage();
	int startBlock = listDTO.getStartBlock();
	int endBlock = listDTO.getEndBlock();

	ArrayList<BoardDTO> boardLists = listDTO.getBoardLists();
	StringBuffer strHtml = new StringBuffer();
	
	int imgcount = 0;
	
	for (BoardDTO dto : boardLists) {
		String seq = dto.getSeq();
		String subject = dto.getSubject();
		String writer = dto.getWriter();
		String wdate = dto.getWdate();
		String hit = dto.getHit();
		String filename = dto.getFilename();
		int wgap = dto.getWgap();
		
		// 코멘트 수 뽑아오기
		CommentDTO cDTO = new CommentDTO();
		cDTO.setSeq(seq);
		CommentDAO cdao = new CommentDAO();
		cDTO = cdao.commentlist(cDTO);
		
		int totalComments = cDTO.getCommentAll();
		
		if (imgcount%5 == 0 && imgcount != 0) {
			strHtml.append("</tr>");	
		}
		if (imgcount%5 == 0 && imgcount != 5) {
			strHtml.append("<tr>");	
		}
		strHtml.append("<td width='20%' class='last2'>");
		
		strHtml.append("<div class='board'>");
		strHtml.append("<table class='boardT'>");
		strHtml.append("<tr>");
		strHtml.append("<td class='boardThumbWrap'>");
		strHtml.append("<div class='boardThumb'>");
		if (filename == null) {
			strHtml.append("	<a href='board_view1.jsp?cpage="
					+ cpage + "&seq=" + seq +"'><img src='../../images/noimage3.jpg' border='0' width='100%' /></a>");
		} else {
			strHtml.append("	<a href='board_view1.jsp?cpage="
					+ cpage + "&seq=" + seq +"'><img src='../../upload/"+ filename +"' border='0' width='100%' /></a>");
		}
		
		strHtml.append("</div></td></tr><tr><td>");
		strHtml.append("<div class='boardItem'>");
		strHtml.append("<strong>"+ subject +"</strong>");
		strHtml.append("<span class='coment_number'><img src='../../images/icon_comment.png' alt='comment'>" + totalComments + "</span>");
		if (wgap == 0) {
			strHtml.append("	&nbsp;<img src='../../images/icon_hot.gif' alt='HOT'>");	
		}
		strHtml.append("</div></td></tr><tr>");
		strHtml.append("<td><div class='boardItem'><span class='bold_blue'>"+ writer +"</span></div></td>");
		strHtml.append("</tr>");
		strHtml.append("<tr>");
		strHtml.append("<td><div class='boardItem'>"+ wdate +"<font>|</font> Hit "+ hit +"</div></td>");
		strHtml.append("</tr>");
		strHtml.append("</table></div></td>");
		imgcount++;	
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
<style type="text/css">
<!--
	.board_pagetab { text-align: center; }
	.board_pagetab a { text-decoration: none; font: 12px verdana; color: #000; padding: 0 3px 0 3px; }
	.board_pagetab a:hover { text-decoration: underline; background-color:#f2f2f2; }
	.on a { font-weight: bold; }
-->
</style>
</head>

<body>
<!-- 상단 디자인 -->
<div class="contents1"> 
	<div class="con_title"> 
		<p style="margin: 0px; text-align: right">
			<img style="vertical-align: middle" alt="" src="../../images/home_icon.gif" /> &gt; 커뮤니티 &gt; <strong>여행지리뷰</strong>
		</p>
	</div> 
	<div class="contents_sub">	
		<div class="board_top">
			<div class="bold">
				<p>총 <span class="txt_orange">1</span>건</p>
			</div>
		</div>	
		
		<!--게시판-->
		<table class="board_list">
		<%=strHtml %>
		</table>
		<!--//게시판-->	
		
		<div class="align_right">		
			<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='board_write1.jsp'" />
		</div>
		<!--페이지넘버-->
		<div class="paginate_regular">
			<div class="board_pagetab">
				<%
						if (startBlock == 1) {
						out.println("<span><a>&lt;&lt;</a></span>");
					} else {
						out.println("<span><a href='board_list1.jsp?cpage=" + (startBlock - blockPerPage) + "'>&lt;&lt;</a></span>");
					}
					out.println("&nbsp;");

					if (cpage == 1) {
						out.println("<span><a>&lt;</a></span>");
					} else {
						out.println("<span><a href='board_list1.jsp?cpage=" + (cpage - 1) + "'>&lt;</a></span>");
					}
					out.println("&nbsp;&nbsp;");

					for (int i = startBlock; i <= endBlock; i++) {
						if (cpage == i) {
							// span : 줄바꿈을 안하는 태그
							out.println("<span><a>[" + i + "]</a></span>");
						} else {
							out.println("<span><a href='board_list1.jsp?cpage=" + i + "'>" + i + "</a></span>");
						}
					}

					out.println("&nbsp;&nbsp; ");

					if (cpage == totalPage) {
						out.println("<span><a>&gt;</a></span>");
					} else {
						out.println("<span><a href='board_list1.jsp?cpage=" + (cpage + 1) + "'>&gt;</a></span>");
					}

					out.println("&nbsp;");

					if (endBlock == totalPage) {
						out.println("<span><a>&gt;&gt;</a></span>");
					} else {
						out.println("<span><a href='board_list1.jsp?cpage=" + (startBlock + blockPerPage) + "'>&gt;&gt;</a></span>");
					}
					%>
			</div>
		</div>
		<!--//페이지넘버-->	
  	</div>
</div>
<!--//하단 디자인 -->

</body>
</html>
