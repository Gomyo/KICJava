<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%
	request.setCharacterEncoding("utf-8");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String id = request.getParameter("writer");
	String password = request.getParameter("password");
	
	
	
	int flag = 1;
	int result = 0;
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
		conn = dataSource.getConnection();
		
		String sql = "select count(*) from user where user=? && password=password(?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			result = rs.getInt("count(*)");
		}
		System.out.println(result);
		if (result == 1) {
			//out.println("데이터 등록 성공");
			flag = 0;
			session.setAttribute("s_id",id);
	 		session.setAttribute("s_grade","A");
		} else {
			out.println("회원 정보가 없습니다.");
		}
	} catch (NamingException e) {
		System.out.println("[write에러] : "+e.getMessage());
	} catch (SQLException e) { 
		System.out.println("[write에러] : "+e.getMessage());
	} finally {
		if (conn != null) conn.close();
		if (pstmt != null) pstmt.close();
	}
// 	if (id.equals(validId) && password.equals(validPw)) {
// 		// 등록된 사용자
// 		flag = 0;
// 		session.setAttribute("s_id",id);
// 		session.setAttribute("s_grade","A");
// 	} else {
// 		flag = 1;
// 	}
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('로그인에 성공했습니다.');");
		out.println("location.href='./login_complete.jsp';");	
	} else {
		out.println("alert('로그인에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>