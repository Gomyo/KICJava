package com.exam.ex01;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConfigController {
	
	@RequestMapping("/write.do")
	public String handleRequest1() {
		return "write";
	}
	
	@RequestMapping(value="/write_ok.do", method=RequestMethod.GET)
	public String handleRequest21(HttpServletRequest req, HttpServletResponse res, Model model) {
		System.out.println("get 요청 : " + req.getParameter("data"));
		
		// Action
		req.setAttribute("data1", req.getParameter("data"));
		model.addAttribute("data2", req.getParameter("data"));
		
		return "write_ok";
	}
//	@RequestMapping(value="/write_ok.do", method=RequestMethod.GET)
//	public String handleRequest21(@RequestParam("data") String data, Model model) {
//		System.out.println("GET 요청 : " + data);
//		model.addAttribute("data2", data);
//		
//		return "write_ok";
//	}
//	@RequestMapping(value="/write_ok.do", method=RequestMethod.GET)
//	public String handleRequest21(String data, Locale locale, Model model) {
//		System.out.println("GET 요청 : " + data);
//		model.addAttribute("data2", data);
//		
//		return "write_ok";
//	}
	@RequestMapping(value="/write_ok.do", method=RequestMethod.POST)
	public String handleRequest22(HttpServletRequest req, HttpServletResponse res, Model model) {
		System.out.println("post 요청" + req.getParameter("data"));
		
		// Action
		req.setAttribute("data1", req.getParameter("data"));
		model.addAttribute("data2", req.getParameter("data"));
		
		return "write_ok";
	}
}
