package com.exam.ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.BoardTO;
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
    	
    	// 1.
    	WriteAction writeAction = (WriteAction)ctx.getBean("action");
    	writeAction.execute();
    	
    	// 2.
    	BoardTO to = (BoardTO)ctx.getBean("to");
    	
//		BoardTO to = new BoardTO(); to.setSeq(1); to.setSubject("제목1");
//    	    	WriteAction writeAction = new WriteAction();
//    	writeAction.setTo(to);
//    	writeAction.execute();
    	
//    	GenericXmlApplicationContext ctx
//    	= new GenericXmlApplicationContext("classpath:spring/context.xml");
//        
//    	BoardTO to = (BoardTO)ctx.getBean("to");
    	
//        System.out.println(to.getSeq());
//        System.out.println(to.getSubject());
    }
    

}
