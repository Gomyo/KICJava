package com.exam.ex06;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.BoardTO;

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
    	
    	BoardTO to1 = (BoardTO)ctx.getBean("to1");
    	System.out.println(to1.getSeq());
    	System.out.println(to1.getSubject());
    	
    	BoardTO to2 = (BoardTO)ctx.getBean("to2");
    	System.out.println(to2.getSeq());
    	System.out.println(to2.getSubject());
    	
    	ctx.close();
    }
}
