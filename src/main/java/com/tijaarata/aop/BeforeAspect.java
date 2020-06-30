/**
 * 
 */
package com.tijaarata.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author User
 *
 */

@Aspect
@Component
public class BeforeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut(value = "execution(* com.tijaarata.*.*.*(..))")
	public void pointCut() {

	}

	@Around("pointCut()")
	public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
		Object arr[] = joinPoint.getArgs();
		String className = joinPoint.getTarget().getClass().toString();
		logger.info("Class : " + className);
		logger.info("Signatire " + joinPoint.getSignature().getName());
		logger.info("Arguments value {}", arr);
		Object obj = joinPoint.proceed();
		return obj;
	}

}
