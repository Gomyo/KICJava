package com.exam.aop01;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.BoardAction;
import spring.WriteAction;

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
        
//        BoardAction action = (BoardAction)ctx.getBean("action");
        BoardAction action = (BoardAction)ctx.getBean("proxy");
//        action.execute();
        action.execute1();
        action.execute2();
        
        ctx.close();
    }
}
