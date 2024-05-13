package kh.mclass.ttt.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AdviceLog {
	//aop:pointcut
	@Pointcut("execution(public * kh..*Dao.*(..))")
	public void daoPointcut() {}
	
	@Pointcut("execution(public * kh..*Service.*(..))")
	public void servicePointcut() {}
	
	@Pointcut("execution(public * kh..*Controller.*(..))")
	public void controllerPointcut() {}
	
	//Advice 걸어주기
	@Around("daoPointcut()")
	public Object aroundDaoLog(ProceedingJoinPoint pjp) {
		Object returnObj = null;
		//pjp.getThis() : 클래스명               
		//pjp.getSignature().getName() : 메소드명
		System.out.println("pjp.getThis()" + pjp.getThis() + ":" + pjp.getSignature().getName());
		//pjp.getArgs() : 메소드의 파라메터 값들이 들어있음
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length; i++) {
			System.out.println("arg[" + i+ "] : " + args[i]);
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		//pjp.proceed() 타겟 메소드
//		returnObj= pjp.proceed();
		stopwatch.stop();
		
		System.out.println("Dao > " + stopwatch.getTotalTimeMillis() +"ms" + returnObj);
		return returnObj;
	}
	
}
