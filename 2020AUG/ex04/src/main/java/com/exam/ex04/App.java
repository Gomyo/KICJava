package com.exam.ex04;

import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.BoardListTO;
import spring.BoardTO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	ArrayList<String> userLists = new ArrayList<String>();
//    	userLists.add("길동쓰");
//    	userLists.add("문수쓰");
//    	
//    	BoardListTO listTO = new BoardListTO();
//    	listTO.setUserLists(userLists);
    	
    	GenericXmlApplicationContext ctx
    	= new GenericXmlApplicationContext("classpath:spring/context.xml");
    	
//    	BoardListTO listTO = (BoardListTO)ctx.getBean("listTO");
//    	
//    	for (String user : listTO.getUserLists()) {
//    		System.out.println( user );
//    	}
    	
//    	BoardTO to1 = new BoardTO();
//    	to1.setSeq(1);
//    	to1.setSubject("제목1");
//    	
//    	BoardTO to2 = new BoardTO();
//    	to2.setSeq(2);
//    	to2.setSubject("제목2");
//    	
//    	ArrayList<BoardTO> boardLists = new ArrayList<BoardTO>();
//    	boardLists.add(to1);
//    	boardLists.add(to2);
    	
    	/*
    	BoardListTO boardLists = (BoardListTO)ctx.getBean("listTO");
    	
    	for (BoardTO to : boardLists.getBoardLists()) {
    		System.out.println(to.getSeq());
    		System.out.println(to.getSubject());
    	}
    	
    	BoardListTO boardSets = (BoardListTO)ctx.getBean("listTO");
    	for (BoardTO to : boardSets.getBoardSets()) {
    		System.out.println(to.getSeq());
    		System.out.println(to.getSubject());
    	}
    	*/
    	
    	BoardListTO boardMaps = (BoardListTO)ctx.getBean("listTO");
    	
    	for (BoardTO to : boardMaps.getBoardMaps().values()) {
    		System.out.println(to.getSeq());
    		System.out.println(to.getSubject());
    	}
    }
}
