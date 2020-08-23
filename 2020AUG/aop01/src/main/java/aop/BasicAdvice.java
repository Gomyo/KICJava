package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class BasicAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("전처리");
		
		String methodName = invocation.getMethod().getName();
		System.out.println("advice1 시작 : " + methodName);
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start(methodName);
		
		// 핵심실행
		Object rtnObj = invocation.proceed();
		
		System.out.println("advice1 끝 : " + (stopwatch.getTotalTimeSeconds()));
		System.out.println("후처리");
		
		return rtnObj;
	}

}
