package com.exam.ex12;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di.BeanConfig;
import spring.Client2;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);

		Client2 client2 = (Client2) ctx.getBean("client2");
//    	client2.connect();
		client2.send();
//    	client2.close();

	}
}
