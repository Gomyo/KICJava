<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>

<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>

<%	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	StringBuffer xmlData = new StringBuffer();
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/ubuntu");
		conn = dataSource.getConnection();
		
		String sql = "select * from books";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		xmlData.append("<books>");
		while (rs.next()) {
			xmlData.append("<book>");
			xmlData.append("<name>").append(rs.getString("name")).append("</name>");
			xmlData.append("<publisher>").append(rs.getString("publisher")).append("</publisher>");
			xmlData.append("<author>").append(rs.getString("author")).append("</author>");
			xmlData.append("<price>").append(rs.getString("price")).append("</price>");
			xmlData.append("</book>");
		}
		xmlData.append("</books>");
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		System.out.println("[DAO DB에러 : ]" + e.getLocalizedMessage());
	} finally {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}
	}
	out.println(xmlData);
%>

