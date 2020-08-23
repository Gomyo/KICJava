package com.exam.ex05;

import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.BookClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Properties config = new Properties();
//    	config.put("server", "192.168.0.100");
//    	config.put("connectionTimeout", "5000");
//    	
//    	BookClient client = new BookClient();
//    	client.setConfig(config);
    	
    	GenericXmlApplicationContext ctx
    	= new GenericXmlApplicationContext("classpath:spring/context.xml");
    	BookClient client = (BookClient)ctx.getBean("client");
    	
    	Properties newConfig = client.getConfig();
    	System.out.println(newConfig.getProperty("server"));
    	System.out.println(newConfig.getProperty("connectionTimeout"));
    }
}
