package com.exam.mybatis01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController2 {
	
	@Autowired
	private TestDAO dao;
	
	@RequestMapping("/mybatis2.do")
	public String mybatis2() {
		
		String result = dao.selectNow();
		System.out.println("결과2 : " + result);
		
		return "mybatis2";
	}
}
