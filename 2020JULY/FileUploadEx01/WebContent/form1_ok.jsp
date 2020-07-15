<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.io.File" %>
<% 
	// 파일 업로드 시 정해야 할 것:
	// 1. 업로드 경로
	// 2. 제한 용량
	// 3. 인코딩
	
	String uploadPath = "C:/Coding/kicjava/2020JULY/FileUploadEx01/WebContent/Upload";
	int maxFileSize = 1024 * 1024 * 4; // 4MB(단위 : Byte)
	String encType = "utf-8";
	
	// 파일 업로드
	/* MultipartRequest multi
		= new MultipartRequest(
				request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy()); */
	// try / catch 형태로 변경
	MultipartRequest multi = null;
			
	try {
		multi = new MultipartRequest(request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
		// 실제 저장된 파일명
		out.println(multi.getFilesystemName("upload1")+"<br>");
		// 업로드된 파일명
		out.println(multi.getOriginalFileName("upload1")+"<br>");
		// 파일 크기
		File file = multi.getFile("upload1");
		out.println(file.length()+"<br>");
		// request로 받아 오면 파일을 받을 때 request를 사용하기 때문에 multi로 받아 와야 제대로 id를 받아온다.
		out.println("id : " + multi.getParameter("id") + "<br/>");
		out.println("ip : " + request.getRemoteAddr() + "<br/>");
	} catch (Exception e) {
		System.out.println("[Upload 에러]" + e.getMessage());
	}
				
		
%>