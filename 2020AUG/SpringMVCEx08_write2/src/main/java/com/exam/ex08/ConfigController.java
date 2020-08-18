package com.exam.ex08;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {
	
	@RequestMapping(value="/write.do")
	public ModelAndView handleRequest1(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write");
		
		return modelAndView;
	}
	
	@GetMapping(value="/write_ok.do")
//	public ModelAndView handleRequest21(HttpServletRequest request, HttpServletResponse response) {
	public ModelAndView handleRequest21( @RequestParam(value="data1", defaultValue="초기값") String data) {
//		System.out.println("GET 방식 호출" + request.getParameter("data"));
		System.out.println("GET 방식 호출" + data);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write_ok");
//		modelAndView.addObject("data1", request.getParameter("data"));
		modelAndView.addObject("data1", data);
		
		return modelAndView;
	}
	
	@PostMapping(value="/write_ok.do")
	public ModelAndView handleRequest22(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("POST 방식 호출" + request.getParameter("data2"));
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write_ok");
		modelAndView.addObject("data2", request.getParameter("data2"));
		
		return modelAndView;
	}
}
