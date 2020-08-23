package com.exam.aop04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.BeanConfig;
import spring.BoardAction;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/context.xml");
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(BeanConfig.class);

		BoardAction action = (BoardAction) ctx.getBean("writeAction");
		action.execute();
		action.execute1();
		action.execute2();

		ctx.close();
	}
}
