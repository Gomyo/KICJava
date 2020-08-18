package com.exam.ex09;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GugudanController {
	
	@GetMapping(value="/gugudan.do")
	public ModelAndView handleRequest(
			@RequestParam(value="startDan", defaultValue = "1") String startDan, 
			@RequestParam(value="endDan", defaultValue = "9") String endDan) {
		
		StringBuffer sbHtml = new StringBuffer();
		
		if (startDan != null && endDan != null ) {
			int startNum = Integer.parseInt(startDan);
			int endNum = Integer.parseInt(endDan);
			sbHtml.append("<table border='1' width='1200'>");
			for (int i=startNum; i<=endNum; i++) {
				
				sbHtml.append("<tr>");
				for (int j=1; j<=9; j++) {
					sbHtml.append("<td>");
					sbHtml.append(String.format("%d X %d = %d", i,j,i*j));
					sbHtml.append("</td>");
				}
				sbHtml.append("</tr>");
				
			}
			sbHtml.append("</table>");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("gugudan");
		modelAndView.addObject("guguResult", sbHtml);
		
		return modelAndView;
	}
} 
