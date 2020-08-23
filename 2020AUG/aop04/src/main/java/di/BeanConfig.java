package di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aop.BasicAdvice;
import spring.WriteAction;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfig {
	
	@Bean
	public WriteAction writeAction() {
		WriteAction action = new WriteAction();
		action.setwriter("빈콘피그");
		return action;
	}
	
	@Bean
	public BasicAdvice basicAdvice() {
		return new BasicAdvice();
	}
	
}
