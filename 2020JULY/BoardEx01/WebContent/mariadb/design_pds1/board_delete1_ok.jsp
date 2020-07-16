<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.File" %> <!-- 파일 삭제를 위해 삽입 -->

<%
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");
	
	String password = request.getParameter("password");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int flag = 2;
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
		conn = dataSource.getConnection();
		
		String sql = "select filename from pds_board where seq=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);
		
		rs = pstmt.executeQuery();
		
		String filename = null;
		if (rs.next()) {
			filename = rs.getString("filename");
		}
	
		sql = "delete from pds_board where seq=? and password=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);
		pstmt.setString(2, password);
		
		int result = pstmt.executeUpdate();
		
		if (result == 0) {
			// 비밀번호 잘못 기입
			flag = 1;
		} else if (result == 1){
			// 정상적으로 기입
			flag = 0;
			// 파일 삭제
			if (filename != null) {
				File file = new File("C:/Coding/kicjava/2020JULY/BoardEx01/WebContent/upload/" +filename);
				file.delete();
			}
		}
	} catch (NamingException e) {
		System.out.println("[delok에러] : "+e.getMessage());
	} catch (SQLException e) { 
		System.out.println("[delok에러] : "+e.getMessage());
	} finally {
		if (conn != null) conn.close();
		if (pstmt != null) pstmt.close();
	}
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글 삭제에 성공했습니다.');");
		out.println("location.href='./board_list1.jsp?cpage=" + cpage + "';");	
	} else if (flag == 1){
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글삭제에 실패했습니다.');");
		out.println("history.back();");
	}
	
	out.println("</script>");
%>