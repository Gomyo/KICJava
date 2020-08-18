<%@page import="model1.EmpTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set"%>

<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="config.SQLMapperInter" %>
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
	
	is = Resources.getResourceAsStream(resource);
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	sqlSession = sqlSessionFactory.openSession(true);
	
	// 동적으로 클래스를 로딩 (JDBC)
	sqlSession.getConfiguration().addMapper(SQLMapperInter.class);
	
	SQLMapperInter mapper = (SQLMapperInter)sqlSession.getMapper(SQLMapperInter.class);
	
	DeptTO to = new DeptTO();
	to.setDeptno("82");
	to.setDname("빨리빨리");
	to.setLoc("개발");
	
	int result = mapper.insert(to);
	if (result == 1) {
		out.println("입력성공");
	} else {
		out.println("입력실패");
	}
%>
</body>
</html>