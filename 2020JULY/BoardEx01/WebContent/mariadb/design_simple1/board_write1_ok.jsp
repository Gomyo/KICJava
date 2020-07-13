<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %>

<%
	// 인코딩
	request.setCharacterEncoding("UTF-8");
	// 필요한 값 모두 받아오기
	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	// 메일은 받지 않는 경우의 예외 처리를 해 줘야 함
	String mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
	String wip = request.getRemoteAddr();
	
	Connection conn = null;
	Statement stmt = null;
	
	// 데이터 등록 유무를 위한 flag 변수
	int flag = 0;
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
		conn = dataSource.getConnection();
		String sql = String.format("insert into board values(0,'%s','%s','%s','%s','%s',0,'%s',now())",subject, writer, mail,password,content,wip);
		//out.println("sql 전달 확인 : " + sql);
		stmt = conn.createStatement();
		
		int result = stmt.executeUpdate(sql);
		if (result == 1) {
			//out.println("데이터 등록 성공");
			flag = 0;
		} else {
			out.println("데이터 등록 실패");
		}
	} catch (NamingException e) {
		System.out.println("[에러] : "+e.getMessage());
	} catch (SQLException e) { 
		System.out.println("[에러] : "+e.getMessage());
	} finally {
		if (conn != null) conn.close();
		if (stmt != null) stmt.close();
	}
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글쓰기에 성공했습니다.');");
		out.println("location.href='./board_list1.jsp';");	
	} else {
		out.println("alert('글쓰기에 성공했습니다.');");
		out.println("history.back();");
	}
	
	out.println("</script>");
%>