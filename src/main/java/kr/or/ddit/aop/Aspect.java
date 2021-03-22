package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//클래스명과 동일해서 길게 표현됨
@org.aspectj.lang.annotation.Aspect
public class Aspect {
	private static final Logger logger = LoggerFactory.getLogger(Aspect.class);

	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {
	}

	// 특정 메소드가 실행되기전에 실행 되어야할 공통의 관심사항
	@Before("dummy()")
	public void beforeMethod(JoinPoint joinPoint) {
		logger.debug("INN Aspect.beforeMethod()");
		// 모든 메소드가 실행될때
	}

	// around 특정 메소드 실행 전후
	// 메소드 실행전 - 공통 관심사항
	// 메소드의 원래 로직
	// 메소드 실행후 -공통 관심사항
	// 타입이 Object 이다
	@Around("dummy()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

		//////////////
		// 메소드 본 로직 실행전
		long startTime = System.nanoTime();
		//////////////
		// 클래스의 간단한 이름 가져옴
		String className = joinPoint.getTarget().getClass().getSimpleName();
		// 메소드명 가져옴
		String methodName = joinPoint.getSignature().getName();

		// 실행 로직 //joinPoint.getArgs();
		// 원래 로직
		Object ret = joinPoint.proceed(joinPoint.getArgs());

		//////////////
		// 메소드 본 로직 실행후
		long endTime = System.nanoTime();

		//////////////
		logger.debug("Aspect.aroundMethod() nanotime : {}", endTime - startTime);
		logger.debug("classname {} : {} : nanoTime duration : {}", className, methodName, endTime - startTime);
		logger.debug("classname {} : {} : secondTime duration : {}", className, methodName,
				((double) endTime - startTime) / 1000000000);
		/* className, methodName, endTime - startTime */

		return ret;
	}
}
