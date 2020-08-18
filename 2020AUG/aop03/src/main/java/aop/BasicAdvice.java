package aop;

public class BasicAdvice {
	public void before() throws Throwable {
		System.out.println("before() 실행");
	}
	
	public void after() throws Throwable {
		System.out.println("after() 실행");
	}
}
