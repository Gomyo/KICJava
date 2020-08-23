package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {
	public static void main(String[] args) {
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("classpath:spring/context.xml");
		
		HelloBean1 helloBean1 = (HelloBean1)ctx.getBean("helloBean1");
		helloBean1.sayHello("spring ctx");
		
		HelloBean2 helloBean2 = (HelloBean2)ctx.getBean("helloBean2");
		helloBean2.sayHello("spring ctx22");
	}
}
