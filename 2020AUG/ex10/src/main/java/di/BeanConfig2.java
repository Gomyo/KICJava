package di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.HelloBean2;


@Configuration
public class BeanConfig2 {
	
	@Bean
	public HelloBean2 helloBean2() {
		return new HelloBean2();
	}
}