<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>

<%
	request.setCharacterEncoding("utf-8");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String writer = request.getParameter("writer");
	String password = request.getParameter("password");
	
	String url = "jdbc:mysql://localhost:3306/mysql";
	String user = "root";
	String pw = "123456";
	
	int flag = 1;
	int result = 0;
	
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,pw);
		
		String sql = "select count(*) from user where user=? && password=password(?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, writer);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			result = rs.getInt("count(*)");
		}
		if (result == 1) {
			flag = 0;
			session.setAttribute("s_writer",writer);
	 		session.setAttribute("s_grade","네카라쿠배");
		} else {
			out.println("회원 정보가 없습니다. ㅋㅋ루삥뽕빵빠라빵빵뿡삥");
		}
	} catch (ClassNotFoundException e) {
		System.out.println("[write에러] : "+e.getMessage());
	} catch (SQLException e) { 
		System.out.println("[write에러] : "+e.getMessage());
	} finally {
		if (conn != null) conn.close();
		if (pstmt != null) pstmt.close();
	}
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('로그인에 성공했습니다.');");
		out.println("location.href='./board_list1.jsp';");	
	} else {
		out.println("alert('로그인에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>