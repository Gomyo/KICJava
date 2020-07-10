<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	String sido = request.getParameter("sido");
	String gugun = request.getParameter("gugun");
	String dong = request.getParameter("dong");
	
	String url = "jdbc:mysql://localhost:3306/project";
	String user = "root";
	String password = "123456";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sidoResult = "";
	String gugunResult = "";
	String dongResult = "";
	
	String result = "";
	
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,password);
		
		String sql = "select distinct sido from zipcode";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			sidoResult += "<option value='"+rs.getString("sido")+"'>"+rs.getString("sido")+"</option>";
		}
	} catch (ClassNotFoundException e) {
		out.println("[에러]"+e.getMessage());
	} catch (SQLException e) {
		out.println("[에러]"+e.getMessage());
	} finally {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,password);
		
		String sql = "select distinct gugun from zipcode where sido like ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sido+"%");
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			gugunResult += "<option value='"+rs.getString("gugun")+"'>"+rs.getString("gugun")+"</option>";
		}
	} catch (ClassNotFoundException e) {
		out.println("[에러]"+e.getMessage());
	} catch (SQLException e) {
		out.println("[에러]"+e.getMessage());
	} finally {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,password);
		
		String sql = "select distinct dong from zipcode where gugun like ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gugun+"%");
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			dongResult += "<option value='"+rs.getString("dong")+"'>"+rs.getString("dong")+"</option>";
		}
	} catch (ClassNotFoundException e) {
		out.println("[에러]"+e.getMessage());
	} catch (SQLException e) {
		out.println("[에러]"+e.getMessage());
	} finally {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,password);
		
		String sql = "select * from zipcode where dong like ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dong+"%");
		rs = pstmt.executeQuery();
		
		result +="<table border='1' width='1000'>";
        while (rs.next()) {
	        result+= "<tr><td>"+rs.getString("zipcode")+"</td>";
	        result+= "<td>"+rs.getString("sido")+"</td>";
	        result+= "<td>"+rs.getString("gugun")+"</td>";
	        result+= "<td>"+rs.getString("dong")+"</td>";
	        result+= "<td>"+rs.getString("bunji")+"</td>";
	        result+= "<td>"+rs.getString("ri")+"</td>";
	        result+= "<td>"+rs.getString("seq")+"</td></tr>";
        }
        result+="</table>";
        
	} catch (ClassNotFoundException e) {
		out.println("[에러]"+e.getMessage());
	} catch (SQLException e) {
		out.println("[에러]"+e.getMessage());
	} finally {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("sido").onchange = function() {
			/* var sido = document.getElementById("sido").value;
			alert(sido); */
			document.frm.submit();
		}
		document.getElementById("gugun").onchange = function() {
			document.frm.submit();
		}
		document.getElementById("dong").onchange = function() {
			document.frm.submit();
		}
	}
</script>
</head>
<body>
<form action="zipsearch02.jsp" method="post" name="frm">
<select name="sido" id="sido">
	<option value="전체"></option>
	<%= sidoResult %>
</select>
<select name="gugun" id="gugun">
	<option value="전체">전체</option>
	<%= gugunResult %>
</select>
<select name="dong" id="dong">
	<option value="전체">전체</option>
	<%= dongResult %>
</select>
<%= result %>
</form>
</body>
</html>