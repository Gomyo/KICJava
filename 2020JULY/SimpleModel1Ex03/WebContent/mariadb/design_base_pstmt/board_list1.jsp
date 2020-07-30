<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int totalRecord = 0;
	StringBuffer strHtml = new StringBuffer();
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb1" );
		
		conn = dataSource.getConnection();
		
		String sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc";
		pstmt = conn.prepareStatement( sql );
		
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String seq = rs.getString( "seq" );
			String subject = rs.getString( "subject" );
			String writer = rs.getString( "writer" );
			String wdate = rs.getString( "wdate" );
			String hit = rs.getString( "hit" );
			int wgap = rs.getInt( "wgap");
			
			strHtml.append( "<tr>" );
			strHtml.append( "<td>&nbsp;</td>" );
			strHtml.append( "<td>" + seq + "</td>" );
			strHtml.append( "<td class='left'>" );
			strHtml.append( "	<a href='board_view1.jsp?seq=" + seq + "'>" + subject + "</a>" );
			if( wgap == 0 ) {
				strHtml.append( "	&nbsp;<img src='../../images/icon_hot.gif' alt='HOT'>" );
			}
			strHtml.append( "</td>" );
			strHtml.append( "<td>" + writer + "</td>" );
			strHtml.append( "<td>" + wdate + "</td>" );
			strHtml.append( "<td>" + hit + "</td>" );
			strHtml.append( "<td>&nbsp;</td>" );
			strHtml.append( "</tr>" );
		}
		
	} catch( NamingException e ) {
		System.out.println( "[에러] : " + e.getMessage() );
	} catch( SQLException e ) {
		System.out.println( "[에러] : " + e.getMessage() );
	} finally {
		if( rs != null ) rs.close();
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
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
