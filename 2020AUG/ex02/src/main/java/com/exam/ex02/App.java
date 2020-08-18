package com.exam.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.HelloBean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GenericXmlApplicationContext ctx
        = new GenericXmlApplicationContext("classpath:spring/context.xml");
        
        HelloBean helloBean1 = (HelloBean)ctx.getBean("helloBean2");
        helloBean1.sayHello();
        
        ctx.close();
    }
}
