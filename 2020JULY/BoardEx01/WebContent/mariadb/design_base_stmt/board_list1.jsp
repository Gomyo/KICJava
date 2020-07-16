<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>

<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	StringBuffer strHtml = new StringBuffer();
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
		conn = dataSource.getConnection();
		// wdate 포맷을 변경할 때 다시 wdate로 컬럼 이름을 바꿔주는 것을 잊지 않게
		// DATEDIFF를 사용해 new 변수 계산
		// DB에서 계산해 버리는게 코드가 깔끔해 지는 듯. 나중에 변경하기도 편하고.
		String sql = "select seq, subject, writer, date_format(wdate,'%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc";
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			String seq = rs.getString("seq");
			String subject = rs.getString("subject");
			String writer = rs.getString("writer");
			String wdate = rs.getString("wdate");
			String hit = rs.getString("hit");
			int wgap = rs.getInt("wgap");
			
			strHtml.append("<tr>");
			strHtml.append("<td>&nbsp;</td>");
			strHtml.append("<td>"+ seq + "</td>");
			// PK를 가져오기 위해 seq를 append
			
			strHtml.append("<td class='left'>");
			strHtml.append("	<a href='board_view1.jsp?seq="+ seq +"'>"+ subject + "</a>");
			if (wgap == 0) {
				strHtml.append("	&nbsp;<img src='../../images/icon_hot.gif' alt='HOT'>");	
			}
			strHtml.append("</td>");
			strHtml.append("<td>"+ writer + "</td>");
			strHtml.append("<td>"+ wdate + "</td>");
			strHtml.append("<td>"+ hit + "</td>");
			strHtml.append("<td>&nbsp;</td>");
			strHtml.append("</tr>");
		}
	} catch (NamingException e) {
		System.out.println("[에러] : "+e.getMessage());
	} catch (SQLException e) { 
		System.out.println("[에러] : "+e.getMessage());
	} finally {
		if (conn != null) conn.close();
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
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
			<!-- 게시글 넣는 부분 -->
			<%= strHtml %>
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
