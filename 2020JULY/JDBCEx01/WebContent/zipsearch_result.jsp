<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String dong = request.getParameter("dong");
	
	String url = "jdbc:mysql://localhost:3306/project";
	String user = "root";
	String password = "123456";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String result = "";
	
 	try {
         Class.forName("org.mariadb.jdbc.Driver");
         conn = DriverManager.getConnection(url, user, password);
         
         String sql ="select * from zipcode where dong like ?";
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
         // TODO Auto-generated catch block
         System.out.println("에러 : "+e.getMessage());
      } catch (SQLException e) {
    	  
      } finally {
         if(conn != null) try {conn.close();} catch(SQLException e) {}
         if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
         if(rs != null) try {rs.close();} catch(SQLException e) {}
      }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= result %>

</body>
</html>