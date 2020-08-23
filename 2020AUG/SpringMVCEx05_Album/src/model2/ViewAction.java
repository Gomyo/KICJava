package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import albummodel1.*;

public class ViewAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("ViewAction 호출");
		String cpage = request.getParameter( "cpage" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardView( to );
		
		String seq = to.getSeq();
		String subject = to.getSubject();
		String writer = to.getWriter();
		String mail = to.getMail();
		String wip = to.getWip();
		String wdate = to.getWdate();
		String hit = to.getHit();
		String content = to.getContent();
		String filename = to.getFilename();
		
		CommentDAO cdao = new CommentDAO();
		ArrayList<CommentTO> commentLists = cdao.commentList( to );
		
		request.setAttribute("cpage", cpage);
		request.setAttribute("seq", seq);
		request.setAttribute("subject", subject);
		request.setAttribute("writer", writer);
		request.setAttribute("mail", mail);
		request.setAttribute("wdate", wdate);
		request.setAttribute("hit", hit);
		request.setAttribute("content", content);
		request.setAttribute("filename", filename);
		request.setAttribute("commentLists", commentLists);
		
	}

}
