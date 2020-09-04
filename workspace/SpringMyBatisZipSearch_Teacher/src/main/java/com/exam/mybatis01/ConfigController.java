package com.exam.mybatis01;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.ZipcodeTO;

@Controller
public class ConfigController {
	@Autowired
	private TestMapper testMapper;
	
	@RequestMapping("/zipcode.do")
	public String zipcode(HttpServletRequest req, Model model) {
		
		List<ZipcodeTO> result = testMapper.selectZipcode(req.getParameter("dong"));
		
		System.out.println(req.getParameter("dong"));
		if (req.getParameter("dong").equals("박성훈바보")) {
			System.out.println("이스터에그 성공!");
			model.addAttribute("egg", "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ정답!");
		} else {
			model.addAttribute("lists", result);
		}
		
		return "zipcode";
	}
}
