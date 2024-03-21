package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect { // 실제 Aspect 로써, @LogExecutionTime 애너테이션이 달린 곳에 적용
	Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Around("@annotation(LogExecutionTime)") //이 부분은 공부할 것이 많다고 함.
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable { //ProceedingJoinPoint는 애너테이션이 붙은 매서드임
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object proceed = joinPoint.proceed(); //매서드를 실행하고,

		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());

		return proceed; // 결과를 리턴한다.

		//단지 앞뒤로 시간을 측정하는 코드가 추가됨.
		//이것이 스프링이 제공하는 애노테이션 기반 AOP 이다. -> 프록시 패턴을 기반으로 동작
	}
}
