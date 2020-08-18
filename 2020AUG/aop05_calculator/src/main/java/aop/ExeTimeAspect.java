package aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect {
	
	@Pointcut("execution(public * spring..*(long))")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object rtnObj = joinPoint.proceed();
			return rtnObj;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n", 
					joinPoint.getTarget().getClass().getSimpleName(), // RecCalculator
					sig.getName(), Arrays.toString(joinPoint.getArgs()),
					(finish - start));
		}
	}
}
