package model2;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import albummodel1.*;

public class ModifyOkAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String uploadPath = "C:/Coding/eclipse/workspace/AlbumModel2Ex01/WebContent/upload";
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
			
			request.setAttribute("flag", flag);
			request.setAttribute("seq", seq);
			request.setAttribute("cpage", cpage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
