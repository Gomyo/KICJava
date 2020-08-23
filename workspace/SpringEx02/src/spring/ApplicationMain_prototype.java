package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain_prototype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:spring/context.xml");
		
		HelloBean helloBean1 = (HelloBean)ctx.getBean("HelloBean1");
		HelloBean helloBean2 = (HelloBean)ctx.getBean("HelloBean1");
		
		helloBean1.sayHello("홍길동");
		helloBean2.sayHello("문수팍");
		
		// 서로 다른 두개의 인스턴스
		System.out.println(helloBean1);
		System.out.println(helloBean2);
	}

}
