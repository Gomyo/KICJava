package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import share.ShareData;


public class ListAction1 implements Controller {
	private ShareData shareData;
	
	public void setShareData(ShareData shareData) {
		this.shareData = shareData;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("공유데이터 : " + shareData.getSharedata());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listView1");
		modelAndView.addObject("list1", arg0);
		
		return modelAndView;
	}

}