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
public class WriteOkAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		// 파일 업로드를 위한 코드
		String uploadPath = "C:/Coding/KICJava/workspace/SpringMVCEx05_Album/WebContent/upload";
		int maxFileSize = 1024 * 1024 * 5;
		String encType = "utf-8";
		
		try {
			MultipartRequest multi = new MultipartRequest(arg0, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
			
			BoardTO to = new BoardTO();
			to.setSubject(multi.getParameter("subject"));
			to.setWriter(multi.getParameter("writer"));
			to.setMail("");
			if (!multi.getParameter("mail1").equals("") && !multi.getParameter("mail2").equals("")) {
				to.setMail(multi.getParameter("mail1") + "@" + multi.getParameter("mail2"));
			}
			to.setPassword(multi.getParameter("password"));
			to.setContent(multi.getParameter("content"));
			to.setWip(arg0.getRemoteAddr());
			
			String filename = multi.getFilesystemName("upload");
			to.setFilename(filename);
			
			long filesize = 0;
			File file = multi.getFile("upload");
			// 파일 업로드 된 것이 있을 때 길이 리턴. if처리를 안하면 NPE
			if (file != null) {
				filesize = file.length();
			}
			to.setFilesize(filesize);
			
			BoardDAO dao = new BoardDAO();
			
			int flag = dao.boardWriteOk(to);
			arg0.setAttribute("flag", flag);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1_ok");
		modelAndView.addObject("write_ok", arg0);
		
		return modelAndView;
	}

}
