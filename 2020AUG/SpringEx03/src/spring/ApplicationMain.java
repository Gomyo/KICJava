package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:spring/context.xml");
		
//		HelloBean helloBean2 = (HelloBean)ctx.getBean("helloBean2");
//		helloBean2.sayHello();
		
		HelloBean helloBean3 = (HelloBean)ctx.getBean("helloBean3");
		helloBean3.sayHello();
		
		ctx.close();
	}
}
