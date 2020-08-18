package model3;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import albummodel1.*;

public class ViewAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ViewAction 호출");
		String cpage = arg0.getParameter( "cpage" );
		
		BoardTO to = new BoardTO();
		to.setSeq( arg0.getParameter( "seq" ) );
		
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
		
		arg0.setAttribute("cpage", cpage);
		arg0.setAttribute("seq", seq);
		arg0.setAttribute("subject", subject);
		arg0.setAttribute("writer", writer);
		arg0.setAttribute("mail", mail);
		arg0.setAttribute("wdate", wdate);
		arg0.setAttribute("hit", hit);
		arg0.setAttribute("content", content);
		arg0.setAttribute("filename", filename);
		arg0.setAttribute("commentLists", commentLists);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_view1");
		modelAndView.addObject("view", arg0);
		
		return modelAndView;
	}

}
