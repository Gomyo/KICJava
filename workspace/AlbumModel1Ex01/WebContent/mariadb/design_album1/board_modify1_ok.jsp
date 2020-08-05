<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="albummodel1.*" %>

<%
// if(session.getattribute("s_id") == null) {
// 	out.println("<script type='text/javascript'>");
// 	out.println("alert('로그인 해야 합니다.');");
// 	out.println("location.href='./board_list1.jsp';");
// 	out.println("</script>");
// } 	else {
	request.setCharacterEncoding("UTF-8");
	
	String uploadPath = "C:/Coding/kicjava/2020JULY/AlbumModel1Ex01/WebContent/upload";
	int maxFileSize = 1024 * 1024 * 5;
	String encType = "utf-8";
	
	MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());

	// get
	String seq = multi.getParameter("seq");
	String cpage = multi.getParameter("cpage");
	String password = multi.getParameter("password");
	String subject = multi.getParameter("subject");
	String mail = "";
	if (!multi.getParameter("mail1").equals("") && !multi.getParameter("mail2").equals("")){
		mail = multi.getParameter("mail1") + "@" + multi.getParameter("mail2");	
	}
	String content = multi.getParameter("content");
	String filename = multi.getParameter("filename");
	String newfilename = multi.getFilesystemName("upload");
	long newfilesize = 0; 
	File newfile = multi.getFile("upload");
	if (newfile != null) {
		newfilesize = newfile.length();
	}
	
	BoardTO dto = new BoardTO();
	dto.setSeq(multi.getParameter("seq"));
	
	BoardDAO dao = new BoardDAO();
	
	dto.setSeq(seq);
	dto.setSubject(subject);
	dto.setMail(mail);
	dto.setPassword(password);
	dto.setContent(content);
	dto.setFilename(newfilename);
	dto.setFilesize(newfilesize);
	
	int flag = dao.boardModifyOk(dto);
	
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