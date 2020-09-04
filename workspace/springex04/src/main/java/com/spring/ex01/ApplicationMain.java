package com.spring.ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain {
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:com/spring/ex01/context.xml");

		HelloBean helloBean1 = (HelloBean) ctx.getBean("helloBean1");
		helloBean1.sayHello();

		ctx.close();
	}
}
