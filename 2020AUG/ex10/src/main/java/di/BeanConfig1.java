package di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.HelloBean1;

@Configuration
public class BeanConfig1 {
	
	@Bean
	public HelloBean1 helloBean1() {
		return new HelloBean1();
	}
}
