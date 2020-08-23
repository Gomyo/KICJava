package model3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import albummodel1.*;

public class DeleteAction implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DeleteAction 호출");
		
		BoardTO to = new BoardTO();
		to.setSeq(arg0.getParameter("seq"));
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardDelete(to);
		
		arg0.setAttribute("to", to);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_delete1");
		modelAndView.addObject("delete", arg0);
		
		return modelAndView;
	}

}
