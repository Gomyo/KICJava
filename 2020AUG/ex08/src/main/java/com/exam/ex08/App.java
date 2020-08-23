package com.exam.ex08;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.BeanConfig;
import spring.Hello;
import spring.HelloBean1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// 동적 클래스 로딩
    	AnnotationConfigApplicationContext ctx
    		= new AnnotationConfigApplicationContext(BeanConfig.class);
    	
    	HelloBean1 helloBean1 = (HelloBean1)ctx.getBean("helloBean1");
    	helloBean1.sayHello("드디어");
    	
    	// interface
    	Hello hello1 = (Hello)ctx.getBean("helloBean1");
    	hello1.sayHello("박문수");
    	
    	Hello hello2 = (Hello)ctx.getBean("helloBean2");
    	hello2.sayHello("몽룡리");
    	
    	Hello hello3 = (Hello)ctx.getBean("helloAllBean");
    	hello3.sayHello("길동퐁");
    	
    	// 생성자를 통해 주입된 것으로 가져오기
    	HelloBean1 helloBean4 = (HelloBean1)ctx.getBean("helloBean1");
    	helloBean4.sayHello();
    	
    	ctx.close();
    }
}
