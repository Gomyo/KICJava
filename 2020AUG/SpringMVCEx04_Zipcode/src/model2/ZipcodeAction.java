package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.ZipcodeDAO;
import model1.ZipcodeTO;

public class ZipcodeAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<ZipcodeTO> lists = null;
		
		if (arg0.getParameter("dong") != null) {
			ZipcodeTO pto = new ZipcodeTO();
			pto.setDong(arg0.getParameter("dong"));
			
			ZipcodeDAO dao = new ZipcodeDAO();
			lists = dao.allZipcode(pto);
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("zipcodeForm");
		modelAndView.addObject("lists", lists);
		
		return modelAndView;
	}

}
