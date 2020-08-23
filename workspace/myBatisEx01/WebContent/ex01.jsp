<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>

<%@ page import="model1.DeptTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String resource = "myBatisConfig.xml";

	InputStream is = null;
	SqlSession sqlSession = null;
	
	StringBuffer sbHtml = new StringBuffer();
	
	is = Resources.getResourceAsStream(resource);
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	sqlSession = sqlSessionFactory.openSession(true);
	
// 	List<DeptTO> lists = sqlSession.selectList("selectlist1");
	ArrayList<DeptTO> lists = (ArrayList)sqlSession.selectList("selectlist1");
	
	sbHtml.append("<table border='1'>");
	for (DeptTO to : lists) {
		sbHtml.append("<tr>");
		sbHtml.append("<td>"+ to.getDeptno() +"</td>");
		sbHtml.append("<td>"+ to.getDname() +"</td>");
		sbHtml.append("<td>"+ to.getLoc()+"</td>");
		sbHtml.append("</tr>");
	}
	sbHtml.append("</table>");
%>
<%= sbHtml %>
</body>
</html>