package aop;

import org.aspectj.lang.ProceedingJoinPoint;

// pojo
public class BasicAdvice {
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("전처리1");
		
		Object rtnObj = joinPoint.proceed();
		
		System.out.println("후처리1");
		
		return rtnObj;
	}
}
