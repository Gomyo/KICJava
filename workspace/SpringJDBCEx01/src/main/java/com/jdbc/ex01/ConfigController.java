package com.jdbc.ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {
	
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	@RequestMapping("/jdbc1.do")
	public String jdbc1() {
		System.out.println("jdbc1 호출 : " + JdbcTemplate);
		
		String result = JdbcTemplate.queryForObject("select now()", String.class);
		System.out.println(result);
		
		return "jdbc1";
	}
	
	@RequestMapping("/insertDept.do")
	public String insertDept() {
		// Dept Table - insert
		int result = JdbcTemplate.update("insert into dept2 values(110, '준준', '사우디아라비아')");
		System.out.println(result);
		return "insertDept";
	}
}
