package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import albummodel1.BoardDAO;
import albummodel1.BoardTO;
import albummodel1.CommentDAO;
import albummodel1.CommentTO;

public class BoardViewAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "BoardViewAction" );
			
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardView( to );
		
		CommentDAO cdao = new CommentDAO();
		ArrayList<CommentTO> cLists = cdao.commentList( to );
		
		request.setAttribute( "cpage", request.getParameter( "cpage" ) );
		request.setAttribute( "to", to );
		request.setAttribute( "cLists", cLists );
	}

}
