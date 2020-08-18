package spring2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain_context {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:spring2/context.xml");
		writeAction action = (writeAction)ctx.getBean("action1");
		action.execute();
		
		ctx.close();
	}
}
