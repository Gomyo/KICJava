package com.exam.aop02;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.BoardAction;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:spring/context.xml");

		BoardAction action = (BoardAction) ctx.getBean("action"); // writer에 홍길동 값 들어감
		action.execute();
		action.execute();
		action.execute1();
		action.execute2();
		
		ctx.close();
	}
}
