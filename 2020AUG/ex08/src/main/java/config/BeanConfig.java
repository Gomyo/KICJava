package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.HelloBean1;
import spring.HelloBean2;

@Configuration
public class BeanConfig {
	
//	@Bean
//	// 얘를 실행시키는 순간 인스턴스화된 내용이 넘어옴
//	public HelloBean1 helloBean1() {
//		return new HelloBean1();
//	}
	
	@Bean
	public HelloBean1 helloBean1() {
		// 생성자를 통한 주입
		return new HelloBean1( "홍길동" );
	}
	
	@Bean
	public HelloBean2 helloBean2() {
		return new HelloBean2();
	}
	
	// 이름을 바꾸는 옵션
	@Bean(name="helloAllBean")
	public HelloBean2 helloBean() {
		return new HelloBean2();
	}
}
