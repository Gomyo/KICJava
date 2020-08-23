package polyspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {
	public static void main(String[] args) {
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("classpath:polyspring/context.xml");
		
		// 인터페이스 이용
		Hello helloBean = (Hello)ctx.getBean("helloBean1");
		helloBean.sayHello("spring ctx");
		
		helloBean = (Hello)ctx.getBean("helloBean2");
		helloBean.sayHello("spring ctx22");
	}
}
