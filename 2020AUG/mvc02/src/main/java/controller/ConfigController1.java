package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class ConfigController1 {
	
	@RequestMapping("/list1.do")
	public String handleRequest1() {
		System.out.println("handleRequest1 호출");
		// page명
		return "listview1";
	}
}
