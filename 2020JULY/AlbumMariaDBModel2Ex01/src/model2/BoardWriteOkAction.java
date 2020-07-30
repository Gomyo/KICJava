package model2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import albummodel1.BoardDAO;
import albummodel1.BoardTO;

public class BoardWriteOkAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "BoardWriteOkAction" );

		String uploadPath = "C:/Java/jsp-workspace/AlbumMariaDBModel2Ex01/WebContent/upload/";
		int maxFileSize = 1024 * 1024 * 5;
		String encType = "utf-8";
		
		
		int flag = 1;
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest( request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());

			BoardTO to = new BoardTO();
				
			to.setSubject( multi.getParameter( "subject" ) );
			to.setWriter( multi.getParameter( "writer" ) );
			to.setMail( "" );
			if( !multi.getParameter( "mail1" ).equals("") && !multi.getParameter( "mail2" ).equals( "" ) ) {
				to.setMail( multi.getParameter( "mail1" ) + "@" + multi.getParameter( "mail2" ) );	
			}
			to.setPassword( multi.getParameter( "password" ) );
			to.setContent( multi.getParameter( "content" ) );
			to.setFilename( multi.getFilesystemName( "upload" ) );
			to.setFilesize( multi.getFile( "upload" ).length() ); 
			to.setWip( request.getRemoteAddr() );

			BoardDAO dao = new BoardDAO();
			flag = dao.boardWriteOk( to );

			request.setAttribute( "flag", flag );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
