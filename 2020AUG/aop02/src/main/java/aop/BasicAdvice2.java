package aop;

import org.aspectj.lang.ProceedingJoinPoint;

// pojo
public class BasicAdvice2 {
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("전처리2");
		
		Object rtnObj = joinPoint.proceed();
		
		System.out.println("후처리2");
		
		return rtnObj;
	}
}
