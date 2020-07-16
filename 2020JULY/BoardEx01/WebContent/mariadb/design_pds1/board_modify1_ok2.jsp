<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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

<%	
	//파일 업로드를 위한 코드
	String uploadPath = "C:/Coding/kicjava/2020JULY/BoardEx01/WebContent/upload";
	int maxFileSize = 1024 * 1024 * 5;
	String encType = "utf-8";
	
	MultipartRequest multi
	= new MultipartRequest(
			request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
	
	String seq = multi.getParameter("seq");
	String cpage = multi.getParameter("cpage");
	String writer = multi.getParameter("writer");
	String subject = multi.getParameter("subject");
	String password = multi.getParameter("password");
	String content = multi.getParameter("content");
	String mail = "";
	
	if (!multi.getParameter("mail1").equals("") && ! multi.getParameter("mail2").equals("")){
		mail = multi.getParameter("mail1") + "@" + multi.getParameter("mail2");	
	}
	String newfilename = multi.getFilesystemName("upload");
	System.out.println(newfilename);
	long newfilesize = 0; 
	File newfile = multi.getFile("upload");
	if (newfile != null) {
		newfilesize = newfile.length();
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 데이터 수정 유무를 위한 flag 변수
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
		/* if (filename == newfilename) {
			newfilename = null;
		} */
		
		if (newfilename == null) {
			sql = "update pds_board set subject=?,mail=?, content=? where seq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, seq);
			pstmt.setString(5, password);
		} else {
			sql = "update pds_board set subject=?,mail=?, content=?, filename=?, filesize=? where seq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, newfilename);
			pstmt.setLong(5, newfilesize);
			pstmt.setString(6, seq);
			pstmt.setString(7, password);
		}
		
		int result = pstmt.executeUpdate();
		
		if (result == 0) {
			flag = 1;
		} else if (result == 1){
			flag = 0;
			if (newfilename != null && filename != null) {
				File file = new File("C:/Coding/kicjava/2020JULY/BoardEx01/WebContent/upload/" + filename);
				file.delete();
			}
		}
	} catch (NamingException e) {
		System.out.println("[modifyok에러] : "+e.getMessage());
	} catch (SQLException e) { 
		System.out.println("[modifyok에러] : "+e.getMessage());
	} finally {
		if (conn != null) conn.close();
		if (pstmt != null) pstmt.close();
	}
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글 수정에 성공했습니다.');");
		out.println("location.href='./board_view1.jsp?cpage="+ cpage +"&seq="+seq+"';");	
	} else if (flag == 1){
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글 수정에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>