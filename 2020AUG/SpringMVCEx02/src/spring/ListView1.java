package spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListView1 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Call ListAction1()");
		
		// 모델과 뷰를 한번에 다 처리하는 방법
//		return new ModelAndView("listview1");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listView1");
		
		return modelAndView;
	}

}
