<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<%
	request.setCharacterEncoding("utf-8");

	int cpage = 1;
	
	if (request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) {
		cpage = Integer.parseInt(request.getParameter("cpage"));
	} else {
		cpage = 1;
	}
	
	//페이지당 출력될 데이터 갯수
	int recordPerPage = 10;
	int totalRecord = 0;
	// 전체 페이지 갯수
	int totalPage = 1;
	// 페이지 블록 변수
	int blockPerPage = 5;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer strHtml = new StringBuffer();
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb1");
		conn = dataSource.getConnection();
		
		String sql = "select seq, subject, writer, date_format(wdate,'%Y-%m-%d') wdate, emot, hit, datediff(now(), wdate) wgap from emoji_board order by seq desc";
		// ResultSet 옵션으로 커서의 진행 방향을 조절한다. 이걸 해야 이후의 rs 명령이 가능.
		pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = pstmt.executeQuery();
		
		
		// 맨 밑에 가서
		rs.last();
		// 커서를 찍는다.
		totalRecord = rs.getRow();
		// 그 뒤, 다시 돌아온다.
		rs.beforeFirst();
		
		// 자바 정수 나누기 정수는 정수이니 double 형으로 쓰려면 이렇게 
		double pageCount = (double)totalRecord/recordPerPage;
		totalPage = (int)Math.ceil(pageCount);
		// 아니면 이렇게
		/* totalPage = ((totalRecord-1)/recordPerPage) +1*/
		
		int skip = (cpage - 1) * recordPerPage;
		// absolute : 특정 위치로 보내버리는 함수
		if (skip != 0) rs.absolute(skip);
		
		// 마지막 페이지는 recordPerPage의 영향을 받지 않기 때문에 rs.next로 제한을 둬야 한다 
		for (int i=0; i<recordPerPage && rs.next(); i++) {
			String seq = rs.getString("seq");
			String subject = rs.getString("subject");
			String writer = rs.getString("writer");
			String wdate = rs.getString("wdate");
			String hit = rs.getString("hit");
			String emot = rs.getString("emot");
			int wgap = rs.getInt("wgap");
	
			strHtml.append("<tr>");
			strHtml.append("<td>&nbsp;</td>");
			strHtml.append("<td>" + seq + "</td>");
			strHtml.append("<td class='left'>");
			// &변수 링크를 넣을 때는 엠퍼샌드 까먹지 말 것
			strHtml.append("<img src='../../images/emoticon/emot"+ emot + ".png' width='25'/><a href='board_view1.jsp?cpage="+ cpage + "&seq=" + seq + "'>" + subject + "</a>");
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
	} catch (NamingException e) {
		System.out.println("[에러] : " + e.getMessage());
	} catch (SQLException e) {
		System.out.println("[에러] : " + e.getMessage());
	} finally {
		if (conn != null)
			conn.close();
		if (pstmt != null)
			pstmt.close();
		if (rs != null)
			rs.close();
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/board_list.css">
</head>

<body>
	<!-- 상단 디자인 -->
	<div class="con_title">
		<h3>게시판</h3>
		<p>
			HOME &gt; 게시판 &gt; <strong>게시판</strong>
		</p>
	</div>
	<div class="con_txt">
		<div class="contents_sub">
			<div class="board_top">
				<div class="bold">
					총 <span class="txt_orange">1</span>건
				</div>
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
					<%=strHtml%>
				</table>
			</div>
			<!--//게시판-->
			<!--페이지넘버-->
			<div class="paginate_regular">
<%
	int startBlock = ((cpage-1)/blockPerPage) * blockPerPage + 1;
	int endBlock = ((cpage-1)/blockPerPage) * blockPerPage + blockPerPage;
	// 마지막 페이지 예외처리
	if (endBlock >= totalPage) {
		endBlock = totalPage;
	}
%>
				<div align="absmiddle">
<%
	if (startBlock == 1){
		out.println("<span><a>&lt;&lt;</a></span>");	
	} else {
		out.println("<span><a href='board_list1.jsp?cpage=" + (startBlock - blockPerPage) + "'>&lt;&lt;</a></span>");
	}
	out.println("&nbsp;");
	
	if(cpage==1){
		out.println("<span><a>&lt;</a></span>");
	} else {
		out.println("<span><a href='board_list1.jsp?cpage="+ (cpage-1) +"'>&lt;</a></span>");
	}
	out.println("&nbsp;&nbsp;");
	
	for (int i=startBlock; i<=endBlock; i++){
		if (cpage == i) {
			// span : 줄바꿈을 안하는 태그
			out.println("<span><a>["+ i +"]</a></span>");
		} else {
			out.println("<span><a href='board_list1.jsp?cpage="+ i +"'>"+ i +"</a></span>");
		}
	}
	
	out.println("&nbsp;&nbsp; ");
	
	if(cpage==totalPage){
		out.println("<span><a>&gt;</a></span>");
	} else {
		out.println("<span><a href='board_list1.jsp?cpage="+ (cpage+1) +"'>&gt;</a></span>");
	}
	
	out.println("&nbsp;");
	
	if (endBlock == totalPage){
		out.println("<span><a>&gt;&gt;</a></span>");	
	} else {
		out.println("<span><a href='board_list1.jsp?cpage=" + (startBlock+blockPerPage) + "'>&gt;&gt;</a></span>");
	}
	
%>
	</div>
		</div>
			<!--//페이지넘버-->
			<div class="align_right">
				<input type="button" value="쓰기" class="btn_write btn_txt01"
					style="cursor: pointer;" onclick="location.href='board_write1.jsp?cpage=<%= cpage %>'" />
			</div>
		</div>
	</div>
	<!--//하단 디자인 -->

</body>
</html>
