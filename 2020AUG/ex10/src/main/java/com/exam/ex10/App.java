package com.exam.ex10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di.BeanConfig1;
import di.BeanConfig2;
import spring.HelloBean1;
import spring.HelloBean2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext ctx
        	= new AnnotationConfigApplicationContext(BeanConfig1.class, BeanConfig2.class);
        
        HelloBean1 helloBean1 = (HelloBean1)ctx.getBean("helloBean1");
        HelloBean2 helloBean2 = (HelloBean2)ctx.getBean("helloBean2");
    }
}
