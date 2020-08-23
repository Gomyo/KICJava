package com.exam.aop05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di.BeanConfig;
import spring.Calculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx
    		= new AnnotationConfigApplicationContext(BeanConfig.class);
    	
    	Calculator cal = ctx.getBean("calculator", Calculator.class);
    	cal.factorial(7);
    	cal.factorial(7);
    	cal.factorial(5);
    	cal.factorial(5);
    	ctx.close();
    }
}
