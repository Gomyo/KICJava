package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import albummodel1.CommentDAO;
import albummodel1.CommentTO;

public class CommentWriteOkAction implements CommentAction{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "CommentWriteOkAction" );
		
		String cpage = request.getParameter( "cpage" );
		String pseq =  request.getParameter( "pseq" );
		
		CommentTO cto = new CommentTO();
		cto.setPseq( request.getParameter( "pseq" ) );		
		cto.setWriter( request.getParameter( "cwriter" ) );
		cto.setPassword( request.getParameter( "cpassword" ) );
		cto.setContent( request.getParameter( "ccontent" ) );
		CommentDAO cdao = new CommentDAO();
		int flag = cdao.commentWriteOk( cto );
		
		request.setAttribute("flag", flag);
		request.setAttribute("cpage", cpage);
		request.setAttribute("pseq", pseq);
	}
}
