package com.exam.ex11;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.BoardAction;
import spring.Client2;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/context.xml");

		BoardAction action = (BoardAction) ctx.getBean("action");

		action.execute();

		ctx.close();
	}
}
