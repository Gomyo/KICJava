package com.exam.mybatis01;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public String selectNow() {
		
		System.out.println(sqlSession + "호호호 럼주우 한벼엉");
		
		return sqlSession.selectOne("selectNow");
	}
	
}
