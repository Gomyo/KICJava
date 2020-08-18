package com.exam.ex07;

import org.springframework.context.support.GenericXmlApplicationContext;

import model1.BoardDAO;
import model2.BoardAction;
import model2.ListAction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        BoardDAO dao = new BoardDAO();
//        BoardAction action = new ListAction(dao);
//        action.execute();
    	GenericXmlApplicationContext ctx 
    	= new GenericXmlApplicationContext("classpath:context.xml");
        BoardAction action = (BoardAction)ctx.getBean("action");
        action.execute();
    }
}
