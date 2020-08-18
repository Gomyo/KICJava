package polyspring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain2 {
	public static void main(String[] args) {
		// 미리 생성자를 호출하는 효과가 있다.
//		GenericXmlApplicationContext ctx
//			= new GenericXmlApplicationContext("classpath:polyspring/context.xml");
		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext();
		ctx.load("classpath:polyspring/context.xml");
		ctx.refresh();
		
		Hello helloBean = (Hello)ctx.getBean("helloBean1");
		helloBean.sayHello("spring ctx1111");
		
		helloBean = (Hello)ctx.getBean("helloBean2");
		helloBean.sayHello("spring ctx2222");
		
		ctx.close();
	}
}
