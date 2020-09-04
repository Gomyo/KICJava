package com.exam.mybatis01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.DeptTO;

@Controller
public class ConfigController {
	@Autowired
	private TestMapper testMapper;
	
	@RequestMapping("/mybatis1.do")
	public String mybatis1() {

		System.out.println("mybatis + interface 호출");
		
		String result = testMapper.selectNow();
		System.out.println("결과 : " + result);
		
		return "mybatis1";
	}
	
	@RequestMapping("/mybatis2.do")
	public String mybatis2() {
		
		
		List<DeptTO> result = testMapper.selectDept();
		
		for (DeptTO to : result) {
			System.out.println(to.getDeptno());
			System.out.println(to.getDname());
			System.out.println(to.getLoc());
		}
		
		return "mybatis2";
	}
}
