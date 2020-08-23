package model3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WriteAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("WriteAction 호출");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1");
		modelAndView.addObject("write", arg0);
		
		return modelAndView;
	}

}
