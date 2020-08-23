package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import share.ShareData;

public class ListAction2 implements Controller {
	private ShareData shareData;

	public void setShareData(ShareData shareData) {
		this.shareData = shareData;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		shareData.setSharedata("변경된 데이터");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listView2");
		modelAndView.addObject("list2", arg0);

		return modelAndView;
	}

}
