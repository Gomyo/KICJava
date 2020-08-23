package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class ConfigController2 {
	
	@RequestMapping("/list2.do")
	public String handleRequest2() {
		System.out.println("handleRequest2 호출");
		// page명
		return "listview2";
	}
	
	@RequestMapping("/naver.do")
	public String handleRequest3() {
		System.out.println("handleRequest3 호출");
		return "redirect:http://www.naver.com";
	}
	
}
