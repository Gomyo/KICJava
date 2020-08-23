package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class BasicAdvice2 implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("전처리");
		
		String methodName = invocation.getMethod().getName();
		System.out.println("advice2 시작 : " + methodName);
		
		Object rtnObj = invocation.proceed();
		
		System.out.println("advice2 끝");
		System.out.println("후처리");
		
		return rtnObj;
	}

}
