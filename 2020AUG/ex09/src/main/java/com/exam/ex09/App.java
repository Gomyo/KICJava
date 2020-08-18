package com.exam.ex09;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di.BeanConfig;
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
    	AnnotationConfigApplicationContext ctx
		= new AnnotationConfigApplicationContext(BeanConfig.class);
    	
//    	BoardTO to1 = (BoardTO)ctx.getBean("to1");
//    	System.out.println(to1.getSeq());
//    	System.out.println(to1.getSubject());
    	
//    	WriteAction 사용하기
    	BoardTO to = new BoardTO();
    	to.setSeq(1);
    	to.setSubject("제목");
    	
    	WriteAction writeAction = (WriteAction)ctx.getBean("writeAction");
    	writeAction.execute();
    	
    	ctx.close();
    }
}
