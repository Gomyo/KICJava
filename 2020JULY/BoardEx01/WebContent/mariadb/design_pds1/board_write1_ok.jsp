<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.io.File" %>

<%
	// 파일 업로드를 위한 코드
	String uploadPath = "C:/Coding/kicjava/2020JULY/BoardEx01/WebContent/upload";
	int maxFileSize = 1024 * 1024 * 5;
	String encType = "utf-8";
	
	MultipartRequest multi
	= new MultipartRequest(
			request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
	// 인코딩 필요 없어지니 삭제하고 request 싹다 multi로 변경 (ip 제외)
	String writer = multi.getParameter("writer");
	String subject = multi.getParameter("subject");
	String password = multi.getParameter("password");
	String content = multi.getParameter("content");
	
	String mail = "";
	if (!multi.getParameter("mail1").equals("") && ! multi.getParameter("mail2").equals("")){
		mail = multi.getParameter("mail1") + "@" + multi.getParameter("mail2");	
	}
	String wip = request.getRemoteAddr();
	
	String filename = multi.getFilesystemName("upload");
	
	long filesize = 0;
	File file = multi.getFile("upload");
	// 파일 업로드 된 것이 있을 때 길이 리턴. if처리를 안하면 NPE
	if (file != null) {
		filesize = file.length();
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	int flag = 0;
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
		conn = dataSource.getConnection();
		
		String sql = "insert into pds_board values(0,?,?,?,?,?,?,?,0,?,now())";
		// insert into pds_board values(0,?,?,?,)
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, subject);		
		pstmt.setString(2, writer);		
		pstmt.setString(3, mail);		
		pstmt.setString(4, password);		
		pstmt.setString(5, content);
		pstmt.setString(6, filename);
		pstmt.setLong(7, filesize);
		pstmt.setString(8, wip);
		
		int result = pstmt.executeUpdate();
		
		if (result == 1) {
			//out.println("데이터 등록 성공");
			flag = 0;
		} else {
			out.println("데이터 등록 실패");
		}
	} catch (NamingException e) {
		System.out.println("[write에러] : "+e.getMessage());
	} catch (SQLException e) { 
		System.out.println("[write에러] : "+e.getMessage());
	} finally {
		if (conn != null) conn.close();
		if (pstmt != null) pstmt.close();
	}
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글쓰기에 성공했습니다.');");
		out.println("location.href='./board_list1.jsp';");	
	} else {
		out.println("alert('글쓰기에 실패했습니다.');");
		out.println("history.back();");
	}
	
	out.println("</script>");
%>