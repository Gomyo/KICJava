package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListAction2 implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ListAction1 호출");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listView2");
		modelAndView.addObject("list2", arg0);
		
		return modelAndView;
	}

}
