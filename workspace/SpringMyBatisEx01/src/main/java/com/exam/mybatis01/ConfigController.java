package com.exam.mybatis01;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/mybatis1.do")
	public String mybatis1() {
		System.out.println("mybatis1 호출");
		System.out.println("sqlSession");
		
		String result = sqlSession.selectOne("selectNow");
		System.out.println("결과 : " + result);
		
		return "mybatis1";
	}
}
