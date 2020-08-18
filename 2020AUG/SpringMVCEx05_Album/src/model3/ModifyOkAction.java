package model3;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import albummodel1.*;

public class ModifyOkAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		try {
			String uploadPath = "C:/Coding/KICJava/workspace/SpringMVCEx05_Album/WebContent/upload";
			int maxFileSize = 1024 * 1024 * 5;
			String encType = "utf-8";
			
			MultipartRequest multi = new MultipartRequest(arg0, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());

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
			
			arg0.setAttribute("flag", flag);
			arg0.setAttribute("seq", seq);
			arg0.setAttribute("cpage", cpage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1_ok");
		modelAndView.addObject("modify_ok", arg0);
		
		return modelAndView;
	}

}
