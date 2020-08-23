package com.exam.ex01;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model1.ZipcodeDAO;
import model1.ZipcodeTO;

@Controller
public class ZipcodeController {
	
	@RequestMapping(value="/zipcode.do")
	public String handleRequest1(Model model, @RequestParam(value="dong", defaultValue = "초지") String dong) {
		System.out.println("집코드" + dong);
		ArrayList<ZipcodeTO> lists = null;
		
		ZipcodeTO to = new ZipcodeTO();
		to.setDong(dong);
		
		ZipcodeDAO dao = new ZipcodeDAO();
		lists = dao.allZipcode(to);
		
		model.addAttribute("dong", dong);
		model.addAttribute("lists", lists);
		
		return "zipcode";
	}
}
