package model3;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import albummodel1.*;
public class ModifyAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ModifyAction 호출");
		
		BoardTO dto = new BoardTO();
		dto.setSeq(arg0.getParameter( "seq" ));
		
		BoardDAO dao = new BoardDAO();
		dto = dao.boardModify(dto);
		
		arg0.setAttribute("to", dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1");
		modelAndView.addObject("modify", arg0);
		
		return modelAndView;
	}

}
