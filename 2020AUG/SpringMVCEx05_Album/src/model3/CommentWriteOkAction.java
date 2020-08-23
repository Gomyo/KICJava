package model3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import albummodel1.CommentDAO;
import albummodel1.CommentTO;

public class CommentWriteOkAction implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "CommentWriteOkAction" );
		
		String cpage = arg0.getParameter( "cpage" );
		String pseq =  arg0.getParameter( "pseq" );
		
		CommentTO cto = new CommentTO();
		cto.setPseq( arg0.getParameter( "pseq" ) );		
		cto.setWriter( arg0.getParameter( "cwriter" ) );
		cto.setPassword( arg0.getParameter( "cpassword" ) );
		cto.setContent( arg0.getParameter( "ccontent" ) );
		CommentDAO cdao = new CommentDAO();
		int flag = cdao.commentWriteOk( cto );
		
		arg0.setAttribute("flag", flag);
		arg0.setAttribute("cpage", cpage);
		arg0.setAttribute("pseq", pseq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_comment1_ok");
		modelAndView.addObject("comment_ok", arg0);
		
		return modelAndView;
	}
}
