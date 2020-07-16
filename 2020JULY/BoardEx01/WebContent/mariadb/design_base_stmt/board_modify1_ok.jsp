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
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
	String password = request.getParameter("password");
	String subject = request.getParameter("subject");
	String mail = "";
	if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")){
		mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");	
	}
	String content = request.getParameter("content");
	
	Connection conn = null;
	Statement stmt = null;
	
	// 데이터 수정 유무를 위한 flag 변수
	int flag = 2;
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
		conn = dataSource.getConnection();
		// %s 쓸 때 ''로 감싸주는 것을 잊지 말 것
		String sql = String.format("update board set subject='%s',mail='%s', content='%s' where seq=%s and password='%s'", subject,mail,content,seq,password);
		stmt = conn.createStatement();
		
		int result = stmt.executeUpdate(sql);
		if (result == 0) {
			// 비밀번호 잘못 기입
			flag = 1;
		} else if (result == 1){
			// 정상적으로 기입
			flag = 0;
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
		out.println("alert('글 수정에 성공했습니다.');");
		out.println("location.href='./board_view1.jsp?seq="+seq+"';");	
	} else if (flag == 1){
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글 수정에 실패했습니다.');");
		out.println("history.back();");
	}
	
	out.println("</script>");
%>