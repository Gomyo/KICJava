<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>

<%
	// 인코딩
	request.setCharacterEncoding("UTF-8");
	// 필요한 값 모두 받아오기
	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	String emot = request.getParameter("emot");
	emot = emot.substring(4);
	/* System.out.println(emot); */
	
	// 메일은 받지 않는 경우의 예외 처리를 해 줘야 함
	String mail = "";
	if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")){
		mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");	
	}
	String wip = request.getRemoteAddr();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	int flag = 0;
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
		conn = dataSource.getConnection();
		
		String sql = "insert into emoji_board values(0,?,?,?,?,?,?,0,?,now())";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, subject);		
		pstmt.setString(2, writer);		
		pstmt.setString(3, mail);		
		pstmt.setString(4, password);		
		pstmt.setString(5, content);
		pstmt.setString(6, emot);
		pstmt.setString(7, wip);	
		
		int result = pstmt.executeUpdate();
		
		if (result == 1) {
			//out.println("데이터 등록 성공");
			flag = 0;
		} else {
			out.println("데이터 등록 실패");
		}
	} catch (NamingException e) {
		System.out.println("[write에러] : "+e.getMessage());
	} catch (SQLException e) { 
		System.out.println("[write에러] : "+e.getMessage());
	} finally {
		if (conn != null) conn.close();
		if (pstmt != null) pstmt.close();
	}
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글쓰기에 성공했습니다.');");
		out.println("location.href='./board_list1.jsp';");	
	} else {
		out.println("alert('글쓰기에 실패했습니다.');");
		out.println("history.back();");
	}
	
	out.println("</script>");
%>