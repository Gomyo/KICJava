<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
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
<%@ page import="java.sql.ResultSet" %>

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
	String filename = multi.getParameter("filename");
	String newfile = multi.getFilesystemName("upload");
	
	System.out.println(filename);
	System.out.println(newfile);
	
	if (filename != newfile) {
		filename = newfile;
	}
	
	
	
	long filesize = 0;
	File file = multi.getFile("upload");
	// 파일 업로드 된 것이 있을 때 길이 리턴. if처리를 안하면 NPE
	if (file != null) {
		filesize = file.length();
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
		
		if (filename == "파일없음" || filename == newfile) {
			String sql = "update pds_board set subject=?,mail=?, content=? where seq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, seq);
			pstmt.setString(5, password);
		} else {
			String sql = "update pds_board set subject=?,mail=?, content=?, filename=?, filesize=? where seq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, filename);
			pstmt.setLong(5, filesize);
			pstmt.setString(6, seq);
			pstmt.setString(7, password);
		}
		int result = pstmt.executeUpdate();
		
		if (result == 0) {
			// 비밀번호 잘못 기입
			flag = 1;
		} else if (result == 1){
			// 정상적으로 기입
			flag = 0;
			if (filename != multi.getParameter("filename")) {
				System.out.println("삭제 성공");
				File file2 = new File("C:/Coding/kicjava/2020JULY/BoardEx01/WebContent/upload/" +multi.getParameter("filename"));
				file2.delete();
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