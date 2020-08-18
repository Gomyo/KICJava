package model3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import albummodel1.*;

public class DeleteOkAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DeleteOkAction 호출");
		
		BoardTO dto = new BoardTO();
		BoardDAO dao = new BoardDAO();
		
		String seq = arg0.getParameter("seq");
		String password = arg0.getParameter("password");
		String cpage = arg0.getParameter("cpage");
		
		dto.setSeq(seq);
		dto.setPassword(password);
		int flag = dao.boardDeleteOk(dto);
		
		arg0.setAttribute("flag", flag);
		arg0.setAttribute("seq", seq);
		arg0.setAttribute("cpage", cpage);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_delete1_ok");
		modelAndView.addObject("delete_ok", arg0);
		
		return modelAndView;
	}

}
